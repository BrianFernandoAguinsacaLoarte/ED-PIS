/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
import modelo.controladores.EstudianteController;
import modelo.controladores.MatriculaControlador;

/**
 *
 * @author juanc
 */
public class Matricula {

    private Integer id;
    private Date fechaMatricula;
    private String estado;
    private String gratuidad;
    private String turno;
    private String modalidad;

    //Llaves foraneas
    private Integer id_estudiante;
    private Integer id_periodoAcademico;

    private MatriculaControlador matriculaControlador = new MatriculaControlador();
    private EstudianteController estudianteControlador = new EstudianteController();

  
    @Override
    public String toString() {
        String nombreParaleloCiclo = "";

        Matricula matricula = matriculaControlador.obtener(this.getId());
        if (matricula != null) {
            Estudiante estudiante = estudianteControlador.obtener(matricula.getId());
            if (estudiante != null) {
                nombreParaleloCiclo = estudiante.getNombres() + " " + estudiante.getApellidos();
            }
        }

        return nombreParaleloCiclo;

    }

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getGratuidad() {
        return gratuidad;
    }

    public void setGratuidad(String gratuidad) {
        this.gratuidad = gratuidad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
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


}
