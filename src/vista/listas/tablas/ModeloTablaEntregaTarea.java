
package vista.listas.tablas;

import java.sql.Blob;
import controlador.ControladorEntregaTarea;
import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.EntregaTarea;
import java.sql.SQLException;
import vista.tablas.botonTabla;

/**
 *
 * @author 
 */
public class ModeloTablaEntregaTarea {

    ControladorEntregaTarea dao = null;

    public void visualizar(JTable tabla) throws VacioExcepcion {
        tabla.setDefaultRenderer(Object.class, new botonTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Id");
        dt.addColumn("Estado Entrega");
        dt.addColumn("Fecha Entrega");
        dt.addColumn("Archivo Subida");
        dt.addColumn("Calificacion");

        dao = new ControladorEntregaTarea();
        EntregaTarea vo = new EntregaTarea();
        LinkedList<EntregaTarea> list = dao.listar(); // Cambiado a LinkedList

        if (list.getSize() > 0) {
            for (int i = 0; i < list.getSize(); i++) {
                Object fila[] = new Object[6];
                vo = list.get(i);
                fila[0] = vo.getId();
                fila[1] = vo.getFechaEntrega();
                fila[2] = vo.getNombreTarea();
                String extension = vo.getExtensionTarea();
                System.out.println("La extension es: " + extension);
                if (vo.getArchivoTarea()!= null) {
                    JButton descargarArchivoBtn = new JButton("Descargar Archivo");
                    Blob archivoBlob = vo.getArchivoTarea();
                    descargarArchivoBtn.putClientProperty("archivo", archivoBlob);
                    descargarArchivoBtn.putClientProperty("nombreArchivo", vo.getNombreTarea());
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
                    fila[3] = descargarArchivoBtn;

                } else {
                    fila[3] = new JButton("Vacio");
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
}
