/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo.enums.Genero;
import modelo.enums.Rol;

/**
 *
 * @author Usuario iTC
 */
public class Docente extends Persona{
    
    //Atributos
    private Integer id_Persona;
    private String titulo;
    private String especializacion;
    private Integer experienciaLaboral;
    private String certificaciones;
    
    
    //Constructores
    public Docente() {
    }

    public Docente(String titulo, Integer id, String nombres, String apellidos, String correo, Integer edad, Genero genero, Rol rol, String direccion, String telefono, String cedula) {
        super(id, nombres, apellidos,correo, edad, genero, rol, direccion, telefono, cedula);
        this.titulo = titulo;
    }

   
    //Getter and Setter
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(Integer id_Persona) {
        this.id_Persona = id_Persona;
    }
    
    


    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }


    public Integer getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(Integer experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public String getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(String certificaciones) {
        this.certificaciones = certificaciones;
    }

    
    
    //Print
    @Override
    public String toString() {
        return super.toString();
    }
    
}
