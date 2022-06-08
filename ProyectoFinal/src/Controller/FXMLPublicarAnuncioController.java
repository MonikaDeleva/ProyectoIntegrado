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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 * <p>Podremos publicar un anuncio rellenando todos los campos que aparecen en la escena y dandole al boton publicar.</p>
 *
 * @author 1erDAM
 */
public class FXMLPublicarAnuncioController implements Initializable {

    @FXML
    private TextField tituloAnuncioTextField;
    @FXML
    private ChoiceBox<String> ubicacionAnuncioChoiceBox;
    @FXML
    private ChoiceBox<String> categoriaAnuncioChoiceBox;
    @FXML
    private Spinner<Integer> tiempoEstimadoAnuncioSpinner;
    @FXML
    private Button botonPublicarAnuncio;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextArea descripcionAnuncioTextArea;

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
        SpinnerValueFactory<Integer> valueFactoryTiempoEstimado = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 120, 0, 2);
        tiempoEstimadoAnuncioSpinner.setValueFactory(valueFactoryTiempoEstimado);

        //Seteamos por defecto la ubicacion del usuario
        ubicacionAnuncioChoiceBox.getSelectionModel().select(Usuario.getUsuario().ubicacion);

    }

    /**
     * <p>Recoge todos los campos introducidos por pantalla y crea un objeto anuncio, luego llama al metodo insertarAnuncio situado en la clase AnuncioModel</p>
     * @param event 
     */
    @FXML
    private void publicarAnuncio(ActionEvent event) {

        CategoriaModel categoriaModel = new CategoriaModel();
        AnuncioModel anuncioModel = new AnuncioModel();

        try {

            String tituloAnuncio = tituloAnuncioTextField.getText();
            String descripcionAnuncio = descripcionAnuncioTextArea.getText();
            String ubicacionAnuncio = ubicacionAnuncioChoiceBox.getSelectionModel().getSelectedItem();
            String categoriaAnuncio = categoriaAnuncioChoiceBox.getSelectionModel().getSelectedItem();
            Integer tiempoEstimado = tiempoEstimadoAnuncioSpinner.getValue();

            ArrayList<Categoria> listaCategorias = categoriaModel.getCategorias();

            Categoria categoria = null;
            for (Categoria listaCategoria : listaCategorias) {

                if (listaCategoria.descripcion.equals(categoriaAnuncioChoiceBox.getSelectionModel().getSelectedItem())) {
                    categoria = new Categoria(listaCategoria.getIdCategoria(), listaCategoria.getDescripcion());
                }

            }

            Anuncio anuncio = new Anuncio(0, Usuario.getUsuario().id, tituloAnuncio, descripcionAnuncio, ubicacionAnuncio, tiempoEstimado, categoria.getIdCategoria(), Anuncio.ESTADO_LIBRE, "");

            if (anuncioModel.insertarAnuncio(anuncio)) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("ANUNCIO PUBLICADO");
                alert.setContentText("El anuncio ha sido publicado correcatemente.");
                alert.showAndWait();

                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLMisAnuncios.fxml"));
                    this.rootPane.getChildren().setAll(pane);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLMisAnunciosController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("ERROR");
                alert.setContentText("No se ha podido publicar el anuncio. Revise los campos introducidos");
                alert.showAndWait();

            }

        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setContentText("Revise los campos introducidos");
            alert.showAndWait();

        }

    }

}
