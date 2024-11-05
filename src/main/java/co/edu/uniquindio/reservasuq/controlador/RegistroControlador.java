package co.edu.uniquindio.reservasuq.controlador;

import co.edu.uniquindio.reservasuq.controlador.observador.Observable;
import co.edu.uniquindio.reservasuq.modelo.Persona;
import co.edu.uniquindio.reservasuq.modelo.enums.TipoPersona;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistroControlador implements Observable, Initializable {

    @FXML private ComboBox<TipoPersona> comboTipoUsuario;
    @FXML private TextField txtCedula;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtNombre;
    @FXML private TextField txtPassword;

    private final PrincipalControlador principalControlador;
    private Observable observable;

    public RegistroControlador() {
        this.principalControlador = PrincipalControlador.getInstancia();
    }

    @FXML
    void registrarse(ActionEvent event) {
        if (txtCedula.getText().isEmpty() || txtCorreo.getText().isEmpty() || txtNombre.getText().isEmpty() ||
                txtPassword.getText().isEmpty() || comboTipoUsuario.getValue() == null) {
            principalControlador.mostrarAlerta("Todos los campos son obligatorios para el registro",
                    Alert.AlertType.WARNING);
            return;
        }
        try {
            System.out.println("CÉDULA PARA BUSCAR: " + txtCedula.getText());
            Persona persona = principalControlador.registrarPersona(txtCedula.getText(), txtNombre.getText(), comboTipoUsuario.getValue(), txtCorreo.getText(), txtPassword.getText());
            if (persona != null) {
                principalControlador.mostrarAlerta("El usuario fue creado con éxito.", Alert.AlertType.INFORMATION);
                observable.notificar();
                principalControlador.navegarVentana("/registro.fxml", "Registrarse");
                principalControlador.getSesion().setPersona(null);
                principalControlador.cerrarVentana(txtNombre);
            } else {
                principalControlador.mostrarAlerta("No fue posible crear el usuario", Alert.AlertType.WARNING);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            principalControlador.mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void obtenerTipoUsuario(ActionEvent event) {
    }

    public void inicializarObservable(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void notificar() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarTiposDePersona();
    }

    private void cargarTiposDePersona() {
        comboTipoUsuario.setItems(FXCollections.observableArrayList(TipoPersona.values()));
    }
}
