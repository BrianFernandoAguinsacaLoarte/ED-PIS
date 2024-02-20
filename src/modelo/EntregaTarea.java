/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

//import com.mysql.cj.jdbc.Blob;
import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author juanc
 */
public class EntregaTarea {

    private Integer id;
    private String nombreTarea;
    private String estado;
    private Date fechaEntrega;
    private Double calificacion;
    private String texto;
    private String codigo;
    private Blob archivo;
    private String extensionArchivo;

    //Llaves foraneas
    private Integer idCrearTarea;
    private Integer idMatriculaCursoMateria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Blob getArchivo() {
        return archivo;
    }

    public void setArchivo(Blob archivo) {
        this.archivo = archivo;
    }

    public String getExtensionArchivo() {
        return extensionArchivo;
    }

    public void setExtensionArchivo(String extensionArchivo) {
        this.extensionArchivo = extensionArchivo;
    }

    public Integer getIdCrearTarea() {
        return idCrearTarea;
    }

    public void setIdCrearTarea(Integer idCrearTarea) {
        this.idCrearTarea = idCrearTarea;
    }

    public Integer getIdMatriculaCursoMateria() {
        return idMatriculaCursoMateria;
    }

    public void setIdMatriculaCursoMateria(Integer idMatriculaCursoMateria) {
        this.idMatriculaCursoMateria = idMatriculaCursoMateria;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    @Override
    public String toString() {
        return nombreTarea ;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
