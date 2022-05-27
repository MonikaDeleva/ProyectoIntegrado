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
    //Constantes

    //Variables
    private int idAnuncio;
    private Usuario usuarioPropietario;
    private int tiempoEstimadoAnuncio;
    private int personasNecesariasAnuncio;
    private String tituloAnuncio;
    private String descripcionAnuncio;
    private String ubicacionAnuncio;
    private Categoria categoria;
    private Estado estadoAnuncio;

    //Constructores
    public Anuncio() {
        
    }

    
    public Anuncio(int idAnuncio, Usuario usuarioPropietario, int tiempoEstimadoAnuncio, int personasNecesariasAnuncio, String tituloAnuncio, String descripcionAnuncio, String ubicacionAnuncio, Categoria categoria, Estado estadoAnuncio) {
        this.idAnuncio = idAnuncio;
        this.usuarioPropietario = usuarioPropietario;
        this.tiempoEstimadoAnuncio = tiempoEstimadoAnuncio;
        this.personasNecesariasAnuncio = personasNecesariasAnuncio;
        this.tituloAnuncio = tituloAnuncio;
        this.descripcionAnuncio = descripcionAnuncio;
        this.ubicacionAnuncio = ubicacionAnuncio;
        this.categoria = categoria;
        this.estadoAnuncio = estadoAnuncio;
    }

    //Getters

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public Usuario getUsuarioPropietario() {
        return usuarioPropietario;
    }

    public int getTiempoEstimadoAnuncio() {
        return tiempoEstimadoAnuncio;
    }

    public int getPersonasNecesariasAnuncio() {
        return personasNecesariasAnuncio;
    }

    public String getTituloAnuncio() {
        return tituloAnuncio;
    }

    public String getDescripcionAnuncio() {
        return descripcionAnuncio;
    }

    public String getUbicacionAnuncio() {
        return ubicacionAnuncio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Estado getEstadoAnuncio() {
        return estadoAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public void setUsuarioPropietario(Usuario usuarioPropietario) {
        this.usuarioPropietario = usuarioPropietario;
    }

    public void setTiempoEstimadoAnuncio(int tiempoEstimadoAnuncio) {
        this.tiempoEstimadoAnuncio = tiempoEstimadoAnuncio;
    }

    public void setPersonasNecesarias_anuncio(int personasNecesariasAnuncio) {
        this.personasNecesariasAnuncio = personasNecesariasAnuncio;
    }

    public void setTituloAnuncio(String tituloAnuncio) {
        this.tituloAnuncio = tituloAnuncio;
    }

    public void setDescripcionAnuncio(String descripcionAnuncio) {
        this.descripcionAnuncio = descripcionAnuncio;
    }

    public void setUbicacionAnuncio(String ubicacionAnuncio) {
        this.ubicacionAnuncio = ubicacionAnuncio;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setEstadoAnuncio(Estado estadoAnuncio) {
        this.estadoAnuncio = estadoAnuncio;
    }

    
    
    

    
}
