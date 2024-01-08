/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Blob;
import java.util.Date;
import modelo.enums.EstadoEntrega;

/**
 *
 * @author Usuario iTC
 */
public class EntregaTarea {
    
   private Integer id;
    private Date fechaEntrega; 
    private Double calificacion;
    private String estadoEntrega;
    private Blob archivoTarea;
    private String textoTarea;
    private String nombreTarea;
    private String extensionTarea;
    private Integer id_tarea;

    public EntregaTarea() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public String getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(String estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public Blob getArchivoTarea() {
        return archivoTarea;
    }

    public void setArchivoTarea(Blob archivoTarea) {
        this.archivoTarea = archivoTarea;
    }

    public String getExtensionTarea() {
        return extensionTarea;
    }

    public void setExtensionTarea(String extensionTarea) {
        this.extensionTarea = extensionTarea;
    }

    public Integer getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Integer id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getTextoTarea() {
        return textoTarea;
    }

    public void setTextoTarea(String textoTarea) {
        this.textoTarea = textoTarea;
    }
    
    
}
