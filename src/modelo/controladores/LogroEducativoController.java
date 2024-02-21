/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import modelo.LogroEducativo;

/**
 *
 * @author Usuario iTC
 */
public class LogroEducativoController extends AdaptadorDao<LogroEducativo> {
    
    private LogroEducativo logroEducativo = new LogroEducativo();
    private LinkedList<LogroEducativo> lista = new LinkedList<>();
    private Integer index = -1; 
    
    
    //Constructor
    public LogroEducativoController() {
        super(LogroEducativo.class);
    }
    
    //Metodos
     public void guardar() {
        try {
            Integer idGenerado = this.guardar(logroEducativo);
            System.out.println("Tipo de Logro guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar el Tipo de Logro: " + e.getMessage());
            e.printStackTrace();
        }
    }
     
    //Getter and Setter 

    public LogroEducativo getLogroEducativo() {
        
        if(logroEducativo == null){
            logroEducativo = new LogroEducativo();
        }
        return logroEducativo;
    }

    public void setLogroEducativo(LogroEducativo logroEducativo) {
        this.logroEducativo = logroEducativo;
    }

    public LinkedList<LogroEducativo> getLista() {
         if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<LogroEducativo> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    public LinkedList<LogroEducativo> getLogros() {
         if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }
     
     
}
