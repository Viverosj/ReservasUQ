package co.edu.uniquindio.reservasuq;

import co.edu.uniquindio.reservasuq.modelo.Persona;
import lombok.Getter;
import lombok.Setter;

public class Sesion {

    public static Sesion INSTANCIA;

    @Getter @Setter
    private Persona usuarios;

    private Sesion() {
    }

    public static Sesion getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new Sesion();
        }
        return INSTANCIA;
    }

    public void cerrarSesion() {
        usuarios = null;
    }

}
