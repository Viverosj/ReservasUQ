package co.edu.uniquindio.reservasuq.modelo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Sesion {

    public static Sesion INSTANCIA;
    private Persona persona;

    public Sesion() {
    }
    public static Sesion getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new Sesion();
        }
        return INSTANCIA;
    }
    public void cerrarSesion() {
        persona = null;
    }
}


