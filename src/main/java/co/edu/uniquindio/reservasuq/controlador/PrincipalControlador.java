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
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class PrincipalControlador implements ServiciosReservasUQ {

    private final ReservasUQ reservasUQ;
    private final Sesion sesion;
    public static PrincipalControlador INSTANCIA;

    private PrincipalControlador(){
        reservasUQ = new ReservasUQ();
        sesion = new Sesion();
    }

    public static PrincipalControlador getInstancia(){
        if(INSTANCIA == null){
            INSTANCIA = new PrincipalControlador();
        }
        return INSTANCIA;
    }

    @Override
    public Persona login(String correo, String contrasena) throws Exception {
        return reservasUQ.login(correo, contrasena);
    }

    @Override
    public Persona registrarPersona(String cedula, String nombre, TipoPersona tipoPersona, String correo, String password) throws Exception {
        return reservasUQ.registrarPersona(cedula, nombre, tipoPersona, correo, password);
    }

    @Override
    public Persona obtenerPersona(String cedula) throws Exception{
        return reservasUQ.obtenerPersona(cedula);
    }

    @Override
    public ArrayList<Persona> listarPersonas() throws Exception {
        return reservasUQ.listarPersonas();
    }

    @Override
    public void crearInstalacion(String nombre, int aforo, double costo, List<Horario> horarios, TipoInstalacion tipoInstalacion) throws Exception {
        reservasUQ.crearInstalacion(nombre, aforo, costo, horarios, tipoInstalacion);
    }

    @Override
    public Reserva obtenerReservasPersona(String correoPersona) throws Exception {
        return reservasUQ.obtenerReservasPersona(correoPersona);
    }

    @Override
    public Reserva crearReserva(String idInstalacion, String cedulaPersona, LocalDate diaReserva, String horaReserva) throws Exception {
        return reservasUQ.crearReserva(idInstalacion, cedulaPersona, diaReserva, horaReserva);
    }

    @Override
    public Instalacion buscarInstalacionPorId(String idInstalacion) throws Exception{
        return reservasUQ.buscarInstalacionPorId(idInstalacion);
    }

    @Override
    public boolean verificarDisponibilidad(Instalacion instalacion, LocalDate diaReserva, String horaReserva) {
        return reservasUQ.verificarDisponibilidad(instalacion, diaReserva, horaReserva);
    }

    @Override
    public List<Reserva> listarTodasReservas() {
        return reservasUQ.listarTodasReservas();
    }

    @Override
    public List<Reserva> listarReservasPorPersona(String cedulaPersona) {
        return reservasUQ.listarReservasPorPersona(cedulaPersona);
    }

    @Override
    public List<Reserva> obtenerHistorialReservas(String cedulaPersona) {
        return reservasUQ.obtenerHistorialReservas(cedulaPersona);
    }

    @Override
    public boolean hayDisponibilidad(LocalDate diaReserva, String horaReserva, String idInstalacion) {
        return  reservasUQ.hayDisponibilidad(diaReserva, horaReserva, idInstalacion);
    }


    @Override
    public void cancelarReserva(String idReserva) throws Exception {
        reservasUQ.cancelarReserva(idReserva);
    }

    @Override
    public List<Reserva> listarReservasPorInstalacion(String idInstalacion) {
        return reservasUQ.listarReservasPorInstalacion(idInstalacion);
    }

    @Override
    public void enviarNotificacionReserva(String email, Reserva reserva) {
        reservasUQ.enviarNotificacionReserva(email, reserva);
    }

    @Override
    public void enviarRecordatorioReserva(String email, Reserva reserva) {
        reservasUQ.enviarRecordatorioReserva(email, reserva);
    }

    @Override
    public double costoReservaInstalacion(String cedulaPersona, String idInstalacion, int horasReserva) throws Exception {
        return reservasUQ.costoReservaInstalacion(cedulaPersona,idInstalacion, horasReserva);
    }

    @Override
    public List<Instalacion> listarInstalaciones() {
        return reservasUQ.listarInstalaciones();
    }

    @Override
    public void agregarUsuario(String cedula, String nombre, String email, TipoPersona tipo) throws Exception {
        reservasUQ.agregarUsuario(cedula, nombre, email, tipo);
    }

    @Override
    public void actualizarUsuario(String cedula, String nombre, String email, TipoPersona tipo) throws Exception {
        reservasUQ.actualizarUsuario(cedula, nombre, email, tipo);
    }

    @Override
    public void eliminarUsuario(String cedula) throws Exception {
        reservasUQ.eliminarUsuario(cedula);
    }

    @Override
    public void actualizarInstalacion(String nombre, Integer nuevoAforo, Double nuevoCosto, List<Horario> nuevosHorarios) throws Exception {
        reservasUQ.actualizarInstalacion(nombre, nuevoAforo, nuevoCosto, nuevosHorarios);
    }

    @Override
    public void eliminarInstalacion(String nombre) throws Exception {
        reservasUQ.eliminarInstalacion(nombre);
    }

    @Override
    public void asignarHorariosInstalacion(String nombre, List<Horario> horarios) throws Exception {
        reservasUQ.asignarHorariosInstalacion(nombre, horarios);
    }

    @Override
    public void establecerCapacidadInstalacion(String nombre, int nuevoAforo) throws Exception {
        reservasUQ.establecerCapacidadInstalacion(nombre, nuevoAforo);
    }

    @Override
    public List<String> generarHorarios() {
        return reservasUQ.generarHorarios();
    }

    @Override
    public Persona validacionDatosIngreso(String correo, String password) throws Exception {
        return reservasUQ.validacionDatosIngreso(correo, password);
    }


    public void mostrarAlerta(String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setHeaderText(mensaje);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public ButtonType mostrarAlertaConfirmacion(String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setHeaderText(mensaje);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
        return alert.getResult();
    }

    public void cerrarVentana(Node node){
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public FXMLLoader navegarVentana(String nombreArchivoFxml, String tituloVentana) {
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
            return loader;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
