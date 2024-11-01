package co.edu.uniquindio.reservasuq.controlador;
import co.edu.uniquindio.reservasuq.modelo.*;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoUsuario;
import co.edu.uniquindio.reservasuq.servicio.ServiciosReserva;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;

public class ControladorPrincipal implements ServiciosReserva {

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
    public Usuarios login(String correo, String contrasena) throws Exception {
        return reservasUQ.login(correo, contrasena);
    }

    @Override
    public void registrarUsuario(String cedula, String nombre, String correo, TipoUsuario tipoUsuario, String password) throws Exception {

    }

    @Override
    public void registrarUsuario(String cedula, String nombre, TipoUsuario tipoUsuario, String correo, String password) throws Exception {
        reservasUQ.registrarUsuario(cedula, nombre, tipoUsuario, correo, password);
    }

    @Override
    public void crearInstalaciones(String nombre,int aforo, float costo, List<Horario> horarios) {
        reservasUQ.crearInstalaciones(nombre, aforo, costo, horarios);
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
