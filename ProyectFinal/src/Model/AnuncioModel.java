/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Anuncio;
import Controller.Categoria;
import Controller.Estado;
import Controller.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 1erDAM
 */
public class AnuncioModel extends DBUtil{
    
    public ArrayList<Anuncio> getAnuncios() {

        ArrayList<Anuncio> listaAnuncios = new ArrayList<Anuncio>();
        UsuarioModel usuarioModel = new UsuarioModel();
        CategoriaModel categoriaModel = new CategoriaModel();
        EstadoModel estadoModel = new EstadoModel();

        try {
            //Iniciamos conexión
            String sql = "SELECT idAnuncio, idUsuario, titulo, descripcion, ubicacion, tiempoEstimado, categoria, estado, numPersonas FROM anuncio";
            PreparedStatement stmt = this.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                int idAnuncio = rs.getInt("idAnuncio");
                int idUsuario = rs.getInt("idUsuario");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String ubicacion = rs.getString("ubicacion");
                int tiempoEstimado = rs.getInt("tiempoEstimado");
                int categoria = rs.getInt("categoria");
                int estado = rs.getInt("estado");
                int personasNecesarias = rs.getInt("numPersonas");
                
                Usuario u = usuarioModel.getUsuario(idUsuario);
                Categoria c = categoriaModel.getUsuario(categoria);
                Estado e = estadoModel.getEstados(estado);
                
                Anuncio anuncio = new Anuncio(idAnuncio, u, tiempoEstimado, personasNecesarias, titulo, descripcion, ubicacion, c, e);
            }

            return listaAnuncios;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            //Cerramos conexión
            this.closeConnection();
        }

    }
    
}
