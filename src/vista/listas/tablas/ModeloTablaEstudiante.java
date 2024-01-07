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
        return 7;
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
                    return (estudiante != null)? estudiante.getId_Persona(): "";
            case 2:
                    return (estudiante != null)? estudiante.getColegioAnterior(): "";
            case 3:
                    return (estudiante != null)? estudiante.getActividadExtracurricular(): "";
            case 4:
                    return (estudiante != null)? estudiante.getProyectosAcademicos(): "";
            case 5:
                    return (estudiante != null)? estudiante.getReconocimientos(): "";
            case 6:
                    return (estudiante != null)? estudiante.getCertificaciones(): "";
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
                    return "Persona";
            case 2: 
                    return "Institucion Educativa";
            case 3:
                    return "Actividad Extracurricular";
            case 4: 
                    return "Proyectos Academicos";
            case 5:
                    return "Reconocimientos";
            case 6:
                    return "Certificacion";
            default:
                return null;
        }
    }
    
    
    
}
