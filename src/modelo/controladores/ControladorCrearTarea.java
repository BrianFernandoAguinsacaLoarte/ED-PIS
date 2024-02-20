/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

//import com.mysql.cj.jdbc.Blob;

import controlador.dao.AdaptadorDao;
import java.util.Random;
import modelo.CrearTarea;
import controlador.TDA.listas.LinkedList;

/**
 *
 * @author juanc
 */
public class ControladorCrearTarea extends AdaptadorDao<CrearTarea> {

    private CrearTarea tarea;
    private LinkedList<CrearTarea> lista = new LinkedList<>();
    private Integer index = -1;

    public ControladorCrearTarea() {
        super(CrearTarea.class);
    }

    public CrearTarea getTarea() {
        if (tarea == null) {
            tarea = new CrearTarea();
        }
        return tarea;
    }

    public void setTarea(CrearTarea tarea) {
        this.tarea = tarea;
    }

    public void guardar() {
        try {
            Integer idGenerado = this.guardar(tarea);
            System.out.println("Tarea guardada con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar la tarea: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public LinkedList<CrearTarea> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;

    }

    /**
     * @param lista the lista to set
     */
    public void setLista(LinkedList<CrearTarea> lista) {
        this.lista = lista;
    }

    /**
     * @return the index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    public LinkedList<CrearTarea> getMaterias() { //Modificar en el proyecto a getTareas
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }
    
    public LinkedList<CrearTarea> obtenerTodasLasTareas() {
        return listar();
    }

    
    public String generarCodigoUnico() {
        String codigo = null;
        boolean codigoUnico = false;

        while (!codigoUnico) {
            codigo = generarCodigo();

            if (!existeCodigo(codigo)) {
                codigoUnico = true;
            }
        }

        return codigo;
    }

    private String generarCodigo() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder codigoBuilder = new StringBuilder();
        Random random = new Random();

        // Generar un código de 6 caracteres
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(caracteres.length());
            codigoBuilder.append(caracteres.charAt(index));
        }

        return codigoBuilder.toString();
    }

    private boolean existeCodigo(String codigo) {
        try {
            ControladorCrearTarea cct = new ControladorCrearTarea();
            LinkedList<CrearTarea> tareasLink = cct.listar();
            CrearTarea[] tareas = tareasLink.toArray();

            for (CrearTarea tarea : tareas) {
                if (tarea.getCodigo().equals(codigo)) {
                    return true; //El codigo existe
                }
            }
        } catch (Exception e) {
            System.out.println("Error al verificar la existencia del código: " + e.getMessage());
            e.printStackTrace();
        }
        return false; // El código no existe
    }

    
    
}
