/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.util;

import controlador.Excepcion.VacioExcepcion;
import javax.swing.JComboBox;
import modelo.Estudiante;
import modelo.controladores.EstudianteController;

/**
 *
 * @author juanc
 */
public class Estudiante_Util_VistaLinked { 

    public static void cargaEstudiante(JComboBox cbxEstudiante) throws VacioExcepcion { 
        EstudianteController ec = new EstudianteController();

        cbxEstudiante.removeAllItems();
        try {
            for (int i = 0; i < ec.getEstudiantes().getSize(); i++) { 
                cbxEstudiante.addItem(ec.getEstudiantes().get(i)); 
            }
        } catch (VacioExcepcion e) {
            e.printStackTrace();
        }
    }

    public static Estudiante getComboEstudiante(JComboBox cbx) {
        return (Estudiante) cbx.getSelectedItem(); 
    }

}
