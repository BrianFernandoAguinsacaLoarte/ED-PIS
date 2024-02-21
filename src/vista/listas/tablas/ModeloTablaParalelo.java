/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Paralelo; 

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaParalelo extends AbstractTableModel{

    
    private LinkedList<Paralelo> paralelos; 
    
    @Override
    public int getRowCount() {
        return paralelos.getSize();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Paralelo paralelo = null; 
        try {
            paralelo = paralelos.get(row);
        } catch (Exception e) {
        }
        switch (col) {
            case 0:
                return (paralelo != null) ? paralelo.getNombre() : ""; 
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
         switch (column) {
            case 0:
                return "Paralelo"; 
            default:
                return null;
        }
    }
    
    //Getter and Setter

    public LinkedList<Paralelo> getParalelos() { 
        return paralelos;
    }

    public void setParalelos(LinkedList<Paralelo> paralelos) {
        this.paralelos = paralelos;
    }
}
