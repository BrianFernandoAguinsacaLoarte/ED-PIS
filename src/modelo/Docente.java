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
public class Docente extends Persona{
    
    //Atributos
    private String titulo;
    
    
    //Constructores
    public Docente() {
    }

    public Docente(String titulo, Integer id, String nombres, String apellidos, Integer edad, Genero genero, String direccion, String telefono, String cedula) {
        super(id, nombres, apellidos, edad, genero, direccion, telefono, cedula);
        this.titulo = titulo;
    }
    
    //Getter and Setter
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    //Print

    @Override
    public String toString() {
        return "Docente{" + "titulo=" + titulo + "}" + super.toString();
    }
    
    public static void main (String[] args){
        Docente d = new Docente();
        d.setTitulo("Maestria");
        System.out.println(d.toString());
    }
    
    
}
