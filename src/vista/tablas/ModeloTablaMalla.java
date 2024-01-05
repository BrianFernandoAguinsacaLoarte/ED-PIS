/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Malla;

/**
 *
 * @author Usuario 1
 */
public class ModeloTablaMalla extends AbstractTableModel{
//Objeto
    LinkedList<Malla> pas = new LinkedList<>();
    
    //Getter and Setter
    public LinkedList<Malla> getMallas() {
        return pas;
    }
    public void setMallas(LinkedList<Malla> pas) {    
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
        Malla pa = null;
        
        try {
            pa = pas.get(fila);
        } catch (Exception e) {
        }
        
        switch (columna) {
            case 0:
                    return (pa != null) ? pa.getId(): "";
            case 1:
                    return (pa != null) ? pa.getNombreMalla(): "";
            case 2:
                    return (pa != null) ? pa.getDuracion(): "";
            case 3:
                    return (pa != null) ? pa.getFechaRegistro(): "";
            case 4: 
                    return (pa != null) ? pa.getCarrera(): "";
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
                    return "Nombre Malla";
            case 2: 
                    return "Duracion";
            case 3: 
                    return "Fecha Registro";
            case 4: 
                return "Carrera";
            default:
                return null;
        }
    }
}
