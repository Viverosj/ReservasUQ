package co.edu.uniquindio.reservasuq.servicio;
import co.edu.uniquindio.reservasuq.modelo.Horario;
import co.edu.uniquindio.reservasuq.modelo.Instalacion;
import co.edu.uniquindio.reservasuq.modelo.Reserva;
import co.edu.uniquindio.reservasuq.modelo.Persona;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoInstalacion;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoPersona;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface ServiciosReservasUQ {

    Persona login(String correo, String password) throws Exception;

    void registrarPersona(String cedula, String nombre, TipoPersona tipoPersona, String correo, String password) throws Exception;

    Persona obtenerPersona(String cedula);

    void crearInstalacion(String nombre, int aforo, double costo, List<Horario> horarios,TipoInstalacion tipoInstalacion) throws Exception;

    Reserva crearReserva(String idInstalacion, String cedulaPersona, LocalDate diaReserva, String horaReserva) throws Exception;

    Instalacion buscarInstalacionPorId(String idInstalacion);

    boolean verificarDisponibilidad(Instalacion instalacion, LocalDate diaReserva, String horaReserva);

    List<Reserva> listarTodasReservas();
    List<Reserva> listarReservasPorPersona(String cedulaPersona);

    List<Reserva> obtenerHistorialReservas(String cedulaPersona);

    List<Horario> obtenerHorariosDisponibles(String idInstalacion, LocalDate diaReserva) throws Exception;

    void cancelarReserva(String idReserva) throws Exception;

    List<Reserva> listarReservasPorInstalacion(String idInstalacion);

    void enviarNotificacionReserva(String email, Reserva reserva);
    //(Para enviar una notificación al usuario sobre la confirmación de su reserva.)
    void enviarRecordatorioReserva(String idReserva);
    //(Para enviar recordatorios de reservas próximas.)
    boolean verificarRestriccionUsuario(String cedulaPersona, String idInstalacion);
    //(Para verificar si el usuario cumple con las restricciones de acceso a una instalación.)
    void definirRestricciones(String idInstalacion, int aforoMaximo, LocalDate horarioInicio, LocalDate horarioFin);
    //(Permite a los administradores configurar restricciones para las instalaciones.)
    List<Persona> listarUsuariosPorTipo(TipoPersona tipo);
    //(Para listar usuarios por tipo: estudiantes, docentes, administrativos, externos.)
    List<Instalacion> listarInstalaciones();
    //(Para ver todas las instalaciones disponibles.)
    void actualizarInstalacion(String idInstalacion, int aforo, float costo, List<Horario> horarios);
    //(Para modificar los detalles de una instalación.)
    void gestionarInstalaciones() throws Exception;
    void gestionarUsuarios() throws Exception;

}
