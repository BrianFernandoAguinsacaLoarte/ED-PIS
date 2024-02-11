/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
import modelo.enums.Estado;
import modelo.enums.Modalidad;
import modelo.enums.Turno;

/**
 *
 * @author Usuario iTC
 */
public class Matricula {
    //Atributos
    private Integer id;
    private Date fechaMatricula;
    private Estado estado;
    private Estado gratuidad;
    private Turno turno;
    private Modalidad modalidad;
    
    
    //Llaves foraneas
    private Integer id_estudiante;
    private Integer id_periodoAcademico;
    
    //Constructor

    public Matricula() {
    }
    
    //Getter and Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public Integer getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Integer id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public Integer getId_periodoAcademico() {
        return id_periodoAcademico;
    }

    public void setId_periodoAcademico(Integer id_periodoAcademico) {
        this.id_periodoAcademico = id_periodoAcademico;
    }

    public Estado getGratuidad() {
        return gratuidad;
    }

    public void setGratuidad(Estado gratuidad) {
        this.gratuidad = gratuidad;
    }
    
    
    
    
}
