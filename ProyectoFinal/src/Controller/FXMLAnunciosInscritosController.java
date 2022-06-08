/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Anuncio;
import Model.AnuncioModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 * <p>
 * Esta clase nos muestra en una tabla los anuncios en los que estoy inscrito,
 * dispone de un boton en el que podemos desasociarnos de el anuncio que
 * tengamos seleccionado en la tabla.<p>
 * <p>
 * La tabla disponde de la siguiente información:</p>
 * <ul>
 * <li>Titulo del anuncio</li>
 * <li>Descripción del anuncio</li>
 * <li>Categoría del anuncio</li>
 * <li>Ubicación del anuncio</li>
 * <li>Tiempo estimado del anuncio en minutos</li>
 * </ul>
 *
 * @author 1erDAM
 */
public class FXMLAnunciosInscritosController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Anuncio> tableView;
    @FXML
    private TableColumn<Anuncio, String> tituloAnunciosTableColumn;
    @FXML
    private TableColumn<Anuncio, String> descripcionAnunciosTableColumn;
    @FXML
    private TableColumn<Anuncio, String> categoriaAnunciosTableColumn;
    @FXML
    private TableColumn<Anuncio, String> ubicacionAnunciosTableColumn;
    @FXML
    private TableColumn<Anuncio, Integer> tiempoEstimadoTableColumn;
    @FXML
    private Button botonAbandonarAnuncio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        AnuncioModel anuncioModel = new AnuncioModel();

        //Insertamos los datos de la base de datos en la tabla
        this.tituloAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("titulo"));
        this.descripcionAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.categoriaAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("categoriaString"));
        this.ubicacionAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("ubicacion"));
        this.tiempoEstimadoTableColumn.setCellValueFactory(new PropertyValueFactory("tiempoEstimado"));

        ObservableList<Anuncio> anunciosInscritos = anuncioModel.getAnunciosInscritos();

        this.tableView.setItems(anunciosInscritos);

    }

    /**
     * <p>
     * Este metodo es una acción de un boton en el que abandonaremos un anuncio
     * en el que estamos inscritos con tan solo pulsar el anuncio en la tabla y
     * luego el botón. Este llamará a la base de datos con un metodo sitiado en
     * anuncioModel. Además cambiara el estado de ese anuncio de ocupado a
     * Libre.</p>
     *
     * @param event
     */
    @FXML
    private void abandonarAnuncio(ActionEvent event) {

        AnuncioModel anuncioModel = new AnuncioModel();

        Anuncio anuncio = tableView.getSelectionModel().getSelectedItem();

        if (anuncioModel.actualizarEstadoAnuncio(anuncio, Anuncio.ESTADO_LIBRE) && anuncioModel.eliminarAnuncioInscrito(anuncio.getIdAnuncio())) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("ELIMINADO");
            alert.setContentText("Ya no estas inscrito en ese anuncio.");
            alert.showAndWait();

            //Actualizamos la tabla
            this.tituloAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("titulo"));
            this.descripcionAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("descripcion"));
            this.categoriaAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("categoriaString"));
            this.ubicacionAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("ubicacion"));
            this.tiempoEstimadoTableColumn.setCellValueFactory(new PropertyValueFactory("tiempoEstimado"));

            ObservableList<Anuncio> anunciosInscritos = anuncioModel.getAnunciosInscritos();

            this.tableView.setItems(anunciosInscritos);

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR!!");
            alert.setContentText("No hemos podido eliminarte de ese anuncio.");
            alert.showAndWait();

        }

    }

}
