/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.TDA.listas.LinkedList;
import controlador.dao.DataAccessObject;
import modelo.Matricula;

/**
 *
 * @author Usuario
 */
public class MatriculaController extends DataAccessObject<Matricula> {
    private Matricula matricula = new Matricula();
    private LinkedList<Matricula> matriculas = new LinkedList<>();
    private Integer index = -1;

    public MatriculaController() {
        super (Matricula.class);
    }

    public Matricula getMatricula() {
        if (matricula == null) {
            matricula = new Matricula();
        }
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public LinkedList<Matricula> getMatriculas() {
        if (matriculas.isEmpty()) {
            matriculas = this.listAll();
        }
        return matriculas;
    }

    public void setMatriculas(LinkedList<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    public String generatedCode(){
        StringBuilder code = new StringBuilder();
        Integer lenght = listAll().getSize()+ 1;
        Integer pos = lenght.toString().length();
        for (int i = 0; i < (10-pos); i++) {
            code.append("0");
        }
        code.append(lenght.toString());
        return code.toString();
    }
    
    public Boolean save(){
        matricula.setId(generated_id());
        return save(matricula);
    }
    
    public boolean update(Integer index){
        return update(matricula,index);
    }
    
    
}
