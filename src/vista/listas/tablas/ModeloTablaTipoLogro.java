/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.TipoLogro;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaTipoLogro extends AbstractTableModel {
    
    private LinkedList<TipoLogro> tipos;
    
    //Getter and Setter

    public LinkedList<TipoLogro> getTipos() {
        return tipos;
    }

    public void setTipos(LinkedList<TipoLogro> tipos) {
        this.tipos = tipos;
    }
    
    
    
    @Override
    public int getRowCount() {
        return tipos.getSize();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int row, int col) {
        TipoLogro tipo = null; // Cambié Universidad por Genero
        try {
            tipo = tipos.get(row);
        } catch (Exception e) {
        }
        switch (col) {
            case 0:
                return (tipo != null) ? tipo.getNombre() : "";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
         switch (column) {
            case 0:
                return "Catalogo"; 
            default:
                return null;
        }
    }
    
    
    
}
