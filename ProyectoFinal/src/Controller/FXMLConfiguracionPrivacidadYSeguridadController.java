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
 * 
 * <p>Esta clase solo dispone de dos botones:</p>
 * <ul>
 * <li>Cambiar email</li>
 * <li>Cambiar contraseña</li>
 * <li></li>
 * </ul>
 * 
 * <p>cada boton nos redireccionara a una nueva escena donde podremos efectuar los cambios.</p>
 *
 * @author 1erDAM
 */
public class FXMLConfiguracionPrivacidadYSeguridadController implements Initializable {

    @FXML
    private Button botonCambiarEmail;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button botonCambiarContrasenya;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * <p>Nos redirecciona a la pantalla de cambiar email</p>
     * @param event 
     */
    @FXML
    private void cambiarEmail(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLCambiarEmail.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLCambiarEmailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * <p>Nos redirecciona a la pantalla de cambiar Contraseña</p>
     * @param event 
     */
    @FXML
    private void cambiarContrasenya(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLCambiarContrasenya.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLCambiarContrasenyaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
