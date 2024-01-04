/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.persona;

import controlador.TDA.listas.LinkedList;
import controlador.dao.DataAccessObject;
import modelo.Cursa;
/**
 *
 * @author Usuario iTC
 */
public class CursaController extends DataAccessObject<Cursa> {
    
    //Objetos 
    private Cursa cursa = new Cursa();
    private LinkedList<Cursa> cursas = new LinkedList<>();
    private Integer index = -1; 
    
    //Constructor
    public CursaController() {
        super(Cursa.class);
    }
    
     //Métodos 
    public boolean save(){
        cursa.setId(generated_id());//BDD Esto desaparece
        return save(cursa);
    }
    
    public boolean update(Integer index){
        return update(cursa,index);
    }
    
    //Getter and Setter

    public Cursa getCursa() {
        if(cursa == null){
            cursa = new Cursa();
        }
        return cursa;
    }

    public void setCursa(Cursa cursa) {
        this.cursa = cursa;
    }

    public LinkedList<Cursa> getCursas() {
        
        if(cursas.isEmpty()){
            cursas = listAll();
        }
        return cursas;
    }

    public void setCursas(LinkedList<Cursa> cursas) {
        this.cursas = cursas;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    
    
}
