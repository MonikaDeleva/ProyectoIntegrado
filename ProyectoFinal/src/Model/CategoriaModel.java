/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

/**
 *
 * @author 1erDAM
 */
public class CategoriaModel extends DBUtil {

    /**
     * <p>Devuelve un ArrayList de Categoria, con todas las categorias de la base de datos.</p>
     * @return ArrayList
     */
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
    
    /**
     * <p>Devuelve un ObservableList de Categoria con una lista de todas las categorias.</p>
     * @return ObservableList
     */
    public ObservableList<Categoria> getListaCategoria() {
    
        ObservableList<Categoria> listaCategorias = FXCollections.observableArrayList();
        
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
    
    /**
     * <p>Recibe como parametro un objeto Categoria, si consigue eliminar el objeto devolverá true y si no false.</p>
     * @param categoria
     * @return boolean
     */
    public boolean eliminarCategoria(Categoria categoria){
    
        try {
        
            String eliminarCategoria = "DELETE FROM categoria WHERE id_categoria = ? ";
            PreparedStatement stmt = this.getConnection().prepareStatement(eliminarCategoria);
            
            stmt.setInt(1, categoria.getIdCategoria());
            
            stmt.execute();
            stmt.close();
            
            return true;
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
            
        } finally {
            
            this.closeConnection();
            
        }
    
    }
    
    /**
     * <p>Recibe como parametro un string con el nombre de la nueva Categoría, si podemos introducir la nueva categoria a la base de datos devolverá true, 
     *  si no false.</p>
     * @param nuevaCategoria
     * @return boolean
     */
    public boolean anyadirCategoria(String nuevaCategoria){
    
        try {
        
            String anyadirCategoria = "INSERT INTO categoria(valor) VALUES(?)";
            PreparedStatement stmt = this.getConnection().prepareStatement(anyadirCategoria);
            
            stmt.setString(1, nuevaCategoria);
            
            stmt.execute();
            stmt.close();
            
            return true;
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return false;
            
        } finally {
            
            this.closeConnection();
            
        }
    
    }

}
