/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 1erDAM
 */
public class UsuarioModel extends DBUtil {

    public Usuario getUsuario(String correo, String password) {

        try {
            //Iniciamos conexión
            String sql = "SELECT id, email, nombre, apellidos, contrasena, ubicacion, fecha_nacimiento, puntos, admin, division FROM usuario";
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            Usuario usuario = null;
            while(rs.next()){
                
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String contrasena = rs.getString("contrasena");
                String ubicacion = rs.getString("ubicacion");
                String fecha_nacimiento = rs.getString("fecha_nacimiento");
                int puntos = rs.getInt("puntos");
                int admin = rs.getInt("admin");
                int division = rs.getInt("division");
                
                if (email.equals(correo) && contrasena.equals(password) && admin==0) {
                    usuario = new Usuario(id, email, nombre, apellidos, contrasena, ubicacion, fecha_nacimiento, puntos, admin, division);
                    
                }
            }
            
            return usuario;

        } catch (Exception e) {
            
            e.printStackTrace();
            return null;
            
        } finally {
            this.closeConnection();
        }

    }
    
    public Usuario getUsuario(int idUsuario) {

        try {
            //Iniciamos conexión
            String sql = "SELECT id, email, nombre, apellidos, contrasena, ubicacion, fecha_nacimiento, puntos, admin, division FROM usuario";
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            Usuario usuario = null;
            while(rs.next()){
                
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String contrasena = rs.getString("contrasena");
                String ubicacion = rs.getString("ubicacion");
                String fecha_nacimiento = rs.getString("fecha_nacimiento");
                int puntos = rs.getInt("puntos");
                int admin = rs.getInt("admin");
                int division = rs.getInt("division");
                
                if (id == idUsuario && admin==0) {
                    usuario = new Usuario(id, email, nombre, apellidos, contrasena, ubicacion, fecha_nacimiento, puntos, admin, division);
                    
                }
            }
            
            return usuario;

        } catch (Exception e) {
            
            e.printStackTrace();
            return null;
            
        } finally {
            this.closeConnection();
        }

    }

}