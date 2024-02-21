/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;
import controlador.Excepcion.VacioExcepcion;
import modelo.Administrador;
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
public class AdministradorController extends AdaptadorDao<Administrador> {

    private Administrador administrador = new Administrador();
    private LinkedList<Administrador> lista = new LinkedList<>();
    private Integer index = -1;
    private String dominio = "@unl.edu.ec";

    public AdministradorController() {
        super(Administrador.class);
    }

    public Administrador getAdministrador() {
        if (administrador == null) {
            administrador = new Administrador();
        }
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public LinkedList<Administrador> getAdministradores() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public LinkedList<Administrador> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<Administrador> lista) {
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
            if (cedulaEnUso(administrador.getCedula())) {
                System.out.println("Error: La cédula ya está en uso.");
                JOptionPane.showMessageDialog(null, "Error: La cédula ya está en uso.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Integer idGenerado = this.guardar(administrador);
            System.out.println("Administrador guardado con ID: " + idGenerado);
        } catch (Exception e) {
            System.out.println("Error al guardar el Administrador: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean cedulaEnUso(String cedula) {
        LinkedList<Administrador> administradoresRegistrados = listar();
        Administrador[] administradores = administradoresRegistrados.toArray();

        if (administradores == null) {
            return false;
        }

        for (Administrador administrador : administradores) {
            if (administrador.getCedula().equals(cedula)) {
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
}
