/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.persona;
import controlador.dao.DataAccessObject;
import modelo.Docente;
import controlador.TDA.listas.LinkedList;

/**
 *
 * @author Usuario iTC
 */
public class DocenteController extends DataAccessObject<Docente>  {
    
    //Objectos 
    private Docente docente = new Docente();
    private LinkedList<Docente> docentes = new LinkedList<>();
    
    //Constructor
    public DocenteController() {
        super(Docente.class);
    }
    
    //Métodos 
    public boolean save(){
        docente.setId(generated_id());//BDD Esto desaparece
        return save(docente);
    }
    
    public boolean update(Integer index){
        return update(docente,index);
    }
    
    //Getter and Setter
    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public LinkedList<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(LinkedList<Docente> docentes) {
        this.docentes = docentes;
    }
    
    
    
}
