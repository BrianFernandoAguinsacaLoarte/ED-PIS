/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Matricula;

/**
 *
 * @author Usuario
 */
public class ModeloTablaMatricula extends AbstractTableModel {
    private LinkedList<Matricula> lista;

    public LinkedList<Matricula> getLista() {
        return lista;
    }

    public void setLista(LinkedList<Matricula> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Matricula matricula = null;

        try {
            matricula = lista.get(row); // aqui se obtiene la llanta en la posición i
        } catch (VacioExcepcion | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        switch (col) {
            case 0:
                return (matricula != null) ? matricula.getMateria(): "";
            case 1:
                return (matricula != null) ? matricula.getCurso(): "";
            
            default:
                return null; 
        }
    }

    @Override
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Materias";
            case 1:
                return "Curso";
            default:
                return null;
        }
    }
    
}