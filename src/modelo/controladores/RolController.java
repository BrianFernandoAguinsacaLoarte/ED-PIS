/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import modelo.Rol;

/**
 *
 * @author Usuario iTC
 */
public class RolController extends AdaptadorDao<Rol> {
    
    //Objetos
    private Rol rol;
    private LinkedList<Rol> lista = new LinkedList<>();
    private Integer index = -1;

    //Constructor
    public RolController() {
        super(Rol.class);
    }
    
    //Metodo
     public void guardar() {
        try {
            Integer idGenerado = this.guardar(rol);
            System.out.println("Genero guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar el genero: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    //Getter and Setter

    public Rol getRol() {
        
        if(rol == null){
            rol = new Rol();
        }
        
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public LinkedList<Rol> getLista() {
        
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<Rol> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    public LinkedList<Rol> getRoles(){
        if (lista.isEmpty()) {
                lista = listar();
            }
        return lista;
    }
    
}
