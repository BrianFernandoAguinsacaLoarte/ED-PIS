
package vista.listas.tablas;

import controlador.ControladorTarea;
import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Tarea;
import vista.listas.FrmEntregarTarea;
import vista.tablas.botonTabla;

/**
 *
 * @author 
 */
public class ModeloTablaTareasAsignadas {

    Integer id_docente;
    ControladorTarea dao = null;

    public void visualizar(JTable tabla) throws VacioExcepcion {
        tabla.setDefaultRenderer(Object.class, new botonTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("id");
        dt.addColumn("Tema");
        dt.addColumn("Descripcion");
        dt.addColumn("Fecha Creacion");
        dt.addColumn("Fecha limite");
        dt.addColumn("Archivo");
        dt.addColumn("Agregar Entrega");

        dao = new ControladorTarea();
        Tarea vo = new Tarea();
        LinkedList<Tarea> list = dao.listar();

        if (list.getSize() > 0) {
            for (int i = 0; i < list.getSize(); i++) {
                Object fila[] = new Object[7];
                vo = list.get(i);
                fila[0] = vo.getId();
                id_docente = vo.getId();
                fila[1] = vo.getTema();
                fila[2] = vo.getDescripcion();
                fila[3] = vo.getFechaCreacion();
                fila[4] = vo.getFechaEntrega();
                String extension = vo.getExtensionArchivo();
                System.out.println("La extension es: " + extension);
                if (vo.getArchivo() != null) {
                    JButton descargarArchivoBtn = new JButton("Descargar Archivo");
                    Blob archivoBlob = vo.getArchivo();
                    descargarArchivoBtn.putClientProperty("archivo", archivoBlob);
                    descargarArchivoBtn.putClientProperty("nombreArchivo", vo.getTema());
                    descargarArchivoBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Blob archivoBlob = (Blob) descargarArchivoBtn.getClientProperty("archivo");
                            String nombreArchivo = (String) descargarArchivoBtn.getClientProperty("nombreArchivo");

                            try {
                                byte[] archivoBytes = archivoBlob.getBytes(1, (int) archivoBlob.length());

                                JFileChooser fileChooser = new JFileChooser();
                                fileChooser.setDialogTitle("Guardar como");
                                fileChooser.setSelectedFile(new File(nombreArchivo + "." + extension));
                                int userSelection = fileChooser.showSaveDialog(null);

                                if (userSelection == JFileChooser.APPROVE_OPTION) {
                                    File fileToSave = fileChooser.getSelectedFile();

                                    try (FileOutputStream fos = new FileOutputStream(fileToSave)) {
                                        fos.write(archivoBytes);
                                        fos.flush();
                                        JOptionPane.showMessageDialog(null, "Archivo descargado exitosamente.");
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                        JOptionPane.showMessageDialog(null, "Error al descargar el archivo.");
                                    }
                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    fila[5] = descargarArchivoBtn;

                } else {
                    fila[5] = new JButton("Vacio");
                }

                JButton abrirTareaBtn = new JButton("Agregar Tarea Tarea");
                abrirTareaBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            abrirFrmTarea((int) fila[0]); 
                        } catch (VacioExcepcion ex) {
                            Logger.getLogger(ModeloTablaTareasAsignadas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                fila[6] = abrirTareaBtn;

                dt.addRow(fila);

            }
            tabla.setModel(dt);
        }
    }

    private void abrirFrmTarea(Integer id_docente) throws VacioExcepcion {
        FrmEntregarTarea frmTarea = new FrmEntregarTarea();
        frmTarea.setId_docente(id_docente); 
        System.out.println("Id docente: " + id_docente);
        frmTarea.setVisible(true);
    }

}
