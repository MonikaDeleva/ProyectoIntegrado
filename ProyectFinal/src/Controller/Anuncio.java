/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author 1erDAM
 */
public class Anuncio {
    //Constantes

    //Variables
    private int id_anuncio;
    private Usuario usuarioPropietario;
    private int tiempo_estimado_anuncio;
    private int personas_necesarias_anuncio;
    private String titulo_anuncio;
    private String descripcion_anuncio;
    private String ubicacion_anuncio;
    private Categoria categoria;
    private Estado estado_anuncio;

    //Constructores
    public Anuncio() {
        
    }

    
    public Anuncio(int id_anuncio, Usuario usuarioPropietario, int tiempo_estimado_anuncio, int personas_necesarias_anuncio, String titulo_anuncio, String descripcion_anuncio, String ubicacion_anuncio, Categoria categoria, Estado estado_anuncio) {
        this.id_anuncio = id_anuncio;
        this.usuarioPropietario = usuarioPropietario;
        this.tiempo_estimado_anuncio = tiempo_estimado_anuncio;
        this.personas_necesarias_anuncio = personas_necesarias_anuncio;
        this.titulo_anuncio = titulo_anuncio;
        this.descripcion_anuncio = descripcion_anuncio;
        this.ubicacion_anuncio = ubicacion_anuncio;
        this.categoria = categoria;
        this.estado_anuncio = estado_anuncio;
    }

    //Getters

    public int getId_anuncio() {
        return id_anuncio;
    }

    public Usuario getUsuarioPropietario() {
        return usuarioPropietario;
    }

    public int getTiempo_estimado_anuncio() {
        return tiempo_estimado_anuncio;
    }

    public int getPersonas_necesarias_anuncio() {
        return personas_necesarias_anuncio;
    }

    public String getTitulo_anuncio() {
        return titulo_anuncio;
    }

    public String getDescripcion_anuncio() {
        return descripcion_anuncio;
    }

    public String getUbicacion_anuncio() {
        return ubicacion_anuncio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Estado getEstado_anuncio() {
        return estado_anuncio;
    }

    public void setId_anuncio(int id_anuncio) {
        this.id_anuncio = id_anuncio;
    }

    public void setUsuarioPropietario(Usuario usuarioPropietario) {
        this.usuarioPropietario = usuarioPropietario;
    }

    public void setTiempo_estimado_anuncio(int tiempo_estimado_anuncio) {
        this.tiempo_estimado_anuncio = tiempo_estimado_anuncio;
    }

    public void setPersonas_necesarias_anuncio(int personas_necesarias_anuncio) {
        this.personas_necesarias_anuncio = personas_necesarias_anuncio;
    }

    public void setTitulo_anuncio(String titulo_anuncio) {
        this.titulo_anuncio = titulo_anuncio;
    }

    public void setDescripcion_anuncio(String descripcion_anuncio) {
        this.descripcion_anuncio = descripcion_anuncio;
    }

    public void setUbicacion_anuncio(String ubicacion_anuncio) {
        this.ubicacion_anuncio = ubicacion_anuncio;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setEstado_anuncio(Estado estado_anuncio) {
        this.estado_anuncio = estado_anuncio;
    }

    
    
    

    
}
