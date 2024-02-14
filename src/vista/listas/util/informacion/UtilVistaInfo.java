/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.util.informacion;

import org.edisoncor.gui.comboBox.ComboBoxRect;

/**
 *
 * @author Usuario iTC
 */
public class UtilVistaInfo {
    //CARGO MODALIDAD
    public static void cargarOrden (ComboBoxRect cbxOrden){
        cbxOrden.removeAllItems();
        
        cbxOrden.addItem("Ascendente");
        cbxOrden.addItem("Descendente");
        
    }
    
    public static void cargarCriterio (ComboBoxRect cbxCriterio){
        cbxCriterio.removeAllItems();
        
        cbxCriterio.addItem("Nombres");
        cbxCriterio.addItem("Apellidos");
        cbxCriterio.addItem("Correo");
        cbxCriterio.addItem("Fecha Nacimiento");
        cbxCriterio.addItem("ID_GENERO");
        cbxCriterio.addItem("ID_ROL");
        cbxCriterio.addItem("Cedula");
        cbxCriterio.addItem("Direccion");
        cbxCriterio.addItem("Telefono");
        
       
        
    }
    
    
}
