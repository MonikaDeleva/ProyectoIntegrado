/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author 1erDAM
 */
public class Estado {

    //Constantes
    //Variables
    private int id_estado;
    private String valor_estado;

    public Estado(int id_estado, String valor_estado) {
        this.id_estado = id_estado;
        this.valor_estado = valor_estado;
    }

    public Estado(){
        
    }

    public int getId_estado() {
        return id_estado;
    }

    public String getValor_estado() {
        return valor_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public void setValor_estado(String valor_estado) {
        this.valor_estado = valor_estado;
    }
    
    

}
