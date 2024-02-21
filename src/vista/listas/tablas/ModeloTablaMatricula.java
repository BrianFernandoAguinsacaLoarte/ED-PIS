/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Matricula;
import modelo.controladores.EstudianteController;
import modelo.controladores.PeriodoAcademicoController;

/**
 *
 * @author juanc
 */
public class ModeloTablaMatricula extends AbstractTableModel {

    private LinkedList<Matricula> matriculas;

    EstudianteController estudiantePruebaControlador = new EstudianteController();
    PeriodoAcademicoController periodoAcademicoControlador = new PeriodoAcademicoController();

    @Override
    public int getRowCount() {
        return getMatriculas().getSize();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Matricula matricula = null;
        String estudiante = "";
        String periodoAcademico = "";
        try {
            matricula = matriculas.get(row);
            estudiante = estudiantePruebaControlador.obtener(matricula.getId_estudiante()).getNombres();
            periodoAcademico = periodoAcademicoControlador.obtener(matricula.getId_periodoAcademico()).getNombre();
        } catch (Exception e) {
        }

        switch (col) {
            case 1:
                return (matricula != null) ? matricula.getFechaMatricula() : "";
            case 0:
                return (matricula != null) ? estudiante : "";
            case 2:
                return (matricula != null) ? matricula.getEstado(): "";
            case 3:
                return (matricula != null) ? matricula.getGratuidad(): "";
            case 4:
                return (matricula != null) ? matricula.getModalidad(): "";
            case 5:
                return (matricula != null) ? matricula.getTurno(): "";
            case 6:
                return (matricula != null) ? periodoAcademico : "";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 1:
                return "Fecha Matricula";
            case 0:
                return "Estudiante";
            case 2:
                return "Estado";
            case 3:
                return "Gratuidad";
            case 4:
                return "Modalidad";
            case 5:
                return "Turno";
            case 6:
                return "PeriodoAcademico";
            default:
                return null;
        }
    }

    public LinkedList<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(LinkedList<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
