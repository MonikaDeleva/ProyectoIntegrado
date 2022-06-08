/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p>Realiza la conexión con la base de datos.</p>
 * @author Administrador
 */
public class DBUtil {

    Connection conn;
    private String cadenaConexion = "jdbc:mysql://35.170.42.243:3306/meet_yourvolunter";
    private String nombreUsuario = "meet_yourvolunterusr";
    private String password = "1234567";

    /**
     * <p>Abre la conexión con la base de datos, si nos conectamos devuelve una Connection y si no null.</p>
     * @return Connection
     */
    public Connection getConnection() {

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.conn = DriverManager.getConnection(this.cadenaConexion, this.nombreUsuario, this.password);
            return this.conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * <p>Cierra la conexión con la base de datos.</p>
     */
    public void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
