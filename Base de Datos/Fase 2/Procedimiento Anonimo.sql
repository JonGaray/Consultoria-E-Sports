/* Procedimientos Anonimos */


/* Funcion: Verificar si la etapa de inscripcion de una competicion se encuentra
            abierta o cerrada */
SET SERVEROUTPUT ON;

DECLARE
    V_COD_COMPE INT;       -- COD COMPETICION
    V_FECHA_FIN DATE;      -- FECHA FIN INSCRIPCION

BEGIN
    V_COD_COMPE := 1; -- COD COMPE QUE QUEEREMOS CERRAR ETAPA INSCRIPCION

    -- OBTENER LA FECHA DE FIN DE INSCRIPCI�N PARA LA COMPETICI�N
    SELECT FECHA_INICIO INTO V_FECHA_FIN
    FROM COMPETICIONES
    WHERE COD_COMPE = V_COD_COMPE;

    -- VERIFICAR SI LA FECHA DE FIN DE INSCRIPCI�N HA PASADO
    IF V_FECHA_FIN < SYSDATE THEN
        DBMS_OUTPUT.PUT_LINE('LA ETAPA DE INSCRIPCI�N PARA LA COMPETICI�N EST� CERRADA.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('LA ETAPA DE INSCRIPCI�N PARA LA COMPETICI�N EST� ABIERTA.');
    END IF;
END;



/*Funcion: Este procedimiento cierra la etapa de inscripcion de la competicion
        que elijas (mediante codigo competicion [cod_compe]), si esta abierta y 
        se cierra mediante este procedimiento habra una salida que indique que
        se ha cerrado la competicion correctamente, si ya estaba cerrada 
        anteriormente la salida dira que ya estaba cerrada. */
        
SET SERVEROUTPUT ON;

DECLARE
    V_COD_COMPE INT;       -- COD COMPETICION
    V_CURRENT_DATE DATE;        -- FECHA ACTUAL

BEGIN
    V_COD_COMPE := 1; -- COD COMPE QUE QUEEREMOS CERRAR ETAPA INSCRIPCION

    -- VERIFICAR SI ESTA ABIERTA O CERRADA ESA COMPETICION
    SELECT FECHA_INICIO INTO V_CURRENT_DATE
    FROM COMPETICIONES
    WHERE COD_COMPE = V_COD_COMPE;

    -- SI LA FECHA ACTUAL YA SOBREPASA LA DE CIERRE DE INSCRIPCION SACAMOS ESTO
    IF V_CURRENT_DATE < SYSDATE THEN
        DBMS_OUTPUT.PUT_LINE('LA ETAPA DE INSCRIPCI�N PARA LA COMPETICI�N YA EST� CERRADA.');
    ELSE
        -- SE CAMBIA LA FECHA DE FIN DE INSCRIPCION A LA ACTUAL
        UPDATE COMPETICIONES
        SET FECHA_FIN = SYSDATE
        WHERE COD_COMPE = V_COD_COMPE;

        DBMS_OUTPUT.PUT_LINE('SE HA CERRADO LA ETAPA DE INSCRIPCI�N PARA LA COMPETICI�N CORRECTAMENTE.');
    END IF;
END;