/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import modelo.Genero;

/**
 *
 * @author Usuario iTC
 */
public class GeneroController  extends AdaptadorDao<Genero> {
    
    private Genero genero;
    private LinkedList<Genero> lista = new LinkedList<>();
    private Integer index = -1;

    public GeneroController() {
        super(Genero.class);
    }

    public Genero getGenero() {
        if (genero == null) {
            genero = new Genero();
        }
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void guardar() {
        try {
            Integer idGenerado = this.guardar(genero);
            System.out.println("Genero guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar el genero: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public LinkedList<Genero> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<Genero> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public LinkedList<Genero> getGeneros() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }
}
