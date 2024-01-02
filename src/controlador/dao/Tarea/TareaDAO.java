/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao.Tarea;

import controlador.Conexion.ConexionBDD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Tarea;

/**
 *
 * @author Jhostin
 */
public class TareaDAO implements CRUD{
    
    /*Metodo listar*/
    @Override
    public ArrayList<Tarea> Listar_all() {
        ArrayList<Tarea> list = new ArrayList<Tarea>();
        ConexionBDD conec = new ConexionBDD();
        String sql = "SELECT * FROM tarea_archivo;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarea vo = new Tarea();
                vo.setId(rs.getInt(1));
                vo.setTema(rs.getString(2));
                vo.setDescripcion(rs.getString(3)); 
                vo.setFechaCreacion(rs.getString(4));
                vo.setFechaEntrega(rs.getString(5));
                vo.setArchivo(rs.getBlob(6));
                vo.setExtensionArchivo(rs.getString(7));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return list;
    }

    /*Metodo agregar*/
    @Override
    public void Agregar_Archivo(Tarea vo) {
        ConexionBDD conec = new ConexionBDD();
        String sql = "INSERT INTO tarea_archivo (id, tema, descripcion, fechaCreacion, fechaEntrega, archivo, extensionArchivo) VALUES(?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getId());
            ps.setString(2, vo.getTema());
            ps.setString(3, vo.getDescripcion()); 
            ps.setString(4, vo.getFechaCreacion());
            ps.setString(5, vo.getFechaEntrega());
            ps.setBlob(6, vo.getArchivo());
            ps.setString(7, vo.getExtensionArchivo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    /*Metodo Modificar*/
    @Override
    public void Modificar_Archivo(Tarea vo) {
        ConexionBDD conec = new ConexionBDD();
        String sql = "UPDATE tarea_archivo SET tema = ?, descripcion = ?, fechaCreacion = ?, fechaEntrega = ?, archivo = ?, extensionArchivo = ? WHERE id = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getTema());
            ps.setString(2, vo.getDescripcion()); 
            ps.setString(3, vo.getFechaCreacion());
            ps.setString(4, vo.getFechaEntrega());
            ps.setBlob(5, vo.getArchivo());
            ps.setNString(6, vo.getExtensionArchivo());
            ps.setInt(7, vo.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    /* Método Modificar2 */
    @Override
    public void Modificar_Archivo2(Tarea vo) {
        ConexionBDD conec = new ConexionBDD();
        String sql = "UPDATE tarea_archivo SET tema = ?, descripcion = ?, fechaCreacion = ?, fechaEntrega = ?, extensionArchivo = ? WHERE id = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getTema());
            ps.setString(2, vo.getDescripcion());
            ps.setString(3, vo.getFechaCreacion());
            ps.setString(4, vo.getFechaEntrega());
            ps.setString(5, vo.getExtensionArchivo());
            ps.setInt(6, vo.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }


    /*Metodo Eliminar*/
    @Override
    public void Eliminar_Archivo(Tarea vo) {
        ConexionBDD conec = new ConexionBDD();
        String sql = "DELETE FROM tarea_archivo WHERE id = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }
}
