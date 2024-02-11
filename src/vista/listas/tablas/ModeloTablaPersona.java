/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Persona;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaPersona extends AbstractTableModel{
    
    //Objetos
    private LinkedList<Persona> personas = new LinkedList<>();
    
    //Getter and Setter
    public LinkedList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(LinkedList<Persona> personas) {
        this.personas = personas;
    }
    
    
    @Override
    public int getRowCount() {
        return personas.getSize();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Persona persona = null;
        try {
       
            persona = personas.get(fila);

        } catch (Exception e) {
        }
        
        switch (columna) {
            case 0:
                    return (persona != null)? persona.getCedula(): "";    
            case 1:
                    return (persona != null)? persona.getNombres(): "";
            case 2:
                    return (persona != null)? persona.getApellidos(): "";
            case 3:
                    return (persona != null)? persona.getFechaNacimiento(): "";
            case 4:
                    return (persona != null)? persona.getCorreo(): "";
            
                
            default:
                return null;
        }
        
    }

    @Override
    public String getColumnName(int columna) {
        switch (columna) {
            case 0:
                    return "Cédula";
            case 1:
                    return "Nombres";
            case 2:
                    return "Apellidos";        
            case 3:
                    return "Edad";        
            case 4:
                    return "Género";  
            case 5:
                    return "Rol";
            case 6:
                    return "Correo";
            case 7:
                    return "Dirección";
            case 8:
                    return "Teléfono";
            
                    
            default:
                return null;
        }
    }
    
    
    
}
