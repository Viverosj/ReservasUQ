package co.edu.uniquindio.reservasuq.servicio;

import co.edu.uniquindio.reservasuq.modelo.Instalaciones;
import co.edu.uniquindio.reservasuq.modelo.Usuarios;

public interface ServiciosReserva {

    Usuarios registrarUsuarios();
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
