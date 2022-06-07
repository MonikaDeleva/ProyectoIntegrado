/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Usuario;
import Model.UsuarioModel;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrador
 */
public class FXMLRegistrarseController implements Initializable {

    @FXML
    private TextField emailIntroducidoTextField;
    @FXML
    private TextField nombreIntroducidoTextField;
    @FXML
    private TextField apellidosIntroducidosTextField;
    @FXML
    private PasswordField contrsenyaIntroducidaTextField;
    @FXML
    private ChoiceBox<String> ubicacionChoiceBox;
    @FXML
    private Button botonRegistrarse;
    @FXML
    private DatePicker fechaNacimientoDatePicker;
    @FXML
    private Button botonVolverInicioSesion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ubicacionChoiceBox.getItems().add("Valencia");
        ubicacionChoiceBox.getItems().add("Alzira");
        ubicacionChoiceBox.getItems().add("Almussafes");
        ubicacionChoiceBox.getItems().add("Algemesi");
        ubicacionChoiceBox.getItems().add("Catarroja");
        ubicacionChoiceBox.getItems().add("Carcaixent");

    }

    @FXML
    private void registrarUsuario(ActionEvent event) {

        UsuarioModel usuarioModel = new UsuarioModel();

        try {

            String nombre = nombreIntroducidoTextField.getText();
            String apellidos = apellidosIntroducidosTextField.getText();
            String email = emailIntroducidoTextField.getText();
            String contrasenya = contrsenyaIntroducidaTextField.getText();
            String ubicacion = ubicacionChoiceBox.getSelectionModel().getSelectedItem();
            String fechaNacimiento = fechaNacimientoDatePicker.getValue().format(DateTimeFormatter.BASIC_ISO_DATE);

            if (!nombre.equals("") && !apellidos.equals("") && !email.equals("") && !contrasenya.equals("") && !ubicacion.equals("") && !fechaNacimiento.equals("")) {

                Usuario usuario = new Usuario(0, email, nombre, apellidos, contrasenya, ubicacion, fechaNacimiento, 0, Usuario.ADMIN_NO, Usuario.DIVISION_BRONZE);

                if (usuarioModel.insertarUsuario(usuario)) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("USUARIO GUARDADO CORRECTAMENE");
                    alert.setContentText("El usuario se ha guardado correctamente");
                    alert.showAndWait();
                    
                    nombreIntroducidoTextField.setText("");
                    apellidosIntroducidosTextField.setText("");
                    emailIntroducidoTextField.setText("");
                    contrsenyaIntroducidaTextField.setText("");

                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("ERROR!! EL USUARIO NO SE HA PODIDO GUARDAR");
                    alert.setContentText("No se ha pododido introducir el usuario.");
                    alert.showAndWait();

                }

            } else{
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("ERROR");
                alert.setContentText("Rellene todos los campos");
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
    private void volverInicioSesion(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLIniciarSesion.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.botonVolverInicioSesion.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLRegistrarseController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
