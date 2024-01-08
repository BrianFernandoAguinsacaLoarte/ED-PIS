/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import modelo.EntregaTarea;

/**
 *
 * @author juanc
 */
public class ControladorEntregaTarea extends AdaptadorDao<EntregaTarea> {

    private EntregaTarea entregaTarea;
    private LinkedList<EntregaTarea> lista = new LinkedList<>();
    private Integer index = -1;

    public ControladorEntregaTarea() {
        super(EntregaTarea.class);
    }

    public EntregaTarea getEntregaTarea() {
        if (entregaTarea == null) {
            entregaTarea = new EntregaTarea();
        }
        return entregaTarea;
    }

    public void setEntregaTarea(EntregaTarea entregaTarea) {
        this.entregaTarea = entregaTarea;
    }

    public void guardar() {
        try {
            Integer idGenerado = this.guardar(entregaTarea);
            System.out.println("Tarea guardada con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar la tarea: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public LinkedList<EntregaTarea> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<EntregaTarea> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public LinkedList<EntregaTarea> getMaterias() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public static void main(String[] args) {

       
    }

}
