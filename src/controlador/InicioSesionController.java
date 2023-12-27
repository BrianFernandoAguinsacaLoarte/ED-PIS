/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import controlador.dao.DataAccessObject;
import java.util.Iterator;
import modelo.Cuenta;

/**
 *
 * @author Usuario
 */
public class InicioSesionController extends DataAccessObject{
    private Cuenta cuenta = new Cuenta();
    private LinkedList<Cuenta> cuentas = new LinkedList<>();
    private Integer index;

    public InicioSesionController() {
        super(Cuenta.class);
    }

    public Cuenta getCuenta() {
        if (cuenta == null) {
        cuenta = new Cuenta();
    }
    return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public LinkedList<Cuenta> getCuentas() {
        if (cuentas.isEmpty()) {
            cuentas = this.listAll();
        }
        return cuentas;
    }

    public void setCuentas(LinkedList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    public Boolean save(){
        cuenta.setId(generated_id());
        return save(cuenta);
    }
    public boolean verificarCredenciales(String usuario, String contraseña) throws VacioExcepcion {
// Verificar si la lista de cuentas no es nula y no está vacía
    if (cuentas != null && !cuentas.isEmpty()) {
        // Utilizar un bucle tradicional con un índice
        for (int i = 0; i < cuentas.getSize(); i++) {
            Cuenta c = cuentas.get(i);
            if (c.getUsuario().equals(usuario) && c.getContraseña().equals(contraseña)) {
                System.out.println("Credenciales correctSas");
                return true;
            }
        }
    }

        System.out.println("Credenciales Incorrectas");
    return false;
    }
    public static void main(String[] args) {
        InicioSesionController is = new InicioSesionController();
        is.getCuenta().setId(is.generated_id());
        is.getCuenta().setUsuario("admin");
        is.getCuenta().setContraseña("hola");
        is.save();
    }
}
