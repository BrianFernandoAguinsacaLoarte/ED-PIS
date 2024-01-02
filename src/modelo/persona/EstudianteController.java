/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.persona;

import controlador.dao.DataAccessObject;
import modelo.Estudiante;
import controlador.TDA.listas.LinkedList;



/**
 *
 * @author Usuario iTC
 */
public class EstudianteController extends DataAccessObject<Estudiante>{
    
    //Objetos
    private Estudiante estudiante = new Estudiante();
    private LinkedList<Estudiante> estudiantes = new LinkedList<>();
    private Integer index = -1; 
    
    //Constructor
    public EstudianteController() {
        super(Estudiante.class);
    }
    
    //Métodos
    public boolean save(){
        estudiante.setId(generated_id());//BDD Esto desaparece
        return save(estudiante);
    }
    
    public boolean update(Integer index){
        return update(estudiante,index);
    }
    
    //Getter and Setter
    public Estudiante getEstudiante() {
        
        if(estudiante == null){
            estudiante = new Estudiante();
        }
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LinkedList<Estudiante> getEstudiantes() {

        if(estudiantes.isEmpty()){
            estudiantes = listAll();
        }
        return estudiantes;
    }

    public void setEstudiantes(LinkedList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    
}
