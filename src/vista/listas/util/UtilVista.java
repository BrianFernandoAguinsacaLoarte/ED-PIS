/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.util;

import javax.swing.JComboBox;

/**
 *
 * @author Usuario iTC
 */
public class UtilVista {
    
    public static void cargarGenero(JComboBox cbxGenero){
        cbxGenero.removeAllItems();
        cbxGenero.addItem("Femenino");
        cbxGenero.addItem("Masculino");
    }
}
