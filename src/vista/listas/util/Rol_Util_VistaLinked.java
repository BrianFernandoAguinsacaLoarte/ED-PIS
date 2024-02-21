/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.util;

import controlador.Excepcion.VacioExcepcion;
import javax.swing.JComboBox;
import modelo.Rol;
import modelo.controladores.RolController;

/**
 *
 * @author juanc
 */
public class Rol_Util_VistaLinked {

    public static void cargaRol(JComboBox cbxRol) throws VacioExcepcion {
        RolController rc = new RolController();

        cbxRol.removeAllItems();
        try {
            for (int i = 0; i < rc.getRoles().getSize(); i++) {
                cbxRol.addItem(rc.getRoles().get(i));
            }
        } catch (VacioExcepcion e) {
            e.printStackTrace();
        }
    }

    public static Rol getComboRol(JComboBox cbx) {
        return (Rol) cbx.getSelectedItem();
    }

}