/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Anuncio;
import Model.AnuncioModel;
import Model.Categoria;
import Model.CategoriaModel;
import Model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLModificarAnuncioController implements Initializable {

    @FXML
    private TextField tituloAnuncioTextField;
    @FXML
    private TextField descripcionAnuncioTextField;
    @FXML
    private ChoiceBox<String> ubicacionAnuncioChoiceBox;
    @FXML
    private ChoiceBox<String> categoriaAnuncioChoiceBox;
    @FXML
    private Spinner<Integer> tiempoEstimadoAnuncioSpinner;
    @FXML
    private Button botonModificarAnuncio;
    @FXML
    private ChoiceBox<String> estadoAnuncioChoiceBox;
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Rellenamos el choiceBox de ubicaciones
        ubicacionAnuncioChoiceBox.getItems().add("Valencia");
        ubicacionAnuncioChoiceBox.getItems().add("Alzira");
        ubicacionAnuncioChoiceBox.getItems().add("Almussafes");
        ubicacionAnuncioChoiceBox.getItems().add("Algemesi");
        ubicacionAnuncioChoiceBox.getItems().add("Catarroja");
        ubicacionAnuncioChoiceBox.getItems().add("Carcaixent");

        //Rellenamos el choiceBox de categorias
        CategoriaModel categoriaModel = new CategoriaModel();
        ArrayList<Categoria> listaCategorias = categoriaModel.getCategorias();

        for (Categoria listaCategoria : listaCategorias) {

            categoriaAnuncioChoiceBox.getItems().add(listaCategoria.getDescripcion());

        }

        //Configuramos el spinner de tiempoEstimado
        SpinnerValueFactory<Integer> valueFactoryTiempoEstimado = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 120, Anuncio.getAnuncio().tiempoEstimado, 2);
        tiempoEstimadoAnuncioSpinner.setValueFactory(valueFactoryTiempoEstimado);

        tituloAnuncioTextField.setText(Anuncio.getAnuncio().getTitulo());
        descripcionAnuncioTextField.setText(Anuncio.getAnuncio().getDescripcion());
        ubicacionAnuncioChoiceBox.getSelectionModel().select(Anuncio.getAnuncio().ubicacion);
        categoriaAnuncioChoiceBox.getSelectionModel().select(Anuncio.getAnuncio().categoria);

        //Rellenamos el choiceBox de ubicaciones
        estadoAnuncioChoiceBox.getItems().add("Libre");
        estadoAnuncioChoiceBox.getItems().add("Pendiente");
        estadoAnuncioChoiceBox.getItems().add("Completado");

        if (Anuncio.getAnuncio().estado == Anuncio.ESTADO_LIBRE) {
            estadoAnuncioChoiceBox.getSelectionModel().select("Libre");
        } else if (Anuncio.getAnuncio().estado == Anuncio.ESTADO_PENDIENTE) {
            estadoAnuncioChoiceBox.getSelectionModel().select("Pendiente");
        } else if (Anuncio.getAnuncio().estado == Anuncio.ESTADO_COMPLETADO) {
            estadoAnuncioChoiceBox.getSelectionModel().select("Completado");
        }

    }

    @FXML
    private void modificarAnuncio(ActionEvent event) {

        CategoriaModel categoriaModel = new CategoriaModel();
        AnuncioModel anuncioModel = new AnuncioModel();

        try {

            int idAnuncio = Anuncio.getAnuncio().idAnuncio;
            int idUsuario = Anuncio.getAnuncio().idUsuario;
            String tituloAnuncio = tituloAnuncioTextField.getText();
            String descripcionAnuncio = descripcionAnuncioTextField.getText();
            String ubicacion = ubicacionAnuncioChoiceBox.getSelectionModel().getSelectedItem();
            int tiempoEstimado = tiempoEstimadoAnuncioSpinner.getValue();

            ArrayList<Categoria> listaCategorias = categoriaModel.getCategorias();

            Categoria categoria = null;
            for (Categoria listaCategoria : listaCategorias) {

                if (listaCategoria.descripcion.equals(categoriaAnuncioChoiceBox.getSelectionModel().getSelectedItem())) {
                    categoria = new Categoria(listaCategoria.getIdCategoria(), listaCategoria.getDescripcion());
                }

            }

            int estado = 0;
            if (estadoAnuncioChoiceBox.getSelectionModel().getSelectedItem().equals("Libre")) {
                estado = Anuncio.ESTADO_LIBRE;
            } else if (estadoAnuncioChoiceBox.getSelectionModel().getSelectedItem().equals("Pendiente")) {
                estado = Anuncio.ESTADO_PENDIENTE;
            } else if (estadoAnuncioChoiceBox.getSelectionModel().getSelectedItem().equals("Completado")) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("CONFIRMACIÓN");
                alert.setContentText("Esta seguro de que quiere marcar este anuncio como completado?");
                alert.showAndWait();

                if (alert.getResult() == ButtonType.OK) {

                    estado = Anuncio.ESTADO_COMPLETADO;

                } else {

                    estado = Anuncio.getAnuncio().estado;

                }

            }

            Anuncio anuncio = new Anuncio(idAnuncio, idUsuario, tituloAnuncio, descripcionAnuncio, ubicacion, tiempoEstimado, categoria.getIdCategoria(), estado, "");

            if (anuncioModel.modificarUsuario(anuncio)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("ANUNCIO MODIFICADO CORRECTAMENTE");
                alert.setContentText("Se ha modificado correctamente el anuncio.");
                alert.showAndWait();

                if (anuncio.getEstado() == Anuncio.ESTADO_COMPLETADO) {

                    anuncioModel.eliminarAnuncio(anuncio.getIdAnuncio());

                    try {
                        AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLMisAnuncios.fxml"));
                        this.rootPane.getChildren().setAll(pane);
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLMisAnunciosController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("ERROR!! EL ANUNCIO NO SE HA PODIDO MODIFICAR");
                alert.setContentText("No se ha pododido modificar el usuario. Revise los campos introducidos.");
                alert.showAndWait();

            }

        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR!!");
            alert.setContentText("Revise los campos introducidos.");
            alert.showAndWait();

        }

    }

}
