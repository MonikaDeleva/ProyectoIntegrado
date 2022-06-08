/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author Administrador
 */
public class UsuarioModel extends DBUtil {
    
    /**
     * <p>Comprueba que el usuario existe en la base de datos, si existe devolverá un objeto Usuario 
     *  relleno de su información, si no devolverá un Usuario null.</p>
     * @param emailIntroducido
     * @param contrsenyaIntroducida
     * @return Usuario
     */
    public Usuario validarUsuario(String emailIntroducido, String contrsenyaIntroducida){
        
        Usuario usuario = null;
        
        try {
            
            String sql = "SELECT id, email, nombre, apellidos, contrasena, ubicacion, fecha_nacimiento, admin FROM usuario";
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {

                int id = rs.getInt("id");
                String email = rs.getString("email");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String contrasenya = rs.getString("contrasena");
                String ubicacion = rs.getString("ubicacion");
                String fechaNacimiento = rs.getString("fecha_nacimiento");
                int admin = rs.getInt("admin");
                
                if (email.equals(emailIntroducido) && contrasenya.equals(contrsenyaIntroducida)) {
                    usuario = new Usuario(id, email, nombre, apellidos, contrasenya, ubicacion, fechaNacimiento, admin);
                }

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }
        
        return usuario;
        
    }

    /**
     * <p>Recibe como parametro un Usuario y lo inserta en la base de datos, si lo consigue devuelve true y si no false.</p>
     * @param usuario
     * @return boolean
     */
    public boolean insertarUsuario(Usuario usuario) {

        try {

            String sqlInsert = "INSERT INTO usuario(email, nombre, apellidos, contrasena, ubicacion, fecha_nacimiento, admin) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.getConnection().prepareStatement(sqlInsert);

            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellidos());
            stmt.setString(4, usuario.getContrasenya());
            stmt.setString(5, usuario.getUbicacion());
            stmt.setString(6, usuario.getFechaNacimento());
            stmt.setInt(7, Usuario.ADMIN_NO);

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException e) {

            return false;
            
        } finally{
            this.closeConnection();
        }

    }
    
    /**
     * <p>Recibe como parametro los datos que puede modificar, se realiza el UPDATE, si se modifica correctamente
     *  devuelve true, si no false.</p>
     * @param nuevoNombre
     * @param nuevosApellidos
     * @param nuevaUbicacion
     * @param idUsuario
     * @return 
     */
    public boolean modificarUsuario(String nuevoNombre, String nuevosApellidos, String nuevaUbicacion, int idUsuario){
    
        try {
            
            String updateQuery = "UPDATE usuario SET nombre = ?, apellidos = ?, ubicacion = ? WHERE id=?";
            PreparedStatement stmt = this.getConnection().prepareStatement(updateQuery);
            
            stmt.setString(1, nuevoNombre);
            stmt.setString(2, nuevosApellidos);
            stmt.setString(3, nuevaUbicacion);
            stmt.setInt(4, idUsuario);
            
            stmt.execute();
            stmt.close();
            
            return true;
                    
        } catch (SQLException e) {
            
            return false;
            
        } finally {
            this.closeConnection();
        }
        
    }
    
    /**
     * <p>Elimina un usuario de la base de datos, coge el id del Usuario que ha iniciado sesión. 
     * Si se elimina correctamente devuelve true, si no false.</p>
     * @return boolean
     */
    public boolean eliminarUsuario(){
        
        try {
        
            String eliminarUsuario = "DELETE FROM usuario WHERE id = ? ";
            PreparedStatement stmt = this.getConnection().prepareStatement(eliminarUsuario);
            
            stmt.setInt(1, Usuario.getUsuario().id);
            
            stmt.execute();
            stmt.close();
            
            return true;
            
        } catch (Exception e) {
            
            return false;
            
        } finally {
            
            this.closeConnection();
            
        }
    
    }
    
    /**
     * <p>Recibe como parametro el emailActual y el nuevoEmail, si consigue actializar el email en la base de datos devolverá true, si no false</p>
     * @param emailActual
     * @param nuevoEmail
     * @return 
     */
    public boolean cambiarEmail(String emailActual, String nuevoEmail){
    
        try {
            
            String updateQuery = "UPDATE usuario SET email = ? WHERE email=?";
            PreparedStatement stmt = this.getConnection().prepareStatement(updateQuery);
            
            stmt.setString(1, nuevoEmail);
            stmt.setString(2, emailActual);
            
            stmt.execute();
            stmt.close();
            
            return true;
                    
        } catch (SQLException e) {
            
            return false;
            
        } finally {
            this.closeConnection();
        }
        
    }
    
    /**
     * <p>Recibe como parametro la contrasenyaActual y la nuevaContrasenya, si consigue actializar la contraseña en la base de datos devolverá true, si no false</p>
     * @param contrasenyaActual
     * @param nuevaContrasenya
     * @return 
     */
    public boolean cambiarContrasenya(String contrasenyaActual, String nuevaContrasenya){
    
        try {
            
            String updateQuery = "UPDATE usuario SET contrasena = ? WHERE contrasena = ?";
            PreparedStatement stmt = this.getConnection().prepareStatement(updateQuery);
            
            stmt.setString(1, nuevaContrasenya);
            stmt.setString(2, contrasenyaActual);
            
            stmt.execute();
            stmt.close();
            
            return true;
                    
        } catch (SQLException e) {
            
            return false;
            
        } finally {
            this.closeConnection();
        }
        
    }
    
    /**
     * <p>Rellena un ObservableList con una lista de todos los usuarios de la base de datos.</p>
     * @return ObservableList<Usuario>
     */
    public ObservableList<Usuario> getListaUsuarios(){
    
        ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
        
        try {
            
            String listaUsuario = "SELECT id, email, nombre, apellidos, contrasena, ubicacion, fecha_nacimiento, admin FROM usuario";
            PreparedStatement stmt = this.getConnection().prepareStatement(listaUsuario);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {

                int id = rs.getInt("id");
                String email = rs.getString("email");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String contrasenya = rs.getString("contrasena");
                String ubicacion = rs.getString("ubicacion");
                String fechaNacimiento = rs.getString("fecha_nacimiento");
                int admin = rs.getInt("admin");
                
                if (admin == Usuario.ADMIN_NO) {
                    
                    Usuario usuario = new Usuario(id, email, nombre, apellidos, contrasenya, ubicacion, fechaNacimiento, admin);
                    listaUsuarios.add(usuario);
                    
                }

            }
            
            return listaUsuarios;
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return null;
            
        } finally {
            
            this.closeConnection();
            
        }
    
    }
    
    /**
     * <p>Elimina un usuario de la base de datos, coge el id que le hemos pasado por parametro y ejecuta la Consulta. 
     * Si se elimina correctamente devuelve true, si no false.</p>
     * @param id
     * @return boolean
     */
    public boolean eliminarUsuarioAdministrador(int id){
        
        try {
        
            String eliminarUsuario = "DELETE FROM usuario WHERE id = ? ";
            PreparedStatement stmt = this.getConnection().prepareStatement(eliminarUsuario);
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();
            
            return true;
            
        } catch (Exception e) {
            
            return false;
            
        } finally {
            
            this.closeConnection();
            
        }
    
    
    }

}
