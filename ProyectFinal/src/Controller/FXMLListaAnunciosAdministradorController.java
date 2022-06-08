/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Anuncio;
import Model.AnuncioModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 * <p>En esta escena del administrador podrmoe ver todos los anuncios que hay y eliminar cualquier anuncio.</p>
 *
 * @author 1erDAM
 */
public class FXMLListaAnunciosAdministradorController implements Initializable {

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
    private Button botonEliminarAnuncio;
    @FXML
    private Button botonVolverAtras;
    @FXML
    private AnchorPane rootPane;

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

        ObservableList<Anuncio> listaAnuncios = anuncioModel.getListaAnuncios();

        this.tableView.setItems(listaAnuncios);

    }

    /**
     * <p>Este metodo se encarga de eliminar un anuncio, recogiendo el objeto anuncio de la tabla
     * y llamando a un método de la clase AnuncioModel</p>
     * @param event 
     */
    @FXML
    private void eliminarAnuncio(ActionEvent event) {

        AnuncioModel anuncioModel = new AnuncioModel();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("ELIMINAR ANUNCIO");
        alert.setContentText("Esta seguro de que quiere eliminar este anuncio?");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {

            Anuncio a = tableView.getSelectionModel().getSelectedItem();

            if (anuncioModel.eliminarAnuncio(a.getIdAnuncio())) {

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("ANUNCIO ELIMINADO CORRECTAMENE");
                alert.setContentText("Se ha eliminado correctamente el anuncio");
                alert.showAndWait();

                this.tituloAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("titulo"));
                this.descripcionAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("descripcion"));
                this.categoriaAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("categoriaString"));
                this.ubicacionAnunciosTableColumn.setCellValueFactory(new PropertyValueFactory("ubicacion"));
                this.tiempoEstimadoTableColumn.setCellValueFactory(new PropertyValueFactory("tiempoEstimado"));

                ObservableList<Anuncio> listaAnuncios = anuncioModel.getListaAnuncios();

                this.tableView.setItems(listaAnuncios);

            } else {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("ERROR!! EL ANUNCIO NO SE HA PODIDO ELIMINAR");
                alert.setContentText("No se ha pododido eliminar el anuncio.");
                alert.showAndWait();

            }

        } else {

            Alert alertaCancelarEliminacion = new Alert(Alert.AlertType.INFORMATION);
            alertaCancelarEliminacion.setHeaderText("ELIMINACIÓN CANCELADA");
            alertaCancelarEliminacion.setContentText("La anuncio no se ha eliminado");
            alertaCancelarEliminacion.showAndWait();

        }

    }

    /**
     * <p>Solo tiene la función de volver al Panel de control del Administrador.</p>
     * @param event 
     */
    @FXML
    private void volverAtras(ActionEvent event) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLPanelControlAdministrador.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPanelControlAdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
