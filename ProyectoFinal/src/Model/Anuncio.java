/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author 1erDAM
 */
public class Anuncio {
    
    public int idAnuncio;
    public int idUsuario;
    public String titulo;
    public String descripcion;
    public String ubicacion;
    public int tiempoEstimado;
    public int categoria;
    public int estado;
    String categoriaString;
    
    public static int ESTADO_LIBRE = 1;
    public static int ESTADO_PENDIENTE = 2;
    public static int ESTADO_COMPLETADO = 3;

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getCategoriaString() {
        return categoriaString;
    }

    public void setCategoriaString(String categoriaString) {
        this.categoriaString = categoriaString;
    }

    public Anuncio(int idAnuncio, int idUsuario, String titulo, String descripcion, String ubicacion, int tiempoEstimado, int categoria, int estado, String categoriaString) {
        this.idAnuncio = idAnuncio;
        this.idUsuario = idUsuario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.tiempoEstimado = tiempoEstimado;
        this.categoria = categoria;
        this.estado = estado;
        this.categoriaString = categoriaString;
    }

    
    //---------------------------------------------------
    //Singleton
    
    private static Anuncio anuncio;
    
    public Anuncio(){}
    
    public synchronized static Anuncio getAnuncio(){
        if (anuncio == null) {
            anuncio = new Anuncio();
        }
        return anuncio;
    }
    
}
