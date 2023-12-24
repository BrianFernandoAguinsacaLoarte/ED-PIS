/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo.enums.Genero;

/**
 *
 * @author Usuario iTC
 */
public class Estudiante extends Persona {
    
    //Atributos
    private String colegioAnterior;
    
    
    //Constructores
    public Estudiante() {
    }
    
    public Estudiante(Integer id, String nombres, String apellidos, Integer edad, Genero genero, String direccion, String telefono, String cedula, String colegioAnterior) {
        super(id, nombres, apellidos, edad, genero, direccion, telefono, cedula);
        this.colegioAnterior = colegioAnterior; 
    }
    
    //Getter and Setter

    public String getColegioAnterior() {
        return colegioAnterior;
    }

    public void setColegioAnterior(String colegioAnterior) {
        this.colegioAnterior = colegioAnterior;
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
