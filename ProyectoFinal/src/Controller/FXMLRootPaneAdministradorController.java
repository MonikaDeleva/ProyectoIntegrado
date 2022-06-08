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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLRootPaneAdministradorController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLPanelControlAdministrador.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPanelControlAdministradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}
