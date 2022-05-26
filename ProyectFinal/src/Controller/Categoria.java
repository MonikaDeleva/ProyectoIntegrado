/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author 1erDAM
 */
public class Categoria {
    //Constantes
    //Variables
    private int id_categoria;
    private int valor_categoria;

    
    
    //Constructores
    public Categoria(int id_categoria, int valor_categoria) {
        this.id_categoria = id_categoria;
        this.valor_categoria = valor_categoria;
    }
    
    
    public Categoria() {
        
    }
    //Getters
     public int getId_categoria() {
        return id_categoria;
    }

    public int getValor_categoria() {
        return valor_categoria;
    }
    //Setters
    
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setValor_categoria(int valor_categoria) {
        this.valor_categoria = valor_categoria;
    }
    
    //Metodos

    

   
}
