/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.Excepcion.VacioExcepcion;
import modelo.Estudiante;
import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import controlador.dao.AdaptadorDao;
import controlador.util.Utilidades;
import java.lang.reflect.Field;
import javax.swing.JOptionPane;
import modelo.Cuenta;
import modelo.Persona;

/**
 *
 * @author Usuario iTC
 */
public class EstudianteController extends AdaptadorDao<Estudiante> {

    //Objetos
    private Estudiante estudiante = new Estudiante();
    private LinkedList<Estudiante> lista = new LinkedList<>();
    private Integer index = -1;
    private String dominio = "@unl.edu.ec";

    //Constructor
    public EstudianteController() {
        super(Estudiante.class);
    }

    //Métodos
//     public void guardar() {
//        try {
//            Integer idGenerado = this.guardar(estudiante);
//            System.out.println("Estudiante guardado con ID: " + idGenerado);
//        } catch (Exception e) {
//            System.out.println("Error al guardar el Docente: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//    public String obtenerNombre(Integer idPersona) throws VacioExcepcion {
//        PersonaController pc = new PersonaController();
//
//        for (int i = 0; i < pc.getPersonas().getSize(); i++) {
//            Persona persona = pc.getPersonas().get(i);
//            if (persona.getId().equals(idPersona)) {
//                 return persona.getNombres() + " " + persona.getApellidos();
//            }
//        }
//        return "";
//    }
    //Getter and Setter
    public Estudiante getEstudiante() {

        if (estudiante == null) {
            estudiante = new Estudiante();
        }
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LinkedList<Estudiante> getEstudiantes() {

        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public LinkedList<Estudiante> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<Estudiante> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void guardar() {
        try {
            // Verificar si la cédula ya está en uso
            if (cedulaEnUso(estudiante.getCedula())) {
                System.out.println("Error: La cédula ya está en uso.");
                JOptionPane.showMessageDialog(null, "Error: La cédula ya está en uso.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método sin guardar el estudiante
            }

            // La cédula no está en uso, guardar el estudiante
            Integer idGenerado = this.guardar(estudiante);
            System.out.println("Estudiante guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar el Estudiante: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean cedulaEnUso(String cedula) {

        // Verificar si la cédula ya está en uso
        LinkedList<Estudiante> estudiantesRegistrados = listar();
        Estudiante[] estudiantes = estudiantesRegistrados.toArray();

        if (estudiantes == null) {
            return false;
        }

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return true; // La cédula ya está en uso
            }
        }
        return false; // La cédula no está en uso
    }

    private String crearCorreo(String nombre, String apellido) {
        String appellido = apellido.substring(0, 1);
        String correo = "";
        return correo = nombre + appellido + apellido.substring(1) + getDominio();
    }

    public Integer crearCuenta(String nombre, String apellido, String cedula) {
        CuentaController cuentaControlador = new CuentaController();
        Cuenta cuenta = new Cuenta();
        // Verificar si la cédula ya está en uso

        if (cedulaEnUso(cedula)) {
            System.out.println("Error: La cédula ya está en uso. No se puede crear la cuenta.");
            return -1;

        } else {

            // Crear cuenta, si cedula no esta en uso
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

}
