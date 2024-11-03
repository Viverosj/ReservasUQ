package co.edu.uniquindio.reservasuq.modelo;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoPersona;
import co.edu.uniquindio.reservasuq.servicio.ServiciosReservasUQ;
import java.time.LocalDate;
import java.util.List;
public class ReservasUQ implements ServiciosReservasUQ {

    List<Persona> usuarios;
    List<Instalacion> instalaciones;
    List<Reservas> reservas;

    @Override
    public Persona login(String correo, String password) throws Exception {
        return null;
    }

    @Override
    public void registrarPersona(String cedula, String nombre, String correo, TipoPersona tipoPersona, String password) throws Exception {

    }


    @Override
    public void registrarUsuario(String cedula, String nombre, TipoPersona tipoUsuario, String correo, String password) throws Exception {

    }

    @Override
    public void crearInstalaciones(String nombre, int capacidad, float costo, List<Horario> horarios) {

    }

    @Override
    public Reservas crearReserva(String idInstalaciones, String cedulaUsuario, LocalDate diaReserva, String horaReserva) throws Exception {
        return null;
    }

    @Override
    public List<Reservas> listarTodasReservas() {
        return null;
    }

    @Override
    public List<Reservas> listarReservasPorPersona(String cedulaUsuario) {
        return null;
    }

    @Override
    public Persona obtenerUsuarios(String cedula, String nombre, String correo, TipoPersona tipoUsuario, String password) {
        return null;
    }

    @Override
    public Persona validarUsuarios(String cedula, String nombre, String correo, TipoPersona tipoUsuario, String password) {
        return null;
    }

    @Override
    public void enviarNotificacionEmail() {

    }

    @Override
    public boolean validarIngresoAdministrador() {
        return false;
    }

    @Override
    public Instalacion crearEvento() {
        return null;
    }

    @Override
    public Instalacion obtenerEvento() {
        return null;
    }

    @Override
    public void validarDisponibilidad() {

    }

    @Override
    public void crearReserva() {

    }

    @Override
    public void cancelarReserva() {

    }

    @Override
    public boolean disponibilidadInstalaciones() {
        return false;
    }

    @Override
    public String historialReservas() {
        return null;
    }

    @Override
    public int capacidadMaxima() {
        return 0;
    }

    @Override
    public double costoReserva() {
        return 0;
    }
}
