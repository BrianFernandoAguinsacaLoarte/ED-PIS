/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.LogroEducativo;
import modelo.controladores.DocenteController;
import modelo.controladores.TipoLogroController;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaLogroEducativo extends AbstractTableModel {
    
    private LinkedList<LogroEducativo> logros;
    private TipoLogroController tc = new TipoLogroController();
    private DocenteController dc = new DocenteController();
    
    //Getter amd Setter
    public LinkedList<LogroEducativo> getLogros() {
        return logros;
    }

    public void setLogros(LinkedList<LogroEducativo> logros) {
        this.logros = logros;
    }
    
    

    @Override
    public int getRowCount() {
        return logros.getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int col) {
        LogroEducativo logro = null; 
        String tipo = "";
        String nombre = "";
        String apellido = "";
        try {
            logro = logros.get(row);
            nombre = dc.obtener(logro.getId_docente()).getNombres();
            apellido = dc.obtener(logro.getId_docente()).getApellidos();
            tipo = tc.obtener(logro.getId_tipoLogro()).getNombre();
        } catch (Exception e) {
        }
        switch (col) {
            case 0:
                return (logro != null) ? logro.getNombre() : "";
            case 1: 
                return (logro != null) ? nombre + " " + apellido : "";
            case 2:
                return (logro != null) ? tipo : "";
            default:   
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
         switch (column) {
            case 0:
                return "Logro";
            case 1:
                return "Docente";
            case 2:
                return "Tipo De Logro";
            default:
                return null;
        }
    }
    
    
    
    
}
