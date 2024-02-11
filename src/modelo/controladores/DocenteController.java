/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;
import controlador.Excepcion.VacioExcepcion;
import modelo.Docente;
import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import controlador.util.Utilidades;
import java.lang.reflect.Field;
import modelo.Estudiante;
import modelo.Persona;

/**
 *
 * @author Usuario iTC
 */
public class DocenteController extends AdaptadorDao<Docente>  {
    
    private Docente docente;
    private LinkedList<Docente> lista = new LinkedList<>();
    private Integer index = -1;

    public DocenteController() {
        super(Docente.class);
    }
    
    public void guardar() {
        try {
            Integer idGenerado = this.guardar(docente);
            System.out.println("Docente guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar el Docente: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    public Docente getDocente() {
        if (docente == null) {
            docente = new Docente();
        }
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    

    public LinkedList<Docente> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<Docente> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public LinkedList<Docente> getDocentes() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }
    
    
    
}
