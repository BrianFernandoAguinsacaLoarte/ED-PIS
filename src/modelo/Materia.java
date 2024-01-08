/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario iTC
 */
public class Materia {

    private Integer id;
    private String Codigo;
    private String nombreMateria;
    private String descripcion;

    public Materia() {
    }

    public Materia(Integer id, String nombreMateria, String descripcion) {
        this.id = id;
        this.nombreMateria = nombreMateria;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    //Print
    @Override
    public String toString() {
        return nombreMateria;
    }

    public Boolean comparar(Materia m, String field, Integer type) {

        switch (type) {
            case 1:
                if (field.equalsIgnoreCase("nombreMateria")) {
                    return getNombreMateria().compareTo(m.getNombreMateria()) > 0;
                } else if (field.equalsIgnoreCase("descripcion")) {
                    return getDescripcion().compareTo(m.getDescripcion()) > 0;
                } else if (field.equalsIgnoreCase("codigo")) {
                    return getCodigo().compareTo(m.getCodigo()) > 0;
                }

                break;
            case 0:
                if (field.equalsIgnoreCase("nombreMateria")) {
                    return getNombreMateria().compareTo(m.getNombreMateria()) < 0;
                } else if (field.equalsIgnoreCase("descripcion")) {
                    return getDescripcion().compareTo(m.getDescripcion()) < 0;
                } else if (field.equalsIgnoreCase("codigo")) {
                    return getCodigo().compareTo(m.getCodigo()) < 0;
                }

                break;
            default:
                return null;
        }
        return null;
    }

}
