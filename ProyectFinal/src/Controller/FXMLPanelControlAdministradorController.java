/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 * <p>En el panel de control del Administrador se podrán realizar tres operaciones:</p>
 * <ol>
 * <li>Mostrar usuarios y eliminar usuarios</li>
 * <li>Mostrar anuncios y eliminar anuncios</li>
 * <li>Mostrar categorias, eliminar categorias y añadir Categorias.</li>
 * 
 * </ol>
 *
 * @author 1erDAM
 */
public class FXMLPanelControlAdministradorController implements Initializable {

    @FXML
    private Button botonListaUsuarios;
    @FXML
    private Button botonListaAnuncios;
    @FXML
    private Button botonListaCategorias;
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * <p>Nos redirecciona a la escena de ListarUsuarios, donde nos mostrará todos los usuarios no admin en una tabla y podremos eliminarlos.</p>
     * @param event 
     */
    @FXML
    private void listaUsuarios(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMListaUsuariosAdministrador.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMListaUsuariosAdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * <p>Nos redirecciona a una escena de ListarAnuncios, donde nos mostrará todos los anuncios en una tabla y podremos eliminarlos.</p>
     * @param event 
     */
    @FXML
    private void listaAnuncios(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLListaAnunciosAdministrador.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLListaAnunciosAdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * <p>Nos redirecciona a una escena de ListarCategorias, donde nos mostrarán todas las categorias en una tabla y podremos eliminar y añadir categorias.</p>
     * @param event 
     */
    @FXML
    private void listaCategorias(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLListaCategoriasAdministrador.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLListaCategoriasAdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
