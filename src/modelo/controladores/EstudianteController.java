/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.Excepcion.VacioExcepcion;
import controlador.dao.DataAccessObject;
import modelo.Estudiante;
import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import controlador.util.Utilidades;
import java.lang.reflect.Field;
import modelo.Persona;



/**
 *
 * @author Usuario iTC
 */
public class EstudianteController extends AdaptadorDao<Estudiante>{
    
    //Objetos
    private Estudiante estudiante = new Estudiante();
    private LinkedList<Estudiante> lista = new LinkedList<>();
    private Integer index = -1; 
    
    //Constructor
    public EstudianteController() {
        super(Estudiante.class);
    }
    
    //Métodos
     public void guardar() {
        try {
            Integer idGenerado = this.guardar(estudiante);
            System.out.println("Estudiante guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar el Docente: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
//    public String obtenerNombre(Integer idPersona) throws VacioExcepcion {
//        PersonaController pc = new PersonaController();
//
//        for (int i = 0; i < pc.getPersonas().getSize(); i++) {
//            Persona persona = pc.getPersonas().get(i);
//            if (persona.getId().equals(idPersona)) {
//                 return persona.getNombres() + " " + persona.getApellidos();
//            }
//        }
//        return "";
//    }
    
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

        if(lista.isEmpty()){
            lista = listar();
        }
        return lista;
    }

    public LinkedList<Estudiante> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<Estudiante> lista) {
        this.lista = lista;
    }

    
    
    
    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    
    
}
