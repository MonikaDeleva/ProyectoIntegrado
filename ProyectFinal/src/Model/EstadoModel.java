/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 1erDAM
 */
public class EstadoModel extends DBUtil{
    
    public Estado getEstados(int idEstado){
        
        try {
            //Iniciamos conexión
            String sql = "SELECT id_estado, valor FROM estado";
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            Estado estado = null;
            while(rs.next()){
                
                int id = rs.getInt("id_estado");
                String valor = rs.getString("valor");
                
                if (id == idEstado) {
                    estado = new Estado(id, valor);
                }
            }
            
            return estado;

        } catch (Exception e) {
            
            e.printStackTrace();
            return null;
            
        } finally {
            this.closeConnection();
        }
        
    }
    
}
