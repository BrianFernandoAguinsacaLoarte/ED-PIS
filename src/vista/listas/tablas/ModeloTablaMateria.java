/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Materia;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaMateria extends AbstractTableModel {

    private LinkedList<Materia> materias;
    
    //Getter and Setter
    public LinkedList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(LinkedList<Materia> materias) {
        this.materias = materias;
    }
    
    
    
    @Override
    public int getRowCount() {
        return materias.getSize();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Materia materia = null; 
        try {
            materia = materias.get(row);
        } catch (Exception e) {
        }
        switch (col) {
            case 0:
                return (materia != null) ? materia.getNombre() : "";
            case 1: 
                return (materia != null) ? materia.getTotalHoras() + " Horas": "";  
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
                return "Horas Totales"; 
            default:
                return null;
        }
    }
    
    
    
}
