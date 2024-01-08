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

    //Metodo Compare
    public Integer compareQuickSort(Docente c, Integer type, String field) {
    switch (type) {
        case 0:
            if (field.equalsIgnoreCase("id_Persona")) {
                return this.getId_Persona().compareTo(c.getId_Persona());
                
            } else if (field.equalsIgnoreCase("titulo")) {
                return this.getTitulo().compareTo(c.getTitulo());
                
            } else if (field.equalsIgnoreCase("especializacion")) {
                return this.getEspecializacion().compareTo(c.getEspecializacion());
                
            } else if (field.equalsIgnoreCase("experiencialaboral")) {
                return this.getExperienciaLaboral().compareTo(c.getExperienciaLaboral());
                
            } else if (field.equalsIgnoreCase("certificaciones")) {
                return this.getCertificaciones().compareTo(c.getCertificaciones());
                
            }
            
        case 1:
            if (field.equalsIgnoreCase("id_Persona")) {
                return c.getId_Persona().compareTo(this.getId_Persona());
                
            } else if (field.equalsIgnoreCase("titulo")) {
                return c.getTitulo().compareTo(this.getTitulo());
                
            } else if (field.equalsIgnoreCase("especializacion")) {
                return c.getEspecializacion().compareTo(this.getEspecializacion());
                
            } else if (field.equalsIgnoreCase("experiencialaboral")) {
                return c.getExperienciaLaboral().compareTo(this.getExperienciaLaboral());
                
            } else if (field.equalsIgnoreCase("certificaciones")) {
                return c.getCertificaciones().compareTo(this.getCertificaciones());
                
            }
            
        default:
            return 0;
        }
    }
    
    //Criterios para las busquedas
    public static String criterio(Docente docente ,String field) {
        switch (field.toLowerCase()) {
            case "titulo":
                return docente.getTitulo();
            case "especializacion":
                return docente.getEspecializacion();
            case "certificaciones":
                return docente.getCertificaciones();
            
            default:
                throw new IllegalArgumentException("Opcion invalida");
        }
    }
    
    //Para casos con valor Int
    public static Integer criterioEntero(Docente docente, String field) {
        switch (field.toLowerCase()) {
            case "id":
                return docente.getId();
            case "id_persona":
                return docente.getId_Persona();
            case "experiencialaboral":
                return docente.getExperienciaLaboral();
            default:
                throw new IllegalArgumentException("Opcion invalida");
        }
    }
    
    //Print
    @Override
    public String toString() {
        return super.toString();
    }
    
}
