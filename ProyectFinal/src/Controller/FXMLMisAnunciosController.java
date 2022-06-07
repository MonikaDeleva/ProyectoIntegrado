/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Anuncio;
import Model.AnuncioModel;
import Model.Categoria;
import Model.CategoriaModel;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLMisAnunciosController implements Initializable {

    @FXML
    private TableView<Anuncio> tableViewMisAnuncios;
    @FXML
    private TableColumn<Anuncio, String> tableColumnTituloAnuncio;
    @FXML
    private TableColumn<Anuncio, String> tableColumnDescripcionAnuncio;

    @FXML
    private Button botonAnyadirAnuncio;
    @FXML
    private Button botonEliminarAnuncio;
    @FXML
    private Button botonModificarAnuncio;
    @FXML
    private AnchorPane rootPane;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Insertamos los datos de la base de datos en la tabla
        this.tableColumnTituloAnuncio.setCellValueFactory(new PropertyValueFactory("titulo"));
        this.tableColumnDescripcionAnuncio.setCellValueFactory(new PropertyValueFactory("descripcion"));

        AnuncioModel anuncioModel = new AnuncioModel();

        ObservableList<Anuncio> misAnuncios = anuncioModel.getMisAnuncios();

        this.tableViewMisAnuncios.setItems(misAnuncios);

    }

    @FXML
    private void anyadirAnuncio(ActionEvent event) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLPublicarAnuncio.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPublicarAnuncioController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void eliminarAnuncio(ActionEvent event) {

        AnuncioModel anuncioModel = new AnuncioModel();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("ELIMINAR ANUNCIO");
        alert.setContentText("Esta seguro de que quiere eliminar este anuncio?");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {

            Anuncio a = tableViewMisAnuncios.getSelectionModel().getSelectedItem();

            if (anuncioModel.eliminarAnuncio(a.getIdAnuncio())) {

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("ANUNCIO ELIMINADO CORRECTAMENE");
                alert.setContentText("Se ha eliminado correctamente el anuncio");
                alert.showAndWait();

                this.tableColumnTituloAnuncio.setCellValueFactory(new PropertyValueFactory("titulo"));
                this.tableColumnDescripcionAnuncio.setCellValueFactory(new PropertyValueFactory("descripcion"));

                

                ObservableList<Anuncio> misAnuncios = anuncioModel.getMisAnuncios();

                this.tableViewMisAnuncios.setItems(misAnuncios);

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

    @FXML
    private void modificarAnuncio(ActionEvent event) {

        AnuncioModel anuncioModel = new AnuncioModel();

        Anuncio anuncio = tableViewMisAnuncios.getSelectionModel().getSelectedItem();

        Anuncio.getAnuncio().idAnuncio = anuncio.getIdAnuncio();
        Anuncio.getAnuncio().idUsuario = anuncio.getIdUsuario();
        Anuncio.getAnuncio().titulo = anuncio.getTitulo();
        Anuncio.getAnuncio().descripcion = anuncio.getDescripcion();
        Anuncio.getAnuncio().ubicacion = anuncio.getUbicacion();
        Anuncio.getAnuncio().tiempoEstimado = anuncio.getTiempoEstimado();
        Anuncio.getAnuncio().categoria = anuncio.getCategoria();
        Anuncio.getAnuncio().estado = anuncio.getEstado();

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLModificarAnuncio.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPaginaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
