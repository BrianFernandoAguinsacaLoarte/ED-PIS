/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Cursa;
import modelo.Persona;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaCursa extends AbstractTableModel {

    //Objetos
    LinkedList<Cursa> cursas = new LinkedList<>();
    
    //Getter and Setter

    public LinkedList<Cursa> getCursas() {
        return cursas;
    }

    public void setCursas(LinkedList<Cursa> cursas) {
        this.cursas = cursas;
    }
    
    
    @Override
    public int getRowCount() {
        return cursas.getSize();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        
        Cursa cursa = null;
        //Persona persona = new Persona();
        try {
            cursa = cursas.get(fila);
        } catch (Exception e) {
        }
        
        switch (columna) {
            case 0:
                    return (cursa != null)? cursa.getId(): "";
            case 1:
                    return (cursa != null)? cursa.getId_Estudiante(): "";
            case 2: 
                    return (cursa != null)? cursa.getCodigo(): "";
            case 3: 
                    return (cursa != null)? cursa.getCapacidad() + " Estudiantes": "";
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
                    return "ID-Estudiante";
            case 2:
                    return "Codigo";
            case 3:
                    return "Capacidad";
            default:
                return null;
        }
    }
    
    
    
}
