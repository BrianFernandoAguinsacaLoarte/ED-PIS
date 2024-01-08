/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Docente;
import modelo.persona.DocenteController;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaDocente extends AbstractTableModel {

    //Objeto
    LinkedList<Docente> docentes = new LinkedList<>();
    DocenteController dc = new DocenteController();
   
    //Getter and Setter
    public LinkedList<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(LinkedList<Docente> docentes) {    
        this.docentes = docentes;
    }
    
    

    @Override
    public int getRowCount() {
        return docentes.getSize();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Docente docente = null;
        try {
            docente = docentes.get(fila);
            
        } catch (Exception e) {
        }
        switch (columna) {
            case 0:
                    return (docente != null)? docente.getId(): "";
            case 1:
                    Integer idPersona = (docente != null) ? docente.getId_Persona() : null;
                    try {
                        String nombrePersona = dc.obtenerNombre(idPersona);
                        return nombrePersona;
                    } catch (Exception ex) {
                        return "Error";
                    }
                   
            case 2:
                    return (docente != null)? docente.getTitulo(): "";
            case 3:
                    return (docente != null)? docente.getEspecializacion(): "";
            case 4:
                    return (docente != null)? docente.getExperienciaLaboral() + " años": "";
            case 5:
                    return (docente != null)? docente.getCertificaciones(): "";
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
                    return "ID-Persona";
            case 2:
                    return "Título";
             case 3:
                    return "Especialización";
            case 4:
                    return "Experiencia Laboral";
            case 5: 
                    return "Certificaciones";
            default:
                return null;
        }
    }
    
}
