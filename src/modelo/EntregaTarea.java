/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
import modelo.enums.EstadoEntrega;

/**
 *
 * @author Usuario iTC
 */
public class EntregaTarea {
    
    private Integer id;
    private EstadoEntrega estado;
    private Date fechaEntrega;
    private String archivo;

    public EntregaTarea() {
    }

    public EntregaTarea(Integer id, EstadoEntrega estado, Date fechaEntrega, String archivo) {
        this.id = id;
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
        this.archivo = archivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoEntrega getEstado() {
        return estado;
    }

    public void setEstado(EstadoEntrega estado) {
        this.estado = estado;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
    
}
