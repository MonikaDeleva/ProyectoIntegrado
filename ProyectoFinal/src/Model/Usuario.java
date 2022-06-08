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
    public int admin;
    
    public static int ADMIN_NO = 0;
    public static int ADMIN_SI = 1;

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

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public Usuario(int id, String email, String nombre, String apellidos, String contrasenya, String ubicacion, String fechaNacimento, int admin) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenya = contrasenya;
        this.ubicacion = ubicacion;
        this.fechaNacimento = fechaNacimento;
        this.admin = admin;
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