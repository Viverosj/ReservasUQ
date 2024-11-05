package co.edu.uniquindio.reservasuq.controlador;

import co.edu.uniquindio.reservasuq.controlador.observador.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class InicioControlador implements Observable, Initializable {


    private final PrincipalControlador controladorPrincipal;

    public InicioControlador() {
        this.controladorPrincipal = PrincipalControlador.getInstancia();
    }

    @FXML
    public void irIniciarSesion(ActionEvent actionEvent) {
        controladorPrincipal.navegarVentana("/login.fxml","Iniciar Sesión");
    }
    @FXML
    public void irRegistroCliente(ActionEvent actionEvent) {
        controladorPrincipal.navegarVentana("/registro.fxml", "Registro Persona");
    }

    @Override
    public void notificar() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
