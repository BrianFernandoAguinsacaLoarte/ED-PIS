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
    private String actividadExtracurricular;
    private String proyectosAcademicos;
    private String reconocimientos;
    private String Certificaciones;
    
    
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

    public String getActividadExtracurricular() {
        return actividadExtracurricular;
    }

    public void setActividadExtracurricular(String actividadExtracurricular) {
        this.actividadExtracurricular = actividadExtracurricular;
    }

    public String getProyectosAcademicos() {
        return proyectosAcademicos;
    }

    public void setProyectosAcademicos(String proyectosAcademicos) {
        this.proyectosAcademicos = proyectosAcademicos;
    }

    public String getReconocimientos() {
        return reconocimientos;
    }

    public void setReconocimientos(String reconocimientos) {
        this.reconocimientos = reconocimientos;
    }

    public String getCertificaciones() {
        return Certificaciones;
    }

    public void setCertificaciones(String Certificaciones) {
        this.Certificaciones = Certificaciones;
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
    
    //Metodo Compare
    public Integer compareQuickSort(Persona c, Integer type, String field) {
    switch (type) {
        case 0:
            if (field.equalsIgnoreCase("nombres")) {
                return this.getNombres().compareTo(c.getNombres());
            } else if (field.equalsIgnoreCase("id")) {
                return this.getId().compareTo(c.getId());
            } else if (field.equalsIgnoreCase("apellidos")) {
                return this.getApellidos().compareTo(c.getApellidos());
            } else if (field.equalsIgnoreCase("direccion")) {
                return this.getDireccion().compareTo(c.getDireccion());
            } else if (field.equalsIgnoreCase("rol")) {
                return this.getRol().compareTo(c.getRol());
            }else if (field.equalsIgnoreCase("edad")) {
                return this.getEdad().compareTo(c.getEdad());
            }else if (field.equalsIgnoreCase("genero")) {
                return this.getGenero().compareTo(c.getGenero());
            }else if (field.equalsIgnoreCase("correo")) {
                return this.getCorreo().compareTo(c.getCorreo());
            }else if (field.equalsIgnoreCase("cedula")) {
                return this.getCedula().compareTo(c.getCedula());
            }else if (field.equalsIgnoreCase("telefono")) {
                return this.getTelefono().compareTo(c.getTelefono());
            }
        case 1:
            if (field.equalsIgnoreCase("nombres")) {
                return c.getNombres().compareTo(this.getNombres());
            } else if (field.equalsIgnoreCase("id")) {
                return c.getId().compareTo(this.getId());
            } else if (field.equalsIgnoreCase("apellidos")) {
                return c.getApellidos().compareTo(this.getApellidos());
            } else if (field.equalsIgnoreCase("direccion")) {
                return c.getDireccion().compareTo(this.getDireccion());
            } else if (field.equalsIgnoreCase("rol")) {
                return c.getRol().compareTo(this.getRol());
            }else if (field.equalsIgnoreCase("edad")) {
                return c.getEdad().compareTo(this.getEdad());
            }else if (field.equalsIgnoreCase("genero")) {
                return c.getGenero().compareTo(this.getGenero());
            }else if (field.equalsIgnoreCase("correo")) {
                return c.getCorreo().compareTo(this.getCorreo());
            }else if (field.equalsIgnoreCase("cedula")) {
                return c.getCedula().compareTo(this.getCedula());
            }else if (field.equalsIgnoreCase("telefono")) {
                return c.getTelefono().compareTo(this.getTelefono());
            }
        default:
            throw new AssertionError();
        }
    }
    
    //Criterios para las busquedas
    public static String criterio(Persona persona, String field) {
        switch (field.toLowerCase()) {
            case "nombres":
                return persona.getNombres();
            case "apellidos":
                return persona.getApellidos();
            case "direccion":
                return persona.getDireccion();
            case "correo":
                return persona.getCorreo();
            case "cedula":
                return persona.getCedula();
            case "telefono":
                return persona.getTelefono();
            default:
                throw new IllegalArgumentException("Opcion invalida");
        }
    }
    
    //Para casos con valor Int
    public static Integer criterioEntero(Persona persona, String field) {
        switch (field.toLowerCase()) {
            case "id":
                return persona.getId();
            case "edad":
                return persona.getEdad();
            default:
                throw new IllegalArgumentException("Opcion invalida");
        }
    }
    

    
    
    
}
