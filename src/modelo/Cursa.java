/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.TDA.listas.LinkedList;

/**
 *
 * @author Usuario iTC
 */
public class Cursa {
    //Atributos
    private Integer id;
    private Integer id_Estudiante;
    private LinkedList<Estudiante> estudiantes;
    private LinkedList<Materia> materias;
    private String codigo;
    
    //Constructor
    
    public Cursa(){
        estudiantes = new LinkedList<>();
        materias = new LinkedList<>();
    }
    
    public Cursa(Integer id, Integer id_Estudiante, String codigo, Integer capacidad) {
        this.id = id;
        this.id_Estudiante = id_Estudiante;
        this.codigo = codigo;
    }
    
    //Getter and Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_Estudiante() {
        return id_Estudiante;
    }

    public void setId_Estudiante(Integer id_Estudiante) {
        this.id_Estudiante = id_Estudiante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    
    public LinkedList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(LinkedList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public LinkedList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(LinkedList<Materia> materias) {
        this.materias = materias;
    }
    
    
    
    
    
}
