/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.tablas;

import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Materia;

/**
 *
 * @author Jhostin
 */
public class ModeloTablaMateria extends AbstractTableModel {
     
    private LinkedList<Materia> materias = new LinkedList<>();

    @Override
    public int getRowCount() {
        return getMaterias().getSize();
    }

    @Override
    public int getColumnCount() {
        return 4; 
    }

    @Override
    public Object getValueAt(int row, int col) {
        Materia materia = null;
        try {
            materia = materias.get(row);
        } catch (VacioExcepcion e) {
            throw new RuntimeException(e);
        }
        switch (col) {
            case 0:
                return (materia != null) ? materia.getCodigo(): "";
            case 1:
                return (materia != null) ? materia.getNombreMateria() : "";
            case 2:
                return (materia != null) ? materia.getDescripcion() : "";
            case 3:
                    return (materia != null) ? materia.getId(): "";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Codigo";
            case 1:
                return "Nombre Materia";
            case 2:
                return "Descripción";
            case 3: 
                return "ID";
            default:
                return null;
        }
    }

    /**
     * @return the materias
     */
    public LinkedList<Materia> getMaterias() {
        return materias;
    }

    /**
     * @param materias the materias to set
     */
    public void setMaterias(LinkedList<Materia> materias) {
        this.materias = materias;
    }
}
