/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import modelo.MatriculaCursoMateria;

/**
 *
 * @author juanc
 */
public class MatriculaCursoMateriaControlador extends AdaptadorDao<MatriculaCursoMateria> {

    private MatriculaCursoMateria matriculaCursoMateria; 
    private LinkedList<MatriculaCursoMateria> lista = new LinkedList<>();
    private Integer index = -1;

    public MatriculaCursoMateriaControlador() {
        super(MatriculaCursoMateria.class);
    }

    public MatriculaCursoMateria getMatriculaCursoMateria() { 
        if (matriculaCursoMateria == null) {
            matriculaCursoMateria = new MatriculaCursoMateria();
        }
        return matriculaCursoMateria;
    }

    public void setMatriculaCursoMateria(MatriculaCursoMateria matriculaCursoMateria) { 
        this.matriculaCursoMateria = matriculaCursoMateria;
    }

    public void guardar() {
        try {
            Integer idGenerado = this.guardar(matriculaCursoMateria);
            System.out.println("MatriculaCursoMateria guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar el MatriculaCursoMateria: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public LinkedList<MatriculaCursoMateria> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<MatriculaCursoMateria> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public LinkedList<MatriculaCursoMateria> getMaterias() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

}
