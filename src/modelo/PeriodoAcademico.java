/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Usuario iTC
 */
public class PeriodoAcademico {
    
    private String id;
    private String semestre;
    private String añoAcademico;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer id_Matricula;
    
    public PeriodoAcademico() {
    }

    public PeriodoAcademico(String id, String semestre, String añoAcademico, Date fechaInicio, Date fechaFin, Integer id_Matricula) {
        this.id = id;
        this.semestre = semestre;
        this.añoAcademico = añoAcademico;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.id_Matricula = id_Matricula;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getAñoAcademico() {
        return añoAcademico;
    }

    public void setAñoAcademico(String añoAcademico) {
        this.añoAcademico = añoAcademico;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getId_Matricula() {
        return id_Matricula;
    }

    public void setId_Matricula(Integer id_Matricula) {
        this.id_Matricula = id_Matricula;
    }
}
