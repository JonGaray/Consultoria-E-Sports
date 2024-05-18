package controlador.admin;

import controlador.ControladorVista;
import controlador.cerrar_inscripciones.ControladorCerrarInscripciones;
import controlador.clasificacion.ControladorClasificacion;
import controlador.competiciones.ControladorCompeticion;
import controlador.equipo_competicion.ControladorEquipoCompeticion;
import controlador.equipos.ControladorEquipo;
import controlador.juegos.ControladorJuego;
import controlador.jugadores.ControladorJugador;
import controlador.patrocinador_equipo.ControladorPatrEqui;
import controlador.patrocinadores.ControladorPatrocinador;
import controlador.registrar.ControladorRegistrar;
import controlador.resultados_todas_jornadas.ControladorResultadosTJornadas;
import controlador.staff.ControladorStaff;
import view.VentanaEquipos;
import view.VentanaPrincipalAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAdmin {
    private ControladorVista cv;
    private VentanaPrincipalAdmin vpa;
    private ControladorEquipo ce;
    private ControladorJugador cj;
    private ControladorStaff cs;
    private ControladorJuego cje;
    private ControladorPatrocinador cp;
    private ControladorCompeticion cc;
    private ControladorEquipoCompeticion cec;
    private ControladorRegistrar cr;
    private ControladorClasificacion ccl;
    private ControladorPatrEqui cpe;
    private ControladorCerrarInscripciones cci;
    private ControladorResultadosTJornadas crtj;

    public ControladorAdmin(ControladorVista cv) {
        mostrar();
        botones();
        this.cv=cv;
    }

    public void mostrar() {
        vpa = new VentanaPrincipalAdmin();
        vpa.setVisible(true);
    }

    public void botones() {
        vpa.addBSalir(new bSalir());
        vpa.addBEquipos(new bEquipo());
        vpa.addBJugadores(new bJugador());
        vpa.addBStaff(new bStaff());
        vpa.addBJuegos(new bJuegos());
        vpa.addBCompeticiones(new bCompeticiones());
        vpa.addBPatrocinadores(new bPatrocinadores());
        vpa.addBAsociarEquiCompe(new bAsociarEquiCompe());
        vpa.bAltaUSu(new bAltaUsu());
        vpa.cerrarSesion(new cerrarSesion());
        vpa.addClasi(new clasi());
        vpa.addBAsociarPatrocinadorEquipo(new bAsociarPatroEqui());
        vpa.addBCerrarEtapaInscripcion(new bCierreInscripciones());
        vpa.addBResultadosJornadas(new bResultadosJornadas());
    }

    private class cerrarSesion implements ActionListener{
        public void actionPerformed (ActionEvent e){
            vpa.dispose();
        }
    }

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public class bEquipo implements ActionListener{
        public void actionPerformed(ActionEvent e){
            ce = new ControladorEquipo(cv);
        }
    }

    private class bJugador implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cj = new ControladorJugador(cv);
        }
    }

    private class bStaff implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cs = new ControladorStaff(cv);
        }
    }

    private class bJuegos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cje = new ControladorJuego(cv);
        }
    }

    private class bCompeticiones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cc = new ControladorCompeticion(cv);
        }
    }

    private class bPatrocinadores implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cp = new ControladorPatrocinador(cv);
        }
    }

    private class bAsociarEquiCompe implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cec = new ControladorEquipoCompeticion(cv);
        }
    }

    private class bAltaUsu implements ActionListener{
        public void actionPerformed (ActionEvent e){
            cr = new ControladorRegistrar(cv);
        }
    }

    private class clasi implements ActionListener{
        public void actionPerformed (ActionEvent e){
            ccl = new ControladorClasificacion(cv);
        }
    }

    public class bAsociarPatroEqui implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cpe = new ControladorPatrEqui(cv);
        }
    }

    public class bCierreInscripciones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cci = new ControladorCerrarInscripciones(cv);
        }
    }

    public class bResultadosJornadas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            crtj = new ControladorResultadosTJornadas(cv);
        }
    }
}
