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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class PerfilController implements Initializable {

    @FXML
    private Menu menuInicio;
    @FXML
    private Menu menuAnunciosInscritos;
    @FXML
    private Menu menuMisAnuncios;
    @FXML
    private Menu menuConfiguracion;
    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldApellidos;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private DatePicker datepickerFecha;
    @FXML
    private PasswordField PasswordField;
    @FXML
    private Button buttonGuardarCambios;
    @FXML
    private Label labelPerfil;

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

    @FXML
    private void paraNombre(ActionEvent event) {
    }

    @FXML
    private void paraApellidos(ActionEvent event) {
    }

    @FXML
    private void paraEmail(ActionEvent event) {
    }

    @FXML
    private void paraFechaNacimiento(ActionEvent event) {
    }

    @FXML
    private void paraContraseña(ActionEvent event) {
    }

    @FXML
    private void paraGuardarCambios(ActionEvent event) {
    }
    
}
