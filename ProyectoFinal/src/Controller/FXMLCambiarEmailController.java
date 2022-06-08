/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Usuario;
import Model.UsuarioModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * <p>En esta clase podremos cambiar el email del usuario, para eso deberemos introducir el email 
 * actual, y dos veces el nuevo email.</p>
 * 
 * @author 1erDAM
 */
public class FXMLCambiarEmailController implements Initializable {

    @FXML
    private TextField emailActual;
    @FXML
    private TextField nuevoEmail;
    @FXML
    private TextField confirmarNuevoEmail;
    @FXML
    private Button botonCambiarEmail;
    @FXML
    private Button botonVolverAtras;
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
    /**
     * <p>En el metodo cambiarEmail podremos cambiar el email del usuario indicando el anterior email y introduciendo
     * el nuevo email 2 veces.</p>
     * @param event 
     */
    @FXML
    private void cambiarEmail(ActionEvent event) {

        UsuarioModel usuarioModel = new UsuarioModel();

        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        String comprobarEmail = nuevoEmail.getText();

        Matcher mather = pattern.matcher(comprobarEmail);

        if (mather.find()) {

            try {

                String emailActual = this.emailActual.getText();
                String nuevoEmail = this.nuevoEmail.getText();
                String confirmarNuevoEmail = this.confirmarNuevoEmail.getText();

                if (nuevoEmail.equals(confirmarNuevoEmail)) {

                    if (emailActual.equals(Usuario.getUsuario().email)) {

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText("CONFIRMACIÓN");
                        alert.setContentText("Esta seguro de que quiere cambiar el email " + Usuario.getUsuario().email + " a " + nuevoEmail + "?");
                        alert.showAndWait();

                        if (alert.getResult() == ButtonType.OK) {

                            if (usuarioModel.cambiarEmail(emailActual, nuevoEmail)) {

                                Usuario.getUsuario().email = nuevoEmail;

                                Alert alertaEmailActualizado = new Alert(Alert.AlertType.INFORMATION);
                                alertaEmailActualizado.setHeaderText("MODIFICACION REALIZADA CON EXITO");
                                alertaEmailActualizado.setContentText("El email se ha actualizado correctamente");
                                alertaEmailActualizado.showAndWait();

                                this.emailActual.setText("");
                                this.nuevoEmail.setText("");
                                this.confirmarNuevoEmail.setText("");

                            } else {

                                Alert alertaError = new Alert(Alert.AlertType.ERROR);
                                alertaError.setHeaderText("ERROR");
                                alertaError.setContentText("No ser ha podido actualizar el email");
                                alertaError.showAndWait();

                            }

                        } else {

                            Alert alertaCancelada = new Alert(Alert.AlertType.INFORMATION);
                            alertaCancelada.setHeaderText("MODIFICACION CANCELADA");
                            alertaCancelada.setContentText("El email NO se ha actualizado");
                            alertaCancelada.showAndWait();

                        }

                    } else {

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("ERROR");
                        alert.setContentText("El email actual no es correcto.");
                        alert.showAndWait();

                    }

                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("ERROR");
                    alert.setContentText("Los nuevos emails no coinciden");
                    alert.showAndWait();

                }

            } catch (Exception e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("ERROR");
                alert.setContentText("Revise los campos introducidos.");
                alert.showAndWait();

            }

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setContentText("Revise los campos introducidos.");
            alert.showAndWait();

        }

    }

    /**
     * <p>Este metodo es solo un boton que nos devuelve a la escena de Privacidad Y Seguridad</p>
     * @param event 
     */
    @FXML
    private void volverAtras(ActionEvent event) {
        
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLConfiguracionPrivacidadYSeguridad.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLConfiguracionPrivacidadYSeguridadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
