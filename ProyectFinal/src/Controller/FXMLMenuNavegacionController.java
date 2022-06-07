/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLMenuNavegacionController implements Initializable {

    @FXML
    private MenuItem botonInicio;
    @FXML
    private MenuItem botonAnunciosInscritos;
    @FXML
    private MenuItem botonMisAnuncios;
    @FXML
    private MenuItem botonConfiguracionPrivacidadYSeguridad;
    @FXML
    private MenuItem botonConfiguracionPerfilYCuenta;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private MenuItem botonPublicarAnuncio;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLPaginaPrincipal.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPaginaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void inicioAplicacion(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLPaginaPrincipal.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPaginaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void anunciosInscritos(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLAnunciosInscritos.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLAnunciosInscritosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void misAnuncios(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLMisAnuncios.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLMisAnunciosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void configuracionPrivacidadYSeguridad(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLConfiguracionPrivacidadYSeguridad.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLConfiguracionPrivacidadYSeguridadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void configuracionPerfilYCuenta(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLConfiguracionPerfilYCuenta.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLConfiguracionPerfilYCuentaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void publicarAnuncio(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLPublicarAnuncio.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPublicarAnuncioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
