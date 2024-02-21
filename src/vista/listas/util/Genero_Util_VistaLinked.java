/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.util;

import controlador.Excepcion.VacioExcepcion;
import javax.swing.JComboBox;
import modelo.Genero;
import modelo.controladores.GeneroController;

public class Genero_Util_VistaLinked {

    public static void cargaGenero(JComboBox cbxGenero) throws VacioExcepcion { 
        GeneroController gc = new GeneroController(); 

        cbxGenero.removeAllItems();
        try {
            for (int i = 0; i < gc.getGeneros().getSize(); i++) {
                cbxGenero.addItem(gc.getGeneros().get(i)); 
            }
        } catch (VacioExcepcion e) {
            e.printStackTrace();
        }
    }

    public static Genero getComboGenero(JComboBox cbx) { 
        return (Genero) cbx.getSelectedItem(); 
    }

}

