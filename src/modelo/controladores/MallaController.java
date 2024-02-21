/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import modelo.Malla;

/**
 *
 * @author Usuario iTC
 */
public class MallaController extends AdaptadorDao<Malla>{
    
    private Malla malla;
    private LinkedList<Malla> lista = new LinkedList<>();
    private Integer index = -1;
    
    //Constructor
    public MallaController() {
        super(Malla.class);
    }
    
    //Metodo
    public void guardar() {
        try {
            Integer idGenerado = this.guardar(malla);
            System.out.println("Malla guardada con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar la Malla: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    //Getter and Setter
    public Malla getMalla() {
        
        if(malla == null){
            malla = new Malla();
        }
        return malla;
    }

    public void setMalla(Malla malla) {
        this.malla = malla;
    }

    public LinkedList<Malla> getLista() {
          if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<Malla> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    public LinkedList<Malla> getMallas() {
          if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }
}
