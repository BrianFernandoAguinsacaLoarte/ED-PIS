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
public class Persona {
    
    //Atributos
    private Integer id;
    private String nombres;
    private String apellidos;
    private Integer edad;
    private Genero genero;
    private String direccion;
    private String telefono;
    private String cedula;
    
    //Constructor
    
    public Persona(){
    }
    
    public Persona(Integer id, String nombres, String apellidos, Integer edad, Genero genero, String direccion, String telefono, String cedula) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cedula = cedula;
    }
    
    //Getter and Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    //Print
    @Override
    public String toString() {
        return nombres +" "+ apellidos;
    }
    
    //Main
    public static void main (String[] args){
        Persona p = new Persona();
        p.setNombres("Brian");
        System.out.println(p.toString());
    }
    
}
