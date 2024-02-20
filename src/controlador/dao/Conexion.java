/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juanc
 */
public class Conexion {
    
    private Connection connection;
    
    public String driver = "com.mysql.cj.jdbc.Driver";//oracle.jdbc.driver.OracleDriver

    public String database = "paraprobarpis";

    public String hostname = "localhost";

    public String port = "3306";

    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";//"jdbc:oracle:thin:@"+hostname+":"+port+":"+database;

    public String username = "root";

    public String password = "2002";

//    public Connection conectar() {
//        Connection conn = null;
//
//        try {
//            Class.forName(driver);
//            conn = DriverManager.getConnection(url, username, password);
//            System.out.println("Conected!");
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//
//        return conn;
//    }

    public Connection conectar() throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }
    
    public Connection getConnection() throws SQLException {
        if(connection == null)
            connection = conectar();
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static void main(String[] args) throws SQLException {
        new Conexion().conectar();
    }
    
}
