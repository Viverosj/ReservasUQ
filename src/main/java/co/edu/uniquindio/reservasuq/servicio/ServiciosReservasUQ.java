package co.edu.uniquindio.reservasuq.servicio;
import co.edu.uniquindio.reservasuq.modelo.Horario;
import co.edu.uniquindio.reservasuq.modelo.Instalacion;
import co.edu.uniquindio.reservasuq.modelo.Reservas;
import co.edu.uniquindio.reservasuq.modelo.Persona;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoPersona;
import java.time.LocalDate;
import java.util.List;

public interface ServiciosReservasUQ {

    Persona login(String correo, String password) throws Exception;

    void registrarPersona(String cedula, String nombre, String correo, TipoPersona tipoPersona, String password) throws Exception;

    void registrarUsuario(String cedula, String nombre, TipoPersona tipoUsuario, String correo, String password) throws Exception;

    void crearInstalaciones(String nombre, int capacidad, float costo, List<Horario> horarios);

    Reservas crearReserva(String idInstalaciones, String cedulaUsuario, LocalDate diaReserva, String horaReserva) throws Exception;

    List<Reservas> listarTodasReservas();

    List<Reservas> listarReservasPorPersona(String cedulaUsuario);

    Persona obtenerUsuarios(String cedula, String nombre, String correo, TipoPersona tipoUsuario, String password);
    Persona validarUsuarios(String cedula, String nombre, String correo, TipoPersona tipoUsuario, String password);
    void enviarNotificacionEmail();
    boolean validarIngresoAdministrador();
    Instalacion crearEvento();
    Instalacion obtenerEvento();
    void validarDisponibilidad();
    void crearReserva();
    void cancelarReserva();
    boolean disponibilidadInstalaciones();
    String historialReservas();
    int capacidadMaxima();
    double costoReserva();

}
