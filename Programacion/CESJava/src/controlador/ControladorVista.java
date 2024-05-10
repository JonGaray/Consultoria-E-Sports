package controlador;

import controlador.login.ControladorLogin;
import modelo.Equipos;
import modelo.Usuarios;

import java.sql.SQLException;

public class ControladorVista {
    private ControladorPrincipal cp;
    private ControladorLogin cl;

    public ControladorVista(ControladorPrincipal cp) {
        cl = new ControladorLogin(this);



        this.cp=cp;
//        cl.mostrar();
    }

    public String login (Usuarios usu) throws SQLException {
        System.out.println("cv");
        return cp.login(usu);
    }

    public void altaEquipo(Equipos eq) {
        cp.altaEquipo(eq);
    }

    public void bajaEquipo(Equipos eq) {
        cp.bajaEquipo(eq);
    }

    public void modiEquipo(Equipos eq) {
        cp.modiEquipo(eq);
    }

    public String consultaEquipo(Equipos eq) {
        return cp.consultaEquipo(eq).toString();
    }
}
