/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.util;

import controlador.Excepcion.VacioExcepcion;
import javax.swing.JComboBox;
import modelo.enums.Genero;
import modelo.Persona;
import modelo.enums.Rol;
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
    
    public static void cargarRol(JComboBox cbxRol){
        cbxRol.removeAllItems();
        cbxRol.addItem(Rol.Docente);
        cbxRol.addItem(Rol.Estudiante);
    }
    
    public static Rol getComboRol(JComboBox cbxRol){
        return (Rol) cbxRol.getSelectedItem();
    }
    
    public static void cargarPersonaDocente(JComboBox cbxPersona, Rol rol) throws VacioExcepcion{
        
        PersonaController pc = new PersonaController();
        cbxPersona.removeAllItems();
        
        for(int i = 0; i < pc.getPersonas().getSize(); i++){
            Persona persona = pc.getPersonas().get(i);
            
            if(persona.getRol() == rol)
            cbxPersona.addItem(persona);
        }
    }
    
    public static Persona getComboPersonaDocente(JComboBox cbxPersona){
        return (Persona) cbxPersona.getSelectedItem();
    }
    
    public static void cargarPersonaEstudiante(JComboBox cbxPersona, Rol rol) throws VacioExcepcion{
        
        PersonaController pc = new PersonaController();
        cbxPersona.removeAllItems();
        
        for(int i = 0; i < pc.getPersonas().getSize(); i++){
            Persona persona = pc.getPersonas().get(i);
            
            if(persona.getRol() == rol)
            cbxPersona.addItem(persona);
        }
    }
    
    public static Persona getComboPersonaEstudiante(JComboBox cbxPersona){
        return (Persona) cbxPersona.getSelectedItem();
    }
}
