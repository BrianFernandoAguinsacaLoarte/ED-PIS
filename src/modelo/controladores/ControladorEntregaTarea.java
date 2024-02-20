/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.dao.AdaptadorDao;
import java.util.Random;
import modelo.EntregaTarea;
import controlador.TDA.listas.LinkedList;

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
        ControladorEntregaTarea cct = new ControladorEntregaTarea();
        LinkedList<EntregaTarea> tareasLink = cct.listar();
        EntregaTarea [] tareas = tareasLink.toArray();
        
        for (EntregaTarea tarea : tareas) {
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
