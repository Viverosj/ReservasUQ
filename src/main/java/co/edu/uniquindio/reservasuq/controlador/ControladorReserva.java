package co.edu.uniquindio.reservasuq.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import co.edu.uniquindio.reservasuq.modelo.Reserva;
import co.edu.uniquindio.reservasuq.servicio.ServiciosReservasUQ;
//import co.edu.uniquindio.reservasuq.servicio.ReservasUQ;

import java.time.LocalDate;
import java.time.LocalTime;

public class ControladorReserva { // esto es un ejemplo sobre todo para tener en cuenta lo de el envio de notificacion

   // private final ServiciosReservasUQ reservasUQ = new ReservasUQ();

    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtInstalacion;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtFecha; // Supongamos formato YYYY-MM-DD
    @FXML
    private TextField txtHoraInicio; // Supongamos formato HH:MM
    @FXML
    private TextField txtHoraFin; // Supongamos formato HH:MM

    // Método para manejar el evento de crear reserva desde el formulario
    @FXML
    public void crearReserva() {
        try {
            // Obtener los datos del formulario
            String email = txtEmail.getText();
            String idInstalacion = txtInstalacion.getText();
            String cedulaPersona = txtCedula.getText();
            LocalDate diaReserva = LocalDate.parse(txtFecha.getText());
            LocalTime horaInicio = LocalTime.parse(txtHoraInicio.getText());
            LocalTime horaFin = LocalTime.parse(txtHoraFin.getText());

            // Crear la reserva
           // Reserva reserva = reservasUQ.crearReserva(idInstalacion, cedulaPersona, diaReserva, horaInicio, horaFin);

            // Enviar la notificación de reserva
           // reservasUQ.enviarNotificacionReserva(email, reserva);

            // Mostrar mensaje de éxito
            mostrarAlerta("Reserva creada", "La reserva ha sido creada y la notificación ha sido enviada.", Alert.AlertType.INFORMATION);

        } catch (Exception e) {
            // Mostrar mensaje de error
            mostrarAlerta("Error", "No se pudo crear la reserva: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    // Método para mostrar una alerta en pantalla
    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}