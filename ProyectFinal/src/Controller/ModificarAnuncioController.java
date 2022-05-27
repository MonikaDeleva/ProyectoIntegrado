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
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class ModificarAnuncioController implements Initializable {

    @FXML
    private TextField tituloAnuncio;
    @FXML
    private TextField textFieldMinutos;
    @FXML
    private TextArea textAreaAnuncio;
    @FXML
    private Label labelSubirAnuncio;
    @FXML
    private SplitMenuButton splitButtonCategoria;
    @FXML
    private SplitMenuButton splitButtonUbicacion;
    @FXML
    private Button modificarButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        tituloAnuncio.setPromptText("cum");
    }    

    
}
