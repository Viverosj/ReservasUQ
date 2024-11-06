package co.edu.uniquindio.reservasuq.servicio;

import co.edu.uniquindio.reservasuq.modelo.Horario;
import co.edu.uniquindio.reservasuq.modelo.Instalacion;
import co.edu.uniquindio.reservasuq.modelo.Persona;
import co.edu.uniquindio.reservasuq.modelo.Reserva;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoPersona;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public interface ServiciosReservasUQ {
    Persona registrarPersona(String cedula, String nombre, TipoPersona tipoPersona, String correo, String password) throws Exception;
    Persona obtenerPersona(String cedula) throws Exception;

    boolean esCorreoValido(String correo);
    Persona login(String correo, String password) throws Exception;
    Reserva crearReserva(String cedulaPersona, Instalacion instalacion, LocalDate diaReserva, String hora, double costo) throws Exception;
    int contarReservasParaInstalacion(Instalacion instalacion, LocalDate diaReserva, LocalTime horaReserva);
    boolean hayDisponibilidad(LocalDate diaReserva, LocalTime horaReserva, Instalacion instalacion);
    List<Reserva> listarReservasPorPersona(String cedulaPersona) throws Exception;
    void cancelarReserva(String idReserva) throws Exception;
    Instalacion crearInstalacion(String nombre, int aforo, double costoBase, List<Horario> horarios) throws Exception;
    List<Instalacion> listarInstalaciones()throws Exception;
    void eliminarInstalacion(String instalacionId);
    void actualizarInstalacion(String idInstalacion, String nuevoNombre, int nuevoAforo, double nuevoCosto, List<Horario> nuevosHorarios) throws Exception;
}
