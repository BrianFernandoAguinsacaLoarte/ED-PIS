/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Ciclo;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaCiclo extends AbstractTableModel {
     
    private LinkedList<Ciclo> ciclos;
    
    //Getter and Setter
    public LinkedList<Ciclo> getCiclos() {
        return ciclos;
    }

    public void setCiclos(LinkedList<Ciclo> ciclos) {
        this.ciclos = ciclos;
    }
    
    @Override
    public int getRowCount() {
        return ciclos.getSize();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Ciclo ciclo = null; 
        try {
            ciclo = ciclos.get(row);
        } catch (Exception e) {
        }
        switch (col) {
            case 0:
                return (ciclo != null) ? ciclo.getNombre() : "";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Ciclo"; 
            default:
                return null;
        }
    }
    
    
}
