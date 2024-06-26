package controlador.baseDeDatos;

import modelo.Competicion;
import modelo.Enfrentamiento;
import modelo.Equipo;
import modelo.Jornada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * La clase TablaJornadas maneja las operaciones relacionadas con las jornadas y enfrentamientos en la base de datos.
 */

public class TablaJornadas {
    private Connection con;

    /**
     * Constructor para inicializar la conexión a la base de datos.
     *
     * @param con La conexión a la base de datos.
     */

    public TablaJornadas(Connection con) {
        this.con = con;
    }

    /**
     * Obtiene la última jornada de una competición.
     *
     * @param com La competición de la cual se desea obtener la última jornada.
     * @return Una lista de enfrentamientos correspondientes a la última jornada de la competición.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public ArrayList ultimaJornada(Competicion com) {
        Enfrentamiento enfre;
        ArrayList lista = new ArrayList<>();
        try {
            String nomCompe = com.getNombre();
            String plantilla = "SELECT e.cod_jornada, e.hora, e.fecha, e.resultado, e.cod_equipo_local, e.cod_equipo_visitante FROM competiciones c JOIN jornadas j ON j.cod_compe = c.cod_compe JOIN enfrentamientos e ON e.cod_jornada = j.cod_jornadas WHERE j.num_jornada = (SELECT MAX(j.num_jornada) FROM jornadas j JOIN competiciones c ON j.cod_compe = c.cod_compe WHERE c.nombre = ?) AND c.nombre = ?";
            PreparedStatement pre = con.prepareStatement(plantilla);
            pre.setString(1, nomCompe);
            pre.setString(2, nomCompe);
            ResultSet respuesta = pre.executeQuery();
            while (respuesta.next()) {
                enfre = new Enfrentamiento();
                Jornada jor = new Jornada();
                jor.setNumJornada(respuesta.getInt(1));
                enfre.setCodJornada(jor);
                enfre.setHora(respuesta.getString(2));
                enfre.setFecha(respuesta.getDate(3).toLocalDate());
                enfre.setResultado(respuesta.getString(4));
                Equipo eqLocal = new Equipo();
                eqLocal.setCodEquipo(respuesta.getInt(5));
                enfre.setCodEquipoLocal(eqLocal);
                Equipo eqVisitante = new Equipo();
                eqVisitante.setCodEquipo(respuesta.getInt(6));
                enfre.setCodEquipoVisitante(eqVisitante);
                lista.add(enfre);

            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Obtiene todas las jornadas de una competición.
     *
     * @param com La competición de la cual se desea obtener todas las jornadas.
     * @return Una lista de enfrentamientos correspondientes a todas las jornadas de la competición.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public ArrayList<Enfrentamiento> obtenerTodasJornadas(Competicion com) {
        Enfrentamiento enfre;
        ArrayList<Enfrentamiento> lista = new ArrayList<>();
        try {
            String nomCompe = com.getNombre();
            String plantilla = "SELECT e.cod_jornada, e.hora, e.fecha, e.resultado, e.cod_equipo_local, e.cod_equipo_visitante " +
                    "FROM competiciones c " +
                    "JOIN jornadas j ON j.cod_compe = c.cod_compe " +
                    "JOIN enfrentamientos e ON e.cod_jornada = j.cod_jornadas " +
                    "WHERE c.nombre = ?";
            PreparedStatement pre = con.prepareStatement(plantilla);
            pre.setString(1, nomCompe);
            ResultSet respuesta = pre.executeQuery();
            while (respuesta.next()) {
                enfre = new Enfrentamiento();
                Jornada jor = new Jornada();
                jor.setNumJornada(respuesta.getInt(1));
                enfre.setCodJornada(jor);
                enfre.setHora(respuesta.getString(2));
                enfre.setFecha(respuesta.getDate(3).toLocalDate());
                enfre.setResultado(respuesta.getString(4));
                Equipo eqLocal = new Equipo();
                eqLocal.setCodEquipo(respuesta.getInt(5));
                enfre.setCodEquipoLocal(eqLocal);
                Equipo eqVisitante = new Equipo();
                eqVisitante.setCodEquipo(respuesta.getInt(6));
                enfre.setCodEquipoVisitante(eqVisitante);
                lista.add(enfre);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
