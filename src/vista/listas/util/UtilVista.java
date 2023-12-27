/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.util;

import javax.swing.JComboBox;
import modelo.enums.Genero;

/**
 *
 * @author Usuario iTC
 */
public class UtilVista {
    
    public static void cargarGenero(JComboBox cbxGenero){
        cbxGenero.removeAllItems();
        cbxGenero.addItem(Genero.Masculino);
        cbxGenero.addItem(Genero.Femenino);
        cbxGenero.addItem(Genero.Otro);
    }
}
