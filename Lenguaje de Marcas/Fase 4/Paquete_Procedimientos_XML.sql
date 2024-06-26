SET SERVEROUTPUT ON;

-- Creaci�n del paquete y su cuerpo
CREATE OR REPLACE PACKAGE gestion_xml IS
    PROCEDURE preparar_entorno;
    PROCEDURE generar_todas_jornadas;
    PROCEDURE generar_clasificacion;
    PROCEDURE generar_ultima_jornada;
END gestion_xml;
/

CREATE OR REPLACE PACKAGE BODY gestion_xml IS

    PROCEDURE preparar_entorno IS
BEGIN
    BEGIN
        EXECUTE IMMEDIATE 'TRUNCATE TABLE temp_jornadas_tab';
    EXCEPTION
        WHEN OTHERS THEN
            IF SQLCODE != -942 THEN
                RAISE;
            END IF;
    END;

    BEGIN
        EXECUTE IMMEDIATE 'TRUNCATE TABLE temp_clasificacion_tab';
    EXCEPTION
        WHEN OTHERS THEN
            IF SQLCODE != -942 THEN
                RAISE;
            END IF;
    END;

    BEGIN
        EXECUTE IMMEDIATE 'TRUNCATE TABLE temp_ultima_jornada_tab';
    EXCEPTION
        WHEN OTHERS THEN
            IF SQLCODE != -942 THEN
                RAISE;
            END IF;
    END;
    
    DBMS_OUTPUT.PUT_LINE('Entorno preparado correctamente.');
END preparar_entorno;

    PROCEDURE generar_todas_jornadas IS
        v_xml CLOB;
        resultado CLOB;
    BEGIN
        SELECT
            XMLELEMENT(
                "competiciones",
                XMLAGG(
                    XMLELEMENT(
                        "competicion",
                        XMLATTRIBUTES(c.cod_compe AS "id_competicion"),
                        XMLELEMENT("nombre_competicion", c.nombre),
                        (
                            SELECT
                                XMLAGG(
                                    XMLELEMENT(
                                        "jornada",
                                        XMLATTRIBUTES(j.cod_jornadas AS "id_jornada", j.dia AS "Fecha"),
                                        XMLELEMENT("numero_jornada", j.num_jornada),
                                        (
                                            SELECT
                                                XMLAGG(
                                                    XMLELEMENT(
                                                        "enfrentamiento",
                                                        XMLATTRIBUTES(rj.cod_enfrentamiento AS "id"),
                                                        XMLFOREST(
                                                            (SELECT nombre FROM equipos WHERE cod_equipo = rj.cod_equipo_local) AS "equipo_local",
                                                            (SELECT nombre FROM equipos WHERE cod_equipo = rj.cod_equipo_visitante) AS "equipo_visitante",
                                                            rj.resultado AS "ganador"
                                                        )
                                                    )
                                                )
                                            FROM enfrentamientos rj
                                            WHERE rj.cod_jornada = j.cod_jornadas
                                        )
                                    )
                                )
                            FROM jornadas j
                            WHERE j.cod_compe = c.cod_compe
                        )
                    )
                )
            ).getClobVal()
        INTO resultado
        FROM competiciones c;

        -- Concatenar el encabezado XML y el DTD al resultado
        resultado := '<?xml version=''1.0'' encoding=''UTF-8'' ?>' || 
        '<!DOCTYPE competiciones SYSTEM "resultados_todas_jornadas.dtd">' || resultado;
        DBMS_OUTPUT.PUT_LINE(resultado);

        -- Insertar el resultado en la tabla
        INSERT INTO temp_jornadas_tab (xml_data) VALUES (resultado);

        COMMIT;
    END generar_todas_jornadas;

    PROCEDURE generar_clasificacion IS
        v_xml CLOB;
        resultado CLOB;
    BEGIN
        SELECT 
           XMLElement("Clasificaciones",
               XMLAgg(
                   XMLElement("Clasificacion",
                       XMLForest(
                           EC.COD_COMPETICION AS "compId",
                               XMLAgg(
                                XMLElement("Equipo",
                                    XMLForest(
                                        E.NOMBRE AS "Nombre",
                                           EC.PUNTOS AS "Puntos"
                                       )
                                )    
                                   ORDER BY EC.PUNTOS DESC
                               ) AS "Equipos"
                           )
                       )
                   )
            ).getClobVal() 
            INTO v_xml
            FROM EQUIPO_COMPETICION EC
            JOIN EQUIPOS E ON EC.COD_EQUIPO = E.COD_EQUIPO
            GROUP BY EC.COD_COMPETICION;

        -- Concatenar el encabezado XML y el DTD al resultado
        resultado := '<?xml version=''1.0'' encoding=''UTF-8'' ?>' || '<!DOCTYPE Clasificaciones SYSTEM "clasificacion.dtd">' || v_xml;
        DBMS_OUTPUT.PUT_LINE(resultado);

        -- Insertar el resultado en la tabla
        INSERT INTO temp_clasificacion_tab (xml_data) VALUES (resultado);

        COMMIT;
    END generar_clasificacion;

    PROCEDURE generar_ultima_jornada IS
        v_xml_data CLOB;
        v_ultima_jornada NUMBER;
        resultado CLOB;
    BEGIN
        SELECT
            XMLELEMENT(
                "competiciones",
                XMLAGG(
                    XMLELEMENT(
                        "competicion",
                        XMLATTRIBUTES(c.cod_compe AS "id_competicion"),
                        XMLELEMENT("nombre_competicion", c.nombre),
                        (SELECT
                        XMLAGG(
                            XMLELEMENT(
                                "jornada",
                                XMLATTRIBUTES(j.cod_jornadas AS "id_jornada", j.dia AS "Fecha"),
                                XMLELEMENT("numero_jornada", j.num_jornada),
                                (
                                    SELECT
                                        XMLAGG(
                                            XMLELEMENT(
                                                    "enfrentamiento",
                                                    XMLATTRIBUTES(rj.cod_enfrentamiento AS "id"),
                                                    XMLFOREST(
                                                        (SELECT nombre FROM equipos WHERE cod_equipo = rj.cod_equipo_local) AS "equipo_local",
                                                        (SELECT nombre FROM equipos WHERE cod_equipo = rj.cod_equipo_visitante) AS "equipo_visitante",
                                                        rj.resultado AS "ganador"
                                                    )
                                                )
                                            )
                                    FROM enfrentamientos rj
                                    WHERE rj.cod_jornada = j.cod_jornadas
                                )
                            )
                        )
                        FROM (
                            SELECT * FROM jornadas j
                            WHERE j.cod_compe = c.cod_compe
                            ORDER BY j.num_jornada DESC
                        ) j
                        WHERE ROWNUM = 1
                        )
                    )
                )
            ).getClobVal()
        INTO resultado
        FROM competiciones c;

        resultado := '<?xml version=''1.0'' encoding=''UTF-8'' ?>' || 
        '<!DOCTYPE competiciones SYSTEM "resultados_ultima_jornada.dtd">' || resultado;
        DBMS_OUTPUT.PUT_LINE(resultado);
    
        INSERT INTO temp_ultima_jornada_tab (xml_data) VALUES (resultado);
    
        COMMIT;
    END generar_ultima_jornada;

END gestion_xml;
/

BEGIN
    gestion_xml.preparar_entorno;

    gestion_xml.generar_todas_jornadas;

    gestion_xml.generar_clasificacion;

    gestion_xml.generar_ultima_jornada;
END;
/