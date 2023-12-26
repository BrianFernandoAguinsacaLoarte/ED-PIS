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
public class Matricula {
    private Integer id;
    private String estado;
    private Estudiante estudiante;
    private Materia materia;
    private Curso curso;
    private PeriodoAcademico p_academico;
    private Date fechaMatricula;

    public Matricula(Estudiante estudiante, Curso curso, Date fechaMatricula) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.fechaMatricula = fechaMatricula;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    

    @Override
    public String toString() {
        return "Matricula{" +
                "estudiante=" + estudiante +
                ", curso=" + curso +
                ", fechaMatricula=" + fechaMatricula +
                '}';
    }
}
