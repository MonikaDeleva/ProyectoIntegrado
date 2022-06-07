/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 1erDAM
 */
public class CategoriaModel extends DBUtil {

    public ArrayList<Categoria> getCategorias() {
    
        ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
        
        try {
            
            String sql = "SELECT id_categoria, valor FROM categoria";
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {

                int id = rs.getInt("id_categoria");
                String descripcion = rs.getString("valor");
                
                Categoria categoria = new Categoria(id, descripcion);
                listaCategorias.add(categoria);

            }
            
            return listaCategorias;
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return null;
            
        } finally {
            this.closeConnection();
        }

    }

}
