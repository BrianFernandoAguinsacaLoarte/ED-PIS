/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Genero;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaGenero extends AbstractTableModel {
   
    private LinkedList<Genero> generos; 
    
    @Override
    public int getRowCount() {
        return generos.getSize();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Genero genero = null; // Cambié Universidad por Genero
        try {
            genero = generos.get(row);
        } catch (Exception e) {
        }
        switch (col) {
            case 0:
                return (genero != null) ? genero.getNombre() : "";
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

    public LinkedList<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(LinkedList<Genero> generos) {
        this.generos = generos;
    }
    
    
    
    
}
