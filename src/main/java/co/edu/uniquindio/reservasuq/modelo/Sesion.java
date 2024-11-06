package co.edu.uniquindio.reservasuq.modelo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Sesion {

    public static Sesion INSTANCIA;
    private Persona persona;
    private List<Instalacion> instalaciones;

    public Sesion() {
        persona = null;
        instalaciones = null;
    }
    public static Sesion getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new Sesion();
        }
        return INSTANCIA;
    }
    public void cerrarSesion() {
        persona = null;
        instalaciones = null;
    }
}


