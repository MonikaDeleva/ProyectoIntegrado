/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Controller;

import Model.Anuncio;
import Model.AnuncioModel;
import Model.UsuarioModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author 1erDAM
 */
public class StandardMenuController implements Initializable {

    @FXML
    private Label tituloAnuncio2;
    @FXML
    private Label descripcionAnuncio2;
    @FXML
    private Label categoriaAnuncio2;
    @FXML
    private Label tiempoAnuncio2;
    @FXML
    private Label numParticipantes2;
    @FXML
    private Label ubicacionAnuncio2;
    @FXML
    private Label tituloAnuncio1;
    @FXML
    private Label descripcionAnuncio1;
    @FXML
    private Label categoriaAnuncio1;
    @FXML
    private Label tiempoAnuncio1;
    @FXML
    private Label numParticipantes1;
    @FXML
    private Label ubicacionAnuncio1;
    @FXML
    private Button inscribirseAnuncio1;
    @FXML
    private Label tituloAnuncio3;
    @FXML
    private Label descripcionAnuncio3;
    @FXML
    private Label categoriaAnuncio3;
    @FXML
    private Label tiempoAnuncio3;
    @FXML
    private Label numParticipantes3;
    @FXML
    private Label ubicacionAnuncio3;
    @FXML
    private Button inscribirseAnuncio2;
    @FXML
    private Pane anuncio2;
    @FXML
    private Pane anuncio3;
    @FXML
    private Button inscribirseAnuncio3;
    @FXML
    private Button prevPageButton;
    @FXML
    private Pane tanuncio1;
    @FXML
    private Button nextPageButton1;

    @FXML
    private void prevPageButtonAction(ActionEvent event) {
        
        

    }
    
    @FXML
    private void nextPageButtonAction(ActionEvent event) {
        
        

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           AnuncioModel am = new AnuncioModel();
           
           ArrayList<Anuncio> listaAnuncios = am.getAnuncios();
           
           
           
           
           
    }

}
