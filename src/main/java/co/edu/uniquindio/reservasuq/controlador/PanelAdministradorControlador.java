package co.edu.uniquindio.reservasuq.controlador;

import co.edu.uniquindio.reservasuq.controlador.observador.Observable;
import co.edu.uniquindio.reservasuq.modelo.Horario;
import co.edu.uniquindio.reservasuq.modelo.Instalacion;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PanelAdministradorControlador implements Observable, Initializable {

    @FXML private ComboBox<Horario> cbHorario;
    @FXML private ComboBox<TipoInstalacion> cbTipoInstalacion;
    @FXML private TableView<Instalacion> tablaInstalaciones;
    @FXML private TableColumn<Instalacion, String> colHorario;
    @FXML private TableColumn<Instalacion, String> colAforo;
    @FXML private TableColumn<Instalacion, String> colCosto;
    @FXML private TableColumn<Instalacion, String> colTipoInstalacion;
    @FXML private TextField txtAforo;
    @FXML private TextField txtCosto;
    private Observable observable;
    private  final PrincipalControlador principalControlador;

    public PanelAdministradorControlador( ) {
        this.principalControlador = PrincipalControlador.getInstancia();
        System.out.println(principalControlador.getReservasUQ().getInstalaciones());
    }

    public void inicializarObservable(Observable observable) {
        this.observable = observable;
    }

    public void inicializarValores(PrincipalControlador principalControlador){
        try {
            if(principalControlador != null){
                actualizarTabla((ArrayList) principalControlador.getSesion().getInstalaciones());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void actualizarTabla(ArrayList listaInstalaciones){
        colHorario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHorarios().toString()));
        colAforo.setCellValueFactory(cellData -> new SimpleStringProperty());
        colCosto.setCellValueFactory(cellData -> new SimpleStringProperty());
        colTipoInstalacion.setCellValueFactory(cellData -> new SimpleStringProperty());

        tablaInstalaciones.setItems(FXCollections.observableArrayList(listaInstalaciones));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inicializarValores(principalControlador);
        //cbHorario.setItems(FXCollections.observableArrayList());
        cbTipoInstalacion.setItems(FXCollections.observableArrayList(TipoInstalacion.values()));
    }

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
    void cerrarSesion(ActionEvent event) {

    }



    @Override
    public void notificar() {

    }




}
