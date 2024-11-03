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


}
