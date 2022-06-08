/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Categoria;
import Model.CategoriaModel;
import Model.Usuario;
import Model.UsuarioModel;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 * 
 * <p>En esta escena del administrador se muestran todas las categorias en una tabla y se puede eliminar o agregar 
 * cualquiera.</p>
 *
 * @author 1erDAM
 */
public class FXMLListaCategoriasAdministradorController implements Initializable {

    @FXML
    private Button botonVolverAtras;
    @FXML
    private TableView<Categoria> tableViewCategorias;
    @FXML
    private TableColumn<Categoria, Integer> tableColumnIDCategoria;
    @FXML
    private TableColumn<Categoria, String> tagleColumnNombreCategoria;
    @FXML
    private Button botonEliminarCategoria;
    @FXML
    private TextField nuevaCategoriaTextField;
    @FXML
    private Button botonAnyadirCategria;
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        CategoriaModel categoriaModel = new CategoriaModel();

        this.tableColumnIDCategoria.setCellValueFactory(new PropertyValueFactory("idCategoria"));
        this.tagleColumnNombreCategoria.setCellValueFactory(new PropertyValueFactory("descripcion"));

        ObservableList<Categoria> listaCategorias = categoriaModel.getListaCategoria();

        this.tableViewCategorias.setItems(listaCategorias);

    }

    /**
     * <p>Seleccionamos un objeto categria en la tabla y lo eliminamos, llamando al metodo eliminarCategoria
     * de la clase CategoriaModel.</p>
     * @param event 
     */
    @FXML
    private void eliminarCategoria(ActionEvent event) {

        CategoriaModel categoriaModel = new CategoriaModel();

        Categoria categoria = tableViewCategorias.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("CONFIRMACIÓN");
        alert.setContentText("Esta seguro de que quiere eliminar la categoría " + categoria.getDescripcion() + "?");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {

            if (categoriaModel.eliminarCategoria(categoria)) {

                Alert eliminacion = new Alert(Alert.AlertType.INFORMATION);
                eliminacion.setHeaderText("CATEGORIA ELIMINADA");
                eliminacion.setContentText("La categoria ha sido eliminada");
                eliminacion.showAndWait();

                this.tableColumnIDCategoria.setCellValueFactory(new PropertyValueFactory("idCategoria"));
                this.tagleColumnNombreCategoria.setCellValueFactory(new PropertyValueFactory("descripcion"));

                ObservableList<Categoria> listaCategorias = categoriaModel.getListaCategoria();

                this.tableViewCategorias.setItems(listaCategorias);

            } else {

                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setHeaderText("ERROR!!");
                error.setContentText("No se ha podido eliminar la categoria");
                error.showAndWait();

            }

        } else {

            Alert alertaCancelacion = new Alert(Alert.AlertType.INFORMATION);
            alertaCancelacion.setHeaderText("ELIMINACIÓN CANNCELADA");
            alertaCancelacion.setContentText("La cetegoría no ha sido eliminada.");
            alertaCancelacion.showAndWait();

        }

    }

    /**
     * <p>Recibiremos a traves de un textFielf una nuevaCategoria y la introduciremos en la base de datos
     * llamando al metodo anyadirCategoria de CategoriaModel</p>
     * @param event 
     */
    @FXML
    private void anyadirCategoria(ActionEvent event) {

        CategoriaModel categoriaModel = new CategoriaModel();
        
        if (nuevaCategoriaTextField.getText().equals("")) {
            
            Alert eliminacion = new Alert(Alert.AlertType.ERROR);
            eliminacion.setHeaderText("ERROR!!");
            eliminacion.setContentText("Revise los campos introducidos!!");
            eliminacion.showAndWait();
            
        } else if (categoriaModel.anyadirCategoria(nuevaCategoriaTextField.getText())) {

            Alert eliminacion = new Alert(Alert.AlertType.INFORMATION);
            eliminacion.setHeaderText("CATEGORIA AÑADIDA CORRECTAMENTE");
            eliminacion.setContentText("La categoria se ha añadido correctamente");
            eliminacion.showAndWait();
            
            nuevaCategoriaTextField.setText("");

            this.tableColumnIDCategoria.setCellValueFactory(new PropertyValueFactory("idCategoria"));
            this.tagleColumnNombreCategoria.setCellValueFactory(new PropertyValueFactory("descripcion"));

            ObservableList<Categoria> listaCategorias = categoriaModel.getListaCategoria();

            this.tableViewCategorias.setItems(listaCategorias);

        } else{
        
            Alert eliminacion = new Alert(Alert.AlertType.ERROR);
            eliminacion.setHeaderText("ERROR!!");
            eliminacion.setContentText("La categoria no se ha podido añadir.");
            eliminacion.showAndWait();
        
        }

    }

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
