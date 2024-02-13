/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;



/**
 *
 * @author Usuario iTC
 */
public class Docente extends Persona{
    
    //Atributos
    private Integer experienciaLaboral;
    
 
    
    //Constructores
    public Docente() {
    }

    
    
    //Getter and Setter
    public Integer getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(Integer experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

   
    
    //Print
    @Override
    public String toString() {
        return super.toString();
    }
    
    
    /////
     public Boolean compareTo(Docente c, String field, Integer type) {
     switch (type) {
        case 1:
            if (field.equalsIgnoreCase("nombres")) {
                return getNombres().compareTo(c.getNombres()) < 0;
                
            } else if (field.equalsIgnoreCase("apellidos")) {
                return getApellidos().compareTo(c.getApellidos()) < 0;
                
             } else if (field.equalsIgnoreCase("correo")) {
                return getCorreo().compareTo(c.getCorreo()) < 0;
                
            } else if (field.equalsIgnoreCase("fechanacimiento")) {
                return getFechaNacimiento().compareTo(c.getFechaNacimiento()) < 0;
                
             } else if (field.equalsIgnoreCase("id_genero")) {
                return getId_genero().compareTo(c.getId_genero()) < 0;
                
             } else if (field.equalsIgnoreCase("id_rol")) {
                return getId_rol().compareTo(c.getId_rol()) < 0;
                
            } else if (field.equalsIgnoreCase("cedula")) {
                return getCedula().compareTo(c.getCedula()) < 0;
                
            } else if (field.equalsIgnoreCase("direccion")) {
                return getDireccion().compareTo(c.getDireccion()) < 0;
                
            } else if (field.equalsIgnoreCase("telefono")) {
                return getTelefono().compareTo(c.getTelefono()) < 0;
                
            } else if (field.equalsIgnoreCase("experiencialaboral")) {
                return getExperienciaLaboral().compareTo(c.getExperienciaLaboral()) < 0;
                
            } 
            case 0:
            if (field.equalsIgnoreCase("nombres")) {
                return getNombres().compareTo(c.getNombres()) > 0;
                
            } else if (field.equalsIgnoreCase("apellidos")) {
                return getApellidos().compareTo(c.getApellidos()) > 0;
                
             } else if (field.equalsIgnoreCase("correo")) {
                return getCorreo().compareTo(c.getCorreo()) > 0;
                
            } else if (field.equalsIgnoreCase("fechanacimiento")) {
                return getFechaNacimiento().compareTo(c.getFechaNacimiento()) > 0;
                
             } else if (field.equalsIgnoreCase("id_genero")) {
                return getId_genero().compareTo(c.getId_genero()) > 0;
                
             } else if (field.equalsIgnoreCase("id_rol")) {
                return getId_rol().compareTo(c.getId_rol()) > 0;
                
            } else if (field.equalsIgnoreCase("cedula")) {
                return getCedula().compareTo(c.getCedula()) > 0;
                
            } else if (field.equalsIgnoreCase("direccion")) {
                return getDireccion().compareTo(c.getDireccion()) > 0;
                
            } else if (field.equalsIgnoreCase("telefono")) {
                return getTelefono().compareTo(c.getTelefono()) > 0;
                
            } else if (field.equalsIgnoreCase("experiencialaboral")) {
                return getExperienciaLaboral().compareTo(c.getExperienciaLaboral()) > 0;
                
            } 
            default:
                return null;
        }
     }
    
}
