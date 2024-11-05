package co.edu.uniquindio.reservasuq.controlador;

import co.edu.uniquindio.reservasuq.controlador.observador.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class PanelAdministradorControlador implements Observable, Initializable {

    @FXML private TableColumn<?, ?> ColHorario;
    @FXML private TableColumn<?, ?> colAforo;
    @FXML private TableColumn<?, ?> colCosto;
    @FXML private TableColumn<?, ?> colIdInstalacion;
    @FXML private TableColumn<?, ?> colTipoInstalacion;

    @FXML
    void agregarInstalacion(ActionEvent event) {

    }

    @FXML
    void cbHorario(ActionEvent event) {

    }

    @FXML
    void cbTipoInstalacion(ActionEvent event) {

    }

    @FXML
    void txtAforo(ActionEvent event) {

    }

    @FXML
    void txtIdInstalacion(ActionEvent event) {

    }
    private Observable observable;

    @Override
    public void notificar() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void inicializarObservable(Observable observable) {
        this.observable = observable;
    }
}
