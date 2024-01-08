/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.persona;
import controlador.Excepcion.VacioExcepcion;
import controlador.dao.DataAccessObject;
import modelo.Docente;
import controlador.TDA.listas.LinkedList;
import controlador.util.Utilidades;
import java.lang.reflect.Field;
import modelo.Persona;

/**
 *
 * @author Usuario iTC
 */
public class DocenteController extends DataAccessObject<Docente>  {
    
    //Objectos 
    private Docente docente = new Docente();
    private LinkedList<Docente> docentes = new LinkedList<>();
    private Integer index = -1; 
    
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
    
     public String obtenerNombre(Integer idPersona) throws VacioExcepcion {
        PersonaController pc = new PersonaController();

        for (int i = 0; i < pc.getPersonas().getSize(); i++) {
            Persona persona = pc.getPersonas().get(i);
            if (persona.getId().equals(idPersona)) {
                 return persona.getNombres() + " " + persona.getApellidos();
            }
        }
        return "";
    }
     
    
    //Getter and Setter
    public Docente getDocente() {
        
        if(docente == null){
            docente = new Docente();
        }
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public LinkedList<Docente> getDocentes() {
        
        if(docentes.isEmpty()){
            docentes = listAll();
        }
        return docentes;
    }

    public void setDocentes(LinkedList<Docente> docentes) {
        this.docentes = docentes;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
     //ORDENAMIENTO QUICKSORT
    public LinkedList<Docente> ordenarQuickSort(LinkedList<Docente> lista, Integer type, String field) throws VacioExcepcion {
        int[] contador = {0};
        lista = quickSort(lista, 0, lista.getSize() - 1, type, field, contador);
        System.out.println("Iteraciones totales realizadas: " + contador[0]);
        return lista;
    }

    public LinkedList<Docente> quickSort(LinkedList<Docente> lista, int izq, int der, Integer type, String field, int[] contador) throws VacioExcepcion {
        Docente[] m = lista.toArray(); // Transformo la lista a arreglo
        Field faux = Utilidades.getField(Docente.class, field);

        if (faux != null && izq < der) {
            int i = izq;
            int j = der;

            // Obtengo el pivote
            Docente pivote = m[(izq + der) / 2];

            // Realizo el particionamiento
            while (i <= j) {
                while (m[i].compareQuickSort(pivote, type, field) < 0) {
                    i++;
                    contador[0]++;
                }

                while (m[j].compareQuickSort(pivote, type, field) > 0) {
                    j--;
                    contador[0]++;
                }

                if (i <= j) {
                    // Intercambia los elementos
                    Docente temp = m[i];
                    m[i] = m[j];
                    m[j] = temp;
                    i++;
                    j--;
                }
            }
            lista = lista.toList(m);
            quickSort(lista, izq, j, type, field, contador); // Ordeno la parte izquierda
            quickSort(lista, i, der, type, field, contador); // Ordeno la parte derecha
        }
        return lista;
    }
    
     //Busqueda Binaria
    public LinkedList<Docente> busquedaBinaria(LinkedList<Docente> lista, String text, String field) throws VacioExcepcion {
        LinkedList<Docente> docentes = new LinkedList<>(); //Nueva Lista
        Docente[] arregloOrdenado = ordenarQuickSort(lista, 0, field).toArray(); //Ordenando con QuickSort ya que es el método mas rapido a diferencia del MergeSort

        int inicio = 0;
        int fin = arregloOrdenado.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Docente b = arregloOrdenado[medio];
            String valor = Docente.criterio(b, field).toLowerCase();

            if (valor.contains(text.toLowerCase())) {
                docentes.add(b);
            }
            if (valor.compareTo(text.toLowerCase()) < 0) {
                inicio = medio + 1; // El elemento está en la mitad derecha
            } else {
                fin = medio - 1; // El elemento está en la mitad izquierda
            }

        }

        return docentes;
    }
    
    public LinkedList<Docente> busquedaBinariaEntero(LinkedList<Docente> lista, Integer text, String field) throws VacioExcepcion {
        LinkedList<Docente> docentes = new LinkedList<>(); // Nueva Lista
        Docente[] arregloOrdenado = ordenarQuickSort(lista, 0, field).toArray(); // Ordenando con QuickSort ya que es el método más rápido a diferencia del MergeSort

        int inicio = 0;
        int fin = arregloOrdenado.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Docente b = arregloOrdenado[medio];
            Integer valor = Docente.criterioEntero(b, field);

            if (valor.equals(text)) {
                docentes.add(b);
            }
            if (valor.compareTo(text) < 0) {
                inicio = medio + 1; // El elemento está en la mitad derecha
            } else {
                fin = medio - 1; // El elemento está en la mitad izquierda
            }
        }

        return docentes;
    }
    
    //Busquedas Lineales
    public LinkedList<Docente> busquedaLinealBinaria(LinkedList<Docente> lista, String text, String field) throws VacioExcepcion {
        LinkedList<Docente> docentes = new LinkedList<>(); // Nueva Lista
        Docente[] arregloOrdenado = ordenarQuickSort(lista, 0, field).toArray(); // Ordenando con QuickSort

        int inicio = 0;
        int fin = arregloOrdenado.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Docente b = arregloOrdenado[medio];
            String valor = Docente.criterio(b, field).toLowerCase();

            if (valor.contains(text.toLowerCase())) {
                docentes.add(b);

               
                int izquierda = medio - 1;
                while (izquierda >= 0 && Docente.criterio(arregloOrdenado[izquierda], field).toLowerCase().contains(text.toLowerCase())) {
                    docentes.add(arregloOrdenado[izquierda]);
                    izquierda--;
                }

               
                int derecha = medio + 1;
                while (derecha < arregloOrdenado.length && Docente.criterio(arregloOrdenado[derecha], field).toLowerCase().contains(text.toLowerCase())) {
                    docentes.add(arregloOrdenado[derecha]);
                    derecha++;
                }

                return docentes;  // Se ha encontrado una coincidencia, devolver la lista actualizada
            }

            if (valor.compareTo(text.toLowerCase()) < 0) {
                inicio = medio + 1; // El elemento está en la mitad derecha
            } else {
                fin = medio - 1; // El elemento está en la mitad izquierda
            }
        }

        return docentes;  // Si no se encuentra ninguna coincidencia
    }
    
    public LinkedList<Docente> busquedaLinealBinariaEntero(LinkedList<Docente> lista, Integer text, String field) throws VacioExcepcion {
        LinkedList<Docente> docentes = new LinkedList<>(); // Nueva Lista
        Docente[] arregloOrdenado = ordenarQuickSort(lista, 0, field).toArray(); // Ordenando con QuickSort

        int inicio = 0;
        int fin = arregloOrdenado.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Docente b = arregloOrdenado[medio];
            Integer valor = Docente.criterioEntero(b, field);

            if (valor.equals(text)) {
                docentes.add(b);

               
                int izquierda = medio - 1;
                while (izquierda >= 0 && Docente.criterioEntero(arregloOrdenado[izquierda], field).equals(text)) {
                    docentes.add(arregloOrdenado[izquierda]);
                    izquierda--;
                }

                
                int derecha = medio + 1;
                while (derecha < arregloOrdenado.length && Docente.criterioEntero(arregloOrdenado[derecha], field).equals(text)) {
                    docentes.add(arregloOrdenado[derecha]);
                    derecha++;
                }

                return docentes;  // Se ha encontrado una coincidencia, devolver la lista actualizada
            }

            if (valor.compareTo(text) < 0) {
                inicio = medio + 1; // El elemento está en la mitad derecha
            } else {
                fin = medio - 1; // El elemento está en la mitad izquierda
            }
        }

        return docentes;  // Si no se encuentra ninguna coincidencia
    }
    
    
    
}
