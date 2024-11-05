package co.edu.uniquindio.reservasuq.controlador;

import co.edu.uniquindio.reservasuq.controlador.observador.Observable;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ReservasControlador implements Observable, Initializable {

    @FXML private DatePicker txtDiaReserva;
    @FXML private TextField txtEmail;
    @FXML private ComboBox<String> cbHoraInicio;
    @FXML private ComboBox<String> cbHoraFin;
    @FXML private TextField txtIdInstalacion;
    private final PrincipalControlador principalControlador;
    private Observable observable;

    public ReservasControlador(PrincipalControlador principalControlador) {
        this.principalControlador = PrincipalControlador.getInstancia();
    }

    public void inicializarObservable(Observable observable) {
        this.observable = observable;
    }


    @FXML
    void registrarReserva(ActionEvent event) {
        try {
            String idInstalacion = txtIdInstalacion.getText();
            LocalDate diaReserva = txtDiaReserva.getValue();
            String correoPersona = txtEmail.getText();
            String horaInicio = cbHoraInicio.getValue();
            String horaFin = cbHoraFin.getValue();

            principalControlador.crearReserva(idInstalacion, correoPersona, diaReserva, horaInicio, horaFin);
            limpiarFormularioReserva();
            principalControlador.mostrarAlerta("La reserva ha sido creada y la notificación ha sido enviada.", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            principalControlador.mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void limpiarFormularioReserva() {
        txtIdInstalacion.setText("");
        txtDiaReserva.setValue(null);
        txtEmail.setText("");
        cbHoraInicio.setValue(null);
        cbHoraFin.setValue(null);
    }
    @Override
    public void notificar() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbHoraInicio.setItems(FXCollections.observableArrayList(principalControlador.generarHorarios()));
        cbHoraFin.setItems(FXCollections.observableArrayList(principalControlador.generarHorarios()));
    }
}
