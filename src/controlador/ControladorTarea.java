/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.sql.rowset.serial.SerialBlob;
import modelo.Tarea;

/**
 *
 * @author 
 */
public class ControladorTarea extends AdaptadorDao<Tarea> {

    private Tarea tarea;
    private LinkedList<Tarea> lista = new LinkedList<>();
    private Integer index = -1;

    public ControladorTarea() {
        super(Tarea.class);
    }

    public Tarea getTarea() {
        if (tarea == null) {
            tarea = new Tarea();
        }
        return tarea;
    }

    public void setTarea(Tarea tarea) {
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

    public LinkedList<Tarea> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;

    }

    /**
     * @param lista the lista to set
     */
    public void setLista(LinkedList<Tarea> lista) {
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

    public LinkedList<Tarea> getMaterias() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public static void main(String[] args) throws Exception {
//        ControladorTarea tarea = new ControladorTarea();
//        try {
//            tarea.getTarea().setTema("Practica 4");
//            tarea.getTarea().setDescripcion("Resolver la leccion");
//            tarea.getTarea().setFechaEntrega("123123");
//            tarea.getTarea().setFechaCreacion("12asd3123");
//            tarea.getTarea().setArchivo(null);
//            tarea.getTarea().setExtensionArchivo("asd");
//            tarea.guardar();
//            tarea.setTarea(null);
//            System.out.println("Hola");
//            tarea.listar().imprimir();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

//        ControladorTarea controladorTarea = new ControladorTarea();
//
//        try {
//            Tarea nuevaTarea = new Tarea();
//            nuevaTarea.setTema("Practica 10");
//            nuevaTarea.setDescripcion("Resolver la lección 4");
//
//            // Establecer fechas específicas
//            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
////            Date fechaCreacion = formatoFecha.parse("01/01/2023 10:30:00");
//            Date fechaCreacion = formatoFecha.parse("01/01/2023");
//
////            Date fechaEntrega = formatoFecha.parse("15/01/2023 18:00:00");
//            Date fechaEntrega = formatoFecha.parse("15/01/2023");
//
//            nuevaTarea.setFechaCreacion(fechaCreacion);
//            nuevaTarea.setFechaEntrega(fechaEntrega);
//
//            // Si los archivos y la extensión son nulos, déjalos así
//            nuevaTarea.setArchivo(null);
//            nuevaTarea.setExtensionArchivo("pdf");
//
//            // Asignar la tarea al controlador y guardarla
//            controladorTarea.setTarea(nuevaTarea);
//            controladorTarea.guardar();
//
//            // Limpia la tarea después de guardar
//            controladorTarea.setTarea(null);
//
//            // Muestra la lista actualizada de tareas
////            controladorTarea.getLista().imprimir();
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//            e.printStackTrace();
//        }
//
//    }
//        Tarea tarea = new Tarea();
//        ControladorTarea dao = new ControladorTarea();
//        String ruta_archivo = "C:\\Users\\juanc\\OneDrive\\Escritorio\\Ensayo2.pdf";
//        
//        tarea.setTema("Hola");
//        
//        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
////            Date fechaCreacion = formatoFecha.parse("01/01/2023 10:30:00");
//            Date fechaCreacion = formatoFecha.parse("01/01/2023");
//
////            Date fechaEntrega = formatoFecha.parse("15/01/2023 18:00:00");
//            Date fechaEntrega = formatoFecha.parse("15/01/2023");
//
//            tarea.setFechaCreacion(fechaCreacion);
//            tarea.setFechaEntrega(fechaEntrega);
//        tarea.setDescripcion("Hola mundo");
//        File ruta = new File(ruta_archivo);
//        try {
//            byte[] archivo = new byte[(int) ruta.length()];
//            InputStream input = new FileInputStream(ruta);
//            input.read(archivo);
//            java.sql.Blob blobArchivo = new SerialBlob(archivo);
//            tarea.setArchivo(blobArchivo);
//        } catch (IOException | SQLException ex) {
//            tarea.setArchivo(null);
//            System.out.println("Error al agregar archivo " + ex.getMessage());
//        }
////                tarea.setExtensionArchivo("pdf");
//        
//        tarea.setExtensionArchivo("pdf");
//        dao.setTarea(tarea);
//        dao.guardar();
//
    }
}
