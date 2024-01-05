/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario iTC
 */
public class Cursa {
    //Atributos
    private Integer id;
    private Integer id_Estudiante;
    private String codigo;
    private Integer capacidad;
    
    //Constructor
    
    public Cursa(){
        
    }
    public Cursa(Integer id, Integer id_Estudiante, String codigo, Integer capacidad) {
        this.id = id;
        this.id_Estudiante = id_Estudiante;
        this.codigo = codigo;
        this.capacidad = capacidad;
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


    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    
}
