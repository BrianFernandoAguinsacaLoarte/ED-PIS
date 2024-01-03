/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jhostin
 */

public class SQL {
    
    public int auto_increment(String sql) {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionBDD db = new ConexionBDD();
        try {
            ps = db.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (Exception ex) {
            System.out.println("idmaximo" + ex.getMessage());
            id = 1;
        } finally {
            try {
                ps.close();
                rs.close();
                db.desconectar();
            } catch (Exception ex) {
            }
        }
        return id;
    }
    
}
