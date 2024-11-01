package co.edu.uniquindio.reservasuq.servicio;
import co.edu.uniquindio.reservasuq.modelo.Horario;
import co.edu.uniquindio.reservasuq.modelo.Instalaciones;
import co.edu.uniquindio.reservasuq.modelo.Reservas;
import co.edu.uniquindio.reservasuq.modelo.Usuarios;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoUsuario;
import java.time.LocalDate;
import java.util.List;

public interface ServiciosReserva {

    Usuarios login(String correo, String password) throws Exception;

    void registrarUsuario(String cedula, String nombre, String correo, TipoUsuario tipoUsuario, String password) throws Exception;

    void registrarUsuario(String cedula, String nombre, TipoUsuario tipoUsuario, String correo, String password) throws Exception;

    void crearInstalaciones(String nombre, int capacidad, float costo, List<Horario> horarios);

    Reservas crearReserva(String idInstalaciones, String cedulaUsuario, LocalDate diaReserva, String horaReserva) throws Exception;

    List<Reservas> listarTodasReservas();

    List<Reservas> listarReservasPorPersona(String cedulaUsuario);

    Usuarios obtenerUsuarios(String cedula, String nombre, String correo, TipoUsuario tipoUsuario, String password);
    Usuarios validarUsuarios(String cedula, String nombre, String correo, TipoUsuario tipoUsuario, String password);
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
