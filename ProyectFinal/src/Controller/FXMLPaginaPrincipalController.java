/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Anuncio;
import Model.AnuncioModel;
import Model.Usuario;
import java.net.URL;
import java.util.ArrayList;
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
 *
 * @author 1erDAM
 */
public class FXMLPaginaPrincipalController implements Initializable {

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
    private Button botonInscribirme;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Insertamos los datos de la base de datos en la tabla
        this.tituloAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("titulo"));
        this.descripcionAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.categoriaAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("categoriaString"));
        this.ubicacionAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("ubicacion"));
        this.tiempoEstimadoTableColumn.setCellValueFactory(new PropertyValueFactory("tiempoEstimado"));

        AnuncioModel anuncioModel = new AnuncioModel();

        ObservableList<Anuncio> anunciosLibres = anuncioModel.getAnunciosLibres();

        this.tableView.setItems(anunciosLibres);

    }

    @FXML
    private void inscribirmeAnuncio(ActionEvent event) {

        AnuncioModel anuncioModel = new AnuncioModel();

        Anuncio anuncio = tableView.getSelectionModel().getSelectedItem();

        if (anuncio.getIdUsuario() == Usuario.getUsuario().id) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setContentText("No te puedes inscribir en tu propio anuncio!!");
            alert.showAndWait();

        } else if (anuncioModel.inscribirAnuncio(anuncio.getIdAnuncio())) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("INSCRITO");
            alert.setContentText("Te has inscrito correctamente en el anuncio.");
            alert.showAndWait();
            
            anuncioModel.actualizarEstadoAnuncio(anuncio, Anuncio.ESTADO_PENDIENTE);
            

            //Actualizamos la tabla
            this.tituloAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("titulo"));
            this.descripcionAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("descripcion"));
            this.categoriaAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("categoriaString"));
            this.ubicacionAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("ubicacion"));
            this.tiempoEstimadoTableColumn.setCellValueFactory(new PropertyValueFactory("tiempoEstimado"));

            ObservableList<Anuncio> anunciosLibres = anuncioModel.getAnunciosLibres();

            this.tableView.setItems(anunciosLibres);

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setContentText("No te puedes inscribir en este anuncio!!");
            alert.showAndWait();

        }

    }

}
