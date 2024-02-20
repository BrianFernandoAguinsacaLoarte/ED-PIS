/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas.Tareas;

import controlador.TDA.listas.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.EntregaTarea;
import modelo.MatriculaCursoMateria;
import modelo.controladores.ControladorEntregaTarea;
import modelo.controladores.MatriculaCursoMateriaControlador;

/**
 *
 * @author juanc
 */
public class ModeloTabla_Estudiante_VerTareaEntregadas {

    Integer idTarea;

    ControladorEntregaTarea dao = null;

    ControladorEntregaTarea tareasCreadas = new ControladorEntregaTarea();
    LinkedList<EntregaTarea> tareasList = tareasCreadas.listar();
    LinkedList<EntregaTarea> tareasCoincidencias = new LinkedList<>();
    MatriculaCursoMateriaControlador matriculasMaterias = new MatriculaCursoMateriaControlador();
    LinkedList<MatriculaCursoMateria> matriculasMateriasList = matriculasMaterias.listar();

    public void visualizar(JTable tabla, Integer id_estudiante, String codigo, Integer idTareaAsignada) {
        tabla.setDefaultRenderer(Object.class, new botonTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("id");

//        dt.addColumn("Codigo");
        dt.addColumn("Tema");
//        dt.addColumn("Nombre");
//        dt.addColumn("Apellido");
        dt.addColumn("Texto");
        dt.addColumn("Fecha Entrega");
        dt.addColumn("Archivo Entregado");
        dt.addColumn("Calificacion");
//        dt.addColumn("Asignar Calificacion");

        dao = new ControladorEntregaTarea();
        EntregaTarea vo = new EntregaTarea();
//        LinkedList<EntregaTarea> tareasCoincidencias = dao.listar();
        EstudianteTareasEntregadas(id_estudiante, idTareaAsignada, tareasList, tareasCoincidencias);

        if (tareasCoincidencias.getSize() >= 0) {
            for (int i = 0; i < tareasCoincidencias.getSize(); i++) {
                Object fila[] = new Object[6];
                vo = tareasCoincidencias.get(i);
//                fila[0] = vo.getId();
//                id_docente = vo.getId();
                Integer idEstudiante = vo.getIdMatriculaCursoMateria();
                fila[0] = vo.getId();
//                fila[1] = vo.getCodigo();
                fila[1] = vo.getNombreTarea();
                fila[2] = vo.getTexto();
                fila[3] = vo.getFechaEntrega();
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
                    fila[4] = descargarArchivoBtn;
                    fila[5] = vo.getCalificacion();

                } else {
                    fila[4] = new JButton("Vacio");
                    fila[5] = vo.getCalificacion();
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
        } else {

        }
    }

    private void EstudianteTareasEntregadas(Integer id_estudiante, Integer idTareaAsignada, LinkedList<EntregaTarea> tareasList, LinkedList<EntregaTarea> tareasCoincidencias) {

        System.out.println("En Ver EntregaTareas");
        System.out.println("Id Estudiante " + id_estudiante);
        System.out.println("Id TareaAsignada " + idTareaAsignada);
        EntregaTarea[] tareasArray = tareasList.toArray();
        if (tareasArray != null) {
            for (EntregaTarea dm : tareasArray) {
                System.out.println("\nAdentro");
                System.out.println("Id Matricula materia" + dm.getIdMatriculaCursoMateria());
                System.out.println("Id Tarea" + dm.getIdCrearTarea());
                if (dm.getIdMatriculaCursoMateria() == id_estudiante && dm.getIdCrearTarea() == idTareaAsignada) {
                    tareasCoincidencias.add(dm);
                    System.out.println(tareasCoincidencias);
                }
            }
        } else {
            System.out.println("No entro en el for");
        }
    }

}
