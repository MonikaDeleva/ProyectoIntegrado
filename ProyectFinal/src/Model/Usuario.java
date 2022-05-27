/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author 1erDAM
 */
public class Usuario {

    private int id;
    private String email;
    private String nombre;
    private String apellidos;
    private String contrasena;
    private String ubicacion;
    private String fechaNacimiento;
    private int puntos;
    private int admin;
    private int division;

    public static final int NO_ADMIN = 0;
    public static final int SI_ADMIN = 1;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getAdmin() {
        return admin;
    }

    public int getDivision() {
        return division;
    }
    
    public Usuario(){
    
    }

    public Usuario(int id, String email, String nombre, String apellidos, String contrasena, String ubicacion, String fechaNacimiento, int puntos, int admin, int division) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
        this.ubicacion = ubicacion;
        this.fechaNacimiento = fechaNacimiento;
        this.puntos = puntos;
        this.admin = admin;
        this.division = division;
    }


    
    
}
