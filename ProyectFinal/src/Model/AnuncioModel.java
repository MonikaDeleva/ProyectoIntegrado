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

/**
 *
 * @author 1erDAM
 */
public class AnuncioModel extends DBUtil {

    public boolean insertarAnuncio(Anuncio anuncio) {

        try {

            String insertarAnuncio = "INSERT INTO anuncio(idUsuario, titulo, descripcion, ubicacion, tiempoEstimado, categoria, estado) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.getConnection().prepareStatement(insertarAnuncio);

            stmt.setInt(1, Usuario.getUsuario().id);
            stmt.setString(2, anuncio.getTitulo());
            stmt.setString(3, anuncio.getDescripcion());
            stmt.setString(4, anuncio.getUbicacion());
            stmt.setInt(5, anuncio.getTiempoEstimado());
            stmt.setInt(6, anuncio.getCategoria());
            stmt.setInt(7, anuncio.getEstado());

            stmt.execute();
            stmt.close();

            return true;

        } catch (Exception e) {

            return false;

        } finally {
            this.closeConnection();
        }

    }

    public ObservableList<Anuncio> getAnunciosLibres() {

        ObservableList<Anuncio> listaAnunciosLibres = FXCollections.observableArrayList();

        try {

            String anunciosLibres = "SELECT a.idAnuncio, a.idUsuario, a.titulo, a.descripcion, a.ubicacion, a.tiempoEstimado, a.categoria, a.estado, c.valor FROM anuncio a LEFT JOIN categoria c ON a.categoria = c.id_categoria";
            PreparedStatement stmt = this.getConnection().prepareStatement(anunciosLibres);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int idAnuncio = rs.getInt("a.idAnuncio");
                int idUsuario = rs.getInt("a.idUsuario");
                String titulo = rs.getString("a.titulo");
                String descripcion = rs.getString("a.descripcion");
                String ubicacion = rs.getString("a.ubicacion");
                int tiempoEstimado = rs.getInt("a.tiempoEstimado");
                int categoria = rs.getInt("categoria");
                int estado = rs.getInt("estado");
                String categoriaString = rs.getString("c.valor");

                if (estado == Anuncio.ESTADO_LIBRE) {

                    Anuncio anuncio = new Anuncio(idAnuncio, idUsuario, titulo, descripcion, ubicacion, tiempoEstimado, categoria, estado, categoriaString);
                    listaAnunciosLibres.add(anuncio);

                }

            }

            return listaAnunciosLibres;

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            this.closeConnection();
        }

    }

    public ObservableList<Anuncio> getMisAnuncios() {

        ObservableList<Anuncio> listaMisAnuncios = FXCollections.observableArrayList();

        try {

            String anunciosLibres = "SELECT a.idAnuncio, a.idUsuario, a.titulo, a.descripcion, a.ubicacion, a.tiempoEstimado, a.categoria, a.estado, c.valor FROM anuncio a LEFT JOIN categoria c ON a.categoria = c.id_categoria";
            PreparedStatement stmt = this.getConnection().prepareStatement(anunciosLibres);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int idAnuncio = rs.getInt("a.idAnuncio");
                int idUsuario = rs.getInt("a.idUsuario");
                String titulo = rs.getString("a.titulo");
                String descripcion = rs.getString("a.descripcion");
                String ubicacion = rs.getString("a.ubicacion");
                int tiempoEstimado = rs.getInt("a.tiempoEstimado");
                int categoria = rs.getInt("a.categoria");
                int estado = rs.getInt("a.estado");
                String categoriaString = rs.getString("c.valor");

                if (idUsuario == Usuario.getUsuario().id) {

                    Anuncio anuncio = new Anuncio(idAnuncio, idUsuario, titulo, descripcion, ubicacion, tiempoEstimado, categoria, estado, categoriaString);
                    listaMisAnuncios.add(anuncio);

                }

            }

            return listaMisAnuncios;

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            this.closeConnection();
        }

    }

    public boolean eliminarAnuncio(int id) {

        try {

            String eliminarUsuario = "DELETE FROM anuncio WHERE idAnuncio = ? ";
            PreparedStatement stmt = this.getConnection().prepareStatement(eliminarUsuario);

            stmt.setInt(1, id);

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
    
    public boolean eliminarAnuncioInscrito(int idAnuncio){
    
    try {

            String eliminarUsuario = "DELETE FROM inscribir WHERE id_anuncio = ? ";
            PreparedStatement stmt = this.getConnection().prepareStatement(eliminarUsuario);

            stmt.setInt(1, idAnuncio);

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

    public boolean modificarUsuario(Anuncio anuncio) {

        try {

            String updateQuery = "UPDATE anuncio SET titulo = ?, descripcion = ?, ubicacion = ?, tiempoEstimado = ?, categoria = ?, estado = ? WHERE idAnuncio = ?";
            PreparedStatement stmt = this.getConnection().prepareStatement(updateQuery);

            stmt.setString(1, anuncio.getTitulo());
            stmt.setString(2, anuncio.getDescripcion());
            stmt.setString(3, anuncio.getUbicacion());
            stmt.setInt(4, anuncio.getTiempoEstimado());
            stmt.setInt(5, anuncio.getCategoria());
            stmt.setInt(6, anuncio.getEstado());
            stmt.setInt(7, anuncio.getIdAnuncio());

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

    public boolean inscribirAnuncio(int idAnuncio) {

        try {

            String insribirseAnuncio = "INSERT INTO inscribir(id_anuncio, id_usuario) VALUES(?, ?)";
            PreparedStatement stmt = this.getConnection().prepareStatement(insribirseAnuncio);

            stmt.setInt(1, idAnuncio);
            stmt.setInt(2, Usuario.getUsuario().id);

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

    public boolean actualizarEstadoAnuncio(Anuncio anuncio, int nuevoEstado) {

        try {

            String actualizarEstadoAnuncio = "UPDATE anuncio SET estado = ? WHERE idAnuncio = ?";
            PreparedStatement stmt = this.getConnection().prepareStatement(actualizarEstadoAnuncio);

            stmt.setInt(1, nuevoEstado);
            stmt.setInt(2, anuncio.getIdAnuncio());

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

    public ObservableList<Anuncio> getAnunciosInscritos() {

        ObservableList<Anuncio> listaAnunciosInscritos = FXCollections.observableArrayList();

        try {

            String anunciosInscritos = "SELECT a.idAnuncio,a.idUsuario,a.titulo, a.descripcion, a.estado , a.ubicacion, a.tiempoEstimado, a.categoria, c.valor FROM anuncio a, inscribir i, categoria c WHERE a.idAnuncio=i.id_anuncio AND a.categoria=c.id_categoria AND i.id_usuario = " + Usuario.getUsuario().id;
            PreparedStatement stmt = this.getConnection().prepareStatement(anunciosInscritos);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int idAnuncio = rs.getInt("a.idAnuncio");
                int idUsuario = rs.getInt("a.idUsuario");
                String titulo = rs.getString("a.titulo");
                String descripcion = rs.getString("a.descripcion");
                String ubicacion = rs.getString("a.ubicacion");
                int tiempoEstimado = rs.getInt("a.tiempoEstimado");
                int categoria = rs.getInt("a.categoria");
                int estado = rs.getInt("a.estado");
                String categoriaString = rs.getString("c.valor");

                Anuncio anuncio = new Anuncio(idAnuncio, idUsuario, titulo, descripcion, ubicacion, tiempoEstimado, categoria, estado, categoriaString);
                listaAnunciosInscritos.add(anuncio);

            }

            return listaAnunciosInscritos;

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {

            this.closeConnection();

        }

    }

}
