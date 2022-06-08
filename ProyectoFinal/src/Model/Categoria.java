/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author 1erDAM
 */
public class Categoria {
    
    public int idCategoria;
    public String descripcion;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Categoria(int idCategoria, String descripcion) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
    }
    
    //---------------------------------------------------
    //Singleton
    
    private static Categoria categoria;
    
    private Categoria(){}
    
    public synchronized static Categoria getCategoria(){
        if (categoria == null) {
            categoria = new Categoria();
        }
        return categoria;
    }
    
}
