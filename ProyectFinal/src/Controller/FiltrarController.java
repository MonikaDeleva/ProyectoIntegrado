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
public class FiltrarController implements Initializable {

    @FXML
    private SplitMenuButton SplitButtonCategoria;
    @FXML
    private Label labelSubirAnuncio;
    @FXML
    private TextField textFieldLocalizacion;
    @FXML
    private Pane paneFiltrar;
    @FXML
    private Button buttonAplicarFiltros;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void paraCategoria(ActionEvent event) {
    }




    @FXML
    private void paraTextFieldLocalizacion(ActionEvent event) {
    }

    @FXML
    private void paraAplicarFiltros(ActionEvent event) {
    }
    
}
