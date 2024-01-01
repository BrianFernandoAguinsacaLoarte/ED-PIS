/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juanc
 */
public class ConexionBDD {
    
    // Parámetros de conexión
    private static final String BD_NOMBRE = "pis_modulo_tarea";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "2002";
    private static final String URL_CONEXION = "jdbc:mysql://localhost/" + BD_NOMBRE;

    // Objeto Connection para manejar la conexión
    private Connection conexion = null;
    
    public ConexionBDD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL_CONEXION, USUARIO, CONTRASEÑA);
            if (conexion != null) {
                System.out.println("Conexión a base de datos " + BD_NOMBRE + " OK\n");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection() {
        return conexion;
    }

    public void desconectar() {
        try {
            conexion.close();
        } catch (Exception ex) {
        }
    }
}
