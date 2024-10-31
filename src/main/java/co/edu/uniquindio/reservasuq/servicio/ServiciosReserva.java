package co.edu.uniquindio.reservasuq.servicio;

import co.edu.uniquindio.reservasuq.modelo.Instalaciones;
import co.edu.uniquindio.reservasuq.modelo.Usuarios;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoUsuario;

public interface ServiciosReserva {

    Usuarios registrarUsuarios(String cedula, String nombre, String correo, TipoUsuario tipoUsuario, String password);
    Usuarios obtenerUsuarios();
    Usuarios validarUsuarios();
    void enviarNotificacionEmail();
    boolean validarIngresoAdministrador();
    Instalaciones crearEvento();
    Instalaciones obtenerEvento();
    void validarDisponibilidad();
    void crearReserva();
    void cancelarReserva();
    boolean disponibilidadInstalaciones();
    String historialReservas();
    int capacidadMaxima();
    double costoReserva();

}
