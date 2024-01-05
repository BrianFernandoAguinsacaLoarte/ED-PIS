/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.persona;

import controlador.TDA.listas.LinkedList;
import controlador.dao.DataAccessObject;
import modelo.DocenteMateria;

/**
 *
 * @author Usuario iTC
 */
public class DocenteMateriaController extends DataAccessObject<DocenteMateria> {
    
    //Objeto
    private DocenteMateria  docenteMateria;
    private LinkedList<DocenteMateria> docenteMaterias = new LinkedList<>();
    private Integer index = -1; 
   
    
    //Constructor
    public DocenteMateriaController() {
        super(DocenteMateria.class);
    }
    
      //Métodos 
    public boolean save(){
        docenteMateria.setId(generated_id());//BDD Esto desaparece
        return save(docenteMateria);
    }
    
    public boolean update(Integer index){
        return update(docenteMateria,index);
    }
    
    //Getter and Setter

    public DocenteMateria getDocenteMateria() {
        if(docenteMateria == null){
            docenteMateria = new DocenteMateria();
        }
        return docenteMateria;
    }

    public void setDocenteMateria(DocenteMateria docenteMateria) {
        this.docenteMateria = docenteMateria;
    }

    public LinkedList<DocenteMateria> getDocenteMaterias() {
        
        if(docenteMaterias.isEmpty()){
            docenteMaterias = listAll();
        }
            
        return docenteMaterias;
    }

    public void setDocenteMaterias(LinkedList<DocenteMateria> docenteMaterias) {
        this.docenteMaterias = docenteMaterias;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    
}
