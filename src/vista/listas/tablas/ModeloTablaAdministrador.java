/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Administrador;
import modelo.controladores.GeneroController;
import modelo.controladores.RolController;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaAdministrador extends AbstractTableModel {

    //Objeto
    LinkedList<Administrador> administradores = new LinkedList<>();
    GeneroController gc = new GeneroController();
    RolController rc = new RolController();
  
   
    //Getter and Setter
    public LinkedList<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(LinkedList<Administrador> administradores) {    
        this.administradores = administradores;
    }
    
    @Override
    public int getRowCount() {
        return administradores.getSize();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Administrador administrador = null;
        String rol = "";
        String genero = "";
        try {
            administrador = administradores.get(fila);
            rol = rc.obtener(administrador.getId_rol()).getNombre();
            genero = gc.obtener(administrador.getId_genero()).getNombre();
            
        } catch (Exception e) {
        }
        switch (columna) {
            case 0:
                    return (administrador != null)? administrador.getNombres(): "";
            case 1:
                    return (administrador != null)? administrador.getApellidos(): "";
            case 2:
                    return (administrador != null)? administrador.getCorreo(): "";
            case 3:
                    return (administrador != null)? administrador.getFechaNacimiento(): "";
            case 4:
                    return (administrador != null)? genero: "";
            case 5:
                    return (administrador != null)? rol: "";
            case 6:
                    return (administrador != null)? administrador.getCedula(): "";
            case 7:
                    return (administrador != null)? administrador.getDireccion(): "";
            case 8:
                    return (administrador != null)? administrador.getTelefono(): "";
            
            default:
                return null;
        }
        
    }

    @Override
    public String getColumnName(int columna) {
        
        switch (columna) {
            case 0:
                    return "Nombres";
            case 1:
                    return "Apellidos";
            case 2:
                    return "Correo";
            case 3:
                    return "Fecha de Nacimiento";
            case 4:
                    return "Género";
            case 5:
                    return "Rol";
            case 6:
                    return "Cédula";
            case 7:
                    return "Dirección";
            case 8:
                    return "Teléfono";
            default:
                return null;
        }
    }
    
}
