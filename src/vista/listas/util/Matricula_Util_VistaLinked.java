/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.util;

import controlador.Excepcion.VacioExcepcion;
import javax.swing.JComboBox;
import modelo.Matricula;
import modelo.controladores.MatriculaControlador;

/**
 *
 * @author juanc
 */
public class Matricula_Util_VistaLinked {

    public static void cargaMatricula(JComboBox cbxMatricula) throws VacioExcepcion {
        MatriculaControlador mc = new MatriculaControlador();

        cbxMatricula.removeAllItems();
        try {
            for (int i = 0; i < mc.getMatriculas().getSize(); i++) {
                cbxMatricula.addItem(mc.getMatriculas().get(i));
            }
        } catch (VacioExcepcion e) {
            e.printStackTrace();
        }
    }

    public static Matricula getComboMatricula(JComboBox cbx) {
        return (Matricula) cbx.getSelectedItem();
    }

}
