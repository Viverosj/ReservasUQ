package co.edu.uniquindio.reservasuq.servicio;
import co.edu.uniquindio.reservasuq.modelo.Horario;
import co.edu.uniquindio.reservasuq.modelo.Instalacion;
import co.edu.uniquindio.reservasuq.modelo.Reserva;
import co.edu.uniquindio.reservasuq.modelo.Persona;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoInstalacion;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoPersona;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface ServiciosReservasUQ {
    Persona login(String correo, String password) throws Exception;
    Persona registrarPersona(String cedula, String nombre, TipoPersona tipoPersona, String correo, String password) throws Exception;
    Persona obtenerPersona(String cedula) throws Exception;
    ArrayList<Persona> listarPersonas() throws Exception;
    void crearInstalacion(String nombre, int aforo, double costo, List<Horario> horarios,TipoInstalacion tipoInstalacion) throws Exception;
    Reserva obtenerReservasPersona(String cedulaPersona) throws Exception;
    Reserva crearReserva(String idInstalacion, String cedulaPersona, LocalDate diaReserva, String horaReserva) throws Exception;
    Instalacion buscarInstalacionPorId(String idInstalacion) throws Exception;
    boolean verificarDisponibilidad(Instalacion instalacion, LocalDate diaReserva, String horaReserva);
    List<Reserva> listarTodasReservas();
    List<Reserva> listarReservasPorPersona(String cedulaPersona);
    List<Reserva> obtenerHistorialReservas(String cedulaPersona);
    List<Horario> obtenerHorariosDisponibles(String idInstalacion, LocalDate diaReserva) throws Exception;

    boolean hayDisponibilidad(LocalDate diaReserva, String horaReserva, String idInstalacion);

    void cancelarReserva(String idReserva) throws Exception;
    List<Reserva> listarReservasPorInstalacion(String idInstalacion);
    void enviarNotificacionReserva(String email, Reserva reserva);
    void enviarRecordatorioReserva(String email, Reserva reserva);
    double costoReservaInstalacion(String cedulaPersona, String idInstalacion, int horasReserva) throws Exception;
    List<Instalacion> listarInstalaciones();
    void agregarUsuario(String cedula, String nombre, String email, TipoPersona tipo) throws Exception;
    void actualizarUsuario(String cedula, String nombre, String email, TipoPersona tipo) throws Exception;
    void eliminarUsuario(String cedula) throws Exception;
    void agregarInstalacion(String nombre, int aforo, double costo, List<Horario> horarios, TipoInstalacion tipoInstalacion) throws Exception;
    void actualizarInstalacion(String nombre, Integer nuevoAforo, Double nuevoCosto, List<Horario> nuevosHorarios) throws Exception;
    void eliminarInstalacion(String nombre) throws Exception;
    void asignarHorariosInstalacion(String nombre, List<Horario> horarios) throws Exception;
    void establecerCapacidadInstalacion(String nombre, int nuevoAforo) throws Exception;
    List<String> generarHorarios();
}
