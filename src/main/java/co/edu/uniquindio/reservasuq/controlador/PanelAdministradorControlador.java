package co.edu.uniquindio.reservasuq.controlador;

import co.edu.uniquindio.reservasuq.controlador.observador.Observable;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class PanelAdministradorControlador implements Observable, Initializable {

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
