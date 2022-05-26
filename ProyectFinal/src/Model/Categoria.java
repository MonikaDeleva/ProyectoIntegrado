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
    //Constantes
    //Variables
    private int id_categoria;
    private String valor_categoria;

    
    
    
    public Categoria(int id_categoria, String valor_categoria) {
        this.id_categoria = id_categoria;
        this.valor_categoria = valor_categoria;
        
    }

    public Categoria() {
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setValor_categoria(String valor_categoria) {
        this.valor_categoria = valor_categoria;
    }
    
    

    public int getId_categoria() {
        return id_categoria;
    }

    public String getValor_categoria() {
        return valor_categoria;
    }

    

   
}
