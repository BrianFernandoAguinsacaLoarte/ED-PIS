/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.persona;

import modelo.Persona;
import controlador.TDA.listas.LinkedList;
import controlador.dao.DataAccessObject;

/**
 *
 * @author Usuario iTC
 */
public class PersonaController extends DataAccessObject<Persona> {
    
    //Objetos 
    private Persona persona = new Persona();
    private LinkedList<Persona> personas = new LinkedList<>();
    private Integer index = -1; //Index para el Update
    
    //Constructor
    public PersonaController() {
        super(Persona.class);
    }

    //Metodos 
    public boolean save(){
        persona.setId(generated_id());//BDD Esto desaparece
        return save(persona);
    }
    
    public boolean update(Integer index){
        return update(persona,index);
    }
    
    
    //Getter and Setter
    public Persona getPersona() {
        if(persona == null){
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LinkedList<Persona> getPersonas() {
        if(personas.isEmpty()){
            personas = listAll();
        }
        return personas;
    }

    public void setPersonas(LinkedList<Persona> personas) {
        this.personas = personas;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    
    
   
    
    
    
}