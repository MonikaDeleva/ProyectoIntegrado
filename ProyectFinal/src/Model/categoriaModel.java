/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 1erDAM
 */
public class CategoriaModel extends DBUtil{
    
    public Categoria getUsuario(int idCategoria) {

        try {
            //Iniciamos conexión
            String sql = "SELECT id_categoria, valor FROM categoria";
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            Categoria categoria = null;
            while(rs.next()){
                
                int id = rs.getInt("id");
                String valor = rs.getString("valor");
                
                if (id == idCategoria) {
                    categoria = new Categoria(id, valor);
                }
            }
            
            return categoria;

        } catch (Exception e) {
            
            e.printStackTrace();
            return null;
            
        } finally {
            this.closeConnection();
        }
        
    }
}
