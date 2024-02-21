/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.Excepcion.VacioExcepcion;
import java.util.Date;
import java.sql.Blob;

/**
 *
 * @author Usuario iTC
 */
public class Estudiante extends Persona {

    //Atributos
    private Blob tituloBachiller;
    private String extensionTituloBachiller;

    public Blob getTituloBachiller() {
        return tituloBachiller;
    }

    public void setTituloBachiller(Blob tituloBachiller) {
        this.tituloBachiller = tituloBachiller;
    }

    public String getExtensionTituloBachiller() {
        return extensionTituloBachiller;
    }

    public void setExtensionTituloBachiller(String extensionTituloBachiller) {
        this.extensionTituloBachiller = extensionTituloBachiller;
    }

    @Override
    public String toString() {
        return getNombres() + " " + getApellidos();
    }

}
