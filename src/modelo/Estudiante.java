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
    public Integer compareQuickSort(Estudiante c, Integer type, String field) {
    switch (type) {
        case 0:
            if (field.equalsIgnoreCase("colegioanterior")) {
                return this.getColegioAnterior().compareTo(c.getColegioAnterior());
                
            } else if (field.equalsIgnoreCase("id")) {
                return this.getId().compareTo(c.getId());
                
            } else if (field.equalsIgnoreCase("actividadextracurricular")) {
                return this.getActividadExtracurricular().compareTo(c.getActividadExtracurricular());
                
            } else if (field.equalsIgnoreCase("proyectosacademicos")) {
                return this.getProyectosAcademicos().compareTo(c.getProyectosAcademicos());
                
            } else if (field.equalsIgnoreCase("reconocimientos")) {
                return this.getReconocimientos().compareTo(c.getReconocimientos());
                
            }else if (field.equalsIgnoreCase("certificaciones")) {
                return this.getCertificaciones().compareTo(c.getCertificaciones());
            }
            
        case 1:
            if (field.equalsIgnoreCase("colegioanterior")) {
                return c.getColegioAnterior().compareTo(this.getColegioAnterior());
                
            } else if (field.equalsIgnoreCase("id")) {
                return c.getId().compareTo(this.getId());
                
            } else if (field.equalsIgnoreCase("actividadextracurricular")) {
                return c.getActividadExtracurricular().compareTo(this.getActividadExtracurricular());
                
            } else if (field.equalsIgnoreCase("proyectosacademicos")) {
                return c.getProyectosAcademicos().compareTo(this.getProyectosAcademicos());
                
            } else if (field.equalsIgnoreCase("reconocimientos")) {
                return c.getReconocimientos().compareTo(this.getReconocimientos());
                
            }else if (field.equalsIgnoreCase("certificaciones")) {
                return c.getCertificaciones().compareTo(this.getCertificaciones());
            }
            
        default:
            return 0;
        }
    }
    
    //Criterios para las busquedas
    public static String criterio(Estudiante estudiante ,String field) {
        switch (field.toLowerCase()) {
            case "colegioanterior":
                return estudiante.getColegioAnterior();
            case "actividadextracurricular":
                return estudiante.getActividadExtracurricular();
            case "proyectosacademicos":
                return estudiante.getProyectosAcademicos();
            case "reconocimientos":
                return estudiante.getReconocimientos();
            case "certificaciones":
                return estudiante.getCertificaciones();
            default:
                throw new IllegalArgumentException("Opcion invalida");
        }
    }
    
    //Para casos con valor Int
    public static Integer criterioEntero(Estudiante estudiante, String field) {
        switch (field.toLowerCase()) {
            case "id":
                return estudiante.getId();
            case "id_persona":
                return estudiante.getId_Persona();
            default:
                throw new IllegalArgumentException("Opcion invalida");
        }
    }
    
    

    
    
    
}
