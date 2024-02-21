/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Malla_materia;
import modelo.controladores.CicloController;
import modelo.controladores.MallaController;
import modelo.controladores.MateriaController;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaMallaMateria extends AbstractTableModel{
    
    private LinkedList<Malla_materia> mallasMaterias;
    MallaController mc = new MallaController();
    MateriaController mac = new MateriaController();
    CicloController cc = new CicloController();
    
    //Getter and Setter
    public LinkedList<Malla_materia> getMallasMaterias() {
        return mallasMaterias;
    }

    public void setMallasMaterias(LinkedList<Malla_materia> mallasMaterias) {
        this.mallasMaterias = mallasMaterias;
    }

    @Override
    public int getRowCount() {
        return mallasMaterias.getSize();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Malla_materia mallaMateria = null; 
        String malla = "";
        String materia = "";
        String ciclo = "";
        
        try {
            mallaMateria = mallasMaterias.get(row);
            malla = mc.obtener(mallaMateria.getId_malla()).getNombre();
            materia = mac.obtener(mallaMateria.getId_materia()).getNombre();
            ciclo = cc.obtener(mallaMateria.getId_ciclo()).getNombre();
            
        } catch (Exception e) {
        }
        switch (col) {
            case 0:
                return (mallaMateria != null) ? malla : "";
            case 1:
                return (mallaMateria != null) ? materia : "";
            case 2:
                return (mallaMateria != null) ? ciclo : "";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
         switch (column) {
            case 0:
                    return "Malla";
            case 1:
                    return "Materia";
            case 2:
                    return "Ciclo";
            default:
                return null;
        }
    }
    
    
    
    
    
}
