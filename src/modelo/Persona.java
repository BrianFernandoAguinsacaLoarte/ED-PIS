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
public class Persona {
    
    //Atributos
    private Integer id;
    private String nombres;
    private String apellidos;
    private String correo;
    private Integer edad;
    private Genero genero;
    private Rol rol;
    private String direccion;
    private String telefono;
    private String cedula;
    
    //Constructor
    
    public Persona(){
    }
    
    public Persona(Integer id, String nombres, String apellidos,String correo, Integer edad, Genero genero, Rol rol, String direccion, String telefono, String cedula) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.edad = edad;
        this.genero = genero;
        this.rol = rol;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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
    
    //Metodo Comparar para el QuickSort
    public Integer compareQuickSort(Persona c, Integer type, String field) {
    switch (type) {
        case 0:
            if (field.equalsIgnoreCase("id")) {
                return this.getId().compareTo(c.getId());
                
            } else if (field.equalsIgnoreCase("nombres")) {
                return this.getNombres().compareTo(c.getNombres());
                
            } else if (field.equalsIgnoreCase("apellidos")) {
                return this.getApellidos().compareTo(c.getApellidos());
                
            } else if (field.equalsIgnoreCase("correo")) {
                return this.getCorreo().compareTo(c.getCorreo());
                
            } else if (field.equalsIgnoreCase("edad")) {
                return this.getEdad().compareTo(c.getEdad());
                
            }else if (field.equalsIgnoreCase("genero")) {
                return this.getGenero().compareTo(c.getGenero());
                
            }else if (field.equalsIgnoreCase("rol")) {
                return this.getRol().compareTo(c.getRol());
                
            }else if (field.equalsIgnoreCase("direccion")) {
                return this.getDireccion().compareTo(c.getDireccion());
                
            }else if (field.equalsIgnoreCase("telefono")) {
                return this.getTelefono().compareTo(c.getTelefono());
                
            }else if (field.equalsIgnoreCase("cedula")) {
                return this.getCedula().compareTo(c.getCedula());
            }
        case 1:
            if (field.equalsIgnoreCase("id")) {
                return c.getId().compareTo(this.getId());
                
            } else if (field.equalsIgnoreCase("nombres")) {
                return c.getNombres().compareTo(this.getNombres());
                
            } else if (field.equalsIgnoreCase("apellidos")) {
                return c.getApellidos().compareTo(this.getApellidos());
                
            } else if (field.equalsIgnoreCase("correo")) {
                return c.getCorreo().compareTo(this.getCorreo());
                
            } else if (field.equalsIgnoreCase("edad")) {
                return c.getEdad().compareTo(this.getEdad());
                
            }else if (field.equalsIgnoreCase("genero")) {
                return c.getGenero().compareTo(this.getGenero());
                
            }else if (field.equalsIgnoreCase("rol")) {
                return c.getRol().compareTo(this.getRol());
                
            }else if (field.equalsIgnoreCase("direccion")) {
                return c.getDireccion().compareTo(this.getDireccion());
                
            }else if (field.equalsIgnoreCase("telefono")) {
                return c.getTelefono().compareTo(this.getTelefono());
                
            }else if (field.equalsIgnoreCase("cedula")) {
                return c.getCedula().compareTo(this.getCedula());
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
            case "correo":
                return persona.getCorreo();
//            case "genero":
//                return persona.getGenero();
//            case "rol":
//                return persona.getRol();
            case "direccion":
                return persona.getDireccion();
            case "telefono":
                return persona.getTelefono();
            case "cedula":
                return persona.getCedula();
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
