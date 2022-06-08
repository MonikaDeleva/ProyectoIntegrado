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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
 * <p>En esta escena tendremos dos opciones:</p>
 * <ul>
 *  <li>Iniciar Sesión</li>
 * <li>Registrarse</li>
 * </ul>
 * 
 * <p>Si queremos iniciar sesión tendremos que introducir nuestro email y contraseña.</p>
 * <p>Si queremos registrarnos nos redireccionará a la escena de regitrarse</p>
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

    /**
     * <p>Este metodo se encarga de ver si el email y la contraseña existen y de redireccionarnos a la pantalla
     * principal, en caso de que exista</p>
     * @param event 
     */
    @FXML
    private void iniciarSesion(ActionEvent event) {

        UsuarioModel usuarioModel = new UsuarioModel();

        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        String comprobarEmail = emaiIntroducidoTextField.getText();

        Matcher mather = pattern.matcher(comprobarEmail);

        if (mather.find()) {

            try {

                Usuario.getUsuario().email = emaiIntroducidoTextField.getText();
                Usuario.getUsuario().contrasenya = contrasenyaIntroducidaTextField.getText();

                String email = emaiIntroducidoTextField.getText();
                String password = contrasenyaIntroducidaTextField.getText();

                Usuario usuario = usuarioModel.validarUsuario(email, password);

                if (usuario != null && usuario.getAdmin() == Usuario.ADMIN_NO) {

                    Usuario.getUsuario().id = usuario.getId();
                    Usuario.getUsuario().email = usuario.getEmail();
                    Usuario.getUsuario().nombre = usuario.getNombre();
                    Usuario.getUsuario().apellidos = usuario.getApellidos();
                    Usuario.getUsuario().contrasenya = usuario.getContrasenya();
                    Usuario.getUsuario().ubicacion = usuario.getUbicacion();
                    Usuario.getUsuario().fechaNacimento = usuario.getFechaNacimento();
                    Usuario.getUsuario().admin = usuario.getAdmin();

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

                } else if (usuario != null && usuario.getAdmin() == Usuario.ADMIN_SI) {

                    Usuario.getUsuario().id = usuario.getId();
                    Usuario.getUsuario().email = usuario.getEmail();
                    Usuario.getUsuario().nombre = usuario.getNombre();
                    Usuario.getUsuario().apellidos = usuario.getApellidos();
                    Usuario.getUsuario().contrasenya = usuario.getContrasenya();
                    Usuario.getUsuario().ubicacion = usuario.getUbicacion();
                    Usuario.getUsuario().fechaNacimento = usuario.getFechaNacimento();
                    Usuario.getUsuario().admin = usuario.getAdmin();

                    try {

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLRootPaneAdministrador.fxml"));

                        Parent root = loader.load();

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();

                        stage.setScene(scene);
                        stage.show();

                        Stage myStage = (Stage) this.botonSeleccionarRegistrarse.getScene().getWindow();
                        myStage.close();

                    } catch (IOException ex) {
                        Logger.getLogger(FXMLRootPaneAdministradorController.class.getName()).log(Level.SEVERE, null, ex);
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

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setContentText("Revise los campos introducidos");
            alert.showAndWait();

        }

    }

    /**
     * <p>Este método solo nos redirecciona a la pantalla de registrarse.</p>
     * @param event
     * @throws IOException 
     */
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
