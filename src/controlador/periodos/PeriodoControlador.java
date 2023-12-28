/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.periodos;


import controlador.TDA.listas.LinkedList;
import controlador.dao.DataAccessObject;
import modelo.PeriodoAcademico;

/**
 *
 * @author Usuario 1
 */
public class PeriodoControlador extends DataAccessObject<PeriodoAcademico> {

    //Objetos
    private PeriodoAcademico pa = new PeriodoAcademico();
    private LinkedList<PeriodoAcademico> pas = new LinkedList<>();
    private Integer index = -1; 
    
    //Constructor
    public PeriodoControlador() {
        super(PeriodoAcademico.class);
    }
    
    //Métodos
    public boolean save(){
        pa.setId(generated_id());//BDD Esto desaparece
        return save(pa);
    }
    
    public boolean update(Integer index){
        return update(pa,index);
    }
    
    //Getter and Setter
    public PeriodoAcademico getPeriodoAcademico() {
        
        if(pa == null){
            pa = new PeriodoAcademico();
        }
        return pa;
    }

    public void setPeriodoAcademico(PeriodoAcademico pa) {
        this.pa = pa;
    }

    public LinkedList<PeriodoAcademico> getPeriodosAcademicos() {

        if(pas.isEmpty()){
            pas = listAll();
        }
        return pas;
    }

    public void setPeriodosAcademicos(LinkedList<PeriodoAcademico> pas) {
        this.pas = pas;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
