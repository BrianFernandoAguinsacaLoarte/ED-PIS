/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Docente;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaDocente extends AbstractTableModel {

    //Objeto
    LinkedList<Docente> docentes = new LinkedList<>();
    
   
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
        return 3;
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
                    return (docente != null && docente.getPersona()!= null)? docente.getPersona().getNombres(): "";
            case 2:
                    return (docente != null)? docente.getTitulo(): "";
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
                    return "Título";
            default:
                return null;
        }
    }
    
    
    
}
