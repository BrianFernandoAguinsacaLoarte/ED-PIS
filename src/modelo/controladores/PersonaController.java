/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import modelo.Persona;

/**
 *
 * @author Usuario iTC
 */
public class PersonaController extends AdaptadorDao<Persona> {

    private Persona persona;
    private LinkedList<Persona> lista = new LinkedList<>();
    private Integer index = -1;

    //Constructor
    public PersonaController() {
        super(Persona.class);
    }

    //Metodos
    public void guardar() {
        try {
            Integer idGenerado = this.guardar(persona);
            System.out.println("Docente guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar el Docente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //Getter and Setter
    public Persona getPersona() {

        if (persona == null) {
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LinkedList<Persona> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<Persona> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public LinkedList<Persona> getPersonas() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

}
