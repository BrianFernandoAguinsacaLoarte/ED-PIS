/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.DocenteMateria;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaDocenteMateria extends AbstractTableModel {
    
    //Objeto
    LinkedList<DocenteMateria> docentesMaterias = new LinkedList<>();
    
    //Getter and Setter
    public LinkedList<DocenteMateria> getDocentesMaterias() {
        return docentesMaterias;
    }

    public void setDocentesMaterias(LinkedList<DocenteMateria> docentesMaterias) {    
        this.docentesMaterias = docentesMaterias;
    }

    
    @Override
    public int getRowCount() {
        return docentesMaterias.getSize();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        DocenteMateria docenteMateria = null;
        try {
            docenteMateria = docentesMaterias.get(fila);
            
        } catch (Exception e) {
        }
        switch (columna) {
            case 0:
                    return (docenteMateria != null)? docenteMateria.getId(): "";
            case 1:
                    return (docenteMateria != null)? docenteMateria.getId_Docente(): "";
            case 2:
                    return (docenteMateria != null)? docenteMateria.getId_Materia(): "";
            case 3:
                    return (docenteMateria != null)? docenteMateria.getId_PeriodoAcademico(): "";
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
                    return "ID-Docente";
            case 2: 
                    return "ID-Materia";
            case 3: 
                    return "ID-Periodo Academico";
            default:
                return null;
        }
    }
    
    
    
}
