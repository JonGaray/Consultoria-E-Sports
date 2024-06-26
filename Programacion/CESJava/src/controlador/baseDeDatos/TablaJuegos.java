package controlador.baseDeDatos;

import modelo.Juego;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * La clase TablaJuegos gestiona las operaciones relacionadas con la tabla de juegos en la base de datos.
 */

public class TablaJuegos {
    Connection con;

    /**
     * Constructor de la clase TablaJuegos.
     *
     * @param con La conexión a la base de datos.
     */

    public TablaJuegos(Connection con) {
        this.con = con;
    }


    /**
     * Inserta un nuevo juego en la base de datos.
     *
     * @param juego El juego a ser insertado.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public void altaJuego(Juego juego) {
        try {
            String plantilla = "INSERT INTO juegos (nombre,desarrolladora,fecha_lanzamiento) VALUES (?,?,?)";
            PreparedStatement sentencia = con.prepareStatement(plantilla);
            sentencia.setString(1, juego.getNombre());
            sentencia.setString(2, juego.getDesarrolladora());
            String fechaVentana = String.valueOf(juego.getFechaLanzamiento());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fechaJava = formato.parse(fechaVentana);
            java.sql.Date fechaSql = new java.sql.Date(fechaJava.getTime());
            sentencia.setDate(3, fechaSql);
            int n = sentencia.executeUpdate();
            if (n != 1) {
                mostrar("No se ha insertado ningún juego");
            } else {
                mostrar("Juego insertado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Elimina un juego de la base de datos.
     *
     * @param juego El juego a ser eliminado.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public void bajaJuego(Juego juego) {
        try {
            String plantilla = "DELETE FROM juegos WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, juego.getNombre());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1) {
                mostrar("Juego borrado");
            } else {
                mostrar("Juego no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Modifica los detalles de un juego en la base de datos.
     *
     * @param juego El juego con los detalles actualizados.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public void modiJuego(Juego juego) {
        try {
            String plantilla = "UPDATE juegos SET desarrolladora = ?, fecha_lanzamiento = ? WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(3, juego.getNombre());
            String fechaVentana = String.valueOf(juego.getFechaLanzamiento());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date fechaJava = formato.parse(fechaVentana);
            java.sql.Timestamp fechaSql = new java.sql.Timestamp(fechaJava.getTime());
            sentenciaPre.setTimestamp(2, fechaSql);
            sentenciaPre.setString(1, juego.getDesarrolladora());
            int n = sentenciaPre.executeUpdate();
            sentenciaPre.close();
            if (n == 1) {
                mostrar("Juego actualizado");
            } else {
                mostrar("Juego no encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Consulta los detalles de un juego en la base de datos.
     *
     * @param nombreJu El nombre del juego a ser consultado.
     * @return Una cadena con los detalles del juego.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public StringBuilder consultaJuego(String nombreJu) {
        Juego juego = null;
        try {
            String plantilla = "SELECT desarrolladora,fecha_lanzamiento FROM juegos WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreJu);
            ResultSet respuesta = sentenciaPre.executeQuery();
            StringBuilder pantalla = new StringBuilder();
            if (respuesta.next()) {
                String desarrolladora = respuesta.getString("desarrolladora");
                java.sql.Timestamp fecha = respuesta.getTimestamp("fecha_lanzamiento");
                pantalla.append("DESARROLLADORA: ").append(desarrolladora).append("\n").append("FECHA LANZAMIENTO: ").append(fecha);
            }
            return pantalla;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Busca un juego en la base de datos por su nombre.
     *
     * @param nombreJu El nombre del juego a ser buscado.
     * @return El juego encontrado, o null si no se encuentra.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public Juego buscarJuego(String nombreJu) {
        Juego juego = null;
        try {
            String plantilla = "SELECT cod_juego FROM juegos WHERE nombre = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setString(1, nombreJu);
            ResultSet respuesta = sentenciaPre.executeQuery();
            if (respuesta.next()) {
                int codJuego = respuesta.getInt("cod_juego");
                juego = new Juego();
                juego.setNombre(nombreJu);
                juego.setCodJuego(codJuego);
            }
            return juego;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Obtiene el nombre de un juego por su código.
     *
     * @param cod El código del juego.
     * @return El nombre del juego.
     * @throws RuntimeException Si ocurre un error durante la operación.
     */

    public Juego getNombreJuegoPorCodigo(int cod) {
        Juego juego = null;
        try {
            String plantilla = "SELECT nombre FROM juegos WHERE cod_juego = ?";
            PreparedStatement sentenciaPre = con.prepareStatement(plantilla);
            sentenciaPre.setInt(1, cod);
            ResultSet respuesta = sentenciaPre.executeQuery();
            if (respuesta.next()) {
                String nombreJuego = respuesta.getString("nombre");
                juego = new Juego();
                juego.setNombre(nombreJuego);
                juego.setCodJuego(cod);
            }
            return juego;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Muestra un mensaje en una ventana emergente.
     *
     * @param m El mensaje a ser mostrado.
     */

    public void mostrar(String m) {
        JOptionPane.showMessageDialog(null, m);
    }
}
