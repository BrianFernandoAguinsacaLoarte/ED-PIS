/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Materia;
import modelo.Matricula;

/**
 *
 * @author Usuario
 */
public class ModeloTablaMatricula extends AbstractTableModel {
    private LinkedList<Matricula> lista;
    private LinkedList<Materia> lista2;

    public LinkedList<Matricula> getLista() {
        return lista;
    }

    public void setLista(LinkedList<Matricula> lista) {
        this.lista = lista;
    }

    public LinkedList<Materia> getLista2() {
        return lista2;
    }

    public void setLista2(LinkedList<Materia> lista2) {
        this.lista2 = lista2;
    }
    
    @Override
    public int getRowCount() {
        return lista2.getSize();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Matricula matricula = null;
        Materia materia = null;

        try {
//            matricula = lista.get(row); // aqui se obtiene la llanta en la posición i
            materia = lista2.get(row);
        } catch (VacioExcepcion | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        switch (col) {
            case 0:
                return (materia != null) ? materia.getNombreMateria(): "";
//            case 1:
//                return (matricula != null) ? matricula.getCurso(): "";
            
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