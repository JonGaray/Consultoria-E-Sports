package controlador;

import controlador.admin.ControladorAdmin;
import controlador.clasificacion.ControladorClasificacion;
import controlador.competiciones.ControladorCompeticion;
import controlador.equipos.ControladorEquipo;
import controlador.juegos.ControladorJuego;
import controlador.jugadores.ControladorJugador;
import controlador.login.ControladorLogin;
import controlador.patrocinadores.ControladorPatrocinador;
import modelo.*;
import view.VentanaPrincipalAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ControladorVista es la clase encargada de gestionar las interacciones entre la vista y los modelos
 * en el sistema de gestión de competiciones deportivas. Coordina las operaciones de alta, baja,
 * modificación y consulta de diferentes entidades como Jugadores, Equipos, Juegos, Patrocinadores,
 * Competiciones y Staff.
 */
public class ControladorVista {
    private ControladorPrincipal cp;
    private ControladorLogin cl;
    private VentanaPrincipalAdmin vpa;

    /* ----------- Controladores ----------- */
    private ControladorAdmin cvpa;
    private ControladorEquipo ce;
    private ControladorCompeticion cc;
    private ControladorJuego cjueg;
    private ControladorJugador cjuga;
    private ControladorPatrocinador cpat;
    private ControladorClasificacion ccl;

    /**
     * Constructor de la clase ControladorVista.
     *
     * @param cp Instancia de ControladorPrincipal para gestionar las operaciones principales.
     */
    public ControladorVista(ControladorPrincipal cp) {
        cl = new ControladorLogin(this);
        this.cp = cp;
    }

    /**
     * Inicia sesión con un usuario proporcionado.
     *
     * @param usu Instancia de Usuario que contiene las credenciales de inicio de sesión.
     * @return String que representa el estado de la operación de inicio de sesión.
     * @throws SQLException Si ocurre un error en la operación de la base de datos.
     */
    public String login(Usuario usu) throws SQLException {
        return cp.login(usu);
    }

    /**
     * Modifica los datos de un miembro del staff.
     *
     * @param staff Instancia de Staff que contiene la información del miembro del staff.
     * @param cargo Nuevo cargo del miembro del staff.
     * @param sueldo Nuevo sueldo del miembro del staff.
     * @param cod_equipo Instancia de Equipo al que pertenece el miembro del staff.
     */
    public void modiStaff(Staff staff, String cargo, Integer sueldo, Equipo cod_equipo) {
        cp.modiStaff(staff, cargo, sueldo, cod_equipo);
    }

    /**
     * Consulta la información de un miembro del staff por su nombre.
     *
     * @param nombreSt Nombre del miembro del staff.
     * @return String que representa la información del miembro del staff.
     */
    public String cosultaStaff(String nombreSt) {
        return cp.consultaStaff(nombreSt).toString();
    }

    // Métodos de gestión de jugadores
    public void altaJugador(Jugador ju) {
        cp.altaJugador(ju);
    }

    public void bajaJugador(Jugador ju) {
        cp.bajaJugador(ju);
    }

    public void modiJugador(Jugador ju) {
        cp.modiJugador(ju);
    }

    public String consultaJugador(String nombre) {
        return cp.consultaJugador(nombre).toString();
    }

    // Métodos de gestión de juegos
    public void altaJuego(Juego juego) {
        cp.altaJuego(juego);
    }

    public void bajaJuego(Juego juego) {
        cp.bajaJuego(juego);
    }

    public void modiJuego(Juego juego) {
        cp.modiJuego(juego);
    }

    public String consultaJuego(String nombreJu) {
        return cp.consultaJuego(nombreJu).toString();
    }

    // Métodos de gestión de patrocinadores
    public void altaPatrocinador(Patrocinador patr) {
        cp.altaPatrocinador(patr);
    }

    public void bajaPatrocinador(Patrocinador patr) {
        cp.bajaPatrocinador(patr);
    }

    // Métodos de gestión de usuarios
    public void altaUsu(Usuario usu) throws Exception {
        cp.altaUsu(usu);
    }

    public Usuario comprobarUsu(Usuario usu) throws Exception {
        return cp.comprobarUsu(usu);
    }

    // Métodos de clasificación
    public ArrayList clasiEquipos() throws Exception {
        return cp.clasiEquipos();
    }

    public ArrayList clasificacionAdmin(Competicion com) {
        return cp.clasificacionAdmin(com);
    }

    // Métodos de obtención de nombres y códigos
    public Juego getNombreJuegoPorCodigo(int cod) {
        return cp.getNombreJuegoPorCodigo(cod);
    }

    public Equipo getNombreEquipoPorCodigo(int codEquipo) {
        return cp.getNombreEquipoPorCodigo(codEquipo);
    }

    public int getCodigoCompeticionPorNombre(String nombre) {
        return cp.getCodigoCompeticionPorNombre(nombre);
    }

    // Métodos de gestión de competiciones
    public void generarCalendario(int codCompeticion) {
        cp.generarCalendario(codCompeticion);
    }

    /* ----------- Botones Ventana Administrador ------------- */
    public class controlEquipos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ce = new ControladorEquipo(ControladorVista.this);
        }
    }

    /* ----------- Métodos de gestión de equipos ----------- */
    public void altaEquipo(Equipo eq) {
        cp.altaEquipo(eq);
    }

    public void bajaEquipo(Equipo eq) {
        cp.bajaEquipo(eq);
    }

    public void modiEquipo(Equipo eq, String fecha) {
        cp.modiEquipo(eq, fecha);
    }

    public void altaStaff(Staff staff) {
        cp.altaStaff(staff);
    }

    public void bajaStaff(Staff staff) {
        cp.bajaStaff(staff);
    }

    public String consultaEquipo(String nombreEq) {
        return cp.consultaEquipo(nombreEq).toString();
    }

    public Juego buscarJuego(String nombreJu) {
        return cp.buscarJuego(nombreJu);
    }

    public Equipo buscarEquipo(String nombreEq) {
        return cp.buscarEquipo(nombreEq);
    }

    public ArrayList obtenerUltimaJornada(Competicion com) {
        return cp.ultimaJornada(com);
    }

    public ArrayList obtenerTodasJornadas(Competicion com) {
        return cp.todasJornadas(com);
    }

    public void altaCompeticion(Competicion compe) {
        cp.altaCompeticion(compe);
    }

    public void bajaCompeticion(Competicion compe) {
        cp.bajaCompeticion(compe);
    }

    public void modiCompeticion(Competicion compe) {
        cp.modiCompeticion(compe);
    }

    public String consultaCompeticion(String nombreCo) {
        return cp.consultaCompeticion(nombreCo).toString();
    }

    public ArrayList clasificacion(Competicion com) {
        return cp.clasificacion(com);
    }

    public void asociarEquipoCompeticion(String nombreEquipo, String nombreCompeticion) {
        cp.asociarEquipoCompeticion(nombreEquipo, nombreCompeticion);
    }

    public void desasociarEquipoCompeticion(String nombreEquipo, String nombreCompeticion) {
        cp.desasociarEquipoCompeticion(nombreEquipo, nombreCompeticion);
    }

    public void asociarPatrocinadorEquipo(String nombreEquipo, String nombrePatrocinador) {
        cp.asociarPatrocinadorEquipo(nombreEquipo, nombrePatrocinador);
    }

    public void desasociarPatrocinadorEquipo(String nombreEquipo, String nombrePatrocinador) {
        cp.desasociarPatrocinadorEquipo(nombreEquipo, nombrePatrocinador);
    }

    public List<String> getEquiposPorPatrocinador(String nombrePatrocinador) {
        return cp.getEquiposPorPatrocinador(nombrePatrocinador);
    }

    public List<String> getPatrocinadoresPorEquipo(String nombreEquipo) {
        return cp.getPatrocinadoresPorEquipo(nombreEquipo);
    }

    public ArrayList<Equipo> getEquiposPorCompeticion(Competicion com) {
        return cp.getEquiposPorCompeticion(com);
    }

    public void cerrarIncripcionCompeticion(String nombreCompeticion) {
        cp.cerrarIncripcionCompeticion(nombreCompeticion);
    }

    public ArrayList<Enfrentamiento> obtenerEnfrentamientosPorCompeticionYJornada(Competicion com, int numJornada) {
        return cp.obtenerEnfrentamientosPorCompeticionYJornada(com, numJornada);
    }

    public void insertarResultadoEnfrentamiento(String codEnfrentamiento, String equipoGanador, String nombreCompe) throws Exception {
        cp.insertarResultadoEnfrentamiento(codEnfrentamiento, equipoGanador, nombreCompe);
    }

    public String generarXMLClasificacion() {
        return cp.generarXMLClasificacion();
    }

    public String generarXMLJornada() {
        return cp.generarXMLJornada();
    }

    public String generarXMLTodasJornadas() {
        return cp.generarXMLTodasJornadas();
    }
}
