/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.PeriodoAcademico;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaPeriodoAcademico extends AbstractTableModel{

    LinkedList<PeriodoAcademico> periodos;
    
    //Getter and Setter

    public LinkedList<PeriodoAcademico> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(LinkedList<PeriodoAcademico> periodos) {
        this.periodos = periodos;
    }
    
    
    
    @Override
    public int getRowCount() {
        return periodos.getSize();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int col) {
        PeriodoAcademico periodo = null;

        try {
            periodo = periodos.get(row);

        } catch (Exception e) {
        }

        switch (col) {
            case 0:
                return (periodo != null) ? periodo.getNombre(): "";
            case 1:
                return (periodo != null) ? periodo.getFechaInicio() : "";
            case 2:
                return (periodo != null) ? periodo.getFechaFin() : "";
            case 3:
                return (periodo != null) ? periodo.getEstado() : "";
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
                return "Fecha De Inicio";
            case 2:
                return "Fecha De Fin";
            case 3:
                return "Estado";
            default:
                return null;
        }
    }
    
    
}
