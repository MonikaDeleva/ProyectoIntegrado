/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Anuncio;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 * <p>Es una escena en la que en una tabla se muestran todos los usuarios no administradores y podremos eliminar usuarios.</p>
 *
 * @author 1erDAM
 */
public class FXMListaUsuariosAdministradorController implements Initializable {

    @FXML
    private TableView<Usuario> tableViewListaUsuarios;
    @FXML
    private TableColumn<Usuario, Integer> tableColumnIDUsuarios;
    @FXML
    private TableColumn<Usuario, String> tableColumnEmailUsuarios;
    @FXML
    private TableColumn<Usuario, String> tableColumnNombreUsuario;
    @FXML
    private TableColumn<Usuario, String> tableColumnApellidosUsuario;
    @FXML
    private TableColumn<Usuario, String> tableColumnUbicacionUsuario;
    @FXML
    private TableColumn<Usuario, String> tableColumnFechaNacimiento;
    @FXML
    private Button botonEliminarUsuario;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button botonVolverAtras;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        UsuarioModel usuarioModel = new UsuarioModel();

        this.tableColumnIDUsuarios.setCellValueFactory(new PropertyValueFactory("id"));
        this.tableColumnEmailUsuarios.setCellValueFactory(new PropertyValueFactory("email"));
        this.tableColumnNombreUsuario.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.tableColumnApellidosUsuario.setCellValueFactory(new PropertyValueFactory("apellidos"));
        this.tableColumnUbicacionUsuario.setCellValueFactory(new PropertyValueFactory("ubicacion"));
        this.tableColumnFechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimento"));

        ObservableList<Usuario> misAnuncios = usuarioModel.getListaUsuarios();

        this.tableViewListaUsuarios.setItems(misAnuncios);

    }

    /**
     * <p>Recoge el usuario seleccionado en la tabla y llama al metodo eliminarusuarioAdministrador situado en UsuarioModel</p>
     * @param event 
     */
    @FXML
    private void eliminarUsuario(ActionEvent event) {

        UsuarioModel usuarioModel = new UsuarioModel();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("CONFIRMACIÓN");
        alert.setContentText("Esta seguro de que quiere eliminar el usuario?");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {

            Usuario usuario = tableViewListaUsuarios.getSelectionModel().getSelectedItem();

            if (usuarioModel.eliminarUsuarioAdministrador(usuario.getId())) {

                Alert eliminacionCompletada = new Alert(Alert.AlertType.INFORMATION);
                eliminacionCompletada.setHeaderText("USUARIO ELIMINADO");
                eliminacionCompletada.setContentText("El usuario se ha eliminado correctamente.");
                eliminacionCompletada.showAndWait();

                //Actualizamos la tabla
                this.tableColumnIDUsuarios.setCellValueFactory(new PropertyValueFactory("id"));
                this.tableColumnEmailUsuarios.setCellValueFactory(new PropertyValueFactory("email"));
                this.tableColumnNombreUsuario.setCellValueFactory(new PropertyValueFactory("nombre"));
                this.tableColumnApellidosUsuario.setCellValueFactory(new PropertyValueFactory("apellidos"));
                this.tableColumnUbicacionUsuario.setCellValueFactory(new PropertyValueFactory("ubicacion"));
                this.tableColumnFechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimento"));

                ObservableList<Usuario> misAnuncios = usuarioModel.getListaUsuarios();

                this.tableViewListaUsuarios.setItems(misAnuncios);

            }

        } else {

            Alert alertaCancelada = new Alert(Alert.AlertType.INFORMATION);
            alertaCancelada.setHeaderText("Eliminación Cancelada");
            alertaCancelada.setContentText("El usuario no se ha eliminado");
            alert.showAndWait();

        }

    }

    /**
     * <p>Es un boton simple que nos devuelve al Panel de Control del Administrador.</p>
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
