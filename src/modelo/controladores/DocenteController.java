/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;
import controlador.Excepcion.VacioExcepcion;
import modelo.Docente;
import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import controlador.util.Utilidades;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Cuenta;
import modelo.Estudiante;
import modelo.Persona;

/**
 *
 * @author Usuario iTC
 */
public class DocenteController extends AdaptadorDao<Docente>  {
    
    private Docente docente;
    private LinkedList<Docente> lista = new LinkedList<>();
    private Integer index = -1;
    
    private String dominio = "@unl.edu.ec";

    public DocenteController() {
        super(Docente.class);
    }
    
//    public void guardar() {
//        try {
//            Integer idGenerado = this.guardar(docente);
//            System.out.println("Docente guardado con ID: " + idGenerado);
//        } catch (Exception e) {
//            System.out.println("Error al guardar el Docente: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
    
    
    public Docente getDocente() {
        if (docente == null) {
            docente = new Docente();
        }
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    

    public LinkedList<Docente> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<Docente> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public LinkedList<Docente> getDocentes() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }
    
    public void guardar() {
        try {
            if (cedulaEnUso(docente.getCedula())) {
                System.out.println("Error: La cédula ya está en uso.");
                JOptionPane.showMessageDialog(null, "Error: La cédula ya está en uso.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Integer idGenerado = this.guardar(docente);
            System.out.println("Docente guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar el Docente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean cedulaEnUso(String cedula) {
        LinkedList<Docente> docentesRegistrados = listar();
        Docente[] docentes = docentesRegistrados.toArray();

        if (docentes == null) {
            return false;
        }

        for (Docente docente : docentes) {
            if (docente.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    private String crearCorreo(String nombre, String apellido) {
        String appellido = apellido.substring(0, 1);
        String correo = "";
        return correo = nombre + appellido + apellido.substring(1) + getDominio();
    }

    public Integer crearCuenta(String nombre, String apellido, String cedula) {
        CuentaController cuentaControlador = new CuentaController();
        Cuenta cuenta = new Cuenta();

        if (cedulaEnUso(cedula)) {
            System.out.println("Error: La cédula ya está en uso. No se puede crear la cuenta.");
            return -1;
        } else {
            String correo = crearCorreo(nombre, apellido);
            cuenta.setUsuario(correo);
            cuenta.setClave(cedula);
            cuentaControlador.setCuenta(cuenta);
            Integer idCuenta = cuentaControlador.guardar();
            return idCuenta;
        }
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }


    private void quickSort(Docente[] arr, String field, Integer type) {
        quickSort(arr, 0, arr.length - 1, field, type);
    }

    private void quickSort(Docente[] arr, int low, int high, String field, Integer type) {
        int i = low;
        int j = high;
        // Escoge el pivote central
        Docente pivot = arr[(low + high) / 2];

        // Divide en dos arrays
        while (i <= j) {
            while (compare(arr[i], pivot, field, type) < 0) {
                i++;
            }

            while (compare(pivot, arr[j], field, type) < 0) {
                j--;
            }

            if (i <= j) {
                Docente aux = arr[i];
                arr[i] = arr[j];
                arr[j] = aux;
                i++;
                j--;
            }
        }

        // Recursivamente ordena las dos partes
        if (low < j) {
            quickSort(arr, low, j, field, type);
        }
        if (i < high) {
            quickSort(arr, i, high, field, type);
        }
    }

    private int compare(Docente a, Docente b, String field, Integer type) {
        return a.compareTo(b, field, type) ? 1 : (b.compareTo(a, field, type) ? -1 : 0);
    }

    public LinkedList<Docente> ordenarporQuickSort(Integer type, String field, LinkedList<Docente> lista) throws Exception {
        Docente[] arregloLista = lista.toArray();
        Field faux = Utilidades.getField(Persona.class, field);
        if (faux != null) {
            quickSort(arregloLista, 0, arregloLista.length - 1, field, type);
            lista = lista.toList(arregloLista);
        } else {
            throw new Exception("No Existe Criterio de Busqueda");
        }
        return lista;
    }

     public LinkedList<Docente> buscarporBusquedaLineal(String key, String field, Docente[] lista) {
        LinkedList<Docente> resultados = new LinkedList<>();
        Field faux = Utilidades.getField(Docente.class, field);

        if (faux != null) {
            int index = busquedaLineal( key, field, lista);

            if (index != -1) {
                resultados.add(lista[index]);
            }
        }

        return resultados;
    }

    public int busquedaLineal( String key, String field, Docente[] arr) {
        Field faux = Utilidades.getField(Docente.class, field);
        if (faux != null) {
            for (int i = 0; i < arr.length; i++) {
                String currentKey;

                switch (field.toLowerCase()) {
                    case "nombres":
                        currentKey = arr[i].getNombres();
                        break;
//                case "edad":
//                    currentKey = String.valueOf(arr[i].getEdad());
//                    break;
                    case "apellidos":
                        currentKey = arr[i].getApellidos();
                        break;
//                case "dni":
//                    currentKey = arr[i].getDni();
//                    break;
                    default:
                        // Manejo por defecto si el campo no coincide
                        return -1;
                }

                if (currentKey.equals(key)) {
                    return i; // Se encontró el elemento
                }
            }
        }

        return -1; // No se encontró el elemento
    }
    
}
