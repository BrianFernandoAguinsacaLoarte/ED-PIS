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
    private Integer id_Persona;
    private String titulo;
    
    //Constructores
    public Docente() {
    }

    public Docente(String titulo, Integer id, String nombres, String apellidos, String correo, Integer edad, Genero genero, String direccion, String telefono, String cedula) {
        super(id, nombres, apellidos,correo, edad, genero, direccion, telefono, cedula);
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
    
    public Persona getPersona() {
        return new Persona(getId(), getNombres(), getApellidos(), getCorreo(), getEdad(), getGenero(), getDireccion(), getTelefono(), getCedula());
    }

    
    //Print

    @Override
    public String toString() {
        return "Docente{" + "titulo=" + titulo + "}" + super.toString();
    }
    
    public static void main (String[] args){
        Docente d = new Docente("Maestria", 1, "Nombre", "Apellido", "correo@example.com", 30, Genero.Masculino, "Dirección", "123456789", "ABC123");

        // Obtener el objeto Persona asociado al Docente
        Persona personaDelDocente = d.getPersona();

        // Imprimir información de la Persona
        System.out.println("ID: " + personaDelDocente.getId());
        System.out.println("Nombres: " + personaDelDocente.getNombres());
        System.out.println("Apellidos: " + personaDelDocente.getApellidos());
        System.out.println("Correo: " + personaDelDocente.getCorreo());

        // También puedes imprimir directamente usando el método toString
        System.out.println(personaDelDocente.toString());
    }
    
}
