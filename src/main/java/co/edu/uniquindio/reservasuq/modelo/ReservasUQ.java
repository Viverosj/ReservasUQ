package co.edu.uniquindio.reservasuq.modelo;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoUsuario;
import co.edu.uniquindio.reservasuq.servicio.ServiciosReserva;
import java.time.LocalDate;
import java.util.List;

public class ReservasUQ implements ServiciosReserva {

    List<Usuarios> usuarios;
    List<Instalaciones> instalaciones;
    List<Reservas> reservas;

    @Override
    public Usuarios login(String correo, String password) throws Exception {
        return null;
    }

    @Override
    public void registrarUsuario(String cedula, String nombre, String correo, TipoUsuario tipoUsuario, String password) throws Exception {

    }

    @Override
    public void registrarUsuario(String cedula, String nombre, TipoUsuario tipoUsuario, String correo, String password) throws Exception {

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
    public Usuarios obtenerUsuarios(String cedula, String nombre, String correo, TipoUsuario tipoUsuario, String password) {
        return null;
    }

    @Override
    public Usuarios validarUsuarios(String cedula, String nombre, String correo, TipoUsuario tipoUsuario, String password) {
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
    public Instalaciones crearEvento() {
        return null;
    }

    @Override
    public Instalaciones obtenerEvento() {
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
