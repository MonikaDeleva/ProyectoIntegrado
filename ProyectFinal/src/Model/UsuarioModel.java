/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author Administrador
 */
public class UsuarioModel extends DBUtil {
    
    public Usuario validarUsuario(String emailIntroducido, String contrsenyaIntroducida){
        
        Usuario usuario = null;
        
        try {
            
            String sql = "SELECT id, email, nombre, apellidos, contrasena, ubicacion, fecha_nacimiento, puntos, admin, division FROM usuario";
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
                int puntos = rs.getInt("puntos");
                int admin = rs.getInt("admin");
                int division = rs.getInt("division");
                
                if (email.equals(emailIntroducido) && contrasenya.equals(contrsenyaIntroducida)) {
                    usuario = new Usuario(id, email, nombre, apellidos, contrasenya, ubicacion, fechaNacimiento, puntos, admin, division);
                }

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }
        
        return usuario;
        
    }

    public boolean insertarUsuario(Usuario usuario) {

        try {

            String sqlInsert = "INSERT INTO usuario(email, nombre, apellidos, contrasena, ubicacion, fecha_nacimiento, puntos, admin, division) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.getConnection().prepareStatement(sqlInsert);

            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellidos());
            stmt.setString(4, usuario.getContrasenya());
            stmt.setString(5, usuario.getUbicacion());
            stmt.setString(6, usuario.getFechaNacimento());
            stmt.setInt(7, usuario.getPuntos());
            stmt.setInt(8, Usuario.ADMIN_NO);
            stmt.setInt(9, Usuario.DIVISION_BRONZE);

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException e) {

            return false;
            
        } finally{
            this.closeConnection();
        }

    }
    
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

}
