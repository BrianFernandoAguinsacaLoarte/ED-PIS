/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import modelo.Materia;

/**
 *
 * @author Usuario iTC
 */
public class MateriaController extends AdaptadorDao<Materia> {
    
    private Materia materia;
    private LinkedList<Materia> lista = new LinkedList<>();
    private Integer index = -1;
    
    //Constructor
    public MateriaController() {
        super(Materia.class);
    }
    
    //Metodos
    public void guardar() {
        try {
            Integer idGenerado = this.guardar(materia);
            System.out.println("Materia guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar la Materia: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    //Getter and Setter
    public Materia getMateria() {
        if(materia == null){
            materia = new Materia();
        }
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public LinkedList<Materia> getLista() {
         if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<Materia> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
     public LinkedList<Materia> getMaterias() {
         if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }
}
