/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import modelo.Ciclo;

/**
 *
 * @author Usuario iTC
 */
public class CicloController extends AdaptadorDao<Ciclo>{
    
    private Ciclo ciclo;
    private LinkedList<Ciclo> lista = new LinkedList<>();
    private Integer index = -1;
    
    //Constructor
    public CicloController() {
        super(Ciclo.class);
    }
    
    //Metodo
    public void guardar() {
        try {
            Integer idGenerado = this.guardar(ciclo);
            System.out.println("Ciclo guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar el ciclo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    //Getter and Setter
    public Ciclo getCiclo() {
        
        if(ciclo == null){
            ciclo = new Ciclo();
        }
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public LinkedList<Ciclo> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<Ciclo> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
     public LinkedList<Ciclo> getCiclos() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }
    
}
