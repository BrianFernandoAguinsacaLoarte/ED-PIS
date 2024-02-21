package vista.listas.util;

import controlador.Excepcion.VacioExcepcion;
import javax.swing.JComboBox;
import modelo.PeriodoAcademico;
import modelo.controladores.PeriodoAcademicoController;

/**
 *
 * @author juanc
 */
public class PeriodoAcademico_Util_VistaLinked {

    public static void cargaPeriodoAcademico(JComboBox cbxPeriodoAcademico) throws VacioExcepcion {
        PeriodoAcademicoController pac = new PeriodoAcademicoController(); 

        cbxPeriodoAcademico.removeAllItems();
        try {
            for (int i = 0; i < pac.getPeriodos().getSize(); i++) {
                cbxPeriodoAcademico.addItem(pac.getPeriodos().get(i)); 
            }
        } catch (VacioExcepcion e) {
            e.printStackTrace();
        }
    }

    public static PeriodoAcademico getComboPeriodoAcademico(JComboBox cbx) {
        return (PeriodoAcademico) cbx.getSelectedItem();
    }

}
