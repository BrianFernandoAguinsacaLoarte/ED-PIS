/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import modelo.Matricula;


/**
 *
 * @author juanc
 */
public class MatriculaControlador extends AdaptadorDao<Matricula> {

    private Matricula matricula;
    private LinkedList<Matricula> lista = new LinkedList<>();
    private Integer index = -1;

    public MatriculaControlador() {
        super(Matricula.class);
    }

    public Matricula getMatricula() {
        if (matricula == null) {
            matricula = new Matricula();
        }
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public void guardar() {
        try {
            Integer idGenerado = this.guardar(matricula);
            System.out.println("Matricula guardada con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar la Matricula: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public LinkedList<Matricula> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<Matricula> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public LinkedList<Matricula> getMatriculas() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

}
