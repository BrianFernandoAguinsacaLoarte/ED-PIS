/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Docente;
import modelo.controladores.GeneroController;
import modelo.controladores.RolController;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaDocente extends AbstractTableModel {

    //Objeto
    LinkedList<Docente> docentes = new LinkedList<>();
    GeneroController gc = new GeneroController();
    RolController rc = new RolController();
  
   
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
        return 10;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Docente docente = null;
        String rol = "";
        String genero = "";
        try {
            docente = docentes.get(fila);
            rol = rc.obtener(docente.getId_rol()).getNombre();
            genero = gc.obtener(docente.getId_genero()).getNombre();
            
        } catch (Exception e) {
        }
        switch (columna) {
            case 0:
                    return (docente != null)? docente.getNombres(): "";
            case 1:
                    return (docente != null)? docente.getApellidos(): "";
            case 2:
                    return (docente != null)? docente.getCorreo(): "";
            case 3:
                    return (docente != null)? docente.getFechaNacimiento(): "";
            case 4:
                    return (docente != null)? genero: "";
            case 5:
                    return (docente != null)? rol: "";
            case 6:
                    return (docente != null)? docente.getCedula(): "";
            case 7:
                    return (docente != null)? docente.getDireccion(): "";
            case 8:
                    return (docente != null)? docente.getTelefono(): "";
            case 9:
                    return (docente != null)? docente.getExperienciaLaboral() + " años": "";
           
            default:
                return null;
        }
        
    }

    @Override
    public String getColumnName(int columna) {
        
        switch (columna) {
            case 0:
                    return "Nombres";
            case 1:
                    return "Apellidos";
            case 2:
                    return "Correo";
            case 3:
                    return "Fecha de Nacimiento";
            case 4:
                    return "Género";
            case 5:
                    return "Rol";
            case 6:
                    return "Cédula";
            case 7:
                    return "Dirección";
            case 8:
                    return "Teléfono";
            case 9: 
                    return "Experiencia Laboral";
            default:
                return null;
        }
    }
    
}
