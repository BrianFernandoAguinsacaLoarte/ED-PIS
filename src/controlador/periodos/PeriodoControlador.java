/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.periodos;


import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import controlador.dao.DataAccessObject;
import controlador.util.Utilidades;
import java.lang.reflect.Field;
import modelo.PeriodoAcademico;

/**
 *
 * @author Usuario 1
 */
public class PeriodoControlador extends DataAccessObject<PeriodoAcademico> {

    //Objetos
    private PeriodoAcademico pa = new PeriodoAcademico();
    private LinkedList<PeriodoAcademico> pas = new LinkedList<>();
    private Integer index = -1; 
    
    //Constructor
    public PeriodoControlador() {
        super(PeriodoAcademico.class);
    }
    
    //Métodos
    public boolean save(){
        pa.setId(generated_id());//BDD Esto desaparece
        return save(pa);
    }
    
    public boolean update(Integer index){
        return update(pa,index);
    }
    
    //Getter and Setter
    public PeriodoAcademico getPeriodoAcademico() {
        
        if(pa == null){
            pa = new PeriodoAcademico();
        }
        return pa;
    }

    public void setPeriodoAcademico(PeriodoAcademico pa) {
        this.pa = pa;
    }

    public LinkedList<PeriodoAcademico> getPeriodosAcademicos() {

        if(pas.isEmpty()){
            pas = listAll();
        }
        return pas;
    }

    public void setPeriodosAcademicos(LinkedList<PeriodoAcademico> pas) {
        this.pas = pas;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    public LinkedList<PeriodoAcademico> ordenar(Integer type, String field, LinkedList<PeriodoAcademico> lista) throws VacioExcepcion, Exception {

        getPeriodoAcademico();
        Integer n = lista.getSize();
        PeriodoAcademico[] m = lista.toArray();
        Field faux = Utilidades.getField(PeriodoAcademico.class, field);
        if (faux != null) {
            //Double Integer
            // < > numericos
            //String compareTo
            for (int i = 0; i < n - 1; i++) {
                int k = i;
                PeriodoAcademico t = m[i];
                for (int j = i + 1; j < n; j++) {
                    //condicion por objetos
                    PeriodoAcademico mj = m[j];
                    if (mj.comparar(t, field, type)) {
                        t = mj;
                        k = j;
                    }
                }
                m[k] = m[i];
                m[i] = t;
            }
            lista = lista.toList(m);
        }else{
            throw new Exception("No existe ese criterio de busqueda");
        }return lista;
    }

    
//    public LinkedList<Llanta> buscar(LinkedList<Llanta> lista, String text) throws Exception{
//        
//        LinkedList<Llanta> lo = this.ordenar(0, "nombre", lista); //ver video de youtbe 
//        Llanta[] m = lo.toArray();
//        LinkedList<Llanta> result = new LinkedList<>();
//        for (int i = 0; i < lo.getSize(); i++) {
//            //if(m[i].getNombre().toLowerCase().startsWith(text.toLowerCase())){
//                result.add(m[i]);
//            //}
//        }
//        return result;
//    }
    
     public LinkedList<PeriodoAcademico> buscarPrecioMenores(LinkedList<PeriodoAcademico> lista, String text, String semestre) throws Exception{
        
        LinkedList<PeriodoAcademico> lo = this.ordenar(0, text, lista); //ver video de youtbe 
        PeriodoAcademico[] m = lo.toArray();
        LinkedList<PeriodoAcademico> result = new LinkedList<>();
        for (int i = 0; i < lo.getSize(); i++) {
            System.out.println(m[i].getSemestre()+ " < " + semestre);
            if(m[i].getSemestre().compareTo(semestre) <= 0){
                result.add(m[i]);
            }
        }
        return result;
    }
}
