/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.Excepcion.VacioExcepcion;
import java.util.Date;

/**
 *
 * @author Usuario iTC
 */
public class Estudiante extends Persona {
    
    //Atributos
    private String tituloBachiller;
    
  
    
    //Constructores
    public Estudiante() {
    }

   
    

    //Getter and Setter

    public String getTituloBachiller() {
        return tituloBachiller;
    }

    public void setTituloBachiller(String tituloBachiller) {
        this.tituloBachiller = tituloBachiller;
    }

    @Override
    public String toString() {
        return getNombres() + " " + getApellidos();
    }
   
    
}
