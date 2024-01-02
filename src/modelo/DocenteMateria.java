/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario iTC
 */
public class DocenteMateria {
    
    //Atributos
    private Integer id;
    private Integer id_Docente;
    private Integer id_Materia;
    private Integer id_PeriodoAcademico;
    
    //Constructor

    public DocenteMateria(Integer id, Integer id_Docente, Integer id_Materia, Integer id_PeriodoAcademico) {
        this.id = id;
        this.id_Docente = id_Docente;
        this.id_Materia = id_Materia;
        this.id_PeriodoAcademico = id_PeriodoAcademico;
    }
    
    //Getter and Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_Docente() {
        return id_Docente;
    }

    public void setId_Docente(Integer id_Docente) {
        this.id_Docente = id_Docente;
    }

    public Integer getId_Materia() {
        return id_Materia;
    }

    public void setId_Materia(Integer id_Materia) {
        this.id_Materia = id_Materia;
    }

    public Integer getId_PeriodoAcademico() {
        return id_PeriodoAcademico;
    }

    public void setId_PeriodoAcademico(Integer id_PeriodoAcademico) {
        this.id_PeriodoAcademico = id_PeriodoAcademico;
    }
    
    
    
}
