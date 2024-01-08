/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Materia;

import controlador.TDA.listas.LinkedList;
import modelo.Materia;
import controlador.dao.DataAccessObject;
import controlador.util.Utilidades;
import java.lang.reflect.Field;
import controlador.Excepcion.VacioExcepcion;
/**
 *
 * @author juanc
 */
public class MateriaControlador extends DataAccessObject<Materia>{
    
    private Materia materia = new Materia();
    private LinkedList<Materia> lista = new LinkedList<>();
    private Integer index = -1;

    public MateriaControlador() {
        super(Materia.class);
    }

    public Materia getMateria() {
        if (materia == null) {
            materia = new Materia();
        }
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Boolean saved() {
        materia.setId(generated_id());
        return save(materia);
    }

    public String generatedCode() {
        StringBuilder code = new StringBuilder();
        Integer length = listAll().getSize() + 1;
        Integer pos = Integer.toString(length).length();
        for (int i = 0; i < (10 - pos); i++) {
            code.append("0");
        }
        code.append(length.toString());
        return code.toString();
    }

    public LinkedList<Materia> getLista() {
        if (lista.isEmpty()) {
            lista = listAll();
        }
        return lista;

    }

    public Boolean update1(Integer i) {
        return update(materia, i);
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(LinkedList<Materia> lista) {
        this.lista = lista;
    }

    /**
     * @return the index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    public LinkedList<Materia> getMaterias() {
        if (lista.isEmpty()) {
            lista = listAll();
        }
        return lista;
    }
    
    public LinkedList<Materia> ordenar(Integer type, String field, LinkedList<Materia> lista) throws VacioExcepcion, Exception {

        getMateria();
        Integer n = lista.getSize();
        Materia[] m = lista.toArray();
        Field faux = Utilidades.getField(Materia.class, field);
        if (faux != null) {
     
            for (int i = 0; i < n - 1; i++) {
                int k = i;
                Materia t = m[i];
                for (int j = i + 1; j < n; j++) {
                    //condicion por objetos
                    Materia mj = m[j];
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
    
    
}
