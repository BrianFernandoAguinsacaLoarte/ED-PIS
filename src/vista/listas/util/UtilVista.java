/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.util;

import controlador.Excepcion.VacioExcepcion;
import javax.swing.JComboBox;
import modelo.enums.Genero;
import modelo.Persona;
import modelo.persona.PersonaController;

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
    
    public static Genero getComboGenero(JComboBox cbxGenero){
        return (Genero) cbxGenero.getSelectedItem();
    }
    
    public static void cargarPersona(JComboBox cbxPersona) throws VacioExcepcion{
        
        PersonaController pc = new PersonaController();
        cbxPersona.removeAllItems();
        
        for(int i = 0; i < pc.getPersonas().getSize(); i++){
            cbxPersona.addItem(pc.getPersonas().get(i));
        }
    }
    
    public static Persona getComboPersona(JComboBox cbxPersona){
        return (Persona) cbxPersona.getSelectedItem();
    }
}
