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
public class Docente extends Persona{
    
    //Atributos
    private Integer experienciaLaboral;
    
 
    
    //Constructores
    public Docente() {
    }

    
    
    //Getter and Setter
    public Integer getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(Integer experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

   
    
    //Print
    @Override
    public String toString() {
        return super.toString();
    }
    
}
