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
import modelo.DocenteMateria;
import modelo.Paralelo;
import modelo.controladores.CicloController;
import modelo.controladores.CursoController;
import modelo.controladores.DocenteController;
import modelo.controladores.MateriaController;
import modelo.controladores.ParaleloController;

/**
 *
 * @author juanc
 */
public class ModeloTablaDocenteMateria extends AbstractTableModel {

    private LinkedList<DocenteMateria> docenteMateria;
    private DocenteMateria docMateria;
    
    CursoController materiaCursoControlador = new CursoController();
    DocenteController docenteControlador = new DocenteController();
    CicloController cicloControlador = new CicloController();
    ParaleloController paraleloControlador = new ParaleloController();
    MateriaController materiaControlador = new MateriaController();

    @Override
    public int getRowCount() {
        return getDocentesMateria().getSize();
    }

    public DocenteMateria getDocMateria() {
        if (docMateria == null) {
            docMateria = new DocenteMateria();
        }
        return docMateria;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int col) {
        DocenteMateria docenteMateria = null;
        String nombreDocente = "";
        String apellidoDocente = "";
        String nombreMateria = "";
        String nombreCicloParalelo = "";

        try {
            docenteMateria = this.docenteMateria.get(row);
            nombreDocente = docenteControlador.obtener(docenteMateria.getId_docente()).getNombres();
            apellidoDocente = docenteControlador.obtener(docenteMateria.getId_docente()).getApellidos();
            nombreMateria = materiaControlador.obtener(docenteMateria.getId_materia()).getNombre();
            Curso curso = materiaCursoControlador.obtener(docenteMateria.getId_curso());
            if (curso != null) {
                Paralelo paralelo = paraleloControlador.obtener(curso.getId_paralelo());
                Ciclo ciclo = cicloControlador.obtener(curso.getId_ciclo());
                if (paralelo != null && ciclo != null) {
                    nombreCicloParalelo = ciclo.getNombre() + " - " + paralelo.getNombre();
                }
            }

        } catch (VacioExcepcion e) {
            throw new RuntimeException(e);
        }

        switch (col) {
            case 0:
                return (docenteMateria != null) ? nombreDocente + " " + apellidoDocente : "";
            case 1:
                return (docenteMateria != null) ? nombreMateria : "";
            case 2:
                return (docenteMateria != null) ? nombreCicloParalelo : "";
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
                return "Materia";
            case 2:
                return "Curso";
            default:
                return null;
        }
    }

    public LinkedList<DocenteMateria> getDocentesMateria() {
        return docenteMateria;
    }

    public void setDocentesMateria(LinkedList<DocenteMateria> docenteMateria) {
        this.docenteMateria = docenteMateria;
    }

}
