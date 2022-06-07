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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLConfiguracionPerfilYCuentaController implements Initializable {

    @FXML
    private TextField nombreMiPerfil;
    @FXML
    private TextField apellidosMiPerfil;
    @FXML
    private ChoiceBox<String> ubicacionMiPerfil;
    @FXML
    private Button botonGuardarCambios;
    @FXML
    private Button botonCerrarSesion;
    @FXML
    private Button botonEliminarCuenta;
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ubicacionMiPerfil.getItems().add("Valencia");
        ubicacionMiPerfil.getItems().add("Alzira");
        ubicacionMiPerfil.getItems().add("Almussafes");
        ubicacionMiPerfil.getItems().add("Algemesi");
        ubicacionMiPerfil.getItems().add("Catarroja");
        ubicacionMiPerfil.getItems().add("Carcaixent");

        nombreMiPerfil.setText(Usuario.getUsuario().nombre);
        apellidosMiPerfil.setText(Usuario.getUsuario().apellidos);
        ubicacionMiPerfil.getSelectionModel().select(Usuario.getUsuario().ubicacion);
    }

    @FXML
    private void guardarCambios(ActionEvent event) {

        UsuarioModel usuarioModel = new UsuarioModel();

        try {

            String nuevoNombre = nombreMiPerfil.getText();
            String nuevosApellidos = apellidosMiPerfil.getText();
            String nuevaUbicacion = ubicacionMiPerfil.getSelectionModel().getSelectedItem();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("CONFIRMACIÓN");
            alert.setContentText("Esta seguro que quiere modificar los cambios?");
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {

                if (usuarioModel.modificarUsuario(nuevoNombre, nuevosApellidos, nuevaUbicacion, Usuario.getUsuario().id)) {
                    
                    Usuario.getUsuario().nombre = nuevoNombre;
                    Usuario.getUsuario().apellidos = nuevosApellidos;
                    Usuario.getUsuario().ubicacion = nuevaUbicacion;

                    Alert alertaConfirmacionCambios = new Alert(Alert.AlertType.INFORMATION);
                    alertaConfirmacionCambios.setHeaderText("CAMBIOS GUARDADOS");
                    alertaConfirmacionCambios.setContentText("Los cambios se han guardado correctamente");
                    alertaConfirmacionCambios.showAndWait();

                } else {

                    Alert alertaErrorGuardarCambios = new Alert(Alert.AlertType.ERROR);
                    alertaErrorGuardarCambios.setHeaderText("LOS CAMBIOS NO SE HAN GUARDADO");
                    alertaErrorGuardarCambios.setContentText("Ha ocurrido un fallo y no se han podido guardar los cambios");
                    alertaErrorGuardarCambios.showAndWait();

                }

            } else if (alert.getResult() == ButtonType.CANCEL) {
                Alert alertaCancelacion = new Alert(Alert.AlertType.INFORMATION);
                alertaCancelacion.setHeaderText("CAMBIOS CANCELADOS");
                alertaCancelacion.setContentText("No se han guardado los cambios.");
                alertaCancelacion.showAndWait();
            }

        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setContentText("Revise los campos introducidos");
            alert.showAndWait();

        }

    }

    @FXML
    private void cerrarSesion(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("CONFIRMACIÓN");
        alert.setContentText("Esta seguro de que quiere cerrar sesión?");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {

            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLIniciarSesion.fxml"));

                Parent root = loader.load();

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.show();

                Stage myStage = (Stage) this.botonCerrarSesion.getScene().getWindow();
                myStage.close();

            } catch (IOException ex) {
                Logger.getLogger(FXMLRegistrarseController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML
    private void eliminarCuenta(ActionEvent event) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/FXMLConfirmacionEliminacionCuenta.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(FXMLConfirmacionEliminacionCuentaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
