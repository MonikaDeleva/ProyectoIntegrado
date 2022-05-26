/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author 1erDAM
 */
public class Division {
    //Constantes
    //Variables
    private int id_division;
    private int valor_division;

    

    
    
    
    //Constructores
    
    public Division(int id_division, int valor_division) {
        this.id_division = id_division;
        this.valor_division = valor_division;
    }
    
    
    public Division() {
        
    }
    
    //Getters
    public int getValor_division() {
        return valor_division;
    }
    public int getId_division() {
        return id_division;
    }

   

   
    
    //Setters
    
    
     public void setId_division(int id_division) {
        this.id_division = id_division;
    }
     
     public void setValor_division(int valor_division) {
        this.valor_division = valor_division;
    }

    
    //Metodos

    

    
}
