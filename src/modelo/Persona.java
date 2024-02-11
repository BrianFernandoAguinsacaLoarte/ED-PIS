/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;


/**
 *
 * @author Usuario iTC
 */
public class Persona {
    
    //Atributos
    private Integer id;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String correo;
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    
    //Llaves foraneas
    private Integer id_genero;
    private Integer id_rol;
    private Integer id_cuenta;
    
    
    
    //Constructor
    
    public Persona(){
    }

    public Persona(Integer id, String cedula, String nombres, String apellidos, String correo, Date fechaNacimiento, String direccion, String telefono, Integer id_genero, Integer id_rol, Integer id_cuenta) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id_genero = id_genero;
        this.id_rol = id_rol;
        this.id_cuenta = id_cuenta;
    }

       

    
    
    //Getter and Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getId_genero() {
        return id_genero;
    }

    public void setId_genero(Integer id_genero) {
        this.id_genero = id_genero;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public Integer getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Integer id_cuenta) {
        this.id_cuenta = id_cuenta;
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
    
    
    
    
    
    //Print
    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }
    
    //Main
    public static void main (String[] args){
        Persona p = new Persona();
        p.setNombres("Brian");
        System.out.println(p.toString());
    }
    
    
    
}
