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
    
    private Integer id;
    private String semestre;
    private String añoAcademico;
    private String fechaInicio;
    private String fechaFin;
    private Integer id_Matricula;
    
    public PeriodoAcademico() {
    }

    public PeriodoAcademico(Integer id, String semestre, String añoAcademico, String fechaInicio, String fechaFin, Integer id_Matricula) {
        this.id = id;
        this.semestre = semestre;
        this.añoAcademico = añoAcademico;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.id_Matricula = id_Matricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getId_Matricula() {
        return id_Matricula;
    }

    public void setId_Matricula(Integer id_Matricula) {
        this.id_Matricula = id_Matricula;
    }
    
    public Boolean comparar(PeriodoAcademico c, String field, Integer type) {

        switch (type) {
            case 1:
                if (field.equalsIgnoreCase("id")) {
                    return getId().intValue() > c.getId().intValue();
                } else if (field.equalsIgnoreCase("semestre")) {
                    return getSemestre().compareTo(c.getSemestre()) > 0;
                } else if (field.equalsIgnoreCase("fechaInicio")) {
                    return getFechaInicio().compareTo(c.getFechaInicio()) > 0;
                } else if (field.equalsIgnoreCase("fechaFin")) {
                    return getFechaFin().compareTo(c.getFechaFin()) > 0;
                } else if (field.equalsIgnoreCase("añoAcademico")) {
                    return getAñoAcademico().compareTo(c.getAñoAcademico()) > 0;
                }
                break;
            case 0:
                if (field.equalsIgnoreCase("id")) {
                    return getId().intValue() < c.getId().intValue();
                } else if (field.equalsIgnoreCase("semestre")) {
                    return getSemestre().compareTo(c.getSemestre()) < 0;
                } else if (field.equalsIgnoreCase("fechaInicio")) {
                    return getFechaInicio().compareTo(c.getFechaInicio()) < 0;
                } else if (field.equalsIgnoreCase("fechaFin")) {
                    return getFechaFin().compareTo(c.getFechaFin()) < 0;
                } else if (field.equalsIgnoreCase("añoAcademico")) {
                    return getAñoAcademico().compareTo(c.getAñoAcademico()) < 0;
                }

                break;
            default:
                return null;
        }
        return null;
    }
}
