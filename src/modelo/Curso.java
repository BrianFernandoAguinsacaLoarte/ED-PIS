/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo.controladores.CicloController;
import modelo.controladores.CursoController;
import modelo.controladores.ParaleloController;

/**
 *
 * @author juanc
 */
public class Curso {
    
    private Integer id;
    
    //Llaves foraneas
    private Integer id_ciclo;
    private Integer id_paralelo;

    CursoController cursoControlador = new CursoController();
    CicloController cicloControlador = new CicloController();
    ParaleloController paraleloControlador = new ParaleloController();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_ciclo() {
        return id_ciclo;
    }

    public void setId_ciclo(Integer id_ciclo) {
        this.id_ciclo = id_ciclo;
    }

    public Integer getId_paralelo() {
        return id_paralelo;
    }

    public void setId_paralelo(Integer id_paralelo) {
        this.id_paralelo = id_paralelo;
    }
    
     @Override
    public String toString() {
        String nombreParaleloCiclo = "";

        Curso curso = cursoControlador.obtener(this.id);
        if (curso != null) {
            Paralelo paralelo = paraleloControlador.obtener(curso.getId_paralelo());
            Ciclo ciclo = cicloControlador.obtener(curso.getId_ciclo());
            if (paralelo != null && ciclo != null) {
                nombreParaleloCiclo = ciclo.getNombre() + " - " + paralelo.getNombre();
            }
        }
        
        return nombreParaleloCiclo;

    }
    
}
