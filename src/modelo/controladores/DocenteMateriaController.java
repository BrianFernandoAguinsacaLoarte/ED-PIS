/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.dao.AdaptadorDao;
import controlador.TDA.listas.LinkedList;
import modelo.DocenteMateria;
/**
 *
 * @author juanc
 */
public class DocenteMateriaController extends AdaptadorDao<DocenteMateria> {

    private DocenteMateria docenteMateria;
    private LinkedList<DocenteMateria> lista = new LinkedList<>();
    private Integer index = -1;

    public DocenteMateriaController() {
        super(DocenteMateria.class);
    }

    public DocenteMateria getDocenteMateria() {
        if (docenteMateria == null) {
            docenteMateria = new DocenteMateria();
        }
        return docenteMateria;
    }

    public void setDocenteMateria(DocenteMateria docenteMateria) {
        this.docenteMateria = docenteMateria;
    }

    public void guardar() {
        try {
            Integer idGenerado = this.guardar(docenteMateria);
            System.out.println("DocenteMateria guardada con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar la DocenteMateria: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public LinkedList<DocenteMateria> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<DocenteMateria> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public LinkedList<DocenteMateria> getDocentesMaterias() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }
}

