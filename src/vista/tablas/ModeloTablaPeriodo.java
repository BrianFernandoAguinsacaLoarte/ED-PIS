/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.PeriodoAcademico;

/**
 *
 * @author Usuario 1
 */
public class ModeloTablaPeriodo extends AbstractTableModel{
//Objeto
    LinkedList<PeriodoAcademico> pas = new LinkedList<>();
    
    //Getter and Setter
    public LinkedList<PeriodoAcademico> getPeriodosAcademicos() {
        return pas;
    }
    public void setPeriodosAcademicos(LinkedList<PeriodoAcademico> pas) {    
        this.pas = pas;
    }
    
    @Override
    public int getRowCount() {
        return pas.getSize();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        PeriodoAcademico pa = null;
        
        try {
            pa = pas.get(fila);
        } catch (Exception e) {
        }
        
        switch (columna) {
            case 0:
                    return (pa != null)? pa.getId(): "";
            case 1:
                    return (pa != null)? pa.getSemestre(): "";
            case 2:
                    return (pa != null)? pa.getFechaInicio(): "";
            case 3:
                    return (pa != null)? pa.getFechaFin(): "";
            case 4:
                    return (pa != null)? pa.getAñoAcademico(): "";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int columna) {
        switch (columna) {
            case 0:
                    return "ID";
            case 1: 
                    return "Semestre";
            case 2: 
                    return "Fecha Inicio";
            case 3: 
                    return "Fecha Fin";
            case 4: 
                    return "Año Academico";
            default:
                return null;
        }
    }
}
