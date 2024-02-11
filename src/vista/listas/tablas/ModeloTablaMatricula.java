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
 * @author Usuario iTC
 */
public class ModeloTablaMatricula extends AbstractTableModel {

    LinkedList<Matricula> matriculas;
    EstudianteController ec = new EstudianteController();
    PeriodoAcademicoController pc = new PeriodoAcademicoController();
    
    
    
    @Override
    public int getRowCount() {
        return matriculas.getSize();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int row, int col) {
        
        Matricula matricula = null;
        String estudiante = "";
        String periodo = "";
        try {
            matricula = matriculas.get(row);
            estudiante = ec.obtener(matricula.getId_estudiante()).getNombres();
            periodo = pc.obtener(matricula.getId_periodoAcademico()).getNombre();
            
        } catch (Exception e) {
        }
        switch (col) {
            case 0:
                    return (matricula != null)? estudiante: "";
            case 1:
                    return (matricula != null)? periodo: "";
            case 2:
                    return (matricula != null)? matricula.getFechaMatricula(): "";
            case 3:
                    return (matricula != null)? matricula.getGratuidad(): "";
            case 4:
                    return (matricula != null)? matricula.getTurno(): "";
            case 5:
                    return (matricula != null)? matricula.getModalidad(): "";
            case 6:
                    return (matricula != null)? matricula.getEstado(): "";
           
           
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
         switch (column) {
            case 0:
                    return "Estudiante";
            case 1:
                    return "Periodo";
            case 2:
                    return "Fecha de Matricula";
            case 3:
                    return "Gratuidad";
            case 4:
                    return "Turno";
            case 5:
                    return "Modalidad";
            case 6:
                    return "Estado";
            
            default:
                return null;
        }
    }
    
    //Getter and Setter

    public LinkedList<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(LinkedList<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
    
    
}
