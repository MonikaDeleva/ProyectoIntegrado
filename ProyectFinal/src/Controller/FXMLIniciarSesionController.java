/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Controller;

import Model.Usuario;
import Model.UsuarioModel;
import java.io.IOException;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEvent;

/**
 *
 * @author Administrador
 */
public class FXMLIniciarSesionController implements Initializable {

    @FXML
    private TextField emaiIntroducidoTextField;
    @FXML
    private PasswordField contrasenyaIntroducidaTextField;
    @FXML
    private Button botonSeleccionarIniciarSesion;
    @FXML
    private Button botonSeleccionarRegistrarse;
    @FXML
    private AnchorPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
    }

    @FXML
    private void iniciarSesion(ActionEvent event) {

        UsuarioModel usuarioModel = new UsuarioModel();

        try {
            
            Usuario.getUsuario().email = emaiIntroducidoTextField.getText();
            Usuario.getUsuario().contrasenya = contrasenyaIntroducidaTextField.getText();

            String email = emaiIntroducidoTextField.getText();
            String password = contrasenyaIntroducidaTextField.getText();

            Usuario usuario = usuarioModel.validarUsuario(email, password);
            
            if (usuario != null) {
                
                Usuario.getUsuario().id = usuario.getId();
                Usuario.getUsuario().email = usuario.getEmail();
                Usuario.getUsuario().nombre = usuario.getNombre();
                Usuario.getUsuario().apellidos = usuario.getApellidos();
                Usuario.getUsuario().contrasenya = usuario.getContrasenya();
                Usuario.getUsuario().ubicacion = usuario.getUbicacion();
                Usuario.getUsuario().fechaNacimento = usuario.getFechaNacimento();
                Usuario.getUsuario().puntos = usuario.getPuntos();
                Usuario.getUsuario().admin = usuario.getAdmin();
                Usuario.getUsuario().division = usuario.getDivision();
                
                try {
                    
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLMenuNavegacion.fxml"));

                    Parent root = loader.load();

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

                    stage.setScene(scene);
                    stage.show();

                    Stage myStage = (Stage) this.botonSeleccionarRegistrarse.getScene().getWindow();
                    myStage.close();

                } catch (IOException ex) {
                    Logger.getLogger(FXMLIniciarSesionController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Email o contrasenya incorrecto");
                alert.showAndWait();
                
            }

        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setContentText("Revise los campos introducidos");
            alert.showAndWait();

        }

    }

    @FXML
    private void registrarUsuario(ActionEvent event) throws IOException {
        
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLRegistrarse.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.botonSeleccionarRegistrarse.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLIniciarSesionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
