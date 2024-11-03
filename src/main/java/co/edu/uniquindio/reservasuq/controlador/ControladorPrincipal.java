package co.edu.uniquindio.reservasuq.controlador;
import co.edu.uniquindio.reservasuq.modelo.*;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoInstalacion;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoPersona;
import co.edu.uniquindio.reservasuq.servicio.ServiciosReservasUQ;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ControladorPrincipal implements ServiciosReservasUQ {

    private static ControladorPrincipal INSTANCIA;
    private final ReservasUQ reservasUQ;

    private ControladorPrincipal() {
        reservasUQ = new ReservasUQ();
    }

    public static ControladorPrincipal getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new ControladorPrincipal();
        }
        return INSTANCIA;
    }

    @Override
    public Persona login(String correo, String contrasena) throws Exception {
        return reservasUQ.login(correo, contrasena);
    }

    @Override
    public void registrarPersona(String cedula, String nombre, TipoPersona tipoPersona, String correo, String password) throws Exception {
    }

    @Override
    public Persona obtenerPersona(String cedula) {
        return null; //creo que se cambia
    }

    @Override
    public void crearInstalacion(String nombre, int aforo, double costo, List<Horario> horarios, TipoInstalacion tipoInstalacion) throws Exception {

    }

    @Override
    public Reserva crearReserva(String idInstalacion, String cedulaPersona, LocalDate diaReserva, String horaReserva) throws Exception {
        return null;
    }

    @Override
    public Instalacion buscarInstalacionPorId(String idInstalacion) {
        return null;
    }

    @Override
    public boolean verificarDisponibilidad(Instalacion instalacion, LocalDate diaReserva, String horaReserva) {
        return false;
    }

    @Override
    public List<Reserva> listarTodasReservas() {
        return null;
    }

    @Override
    public List<Reserva> listarReservasPorPersona(String cedulaPersona) {
        return null;
    }

    @Override
    public List<Reserva> obtenerHistorialReservas(String cedulaPersona) {
        return null;
    }

    @Override
    public List<Horario> obtenerHorariosDisponibles(String idInstalacion, LocalDate diaReserva) {
        return null;
    }

    @Override
    public void cancelarReserva(String idReserva) throws Exception {

    }

    @Override
    public List<Reserva> listarReservasPorInstalacion(String idInstalacion) {
        return null;
    }

    @Override
    public void enviarNotificacionReserva(String email, Reserva reserva) {

    }

    @Override
    public void enviarRecordatorioReserva(String email, Reserva reserva) {

    }

    @Override
    public double costoReservaInstalacion(String cedulaPersona, String idInstalacion, int horasReserva) {
        return 0;
    }

    @Override
    public void definirRestricciones(String idInstalacion, int aforoMaximo, LocalDate horarioInicio, LocalDate horarioFin) {

    }

    @Override
    public List<Persona> listarUsuariosPorTipo(TipoPersona tipo) {
        return null;
    }

    @Override
    public List<Instalacion> listarInstalaciones() {
        return null;
    }

    @Override
    public void actualizarInstalacion(String idInstalacion, int aforo, float costo, List<Horario> horarios) {

    }

    @Override
    public void gestionarInstalaciones() throws Exception {

    }

    @Override
    public void gestionarUsuarios() throws Exception {

    }

    //TODO Completar con el resto de métodos necesarios para la aplicación

    public void mostrarAlerta(String mensaje, String titulo, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void navegarVentana(String nombreArchivoFxml, String tituloVentana) {
        try {

            // Cargar la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nombreArchivoFxml));
            Parent root = loader.load();

            // Crear la escena
            Scene scene = new Scene(root);

            // Crear un nuevo escenario (ventana)
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(tituloVentana);

            // Mostrar la nueva ventana
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void cerrarVentana(Node node) {
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    }
