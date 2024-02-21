/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import modelo.PeriodoAcademico;

/**
 *
 * @author Usuario iTC
 */
public class PeriodoAcademicoController extends AdaptadorDao<PeriodoAcademico>{
    
    private PeriodoAcademico periodo;
    private LinkedList<PeriodoAcademico> lista = new LinkedList<>();
    private Integer index = -1;
    
    //Constructor

    public PeriodoAcademicoController( ) {
        super(PeriodoAcademico.class);
    }
    
    
    //Metodo
     public void guardar() {
        try {
            Integer idGenerado = this.guardar(periodo);
            System.out.println("Periodo Academico guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar el Periodo Academico: " + e.getMessage());
            e.printStackTrace();
        }
    }
     
    //Getter and Setter

    public PeriodoAcademico getPeriodo() {
        
        if(periodo == null){
            periodo = new PeriodoAcademico();
        }
        return periodo;
    }

    public void setPeriodo(PeriodoAcademico periodo) {
        this.periodo = periodo;
    }

    public LinkedList<PeriodoAcademico> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<PeriodoAcademico> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
     
     public LinkedList<PeriodoAcademico> getPeriodos() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }
    
}
