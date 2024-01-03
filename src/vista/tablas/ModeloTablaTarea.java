/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.tablas;

import controlador.dao.Tarea.TareaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Tarea;

/**
 *
 * @author Jhostin
 */
public class ModeloTablaTarea {
 
    TareaDAO dao = null;
    
    public void visualizar(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new botonTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Id");
        dt.addColumn("Tema");
        dt.addColumn("Descripcion");
        dt.addColumn("Fecha Creacion");
        dt.addColumn("Fecha Entrega");
        dt.addColumn("Archivo");
    
        
        dao = new TareaDAO();
        Tarea vo = new Tarea();
        ArrayList<Tarea> list = dao.Listar_all();
        
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[7]; 
                vo = list.get(i);
                fila[0] = vo.getId();
                fila[1] = vo.getTema();
                fila[2] = vo.getDescripcion();
                fila[3] = vo.getFechaCreacion();
                fila[4] = vo.getFechaEntrega();
                fila[6] = vo.getExtensionArchivo();
                String extension = vo.getExtensionArchivo();
                System.out.println("La extension es: " + extension);
                if (vo.getArchivo()!= null) {
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
                    fila[6] = vo.getExtensionArchivo();
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }
}
