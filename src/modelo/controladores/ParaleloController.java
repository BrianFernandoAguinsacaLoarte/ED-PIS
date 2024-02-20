package modelo.controladores;

import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import modelo.Paralelo;

/**
 *
 * @author juanc
 */
public class ParaleloController extends AdaptadorDao<Paralelo> {

    private Paralelo paralelo;
    private LinkedList<Paralelo> lista = new LinkedList<>();
    private Integer index = -1;

    public ParaleloController() {
        super(Paralelo.class);
    }

    public Paralelo getParalelo() {
        if (paralelo == null) {
            paralelo = new Paralelo();
        }
        return paralelo;
    }

    public void setParalelo(Paralelo paralelo) {
        this.paralelo = paralelo;
    }

    public void guardar() {
        try {
            Integer idGenerado = this.guardar(paralelo);
            System.out.println("Paralelo guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar el paralelo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public LinkedList<Paralelo> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<Paralelo> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public LinkedList<Paralelo> getParalelos() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

}
