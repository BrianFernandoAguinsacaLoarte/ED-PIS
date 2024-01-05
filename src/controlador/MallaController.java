/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import controlador.dao.DataAccessObject;
import controlador.util.Utilidades;
import java.lang.reflect.Field;
import modelo.Malla;

/**
 *
 * @author Usuario 1
 */
public class MallaController extends DataAccessObject<Malla>{
    
    //Objetos
    private Malla pa = new Malla();
    private LinkedList<Malla> pas = new LinkedList<>();
    private Integer index = -1; 
    
    //Constructor
    public MallaController(){
        super(Malla.class);
    }
    
    //Métodos
    public boolean save(){
        pa.setId(generated_id());
        return save(pa);
    }
    
    public boolean update(Integer index){
        return update(pa,index);
    }
    
    //Getter and Setter
    public Malla getMalla() {
        
        if(pa == null){
            pa = new Malla();
        }
        return pa;
    }

    public void setMalla(Malla pa) {
        this.pa = pa;
    }

    public LinkedList<Malla> getMallas() {

        if(pas.isEmpty()){
            pas = listAll();
        }
        return pas;
    }

    public void setMallas(LinkedList<Malla> pas) {
        this.pas = pas;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
//    public LinkedList<Malla> ordenar(Integer type, String field, LinkedList<Malla> lista) throws VacioExcepcion, Exception {
//
//        getPeriodoAcademico();
//        Integer n = lista.getSize();
//        PeriodoAcademico[] m = lista.toArray();
//        Field faux = Utilidades.getField(PeriodoAcademico.class, field);
//        if (faux != null) {
//            //Double Integer
//            // < > numericos
//            //String compareTo
//            for (int i = 0; i < n - 1; i++) {
//                int k = i;
//                PeriodoAcademico t = m[i];
//                for (int j = i + 1; j < n; j++) {
//                    //condicion por objetos
//                    PeriodoAcademico mj = m[j];
//                    if (mj.comparar(t, field, type)) {
//                        t = mj;
//                        k = j;
//                    }
//                }
//                m[k] = m[i];
//                m[i] = t;
//            }
//            lista = lista.toList(m);
//        }else{
//            throw new Exception("No existe ese criterio de busqueda");
//        }return lista;
//    }
//    
//     public LinkedList<PeriodoAcademico> buscarPrecioMenores(LinkedList<PeriodoAcademico> lista, String text, String semestre) throws Exception{
//        
//        LinkedList<PeriodoAcademico> lo = this.ordenar(0, text, lista); //ver video de youtbe 
//        PeriodoAcademico[] m = lo.toArray();
//        LinkedList<PeriodoAcademico> result = new LinkedList<>();
//        for (int i = 0; i < lo.getSize(); i++) {
//            System.out.println(m[i].getSemestre()+ " < " + semestre);
//            if(m[i].getSemestre().compareTo(semestre) <= 0){
//                result.add(m[i]);
//            }
//        }
//        return result;
//    }
}
