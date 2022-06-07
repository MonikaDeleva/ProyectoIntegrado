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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLCambiarContrasenyaController implements Initializable {

    @FXML
    private PasswordField contrasenyaActual;
    @FXML
    private PasswordField nuevaContrasenya;
    @FXML
    private PasswordField confirmarNuevaContrasenya;
    @FXML
    private Button botonCambiarContrasenya;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cambiarContrasenya(ActionEvent event) {

        UsuarioModel usuarioModel = new UsuarioModel();

        try {

            String contrasenyaActual = this.contrasenyaActual.getText();
            String nuevaContrasenya = this.nuevaContrasenya.getText();
            String confirmarNuevaContrasenya = this.confirmarNuevaContrasenya.getText();

            if (nuevaContrasenya.equals(confirmarNuevaContrasenya)) {

                if (contrasenyaActual.equals(Usuario.getUsuario().contrasenya)) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("CONFIRMACIÓN");
                    alert.setContentText("Esta seguro de que quiere cambiar la contraseña?");
                    alert.showAndWait();

                    if (alert.getResult() == ButtonType.OK) {

                        if (usuarioModel.cambiarContrasenya(contrasenyaActual, nuevaContrasenya)) {

                            Usuario.getUsuario().contrasenya = nuevaContrasenya;

                            Alert alertaEmailActualizado = new Alert(Alert.AlertType.INFORMATION);
                            alertaEmailActualizado.setHeaderText("MODIFICACION REALIZADA CON EXITO");
                            alertaEmailActualizado.setContentText("La contraseña se ha actualizado correctamente");
                            alertaEmailActualizado.showAndWait();
                            
                            this.contrasenyaActual.setText("");
                            this.nuevaContrasenya.setText("");
                            this.confirmarNuevaContrasenya.setText("");

                        } else {

                            Alert alertaError = new Alert(Alert.AlertType.ERROR);
                            alertaError.setHeaderText("ERROR");
                            alertaError.setContentText("No ser ha podido actualizar la contraseña");
                            alertaError.showAndWait();

                        }

                    } else {

                        Alert alertaCancelada = new Alert(Alert.AlertType.INFORMATION);
                        alertaCancelada.setHeaderText("MODIFICACION CANCELADA");
                        alertaCancelada.setContentText("La contraseña NO se ha actualizado");
                        alertaCancelada.showAndWait();

                    }

                }

            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("ERROR");
                alert.setContentText("Las nuevas contraseñas no coinciden");
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
