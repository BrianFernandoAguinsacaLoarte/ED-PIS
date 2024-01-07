/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.persona;

import controlador.Excepcion.VacioExcepcion;
import controlador.dao.DataAccessObject;
import modelo.Estudiante;
import controlador.TDA.listas.LinkedList;
import controlador.util.Utilidades;
import java.lang.reflect.Field;
import modelo.Persona;



/**
 *
 * @author Usuario iTC
 */
public class EstudianteController extends DataAccessObject<Estudiante>{
    
    //Objetos
    private Estudiante estudiante = new Estudiante();
    private LinkedList<Estudiante> estudiantes = new LinkedList<>();
    private Integer index = -1; 
    
    //Constructor
    public EstudianteController() {
        super(Estudiante.class);
    }
    
    //Métodos
    public boolean save(){
        estudiante.setId(generated_id());//BDD Esto desaparece
        return save(estudiante);
    }
    
    public boolean update(Integer index){
        return update(estudiante,index);
    }
    
    //Getter and Setter
    public Estudiante getEstudiante() {
        
        if(estudiante == null){
            estudiante = new Estudiante();
        }
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LinkedList<Estudiante> getEstudiantes() {

        if(estudiantes.isEmpty()){
            estudiantes = listAll();
        }
        return estudiantes;
    }

    public void setEstudiantes(LinkedList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    //ORDENAMIENTO QUICKSORT
    public LinkedList<Estudiante> ordenarQuickSort(LinkedList<Estudiante> lista, Integer type, String field) throws VacioExcepcion {
        int[] contador = {0};
        lista = quickSort(lista, 0, lista.getSize() - 1, type, field, contador);
        System.out.println("Iteraciones totales realizadas: " + contador[0]);
        return lista;
    }

    public LinkedList<Estudiante> quickSort(LinkedList<Estudiante> lista, int izq, int der, Integer type, String field, int[] contador) throws VacioExcepcion {
        Estudiante[] m = lista.toArray(); // Transformo la lista a arreglo
        Field faux = Utilidades.getField(Estudiante.class, field);

        if (faux != null && izq < der) {
            int i = izq;
            int j = der;

            // Obtengo el pivote
            Estudiante pivote = m[(izq + der) / 2];

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
                    Estudiante temp = m[i];
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
    public LinkedList<Estudiante> busquedaBinaria(LinkedList<Estudiante> lista, String text, String field) throws VacioExcepcion {
        LinkedList<Estudiante> estudiantes = new LinkedList<>(); //Nueva Lista
        Estudiante[] arregloOrdenado = ordenarQuickSort(lista, 0, field).toArray(); //Ordenando con QuickSort ya que es el método mas rapido a diferencia del MergeSort

        int inicio = 0;
        int fin = arregloOrdenado.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Estudiante b = arregloOrdenado[medio];
            String valor = Estudiante.criterio(b, field).toLowerCase();

            if (valor.contains(text.toLowerCase())) {
                estudiantes.add(b);
            }
            if (valor.compareTo(text.toLowerCase()) < 0) {
                inicio = medio + 1; // El elemento está en la mitad derecha
            } else {
                fin = medio - 1; // El elemento está en la mitad izquierda
            }

        }

        return estudiantes;
    }
    
    public LinkedList<Estudiante> busquedaBinariaEntero(LinkedList<Estudiante> lista, Integer text, String field) throws VacioExcepcion {
        LinkedList<Estudiante> estudiantes = new LinkedList<>(); // Nueva Lista
        Estudiante[] arregloOrdenado = ordenarQuickSort(lista, 0, field).toArray(); // Ordenando con QuickSort ya que es el método más rápido a diferencia del MergeSort

        int inicio = 0;
        int fin = arregloOrdenado.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Estudiante b = arregloOrdenado[medio];
            Integer valor = Estudiante.criterioEntero(b, field);

            if (valor.equals(text)) {
                estudiantes.add(b);
            }
            if (valor.compareTo(text) < 0) {
                inicio = medio + 1; // El elemento está en la mitad derecha
            } else {
                fin = medio - 1; // El elemento está en la mitad izquierda
            }
        }

        return estudiantes;
    }
    
    //Busquedas Lineales
    public LinkedList<Estudiante> busquedaLinealBinaria(LinkedList<Estudiante> lista, String text, String field) throws VacioExcepcion {
        LinkedList<Estudiante> estudiantes = new LinkedList<>(); // Nueva Lista
        Estudiante[] arregloOrdenado = ordenarQuickSort(lista, 0, field).toArray(); // Ordenando con QuickSort

        int inicio = 0;
        int fin = arregloOrdenado.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Estudiante b = arregloOrdenado[medio];
            String valor = Estudiante.criterio(b, field).toLowerCase();

            if (valor.contains(text.toLowerCase())) {
                estudiantes.add(b);

               
                int izquierda = medio - 1;
                while (izquierda >= 0 && Estudiante.criterio(arregloOrdenado[izquierda], field).toLowerCase().contains(text.toLowerCase())) {
                    estudiantes.add(arregloOrdenado[izquierda]);
                    izquierda--;
                }

               
                int derecha = medio + 1;
                while (derecha < arregloOrdenado.length && Estudiante.criterio(arregloOrdenado[derecha], field).toLowerCase().contains(text.toLowerCase())) {
                    estudiantes.add(arregloOrdenado[derecha]);
                    derecha++;
                }

                return estudiantes;  // Se ha encontrado una coincidencia, devolver la lista actualizada
            }

            if (valor.compareTo(text.toLowerCase()) < 0) {
                inicio = medio + 1; // El elemento está en la mitad derecha
            } else {
                fin = medio - 1; // El elemento está en la mitad izquierda
            }
        }

        return estudiantes;  // Si no se encuentra ninguna coincidencia
    }
    
    public LinkedList<Estudiante> busquedaLinealBinariaEntero(LinkedList<Estudiante> lista, Integer text, String field) throws VacioExcepcion {
        LinkedList<Estudiante> estudiantes = new LinkedList<>(); // Nueva Lista
        Estudiante[] arregloOrdenado = ordenarQuickSort(lista, 0, field).toArray(); // Ordenando con QuickSort

        int inicio = 0;
        int fin = arregloOrdenado.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Estudiante b = arregloOrdenado[medio];
            Integer valor = Estudiante.criterioEntero(b, field);

            if (valor.equals(text)) {
                estudiantes.add(b);

               
                int izquierda = medio - 1;
                while (izquierda >= 0 && Estudiante.criterioEntero(arregloOrdenado[izquierda], field).equals(text)) {
                    estudiantes.add(arregloOrdenado[izquierda]);
                    izquierda--;
                }

                
                int derecha = medio + 1;
                while (derecha < arregloOrdenado.length && Estudiante.criterioEntero(arregloOrdenado[derecha], field).equals(text)) {
                    estudiantes.add(arregloOrdenado[derecha]);
                    derecha++;
                }

                return estudiantes;  // Se ha encontrado una coincidencia, devolver la lista actualizada
            }

            if (valor.compareTo(text) < 0) {
                inicio = medio + 1; // El elemento está en la mitad derecha
            } else {
                fin = medio - 1; // El elemento está en la mitad izquierda
            }
        }

        return estudiantes;  // Si no se encuentra ninguna coincidencia
    }
    
}
