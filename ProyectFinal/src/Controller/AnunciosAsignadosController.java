/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class AnunciosAsignadosController implements Initializable {

    @FXML
    private Menu menuInicio;
    @FXML
    private Menu menuAnunciosInscritos;
    @FXML
    private Menu menuMisAnuncios;
    @FXML
    private Menu menuConfiguracion;
    @FXML
    private TextArea textAreaAnuncio1;
    @FXML
    private TextArea textAreaAnuncio2;
    @FXML
    private Label labelAnuncio1;
    @FXML
    private Label labelAnuncio2;
    @FXML
    private Label labelAnunciosAsignados;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void paraInicio(ActionEvent event) {
    }

    @FXML
    private void paraAnunciosInscritos(ActionEvent event) {
    }

    @FXML
    private void paraMisAnuncios(ActionEvent event) {
    }

    @FXML
    private void paraConfiguracion(ActionEvent event) {
    }
    
}
