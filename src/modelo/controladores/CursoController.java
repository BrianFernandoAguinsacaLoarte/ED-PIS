package modelo.controladores;

import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import modelo.Curso;

/**
 *
 * @author juanc
 */
public class CursoController extends AdaptadorDao<Curso> {

    private Curso curso;
    private LinkedList<Curso> lista = new LinkedList<>();
    private Integer index = -1;

    public CursoController() {
        super(Curso.class);
    }

    public Curso getCurso() {
        if (curso == null) {
            curso = new Curso();
        }
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void guardar() {
        try {
            Integer idGenerado = this.guardar(curso);
            System.out.println("Curso guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar el Curso: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public LinkedList<Curso> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<Curso> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public LinkedList<Curso> getCursos() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

}
