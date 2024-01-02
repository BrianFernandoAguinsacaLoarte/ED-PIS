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
public class Estudiante extends Persona {
    
    //Atributos
    private Integer id_Persona;
    private String colegioAnterior;
    
    
    //Constructores
    public Estudiante() {
    }
    
    public Estudiante(Integer id, String nombres, String apellidos, String correo, Integer edad, Genero genero, Rol rol, String direccion, String telefono, String cedula, String colegioAnterior) {
        super(id, nombres, apellidos, correo, edad, genero, rol, direccion, telefono, cedula);
        this.colegioAnterior = colegioAnterior; 
    }
    
    //Getter and Setter

    public String getColegioAnterior() {
        return colegioAnterior;
    }

    public void setColegioAnterior(String colegioAnterior) {
        this.colegioAnterior = colegioAnterior;
    }

    public Integer getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(Integer id_Persona) {
        this.id_Persona = id_Persona;
    }
    
    
    //Print
    @Override
    public String toString() {
        return "Estudiante{" + "colegioAnterior=" + colegioAnterior + "}" + super.toString();
    }
    
    
    //Main
    public static void main (String[] args){
        Estudiante e = new Estudiante();
        
        e.setColegioAnterior("La Dolorosa");
        System.out.println(e.toString());
    }
    
    
    
    

    
    
    
}
