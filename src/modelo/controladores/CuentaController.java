/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.controladores;

import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
import java.util.Random;
import modelo.Cuenta;

/**
 *
 * @author juanc
 */
public class CuentaController extends AdaptadorDao<Cuenta> {

    private Cuenta cuenta;
    private LinkedList<Cuenta> lista = new LinkedList<>();
    private Integer index = -1;

    public CuentaController() {
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

    public LinkedList<Cuenta> getLista() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }

    public void setLista(LinkedList<Cuenta> lista) {
        this.lista = lista;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public LinkedList<Cuenta> getMaterias() {
        if (lista.isEmpty()) {
            lista = listar();
        }
        return lista;
    }
    
    
    public Integer guardar() {
        try {
            LinkedList<Cuenta> cuentasRegistradas = getLista();

            Cuenta[] cuentasArray = cuentasRegistradas.toArray();

            // Verificar si la lista está vacía
            if (cuentasArray == null) {
                Integer idGenerado = this.guardar(cuenta);
                System.out.println("Cuenta guardada con ID: " + idGenerado);
                return idGenerado;
            }

            // Verificar si el correo electrónico ya esta usado
            for (Cuenta cuentaRegistrada : cuentasArray) {
                if (cuentaRegistrada.getUsuario().equals(cuenta.getUsuario())) {
                    // El correo electrónico ya está registrado, generar uno nuevo
                    String nuevoCorreo = generarNuevoCorreo(cuenta.getUsuario());
                    cuenta.setUsuario(nuevoCorreo);
                    return guardar();
                }
            }

            Integer idGenerado = this.guardar(cuenta);
            System.out.println("Cuenta guardada con ID: " + idGenerado);
            return idGenerado;

        } catch (Exception e) {
            System.out.println("Error al guardar la Cuenta: " + e.getMessage());
            e.printStackTrace();
            return -1; 
        }
    }

    private String generarNuevoCorreo(String correo) {
        int indexArroba = correo.indexOf('@');

        String parteAntesArroba = correo.substring(0, indexArroba);
        String parteDespuesArroba = correo.substring(indexArroba);

        String numerosAleatorios = getRandomNumbers();

        String nuevoCorreo = parteAntesArroba + numerosAleatorios + parteDespuesArroba;

        return nuevoCorreo;
    }

    private String getRandomNumbers() {
        Random random = new Random();
        int num1 = random.nextInt(10);
        int num2 = random.nextInt(10);
        int num3 = random.nextInt(10);
        return num1 + "" + num2 + "" + num3;
    }

    public int buscarIdPorCorreo(String correo) {

        LinkedList<Cuenta> cuentasRegistradas = getLista();

        Cuenta[] cuentasArray = cuentasRegistradas.toArray();

        for (Cuenta cuenta : cuentasArray) {
            if (cuenta.getUsuario().equals(correo)) {
                return cuenta.getId(); // Devolver el ID de la cuenta encontrada
            }
        }

        return -1;
    }

}
