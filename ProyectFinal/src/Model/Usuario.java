/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Administrador
 */
public class Usuario {
    
    public int id;
    public String email;
    public String nombre;
    public String apellidos;
    public String contrasenya;
    public String ubicacion;
    public String fechaNacimento;
    public int puntos;
    public int admin;
    public int division;
    
    public static int ADMIN_NO = 0;
    public static int ADMIN_SI = 1;
    
    public static int DIVISION_BRONZE = 1;
    public static int DIVISION_PLATA = 2;
    public static int DIVISION_ORO = 3;
    public static int DIVISION_PLATINO = 4;
    public static int DIVISION_DIAMANTE = 5;
    
    
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFechaNacimento() {
        return fechaNacimento;
    }

    public void setFechaNacimento(String fechaNacimento) {
        this.fechaNacimento = fechaNacimento;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public Usuario(int id, String email, String nombre, String apellidos, String contrasenya, String ubicacion, String fechaNacimento, int puntos, int admin, int division) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenya = contrasenya;
        this.ubicacion = ubicacion;
        this.fechaNacimento = fechaNacimento;
        this.puntos = puntos;
        this.admin = admin;
        this.division = division;
    }
    
    //---------------------------------------------------
    //Singleton
    
    private static Usuario usuario;
    
    private Usuario(){}
    
    public synchronized static Usuario getUsuario(){
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }
    
}