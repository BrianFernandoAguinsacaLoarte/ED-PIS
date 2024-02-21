/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Rol;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaRol extends AbstractTableModel{

    
    private LinkedList<Rol> roles; 
    
    @Override
    public int getRowCount() {
        return roles.getSize();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Rol rol = null; // Cambié Universidad por Genero
        try {
            rol = roles.get(row);
        } catch (Exception e) {
        }
        switch (col) {
            case 0:
                return (rol != null) ? rol.getNombre() : "";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
         switch (column) {
            case 0:
                return "Genero"; // Cambié Ciclo por Genero
            default:
                return null;
        }
    }
    
    //Getter and Setter

    public LinkedList<Rol> getRoles() {
        return roles;
    }

    public void setRoles(LinkedList<Rol> roles) {
        this.roles = roles;
    }
    
    
    
}
