package co.edu.uniquindio.reservasuq.controlador;

import co.edu.uniquindio.reservasuq.controlador.observador.Observable;
import co.edu.uniquindio.reservasuq.modelo.Persona;
import co.edu.uniquindio.reservasuq.modelo.Sesion;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoPersona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginControlador implements Observable, Initializable {

    @FXML
    private TextField txtCorreo;
    @FXML
    private PasswordField txtPassword;

    @Setter
    private PrincipalControlador principalControlador;
    private Observable observable;

    public LoginControlador() {
        this.principalControlador = PrincipalControlador.getInstancia();
        this.observable = this;
    }

    public void inicializarObservable(Observable observable) {
        this.observable = observable;
    }

    public void login(ActionEvent actionEvent) {
        try {
            String email = txtCorreo.getText();
            String password = txtPassword.getText();
            Persona persona = principalControlador.login(email, password);

            if (persona.getTipoPersona() != TipoPersona.ADMINISTRADOR) {
                Sesion sesion = Sesion.getInstancia();
                sesion.setPersona(persona);
                FXMLLoader loader = principalControlador.navegarVentana("/panelCliente.fxml", "Panel Usuario");
                PanelClienteControlador controlador = loader.getController();
                controlador.inicializarObservable(this);
            } else {
                Sesion sesion = Sesion.getInstancia();
                sesion.setPersona(persona);
                FXMLLoader loader = principalControlador.navegarVentana("/panelAdministrador.fxml", "Panel Administrador");
                PanelAdministradorControlador controlador = loader.getController();
                controlador.inicializarObservable(this);
            }
            principalControlador.cerrarVentana(txtCorreo);
        } catch (Exception e) {
            principalControlador.mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtCorreo.clear();
        txtPassword.clear();
    }

    @Override
    public void notificar() {
        if (observable != null) {
            observable.notificar();
        } else {
            System.out.println("No se pudo notificar porque observable es null");
        }
    }
}
