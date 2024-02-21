/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import modelo.TipoLogro;

/**
 *
 * @author Usuario iTC
 */
public class TipoLogroController extends AdaptadorDao<TipoLogro> {
    
    
    private TipoLogro tipoLogro = new TipoLogro();
    private LinkedList<TipoLogro> lista = new LinkedList<>();
    private Integer index = -1; 
    
    //Constructor
    public TipoLogroController() {
        super(TipoLogro.class);
    }
    
  
     //Métodos 
     public void guardar() {
        try {
            Integer idGenerado = this.guardar(tipoLogro);
            System.out.println("Tipo de Logro guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar el Tipo de Logro: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
     
     //Getter and Setter

    public TipoLogro getTipoLogro() {
        
        if(tipoLogro == null){
            tipoLogro = new TipoLogro();
        }
        return tipoLogro;
    }

    public void setTipoLogro(TipoLogro tipoLogro) {
        this.tipoLogro = tipoLogro;
    }

    public LinkedList<TipoLogro> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<TipoLogro> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
     
    public LinkedList<TipoLogro> getTiposLogro() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }
    
}
