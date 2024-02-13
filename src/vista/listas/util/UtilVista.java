/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.util;

import controlador.Excepcion.VacioExcepcion;
import modelo.Ciclo;
import modelo.Docente;
import modelo.Estudiante;
import modelo.Genero;
import modelo.Malla;
import modelo.Materia;
import modelo.PeriodoAcademico;
import modelo.Rol;
import modelo.TipoLogro;
import modelo.controladores.CicloController;
import modelo.controladores.DocenteController;
import modelo.controladores.EstudianteController;
import modelo.controladores.GeneroController;
import modelo.controladores.MallaController;
import modelo.controladores.MateriaController;
import modelo.controladores.PeriodoAcademicoController;
import modelo.controladores.RolController;
import modelo.controladores.TipoLogroController;
import modelo.enums.Estado;
import modelo.enums.Modalidad;
import modelo.enums.Turno;
import org.edisoncor.gui.comboBox.ComboBoxRect;

/**
 *
 * @author Usuario iTC
 */
public class UtilVista {
    
    
    //CARGO GENERO
    public static void cargarGenero(ComboBoxRect cbxGenero) throws VacioExcepcion{
        GeneroController gc = new GeneroController();
        cbxGenero.removeAllItems();
        
        for(int i = 0; i < gc.getGeneros().getSize(); i++){
            Genero genero = gc.getGeneros().get(i);
            cbxGenero.addItem(genero);
        }
        
    }
    
    public static Genero getComboGenero(ComboBoxRect cbxGenero){
        return (Genero) cbxGenero.getSelectedItem();
    }
    
    //Setear los combos
    public static void setComboGenero(ComboBoxRect cbxGenero, int idGenero) {
        for (int i = 0; i < cbxGenero.getItemCount(); i++) {
            Genero genero = (Genero) cbxGenero.getItemAt(i);
            if (genero.getId() == idGenero) {
                cbxGenero.setSelectedItem(genero);
                return;
            }
        }
    }
    
    public static void setComboDocente (ComboBoxRect cbxDocente, int idDocente) {
        for (int i = 0; i < cbxDocente.getItemCount(); i++) {
            Docente docente = (Docente) cbxDocente.getItemAt(i);
            if (docente.getId() == idDocente) {
                cbxDocente.setSelectedItem(docente);
                return;
            }
        }
    }
    
    public static void setComboTipoLogro(ComboBoxRect cbxTipoLogro, int idTipoLogro) {
        for (int i = 0; i < cbxTipoLogro.getItemCount(); i++) {
            TipoLogro tipo = (TipoLogro) cbxTipoLogro.getItemAt(i);
            if (tipo.getId() == idTipoLogro) {
                cbxTipoLogro.setSelectedItem(tipo);
                return;
            }
        }
    }
    
    public static void setComboCiclo (ComboBoxRect cbxCiclo, int idCiclo) {
        for (int i = 0; i < cbxCiclo.getItemCount(); i++) {
            Ciclo ciclo = (Ciclo) cbxCiclo.getItemAt(i);
            if (ciclo.getId() == idCiclo) {
                cbxCiclo.setSelectedItem(ciclo);
                return;
            }
        }
    }
    
    public static void setComboMalla(ComboBoxRect cbxMalla, int idMalla) {
        for (int i = 0; i < cbxMalla.getItemCount(); i++) {
            Malla malla = (Malla) cbxMalla.getItemAt(i);
            if (malla.getId() == idMalla) {
                cbxMalla.setSelectedItem(malla);
                return;
            }
        }
    }
    
    public static void setComboMateria(ComboBoxRect cbxMateria, int idMateria) {
        for (int i = 0; i < cbxMateria.getItemCount(); i++) {
            Materia materia = (Materia) cbxMateria.getItemAt(i);
            if (materia.getId() == idMateria) {
                cbxMateria.setSelectedItem(materia);
                return;
            }
        }
    }
    
    public static void setEstudiante(ComboBoxRect cbxEstudiante, int idEstudiante) {
        for (int i = 0; i < cbxEstudiante.getItemCount(); i++) {
            Estudiante estudiante = (Estudiante) cbxEstudiante.getItemAt(i);
            if (estudiante.getId() == idEstudiante) {
                cbxEstudiante.setSelectedItem(estudiante);
                return;
            }
        }
    }
    
    public static void setPeriodoAca(ComboBoxRect cbxPeriodo, int idPeriodo) {
        for (int i = 0; i < cbxPeriodo.getItemCount(); i++) {
            PeriodoAcademico periodo = (PeriodoAcademico) cbxPeriodo.getItemAt(i);
            if (periodo.getId() == idPeriodo) {
                cbxPeriodo.setSelectedItem(periodo);
                return;
            }
        }
    }
    
    
    
    //CARGO ROL
   public static void cargarRoles(ComboBoxRect cbxRol, String tipoRol) throws VacioExcepcion {
    RolController rc = new RolController();
    cbxRol.removeAllItems();

    for (int i = 0; i < rc.getRoles().getSize(); i++) {
        Rol rol = rc.getRoles().get(i);

        // Verificar si el rol coincide con el tipo especificado (docente o estudiante)
        if (rol.getNombre().equalsIgnoreCase(tipoRol)) {
            cbxRol.addItem(rol);
        }
    }
}

    
    public static Rol getComboRol(ComboBoxRect cbxRol){
        return (Rol) cbxRol.getSelectedItem();
    }
    
    
    
    
    
    
    //CARGO DOCENTE
     public static void cargarDocente(ComboBoxRect cbxDocente) throws VacioExcepcion {
        DocenteController dc = new DocenteController();

        cbxDocente.removeAllItems();
        try {
            for (int i = 0; i < dc.getDocentes().getSize(); i++) {
                cbxDocente.addItem(dc.getDocentes().get(i));
            }
        } catch (VacioExcepcion e) {
            e.printStackTrace();
        }
    }

    public static Docente getCargarDocente(ComboBoxRect cbx) {
        return (Docente) cbx.getSelectedItem();
    }
    
    
    //CARGO ESTUDIANTE
    public static void cargarEstudiante(ComboBoxRect cbxEstudiante) throws VacioExcepcion {
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

    public static Estudiante getCargarEstudiante(ComboBoxRect cbx) {
        return (Estudiante) cbx.getSelectedItem();
    }
    
    
    
    //CARGO TIPOS DE LOGRO
    public static void cargarTipoLogro (ComboBoxRect cbxGenero) throws VacioExcepcion{
        TipoLogroController cc = new TipoLogroController();
        cbxGenero.removeAllItems();
        
        for(int i = 0; i < cc.getTiposLogro().getSize(); i++){
            TipoLogro tipo = cc.getTiposLogro().get(i);
            cbxGenero.addItem(tipo);
        }
        
    }
    
    public static TipoLogro getComboTipoLogro (ComboBoxRect cbxGenero){
        return (TipoLogro) cbxGenero.getSelectedItem();
    }
    
    //CARGO Periodos
    public static void cargarPeriodoAca (ComboBoxRect cbxPeriodo) throws VacioExcepcion{
        PeriodoAcademicoController cc = new PeriodoAcademicoController();
        cbxPeriodo.removeAllItems();
        
        for(int i = 0; i < cc.getPeriodos().getSize(); i++){
            PeriodoAcademico periodo = cc.getPeriodos().get(i);
            cbxPeriodo.addItem(periodo);
        }
        
    }
    
    public static PeriodoAcademico getComboPeriodoAca(ComboBoxRect cbxGenero){
        return (PeriodoAcademico) cbxGenero.getSelectedItem();
    }
    
    //CARGO ESTADO
    public static void cargarEstados(ComboBoxRect cbxEstado) throws VacioExcepcion{
        cbxEstado.removeAllItems();
        
        cbxEstado.addItem(Estado.ACTIVO);
        cbxEstado.addItem(Estado.INACTIVO);
       
        
    }
    
    public static Estado getComboEstados (ComboBoxRect cbxEstado){
        return (Estado) cbxEstado.getSelectedItem();
    }
    
    //CARGO MODALIDAD
    public static void cargarModalidad (ComboBoxRect cbxModadlidad) throws VacioExcepcion{
        cbxModadlidad.removeAllItems();
        
        cbxModadlidad.addItem(Modalidad.PRESENCIAL);
        cbxModadlidad.addItem(Modalidad.DISTANCIA);
       
        
    }
    
    public static Modalidad getComboModalidad(ComboBoxRect cbxEstado){
        return (Modalidad) cbxEstado.getSelectedItem();
    }
    
    //CARGO TURNO
    public static void cargarTurno(ComboBoxRect cbxEstado) throws VacioExcepcion{
        cbxEstado.removeAllItems();
        
        cbxEstado.addItem(Turno.MATUTINA);
        cbxEstado.addItem(Turno.VESPERTINA);
        cbxEstado.addItem(Turno.NOCTURNA);
       
        
    }
    
    public static Turno getComboTurno (ComboBoxRect cbxEstado){
        return (Turno) cbxEstado.getSelectedItem();
    }
    
    
    //CARGO Mallas
    public static void cargarMalla (ComboBoxRect cbxMalla) throws VacioExcepcion{
        MallaController mc = new MallaController();
        cbxMalla.removeAllItems();
        
        for(int i = 0; i < mc.getMallas().getSize(); i++){
            Malla malla = mc.getMallas().get(i);
            cbxMalla.addItem(malla);
        }
        
    }
    
    public static Malla getComboMalla(ComboBoxRect cbxMalla){
        return (Malla) cbxMalla.getSelectedItem();
    }
    
     //CARGO Materias
    public static void cargarMateria(ComboBoxRect cbxMateria) throws VacioExcepcion{
        MateriaController mc = new MateriaController();
        cbxMateria.removeAllItems();
        
        for(int i = 0; i < mc.getMaterias().getSize(); i++){
            Materia materia = mc.getMaterias().get(i);
            cbxMateria.addItem(materia);
        }
        
    }
    
    public static Materia getComboMateria(ComboBoxRect cbxMateria){
        return (Materia) cbxMateria.getSelectedItem();
    }
    
    //CARGO CICLOS
    public static void cargarCiclo(ComboBoxRect cbxCiclo) throws VacioExcepcion{
        CicloController cc = new CicloController();
        cbxCiclo.removeAllItems();
        
        for(int i = 0; i < cc.getCiclos().getSize(); i++){
            Ciclo ciclo = cc.getCiclos().get(i);
            cbxCiclo.addItem(ciclo);
        }
        
    }
    
    public static Ciclo getComboCiclo(ComboBoxRect cbxCiclo){
        return (Ciclo) cbxCiclo.getSelectedItem();
    }
    
    
    
    

    
    
    
    
    
}

    