/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario iTC
 */
public class Malla {
    
    private Integer id;
    private String nombreMalla;
    private String duracion;
    private String fechaRegistro;
    private String Carrera;

    public Malla() {
    }

    public Malla(Integer id, String nombreMalla, String duracion, String fechaRegistro) {
        this.id = id;
        this.nombreMalla = nombreMalla;
        this.duracion = duracion;
        this.fechaRegistro = fechaRegistro;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMalla() {
        return nombreMalla;
    }

    public void setNombreMalla(String nombreMalla) {
        this.nombreMalla = nombreMalla;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }
}
