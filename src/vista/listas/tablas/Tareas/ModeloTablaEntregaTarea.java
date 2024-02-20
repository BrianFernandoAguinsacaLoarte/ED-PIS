/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas.Tareas;

import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import java.sql.Blob;
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
import java.sql.SQLException;
import modelo.EntregaTarea;
import modelo.controladores.ControladorEntregaTarea;

/**
 *
 * @author juanc
 */
public class ModeloTablaEntregaTarea {

    Integer id_estudiante;

    ControladorEntregaTarea tareasCreadas = new ControladorEntregaTarea();
    LinkedList<EntregaTarea> tareasList = tareasCreadas.listar();
    LinkedList<EntregaTarea> tareasCoincidencias = new LinkedList<>();

    ControladorEntregaTarea dao = null;

    public void visualizar(JTable tabla, Integer id_estudiante) throws VacioExcepcion {
        tabla.setDefaultRenderer(Object.class, new botonTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.id_estudiante = id_estudiante;

//        dt.addColumn("Id");
//        dt.addColumn("Estado Entrega");
        dt.addColumn("Nombre");
        dt.addColumn("Fecha Entrega");
        dt.addColumn("Archivo Subida");
        dt.addColumn("Calificacion");

        dao = new ControladorEntregaTarea();
        EntregaTarea vo = new EntregaTarea();
//        LinkedList<EntregaTarea> tareasCoincidencias = dao.listar();
        buscarTareasEntregasEstudiante(id_estudiante, tareasList, tareasCoincidencias);

        if (tareasCoincidencias.getSize() >= 0) {
            for (int i = 0; i < tareasCoincidencias.getSize(); i++) {
                Object fila[] = new Object[6];
                vo = tareasCoincidencias.get(i);
//                fila[0] = vo.getId();
                fila[2] = vo.getNombreTarea();
                fila[1] = vo.getFechaEntrega();
                String extension = vo.getExtensionArchivo();
                System.out.println("La extension es: " + extension);
                if (vo.getArchivo() != null) {
                    JButton descargarArchivoBtn = new JButton("Descargar Archivo");
                    Blob archivoBlob = vo.getArchivo();
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
                    fila[2] = descargarArchivoBtn;
//                    fila[3] = vo.getCalificacion();

                } else {
                    fila[2] = new JButton("Vacio");
                    fila[3] = vo.getCalificacion();
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }

    private void buscarTareasEntregasEstudiante(Integer id_estudiante, LinkedList<EntregaTarea> tareasList, LinkedList<EntregaTarea> tareasCoincidencias) {

        EntregaTarea[] tareasArray = tareasList.toArray();

        for (EntregaTarea dm : tareasArray) {
            if (dm.getIdMatriculaCursoMateria() == id_estudiante) {
                tareasCoincidencias.add(dm);
                System.out.println(tareasCoincidencias);
            }
        }
    }
    

}
