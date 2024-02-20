/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.listas.tablas.Tareas;

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
import modelo.CrearTarea;
import modelo.controladores.ControladorCrearTarea;
import vista.listas.FrmEntregarTarea;

/**
 *
 * @author juanc
 */
public class ModeloTablaTareasAsignadas {

    Integer idDocenteMateria;
    Integer idEstudiante;
    Integer idEstudianteMateria;
//    CrearTarea[] coincidenciasArray;

    ControladorCrearTarea tareasCreadas = new ControladorCrearTarea();
    LinkedList<CrearTarea> tareasList = tareasCreadas.listar();
    LinkedList<CrearTarea> tareasCoincidencias = new LinkedList<>();

    public ModeloTablaTareasAsignadas() {
    }

    ControladorCrearTarea dao = null;

    public void visualizar(JTable tabla, Integer idEstudianteMateria, Integer idDocenteMateria, Integer idEstudiante) throws VacioExcepcion {
        tabla.setDefaultRenderer(Object.class, new botonTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        this.idDocenteMateria = idDocenteMateria;
        this.idEstudiante = idEstudiante;
        this.idEstudianteMateria = idEstudianteMateria;

//        dt.addColumn("id");
        dt.addColumn("Tema");
        dt.addColumn("Descripcion");
        dt.addColumn("Archivo");
        dt.addColumn("Agregar Entrega");

        dao = new ControladorCrearTarea();
        CrearTarea vo = new CrearTarea();
        System.out.println("\n\n\nVisualizar: " + idDocenteMateria);
        buscarTareas(idDocenteMateria, tareasList, tareasCoincidencias);

        if (tareasCoincidencias.getSize() > 0) {
            for (int i = 0; i < tareasCoincidencias.getSize(); i++) {
                System.out.println("Coincidencias: " + tareasCoincidencias.toString());
                Object fila[] = new Object[5];
                vo = tareasCoincidencias.get(i);
//                fila[0] = vo.getId();
//                idDocenteMateria = vo.getId();
                String codigoTarea = vo.getCodigo();
                Integer idTareaAsignada = vo.getId();
                fila[0] = vo.getTema();
                fila[1] = vo.getDescripcion();
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
                    fila[2] = descargarArchivoBtn;

                } else {
                    fila[2] = new JButton("Vacio");
                }

                JButton abrirTareaBtn = new JButton("Agregar Tarea");
                abrirTareaBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            abrirFrmTarea(idEstudiante, codigoTarea, idTareaAsignada); // Pasar el id de la tarea seleccionada
                        } catch (VacioExcepcion ex) {
                            Logger.getLogger(ModeloTablaTareasAsignadas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                fila[3] = abrirTareaBtn;

                dt.addRow(fila);

            }
            tabla.setModel(dt);
        } else {
            JOptionPane.showMessageDialog(null, "No hay Tareas", "Notificacion", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void abrirFrmTarea(Integer idEstudiante, String codigo, Integer idTareaAsignada) throws VacioExcepcion {
        FrmEntregarTarea frmTarea = new FrmEntregarTarea();
        frmTarea.Tarea(idEstudiante, codigo, idTareaAsignada, idEstudianteMateria, idDocenteMateria);
        frmTarea.setVisible(true);
    }

    private void buscarTareas(Integer idDocenteMateria, LinkedList<CrearTarea> tareasList, LinkedList<CrearTarea> tareasCoincidencias) {

        System.out.println("\n\n\nBuscarTareas");
        System.out.println("id Docente: " + idDocenteMateria);
        CrearTarea[] tareasArray = tareasList.toArray();

        for (CrearTarea dm : tareasArray) {
            if (dm.getId_docenteMateria() == idDocenteMateria) {
                tareasCoincidencias.add(dm);
                System.out.println(tareasCoincidencias);
            }
        }

    }
}
