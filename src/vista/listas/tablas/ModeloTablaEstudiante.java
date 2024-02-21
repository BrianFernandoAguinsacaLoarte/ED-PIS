/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Estudiante;
import modelo.controladores.CuentaController;
import modelo.controladores.EstudianteController;
import modelo.controladores.GeneroController;
import modelo.controladores.RolController;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaEstudiante extends AbstractTableModel {

    //Objeto
    LinkedList<Estudiante> estudiantes = new LinkedList<>();
    GeneroController gc = new GeneroController();
    RolController rc = new RolController();
    CuentaController cuentaControlador = new CuentaController();

    //Getter and Setter
    public LinkedList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(LinkedList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public int getRowCount() {
        return estudiantes.getSize();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }
    //Metodo de busqueda

    @Override
    public Object getValueAt(int fila, int columna) {
        Estudiante estudiante = null;
        String rol = "";
        String genero = "";
        String usuario = "";
        String clave = "";
        try {
            estudiante = estudiantes.get(fila);
            usuario = cuentaControlador.obtener(estudiante.getId_cuenta()).getUsuario();
            clave = cuentaControlador.obtener(estudiante.getId_cuenta()).getClave();
            rol = rc.obtener(estudiante.getId_rol()).getNombre();
            genero = gc.obtener(estudiante.getId_genero()).getNombre();
        } catch (Exception e) {
        }

        switch (columna) {
            case 0:
                return (estudiante != null) ? estudiante.getNombres() : "";
            case 1:
                return (estudiante != null) ? estudiante.getApellidos() : "";
            case 2:
                return (estudiante != null) ? estudiante.getCorreo() : "";
            case 3:
                return (estudiante != null) ? estudiante.getFechaNacimiento() : "";
            case 4:
                return (estudiante != null) ? genero : "";
            case 5:
                return (estudiante != null) ? rol : "";
            case 6:
                return (estudiante != null) ? estudiante.getCedula() : "";
            case 7:
                return (estudiante != null) ? estudiante.getDireccion() : "";
            case 8:
                return (estudiante != null) ? estudiante.getTelefono() : "";
            case 9:
                return (estudiante != null) ? usuario : "";
            case 10:
                return (estudiante != null) ? clave : "";

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int columna) {
        switch (columna) {
            case 0:
                return "Nombres";
            case 1:
                return "Apellidos";
            case 2:
                return "Correo";
            case 3:
                return "Fecha de Nacimiento";
            case 4:
                return "Género";
            case 5:
                return "Rol";
            case 6:
                return "Cédula";
            case 7:
                return "Dirección";
            case 8:
                return "Telefono";
            case 9:
                return "Usuario";
            case 10:
                return "clave";
            default:
                return null;
        }
    }

}
