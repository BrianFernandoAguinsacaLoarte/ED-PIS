/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import modelo.Malla_materia;

/**
 *
 * @author Usuario iTC
 */
public class Malla_materiaController extends AdaptadorDao<Malla_materia>{
    
    private Malla_materia mallaMateria;
    private LinkedList<Malla_materia> lista = new LinkedList<>();
    private Integer index = -1;
    
    //Constructor
    public Malla_materiaController() {
        super(Malla_materia.class);
    }
    
    //Metodo
    public void guardar() {
        try {
            Integer idGenerado = this.guardar(mallaMateria);
            System.out.println("Malla-Materia guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar la Malla-Materia: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    //Getter and Setter
    public Malla_materia getMallaMateria() {
        
        if(mallaMateria == null){
            mallaMateria = new Malla_materia();
        }
        return mallaMateria;
    }

    public void setMallaMateria(Malla_materia mallaMateria) {
        this.mallaMateria = mallaMateria;
    }

    public LinkedList<Malla_materia> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<Malla_materia> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    
    public LinkedList<Malla_materia> getMallasMaterias() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }
    
    
    
}
