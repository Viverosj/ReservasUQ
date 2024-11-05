package co.edu.uniquindio.reservasuq.controlador;

import co.edu.uniquindio.reservasuq.controlador.observador.Observable;
import co.edu.uniquindio.reservasuq.modelo.Persona;
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

    @FXML private TextField txtCorreo;
    @FXML private PasswordField txtPassword;

    @Setter
    private PrincipalControlador principalControlador;
    private Observable observable;

    public LoginControlador() {
    }

    public void login(ActionEvent actionEvent) {
        FXMLLoader loader = PrincipalControlador.getInstancia().navegarVentana("/login.fxml", "Iniciar sesión");

        String correo = txtCorreo.getText();
        String contrasena = txtPassword.getText();

        if (correo.isEmpty() || contrasena.isEmpty()) {
            PrincipalControlador.getInstancia().mostrarAlerta("Los campos de usuario y contraseña son obligatorios", Alert.AlertType.WARNING);
            return;
        }

        try {
            Persona persona = PrincipalControlador.getInstancia().login(correo, contrasena);
            if (persona == null) {
                PrincipalControlador.getInstancia().mostrarAlerta("El cliente no existe. Lo invitamos a registrarse.", Alert.AlertType.WARNING);
            } else {
                // Lógica para continuar después de un inicio de sesión exitoso
                System.out.println("Inicio de sesión exitoso.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            PrincipalControlador.getInstancia().mostrarAlerta("Error al intentar iniciar sesión", Alert.AlertType.ERROR);
        }
    }


    public void inicializarObservable(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtCorreo.clear();
        txtPassword.clear();
    }

    @Override
    public void notificar() {

    }
}
