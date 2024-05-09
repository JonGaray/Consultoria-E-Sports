package modelo;

public class Clasificaciones {
    private int codequipo;
    private int puntos;
    private int codcompe;

    public Clasificaciones(int codequipo, int puntos, int codcompe) {
        this.codequipo = codequipo;
        this.puntos = puntos;
        this.codcompe = codcompe;
    }

    public Clasificaciones() {
    }

    public int getCodequipo() {
        return codequipo;
    }

    public void setCodequipo(int codequipo) {
        this.codequipo = codequipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getCodcompe() {
        return codcompe;
    }

    public void setCodcompe(int codcompe) {
        this.codcompe = codcompe;
    }
}
