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
 * <p>Es un menú de navegación en el que dispondremos de las siguietes opciones:</p>
 * <ul>
 * <li>Inicio, donde se mostrarán todos los anuncios libres</li>
 * <li>Mis Anuncios, donde se mostrarán todos mis anuncios que estén libres o pendientes</li>
 * <li>Anuncios inscritos, donde se mostrarán todos los anuncios en los que estemos inscritos</li>
 * <li>Publicar anuncio, donde podremos publicar un anuncio.</li>
 * <li>Configuración y privacidad, donde podrmoe cambiar nuestro email y nuestra contraseña.</li>
 * <li>Perfil y cuenta, donde podremos ver nuestra información personal y modificarla, admeás de cerrar sesión y eliminar cuenta.</li>
 * 
 * </ul>
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
     * <p>Al inicializarse esta escena se carga en el enchorPane, llamado rootPane, la pagina principal.</p>
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

    /**
     * <p>Nos redirecciona a la escena de la pagina principal, donde estan todos los anuncios libres.</p>
     * @param event 
     */
    @FXML
    private void inicioAplicacion(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLPaginaPrincipal.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPaginaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * <p>Nos redirecciona a la escena de anuncios insccritos, donde de muestran todos los anuncios en los que estoy inscrito.</p>
     * @param event 
     */
    @FXML
    private void anunciosInscritos(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLAnunciosInscritos.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLAnunciosInscritosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>Nos redirecciona a la escena de mis anuncios, dende se muestran todos los anuncios que he publicado.</p>
     * @param event 
     */
    @FXML
    private void misAnuncios(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLMisAnuncios.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLMisAnunciosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * <p>Nos redirecciona a la escena de Privacidad Y seguridad, donde estan las opciones de cambiar email y contraseña.</p>
     * @param event 
     */
    @FXML
    private void configuracionPrivacidadYSeguridad(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLConfiguracionPrivacidadYSeguridad.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLConfiguracionPrivacidadYSeguridadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * <p>Nos redirecciona a Perfil Y cuenta, donde podremos ver nuestros datos personales, cerrar sesión y eliminar cuenta.</p>
     * @param event 
     */
    @FXML
    private void configuracionPerfilYCuenta(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLConfiguracionPerfilYCuenta.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLConfiguracionPerfilYCuentaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * <p>Nos redireccionará a la escena de publicar anuncio, donde podremos publicar un anuncio.</p>
     * @param event 
     */
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
