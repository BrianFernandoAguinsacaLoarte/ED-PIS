/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Curso;
import modelo.controladores.CicloController;
import modelo.controladores.CursoController;
import modelo.controladores.ParaleloController;

/**
 *
 * @author juanc
 */
public class ModeloTablaCurso extends AbstractTableModel {

    private LinkedList<Curso> cursos;
//    LinkedList<Ciclo> listaCiclos = new LinkedList<>();

    CicloController cicloControlador = new CicloController();
    ParaleloController paraleloControlador = new ParaleloController();
    CursoController cursoControlador = new CursoController();

    @Override
    public int getRowCount() {
        return getCursos().getSize();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Curso curso = null;
        String nombreCiclo;
        String nombreParalelo;
        try {
            curso = cursos.get(row);
            nombreCiclo = cicloControlador.obtener(curso.getId_ciclo()).getNombre();
            nombreParalelo = paraleloControlador.obtener(curso.getId_paralelo()).getNombre();
        } catch (VacioExcepcion e) {
            throw new RuntimeException(e);
        }
        switch (col) {
            case 0:
                return (curso != null) ? nombreCiclo : "";
            case 1:
                return (curso != null) ? nombreParalelo : "";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Ciclo";
            case 1:
                return "Paralelo";
            default:
                return null;
        }
    }

    public LinkedList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(LinkedList<Curso> cursos) {
        this.cursos = cursos;
    }

}
