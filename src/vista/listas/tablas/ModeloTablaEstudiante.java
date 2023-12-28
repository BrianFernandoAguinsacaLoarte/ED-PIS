/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Estudiante;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaEstudiante extends AbstractTableModel {
    //Objeto
    LinkedList<Estudiante> estudiantes = new LinkedList<>();
    
    //Getter and Setter
    public LinkedList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public void setEstudiantes(LinkedList<Estudiante> estudiantes) {    
        this.estudiantes = estudiantes;
    }
    
    @Override
    public int getRowCount() {
        return estudiantes.getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Estudiante estudiante = null;
        
        try {
            estudiante = estudiantes.get(fila);
        } catch (Exception e) {
        }
        
        switch (columna) {
            case 0:
                    return (estudiante != null)? estudiante.getId(): "";
            case 1:
                    //return (estudainte != null)? estudiante.ge
            default:
                throw new AssertionError();
        }
    }
    
}
