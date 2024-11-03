package co.edu.uniquindio.reservasuq.servicio;
import co.edu.uniquindio.reservasuq.modelo.Horario;
import co.edu.uniquindio.reservasuq.modelo.Instalacion;
import co.edu.uniquindio.reservasuq.modelo.Reserva;
import co.edu.uniquindio.reservasuq.modelo.Persona;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoInstalacion;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoPersona;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ServiciosReservasUQ {

    Persona login(String correo, String password) throws Exception;

    void registrarPersona(String cedula, String nombre, TipoPersona tipoPersona, String correo, String password) throws Exception;

    Persona obtenerPersona(String cedula);

    void crearInstalacion(String nombre, int aforo, TipoInstalacion tipoInstalacion, List<Horario> horarios) throws Exception;

    Reserva crearReserva(String idInstalaciones, String cedulaUsuario, LocalDate diaReserva, String horaReserva) throws Exception;
    List<Reserva> listarTodasReservas();
    List<Reserva> listarReservasPorPersona(String cedulaUsuario);
    void actualizarDatosPersona(String cedula, String nombre, TipoPersona tipoPersona, String email, String password) throws Exception;
    //(Para permitir que los usuarios actualicen su información personal.)
    void eliminarPersona(String cedula) throws Exception;
    //(Para eliminar usuarios registrados.)
    List<Reserva> obtenerHistorialReservas(String cedulaPersona);
    //(Para que el usuario consulte el historial de sus reservas.)

    boolean verificarDisponibilidad(String idInstalacion, LocalDate diaReserva, String horaReserva);
    //(Para chequear la disponibilidad de una instalación en un horario específico.)
    List<Horario> obtenerHorariosDisponibles(String idInstalacion, LocalDate diaReserva);
    //(Para listar los horarios disponibles de una instalación en una fecha específica.)
    void cancelarReserva(String idReserva) throws Exception;
    //(Permite a los usuarios cancelar una reserva según las políticas.)
    List<Reserva> listarReservasPorInstalacion(String idInstalacion);
    //(Para ver las reservas actuales de una instalación.)
    void enviarNotificacionReserva(String email, String mensaje);
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

}
