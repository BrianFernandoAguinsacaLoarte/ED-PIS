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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.EntregaTarea;
import modelo.Estudiante;
import modelo.Matricula;
import modelo.MatriculaCursoMateria;
import modelo.controladores.ControladorEntregaTarea;
import modelo.controladores.EstudianteController;
import modelo.controladores.MatriculaControlador;
import modelo.controladores.MatriculaCursoMateriaControlador;

/**
 *
 * @author juanc
 */
public class ModeloTablaVerTareaEntregadas {

    Integer idTarea;

    ControladorEntregaTarea dao = null;

    ControladorEntregaTarea tareasCreadas = new ControladorEntregaTarea();
    LinkedList<EntregaTarea> tareasList = tareasCreadas.listar();
    EntregaTarea[] tareasArray = tareasList.toArray();

    LinkedList<EntregaTarea> tareasCoincidencias = new LinkedList<>();
    MatriculaCursoMateriaControlador matriculasMaterias = new MatriculaCursoMateriaControlador();
    LinkedList<MatriculaCursoMateria> matriculasMateriasList = matriculasMaterias.listar();
    ControladorEntregaTarea controladorEntregaTarea = new ControladorEntregaTarea();
    MatriculaControlador matriculaControlador = new MatriculaControlador();
    EstudianteController estudianteControlador = new EstudianteController();

    public void visualizar(JTable tabla, Integer idTarea) throws VacioExcepcion {
        tabla.setDefaultRenderer(Object.class, new botonTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("id");
        dt.addColumn("Tema");
        dt.addColumn("Nombre");
        dt.addColumn("Apellido");
        dt.addColumn("Descripcion");
        dt.addColumn("Texto");
        dt.addColumn("Archivo Entregado");
        dt.addColumn("Calificacion");
        dt.addColumn("Asignar Calificacion");

        dao = new ControladorEntregaTarea();
        EntregaTarea vo = new EntregaTarea();
//        LinkedList<EntregaTarea> tareasCoincidencias = dao.listar();
        buscarTareas(idTarea, tareasList, tareasCoincidencias);

//        EntregaTarea [] tareas = tareasList.toArray();
        if (tareasCoincidencias.getSize() >= 0) {

            for (int i = 0; i < tareasCoincidencias.getSize(); i++) {

                Integer buscarEstudiar = tareasCoincidencias.get(i).getIdMatriculaCursoMateria();
                System.out.println("Buscar estudiar " + buscarEstudiar);
                String nombreEstudiante = "";
                String apellidoEstudiante = "";
                Object fila[] = new Object[10];
                vo = tareasCoincidencias.get(i);
//                fila[0] = vo.getId();
//                id_docente = vo.getId();
                Integer idEstudiante = vo.getIdMatriculaCursoMateria();
                System.out.println("Tabla Id estudiante " + idEstudiante);
//                EntregaTarea encontradoEntregaTarea = controladorEntregaTarea.obtener(buscarEstudiar);
                System.out.println("\n\nTarea");
//                System.out.println(encontradoEntregaTarea.getIdMatriculaCursoMateria());
//                if (encontradoEntregaTarea != null) {
                MatriculaCursoMateria matriculaMateria = matriculasMaterias.obtener(buscarEstudiar);
                if (matriculaMateria != null) {
                    Matricula matricula = matriculaControlador.obtener(matriculaMateria.getId_matricula());
                    if (matricula != null) {
                        Estudiante estudiante = estudianteControlador.obtener(matricula.getId());
                        if (estudiante != null) {
                            nombreEstudiante = estudiante.getNombres();
                            apellidoEstudiante = estudiante.getApellidos();
                            System.out.println("nombre estudiante: " + nombreEstudiante);
                            System.out.println("nombre estudiante get: " + estudiante.getNombres());
                            System.out.println("apellido estudiante: " + apellidoEstudiante);
                            System.out.println("apellido estudiante get\n\n: " + estudiante.getApellidos());
                        } else {
                            System.out.println("No se encontro el estudiante");

                        }
                    } else {
                        System.out.println("No se encontro la matricula");

                    }
                } else {
                    System.out.println("No se encontro matricularCursoMateria");

                }
//                } else {
//                    System.out.println("No encontrado");
//                }

                fila[0] = vo.getId();
                fila[1] = vo.getNombreTarea();
                fila[2] = nombreEstudiante;
                fila[3] = apellidoEstudiante;
                fila[4] = vo.getFechaEntrega();
                fila[5] = vo.getTexto();
//                Integer idEstudiante = vo.getId();
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
                    fila[6] = descargarArchivoBtn;
                    fila[7] = vo.getCalificacion();

                } else {
                    fila[6] = new JButton("Vacio");
                    fila[7] = vo.getCalificacion();
                }

                JButton asignarCalificacionBtn = new JButton("Asignar Calificación");
                asignarCalificacionBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });

                fila[8] = asignarCalificacionBtn;
                dt.addRow(fila);
            }
            tabla.setModel(dt);
        }
    }

    private void buscarTareas(Integer idtarea, LinkedList<EntregaTarea> tareasList, LinkedList<EntregaTarea> tareasCoincidencias) {

        System.out.println("\n\nEntregar Tareas");
        System.out.println("id Docente: " + idTarea);
        EntregaTarea[] tareasArray = tareasList.toArray();

        for (EntregaTarea dm : tareasArray) {
            if (dm.getIdCrearTarea() == idtarea) {
                tareasCoincidencias.add(dm);
                System.out.println(tareasCoincidencias);
            }
        }
    }

}
