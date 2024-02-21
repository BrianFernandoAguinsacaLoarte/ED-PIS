/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Malla;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaMalla extends AbstractTableModel{
    
    
    LinkedList<Malla> mallas;
    //Getter and Setter

    public LinkedList<Malla> getMallas() {
        return mallas;
    }

    public void setMallas(LinkedList<Malla> mallas) {
        this.mallas = mallas;
    }
    
    
    
    
    @Override
    public int getRowCount() {
        return mallas.getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Malla malla = null;
       
        try {
            malla = mallas.get(row);
            
            
        } catch (Exception e) {
        }
        switch (col) {
            case 0:
                    return (malla != null)? malla.getNombre(): "";
            case 1:
                    return (malla != null)? malla.getFechaRegistro(): "";
            case 2:
                    return (malla != null)? malla.getEstado(): "";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                    return "Nombre";
            case 1:
                    return "Fecha Registro";
            case 2:
                    return "Estado";
            
            default:
                return null;
        }
    }
    
    
    
    
}
