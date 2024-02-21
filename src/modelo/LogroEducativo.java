/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario iTC
 */
public class LogroEducativo {
    
    //Atributos
    private Integer id;
    private String nombre;
    
    
    //Llaves Foraneas
    private Integer id_tipoLogro;
    private Integer id_docente;
    
    //Constructor
    public LogroEducativo() {
    }
    
    //Getter and Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_tipoLogro() {
        return id_tipoLogro;
    }

    public void setId_tipoLogro(Integer id_tipoLogro) {
        this.id_tipoLogro = id_tipoLogro;
    }

    public Integer getId_docente() {
        return id_docente;
    }

    public void setId_docente(Integer id_docente) {
        this.id_docente = id_docente;
    }

    @Override
    public String toString() {
        return getNombre();
    }
    
    
    
    
}
