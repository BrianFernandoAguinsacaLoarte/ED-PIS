/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Ciclo;
import modelo.Curso;
import modelo.Estudiante;
import modelo.Matricula;
import modelo.MatriculaCursoMateria;
import modelo.Paralelo;
import modelo.controladores.CicloController;
import modelo.controladores.CursoController;
import modelo.controladores.EstudianteController;
import modelo.controladores.MateriaController;
import modelo.controladores.MatriculaController;
import modelo.controladores.ParaleloController;

/**
 *
 * @author juanc
 */
public class ModeloTablaMatriculaCursoMateria extends AbstractTableModel {

    private LinkedList<MatriculaCursoMateria> matriculaCursoMaterias;
    MateriaController materiaControlador = new MateriaController();
    CursoController cursoControlador = new CursoController();
    MatriculaController matriculaControlador = new MatriculaController();
    CicloController cicloControlador = new CicloController();
    ParaleloController paraleloControlador = new ParaleloController();
    EstudianteController estudiantePruebaControlador = new EstudianteController();

    @Override
    public int getRowCount() {
        return getMatriculaCursoMaterias().getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int col) {
        MatriculaCursoMateria matriculaCursoMateria = null;
        String estudianteNombreApellido = "";
        String nombreMateria;
        String nombreParaleloCiclo = "";

        try {
            matriculaCursoMateria = matriculaCursoMaterias.get(row);
            
            nombreMateria = materiaControlador.obtener(matriculaCursoMateria.getId_materia()).getNombre();

            Matricula matricula = matriculaControlador.obtener(matriculaCursoMateria.getId_matricula());
            if (matricula != null) {
                Estudiante estudiante = estudiantePruebaControlador.obtener(matricula.getId_estudiante());
                if (estudiante != null) {
                    estudianteNombreApellido = estudiante.getNombres() + " " + estudiante.getApellidos();
                }
            }

            Curso curso = cursoControlador.obtener(matriculaCursoMateria.getId_curso());
            if (curso != null) {
                Paralelo paralelo = paraleloControlador.obtener(curso.getId_paralelo());
                Ciclo ciclo = cicloControlador.obtener(curso.getId_ciclo());
                if (paralelo != null && ciclo != null) {
                    nombreParaleloCiclo = ciclo.getNombre() + " - " + paralelo.getNombre();
                }
            }

        } catch (VacioExcepcion e) {
            throw new RuntimeException(e);
        }

        switch (col) {
            case 0:
                return nombreParaleloCiclo;
            case 1:
                return (matriculaCursoMateria != null) ? nombreMateria : "";
            case 2:
                return estudianteNombreApellido;
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Curso";
            case 1:
                return "Materia";
            case 2:
                return "Estudiante";
            default:
                return null;
        }
    }

    public LinkedList<MatriculaCursoMateria> getMatriculaCursoMaterias() { // Cambiado el nombre
        return matriculaCursoMaterias;
    }

    public void setMatriculaCursoMaterias(LinkedList<MatriculaCursoMateria> matriculaCursoMaterias) { // Cambiado el nombre
        this.matriculaCursoMaterias = matriculaCursoMaterias;
    }

}
