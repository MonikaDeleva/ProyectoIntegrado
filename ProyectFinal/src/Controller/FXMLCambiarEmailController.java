/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Usuario;
import Model.UsuarioModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cambiarEmail(ActionEvent event) {

        UsuarioModel usuarioModel = new UsuarioModel();

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

    }

}
