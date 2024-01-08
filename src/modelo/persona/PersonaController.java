/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.persona;

import controlador.Excepcion.VacioExcepcion;
import modelo.Persona;
import controlador.TDA.listas.LinkedList;
import controlador.dao.DataAccessObject;
import controlador.util.Utilidades;
import java.lang.reflect.Field;

/**
 *
 * @author Usuario iTC
 */
public class PersonaController extends DataAccessObject<Persona> {
    
    //Objetos 
    private Persona persona = new Persona();
    private LinkedList<Persona> personas = new LinkedList<>();
    private Integer index = -1; //Index para el Update
    
    //Constructor
    public PersonaController() {
        super(Persona.class);
    }

    //Metodos 
    public boolean save(){
        persona.setId(generated_id());//BDD Esto desaparece
        return save(persona);
    }
    
    public boolean update(Integer index){
        return update(persona,index);
    }
    
    
    //Getter and Setter
    public Persona getPersona() {
        if(persona == null){
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LinkedList<Persona> getPersonas() {
        if(personas.isEmpty()){
            personas = listAll();
        }
        return personas;
    }

    public void setPersonas(LinkedList<Persona> personas) {
        this.personas = personas;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    //ORDENAMIENTO QUICKSORT
    public LinkedList<Persona> ordenarQuickSort(LinkedList<Persona> lista, Integer type, String field) throws VacioExcepcion {
        int[] contador = {0};
        lista = quickSort(lista, 0, lista.getSize() - 1, type, field, contador);
        System.out.println("Iteraciones totales realizadas: " + contador[0]);
        return lista;
    }

    public LinkedList<Persona> quickSort(LinkedList<Persona> lista, int izq, int der, Integer type, String field, int[] contador) throws VacioExcepcion {
        Persona[] m = lista.toArray(); // Transformo la lista a arreglo
        Field faux = Utilidades.getField(Persona.class, field);

        if (faux != null && izq < der) {
            int i = izq;
            int j = der;

            // Obtengo el pivote
            Persona pivote = m[(izq + der) / 2];

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
                    Persona temp = m[i];
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
    public LinkedList<Persona> busquedaBinaria(LinkedList<Persona> lista, String text, String field) throws VacioExcepcion {
        LinkedList<Persona> personas = new LinkedList<>(); //Nueva Lista
        Persona[] arregloOrdenado = ordenarQuickSort(lista, 0, field).toArray(); //Ordenando con QuickSort ya que es el método mas rapido a diferencia del MergeSort

        int inicio = 0;
        int fin = arregloOrdenado.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Persona b = arregloOrdenado[medio];
            String valor = Persona.criterio(b, field).toLowerCase();

            if (valor.contains(text.toLowerCase())) {
                personas.add(b);
            }
            if (valor.compareTo(text.toLowerCase()) < 0) {
                inicio = medio + 1; // El elemento está en la mitad derecha
            } else {
                fin = medio - 1; // El elemento está en la mitad izquierda
            }

        }

        return personas;
    }
    
    public LinkedList<Persona> busquedaBinariaEntero(LinkedList<Persona> lista, Integer text, String field) throws VacioExcepcion {
        LinkedList<Persona> personas = new LinkedList<>(); // Nueva Lista
        Persona[] arregloOrdenado = ordenarQuickSort(lista, 0, field).toArray(); // Ordenando con QuickSort ya que es el método más rápido a diferencia del MergeSort

        int inicio = 0;
        int fin = arregloOrdenado.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Persona b = arregloOrdenado[medio];
            Integer valor = Persona.criterioEntero(b, field);

            if (valor.equals(text)) {
                personas.add(b);
            }
            if (valor.compareTo(text) < 0) {
                inicio = medio + 1; // El elemento está en la mitad derecha
            } else {
                fin = medio - 1; // El elemento está en la mitad izquierda
            }
        }

        return personas;
    }
    
    //Busquedas Lineales
    public LinkedList<Persona> busquedaLinealBinaria(LinkedList<Persona> lista, String text, String field) throws VacioExcepcion {
        LinkedList<Persona> personas = new LinkedList<>(); // Nueva Lista
        Persona[] arregloOrdenado = ordenarQuickSort(lista, 0, field).toArray(); // Ordenando con QuickSort

        int inicio = 0;
        int fin = arregloOrdenado.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Persona b = arregloOrdenado[medio];
            String valor = Persona.criterio(b, field).toLowerCase();

            if (valor.contains(text.toLowerCase())) {
                personas.add(b);

               
                int izquierda = medio - 1;
                while (izquierda >= 0 && Persona.criterio(arregloOrdenado[izquierda], field).toLowerCase().contains(text.toLowerCase())) {
                    personas.add(arregloOrdenado[izquierda]);
                    izquierda--;
                }

               
                int derecha = medio + 1;
                while (derecha < arregloOrdenado.length && Persona.criterio(arregloOrdenado[derecha], field).toLowerCase().contains(text.toLowerCase())) {
                    personas.add(arregloOrdenado[derecha]);
                    derecha++;
                }

                return personas;  // Se ha encontrado una coincidencia, devolver la lista actualizada
            }

            if (valor.compareTo(text.toLowerCase()) < 0) {
                inicio = medio + 1; // El elemento está en la mitad derecha
            } else {
                fin = medio - 1; // El elemento está en la mitad izquierda
            }
        }

        return personas;  // Si no se encuentra ninguna coincidencia
    }
    
    public LinkedList<Persona> busquedaLinealBinariaEntero(LinkedList<Persona> lista, Integer text, String field) throws VacioExcepcion {
        LinkedList<Persona> personas = new LinkedList<>(); // Nueva Lista
        Persona[] arregloOrdenado = ordenarQuickSort(lista, 0, field).toArray(); // Ordenando con QuickSort

        int inicio = 0;
        int fin = arregloOrdenado.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Persona b = arregloOrdenado[medio];
            Integer valor = Persona.criterioEntero(b, field);

            if (valor.equals(text)) {
                personas.add(b);

               
                int izquierda = medio - 1;
                while (izquierda >= 0 && Persona.criterioEntero(arregloOrdenado[izquierda], field).equals(text)) {
                    personas.add(arregloOrdenado[izquierda]);
                    izquierda--;
                }

                
                int derecha = medio + 1;
                while (derecha < arregloOrdenado.length && Persona.criterioEntero(arregloOrdenado[derecha], field).equals(text)) {
                    personas.add(arregloOrdenado[derecha]);
                    derecha++;
                }

                return personas;  // Se ha encontrado una coincidencia, devolver la lista actualizada
            }

            if (valor.compareTo(text) < 0) {
                inicio = medio + 1; // El elemento está en la mitad derecha
            } else {
                fin = medio - 1; // El elemento está en la mitad izquierda
            }
        }

        return personas;  // Si no se encuentra ninguna coincidencia
    }
    
   
    
    
    
}
