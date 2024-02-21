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
import modelo.DocenteMateria;
import modelo.controladores.ControladorCrearTarea;
import vista.listas.FrmVerTareaEntregadas;

/**
 *
 * @author Jhostin
 */
public class ModeloTablaCrearTarea {

    private LinkedList<CrearTarea> tareas;

    ControladorCrearTarea dao = null;

    public void visualizar(JTable tabla) throws VacioExcepcion{
        tabla.setDefaultRenderer(Object.class, new botonTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("Id");
        dt.addColumn("Tema");
//        dt.addColumn("Codigo");
        dt.addColumn("Descripcion");
//        dt.addColumn("Fecha Creacion");
        dt.addColumn("Fecha Entrega");
        dt.addColumn("Archivo");
        dt.addColumn("Ver Tareas Entregadas");
//        dt.addColumn("Materia");

        dao = new ControladorCrearTarea();
        CrearTarea vo = new CrearTarea();
        LinkedList<CrearTarea> list = dao.listar();

        if (list.getSize() > 0) {
            for (int i = 0; i < list.getSize(); i++) {
                Object fila[] = new Object[8];
                vo = list.get(i);
                Integer TareasEntregadas = vo.getId();
                fila[0] = vo.getId();
                fila[1] = vo.getTema();
//                fila[1] = vo.getCodigo();
                fila[2] = vo.getDescripcion();
//                fila[3] = vo.getFechaCreacion();
                fila[4] = vo.getFechaEntrega();
//                fila[6] = vo.getExtensionArchivo();
                String extension = vo.getExtensionArchivo();
                System.out.println("La extension es: " + extension);
//                String nombreCursoMateria = nombreCursoMateria(vo.getId_docenteMateria());
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
//                    fila[6] = nombreCursoMateria;
                } else {
                    fila[5] = new JButton("Vacio");
//                    fila[5] = nombreCursoMateria;
                }
                JButton abrirTareaBtn = new JButton("Ver Tareas Entregadas");
                abrirTareaBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            abrirFrmTarea(TareasEntregadas); // Pasar el id de la tarea seleccionada
                        } catch (VacioExcepcion ex) {
                            Logger.getLogger(ModeloTablaCrearTarea.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                fila[6] = abrirTareaBtn;
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
        }
    }

    private void abrirFrmTarea(Integer idTarea) throws VacioExcepcion {
        FrmVerTareaEntregadas frmTarea = new FrmVerTareaEntregadas();
        frmTarea.verTareasEntregadas(idTarea);
//        frmTarea.setId_docente(idEstudiante); // Establecer el id_docente en FrmEntregarTarea
//        System.out.println("Id docente: " + idEstudiante);
        frmTarea.setVisible(true);
    }

    public LinkedList<CrearTarea> getTareas() {
        return tareas;
    }

    public void setTareas(LinkedList<CrearTarea> tareas) {
        this.tareas = tareas;
    }

}
