package co.edu.uniquindio.reservasuq.controlador;
import co.edu.uniquindio.reservasuq.modelo.*;
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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class PrincipalControlador implements ServiciosReservasUQ {

    private final ReservasUQ reservasUQ;
    private final Sesion sesion;
    public static PrincipalControlador INSTANCIA;

    private PrincipalControlador(){
        reservasUQ = new ReservasUQ(); //NO SE QUE VA AQUI
        sesion = new Sesion();
    }

    public static PrincipalControlador getInstancia(){
        if(INSTANCIA == null){
            INSTANCIA = new PrincipalControlador();
        }
        return INSTANCIA;
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
    public boolean esCorreoValido(String correo) {
        return false;
    }

    @Override
    public Persona login(String correo, String contrasena) throws Exception {
        return reservasUQ.login(correo, contrasena);
    }

    @Override
    public Reserva crearReserva(String cedulaPersona, Instalacion instalacion, LocalDate diaReserva, String hora, double costo) throws Exception {
        return null;
    }

    @Override
    public int contarReservasParaInstalacion(Instalacion instalacion, LocalDate diaReserva, LocalTime horaReserva) {
        return 0;
    }

    @Override
    public boolean hayDisponibilidad(LocalDate diaReserva, LocalTime horaReserva, Instalacion instalacion) {
        return false;
    }

    @Override
    public List<Reserva> listarReservasPorPersona(String cedulaPersona) throws Exception {
        return null;
    }

    @Override
    public void cancelarReserva(String idReserva) throws Exception {

    }

    @Override
    public Instalacion crearInstalacion(String nombre, int aforo, double costoBase, List<Horario> horarios) throws Exception {
        return null;
    }

    @Override
    public List<Instalacion> listarInstalaciones() throws Exception {
        return null;
    }

    @Override
    public void eliminarInstalacion(String instalacionId) {

    }

    @Override
    public void actualizarInstalacion(String idInstalacion, String nuevoNombre, int nuevoAforo, double nuevoCosto, List<Horario> nuevosHorarios) throws Exception {

    }

    public FXMLLoader navegarVentana(String s, String panelReservas) {
        return null;
    }

    public Reserva obtenerReservasPersona(String cedula) {
        return null;
    }

    public void mostrarAlerta(String message, Alert.AlertType alertType) {
    }
}
