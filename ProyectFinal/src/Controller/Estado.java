/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author 1erDAM
 */
public class Estado {
    //Constantes
    //Variables
  private int id_estado;
  private int valor_estado;

    
    
    
    //Constructores
    public Estado() {
        
    }
    
    public Estado(int id_estado, int valor_estado) {
        this.id_estado = id_estado;
        this.valor_estado = valor_estado;
    }
    
    //Getters
     public int getId_estado() {
        return id_estado;
    }

    public int getValor_estado() {
        return valor_estado;
    }
    //Setters
    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public void setValor_estado(int valor_estado) {
        this.valor_estado = valor_estado;
    }
    //Metodos

   

    
}
