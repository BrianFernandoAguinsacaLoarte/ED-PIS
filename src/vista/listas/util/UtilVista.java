/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.util;

import controlador.Excepcion.VacioExcepcion;
import controlador.Materia.MateriaControlador;
import controlador.TDA.listas.LinkedList;
import controlador.periodos.PeriodoControlador;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import modelo.DocenteMateria;
import modelo.Estudiante;
import modelo.Materia;
import modelo.PeriodoAcademico;
import modelo.enums.Genero;
import modelo.Persona;
import modelo.enums.Rol;
import static modelo.enums.Rol.Estudiante;
import modelo.persona.DocenteMateriaController;
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
    public static Estudiante getComboEstudiante(JComboBox cbxPersona){
        return (Estudiante) cbxPersona.getSelectedItem();
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
    
    public static void cargarMateria(JComboBox cbxMateria) throws VacioExcepcion{
        
        MateriaControlador mc = new MateriaControlador();
        cbxMateria.removeAllItems();
        
        for(int i = 0; i < mc.getLista().getSize(); i++){
            Materia m = mc.getLista().get(i);
            cbxMateria.addItem(m);
        }
    }
    
    public static Materia getComboMateria(JComboBox cbxMateria){
        return (Materia) cbxMateria.getSelectedItem();
    }
    
    public static void cargarPeriodoAcademico(JComboBox cbxPA) throws VacioExcepcion{
        
        PeriodoControlador pc = new PeriodoControlador();
        cbxPA.removeAllItems();
        
        for(int i = 0; i < pc.getPeriodosAcademicos().getSize(); i++){
            PeriodoAcademico pa = pc.getPeriodosAcademicos().get(i);
            cbxPA.addItem(pa);
        }
    }
    
    public static PeriodoAcademico getComboPeriodoAcademico (JComboBox cbxPA){
        return (PeriodoAcademico) cbxPA.getSelectedItem();
    }
    
}
