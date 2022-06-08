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
 *<p>En esta clase se situan todas las operaciones a la base de datos que tengan algo relacionado con el Anuncio</p>
 * @author 1erDAM
 */
public class AnuncioModel extends DBUtil {

    /**
     * <p>Recibe como parametro un anuncio, que introduce en la base de datos, 
     * si se consigue insertar el anuncio devolverá true y si no false.</p>
     * 
     * @param anuncio
     * @return boolean
     */
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

    /**
     * <p>Rellena un ObservableList de anuncios, con los anuncios que estén libres, para eso reliza un 
     * SELECT en la base de datos y luego se filtra en el bucle while.</p>
     * @return ObservableList<Anuncio>
     */
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

    /**
     * <p>Rellena un observable list con los anuncios que yo he publicado, para eso realiza una consulta con un SELECT
     * y luego lo filtra con el id del Usuario</p>
     * @return ObservableList<Anuncio>
     */
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

    /**
     * <p>Recibe como parametro una id que le servirá para realizar la consulta a la base de datos, en este 
     * caso al tratarse de la eliminación de un usuario, se utiliza el DELETE con la id de Anuncio que 
     * queremos eliminar. Si consigue eliminar el Anuncio devolverá true y si no false.</p>
     * @param idAnuncio
     * @return boolean
     */
    public boolean eliminarAnuncio(int idAnuncio) {

        try {

            String eliminarUsuario = "DELETE FROM anuncio WHERE idAnuncio = ? ";
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

    /**
     * <p>Recibe como parametro el id del anuncio al que ya no queremos estar inscrito y lo eliminará de la 
     * tabla inscribir. Si se elimina correctamente devolverá true y si no false.</p>
     * @param idAnuncio
     * @return boolean
     */
    public boolean eliminarAnuncioInscrito(int idAnuncio) {

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

    /**
     * <p>Recibe como parametro un objeto Anuncio, donde se modificara su información con un UPDATE, si 
     * se consigue modificar el anuncio correctamente devolverá true y si no false.</p>
     * @param anuncio
     * @return boolean
     */
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

    /**
     * <p>Recibe por parametro el id del anuncio al que nos queremos inscribir, si conseguimos inscribirnos nos 
     * devolverá true y si no false.</p>
     * @param idAnuncio
     * @return boolean
     */
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

    /**
     * <p>Recibe por parametro un objeto anucio y el nuevo estado, si conseguimos actualizar el estado actual del anuncio por el 
     * nuevo estado devolverá true, si no false.</p>
     * @param anuncio
     * @param nuevoEstado
     * @return 
     */
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

    /**
     * Devolverá un ObservableList de anuncios con los anuncios en los que estoy inscrito.
     * ObservableList<Anuncio>
     * @return 
     */
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

    /**
     * <p>Devolverá un ObservableList con todos los anuncios de las base de datos</p>
     * @return ObservableList<Anuncio>
     */
    public ObservableList<Anuncio> getListaAnuncios() {

        ObservableList<Anuncio> listaAnuncios = FXCollections.observableArrayList();

        try {

            String listaAnuncio = "SELECT a.idAnuncio, a.idUsuario, a.titulo, a.descripcion, a.ubicacion, a.tiempoEstimado, a.categoria, a.estado, c.valor FROM anuncio a LEFT JOIN categoria c ON a.categoria = c.id_categoria";
            PreparedStatement stmt = this.getConnection().prepareStatement(listaAnuncio);
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

                Anuncio anuncio = new Anuncio(idAnuncio, idUsuario, titulo, descripcion, ubicacion, tiempoEstimado, categoria, estado, categoriaString);
                listaAnuncios.add(anuncio);

            }

            return listaAnuncios;

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {
            this.closeConnection();
        }

    }

}
