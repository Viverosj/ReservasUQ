package co.edu.uniquindio.reservasuq.controlador;

import co.edu.uniquindio.reservasuq.controlador.observador.Observable;
import co.edu.uniquindio.reservasuq.modelo.Persona;
import co.edu.uniquindio.reservasuq.modelo.Reserva;
import co.edu.uniquindio.reservasuq.modelo.Sesion;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class PanelClienteControlador implements Observable, Initializable {

    @FXML private Button reservar;
    @FXML private Button cancelarReserva;
    @FXML private TableColumn<Reserva, String> colDiaReserva;
    @FXML private TableColumn<Reserva, String> colHoraReserva;
    @FXML private TableColumn<Reserva, String> colIdInstalacion;
    @FXML private Label mensajeBienvenida;
    @FXML private TableView<Reserva> tablaHistorial;

    private PrincipalControlador principalControlador;
    private Observable observable;
    private final Sesion sesion = Sesion.getInstancia();
    Persona persona = sesion.getPersona();
    Reserva reserva = principalControlador.obtenerReservasPersona(persona.getCedula());

    public PanelClienteControlador() throws Exception {
        this.principalControlador = PrincipalControlador.getInstancia();
    }

    public void inicializarObservable(Observable observable) {
        this.observable = observable;
    }
    public void inicializarValores(Persona persona){
        try {
            if(persona != null){
                setConsultarHistorial();
                mostrarMensajePanel();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void mostrarMensajePanel(){
        mensajeBienvenida.setText(persona.getNombre() + ", bienvenido a su historial y gestión de reservas");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Persona persona = sesion.getPersona();
        inicializarValores(persona);

        colIdInstalacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getInstalacion()));
        colDiaReserva.setCellValueFactory(cellData -> new SimpleStringProperty());
        colHoraReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHoraReserva()));

        tablaHistorial.setItems(FXCollections.observableArrayList());

    }

    private void setConsultarHistorial() throws Exception {
        if (persona != null) {
            tablaHistorial.setItems(FXCollections.observableArrayList(principalControlador.listarReservasPorPersona(persona.getCorreo())));
        }
    }

    @FXML
    public void reservar(ActionEvent event) throws Exception{
        FXMLLoader loader = principalControlador.navegarVentana("/reservas.fxml", "Panel Reservas");
        ReservasControlador reservasControlador = loader.getController();
        reservasControlador.inicializarObservable(this);
    }

    @FXML
    void cerrarSesion(ActionEvent event) {
        sesion.cerrarSesion();
    }

    @FXML
    private void cancelarReserva(ActionEvent event){

    }

    @Override
    public void notificar() throws Exception {
        setConsultarHistorial();
    }


}
