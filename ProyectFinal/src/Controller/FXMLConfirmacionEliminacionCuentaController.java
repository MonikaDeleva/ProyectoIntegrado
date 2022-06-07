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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLConfirmacionEliminacionCuentaController implements Initializable {

    @FXML
    private TextField emailConfirmacion;
    @FXML
    private PasswordField contrasenyaConfirmacion;
    @FXML
    private PasswordField contrasenyaConfirmacion2;
    @FXML
    private Button botonEliminarCuenta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void eliminarCuenta(ActionEvent event) {

        UsuarioModel usuarioModel = new UsuarioModel();

        try {

            String email = emailConfirmacion.getText();
            String contrasenya = contrasenyaConfirmacion.getText();
            String confirmarContrasenya = contrasenyaConfirmacion2.getText();

            if (contrasenya.equals(confirmarContrasenya)) {

                if (email.equals(Usuario.getUsuario().email) && contrasenya.equals(Usuario.getUsuario().contrasenya)) {

                    Alert confirmarEliminacionCuenta = new Alert(Alert.AlertType.CONFIRMATION);
                    confirmarEliminacionCuenta.setHeaderText("CONFIRMACIÓN");
                    confirmarEliminacionCuenta.setContentText("Esta seguro de que quiere eliminar su cuenta?");
                    confirmarEliminacionCuenta.showAndWait();

                    if (confirmarEliminacionCuenta.getResult() == ButtonType.OK) {

                        if (usuarioModel.eliminarUsuario()) {

                            Alert cuentaEliminada = new Alert(Alert.AlertType.INFORMATION);
                            cuentaEliminada.setHeaderText("CUENTA ELIMINADA");
                            cuentaEliminada.setContentText("La cuenta se ha eliminado correctamente.");
                            cuentaEliminada.showAndWait();

                            try {

                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLIniciarSesion.fxml"));

                                Parent root = loader.load();

                                Scene scene = new Scene(root);
                                Stage stage = new Stage();

                                stage.setScene(scene);
                                stage.show();

                                Stage myStage = (Stage) this.botonEliminarCuenta.getScene().getWindow();
                                myStage.close();

                            } catch (IOException ex) {
                                Logger.getLogger(FXMLRegistrarseController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else {

                            Alert errorEliminarCuenta = new Alert(Alert.AlertType.ERROR);
                            errorEliminarCuenta.setHeaderText("ERROR");
                            errorEliminarCuenta.setContentText("Se ha producido un error y no se ha podido eliminar tu cuenta");
                            errorEliminarCuenta.showAndWait();

                        }

                    }

                }

            } else {

                Alert contrasenyasDiferentes = new Alert(Alert.AlertType.ERROR);
                contrasenyasDiferentes.setHeaderText("ERROR");
                contrasenyasDiferentes.setContentText("Las contrasenyas no coinciden");
                contrasenyasDiferentes.showAndWait();

            }

        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setContentText("Revise los campos introducidos");
            alert.showAndWait();

        }

    }

}
