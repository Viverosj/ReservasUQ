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

public class ReservasControlador implements Initializable {

    @FXML private DatePicker txtDiaReserva;
    @FXML private TextField txtCedula;
    @FXML private ComboBox<String> cbHoraReserva;
    @FXML private TextField txtIdInstalacion;
    private final PrincipalControlador principalControlador;
    private Observable observable;

    public ReservasControlador(PrincipalControlador principalControlador) {
        this.principalControlador = PrincipalControlador.getInstancia();
    }

    public void inicializarObservable(Observable observable) {
        this.observable = observable;
    }

    //va al controlador de panel cliente
    @FXML
    void registrarReserva(ActionEvent event) {
        try {
            String idInstalacion = txtIdInstalacion.getText();
            LocalDate diaReserva = txtDiaReserva.getValue();
            String cedulaPersona = txtCedula.getText();
            String horaReserva = cbHoraReserva.getValue();

            principalControlador.crearReserva(idInstalacion, cedulaPersona, diaReserva, horaReserva);
            observable.notificar(); //Se debe invocar este método para que actualice la tabla
            limpiarFormularioReserva();
            principalControlador.mostrarAlerta("La reserva ha sido creada y la notificación ha sido enviada.", Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            principalControlador.mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void limpiarFormularioReserva() {
        txtIdInstalacion.setText("");
        txtDiaReserva.setValue(null);
        txtCedula.setText("");
        cbHoraReserva.setValue(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbHoraReserva.setItems(FXCollections.observableArrayList(principalControlador.generarHorarios()));
    }
}
