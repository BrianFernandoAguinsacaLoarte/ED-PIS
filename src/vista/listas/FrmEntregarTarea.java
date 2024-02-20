/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.listas;

import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import modelo.CrearTarea;
import modelo.EntregaTarea;
import modelo.Matricula;
import modelo.controladores.ControladorCrearTarea;
import modelo.controladores.ControladorEntregaTarea;
import modelo.controladores.MatriculaController;
import vista.listas.tablas.ModeloTablaMatricula;
import vista.listas.tablas.Tareas.ModeloTablaCrearTarea;
import vista.listas.tablas.Tareas.ModeloTabla_Estudiante_VerTareaEntregadas;
import vista.listas.util.UtilVista;

/**
 *
 * @author Usuario iTC
 */
public class FrmEntregarTarea extends javax.swing.JFrame {

    private Integer id_estudiante;
    private String codigo;
    private Integer idTareaAsignada;
    private Integer idEstudianteMateria;
    private Integer idDocenteMateria;
    private ControladorEntregaTarea entCon = new ControladorEntregaTarea();
    private LinkedList<EntregaTarea> entragaTareasList = entCon.listar();
    private EntregaTarea[] entregaTareasArray = entragaTareasList.toArray();
    private ModeloTabla_Estudiante_VerTareaEntregadas mtll = new ModeloTabla_Estudiante_VerTareaEntregadas();

    String ruta_archivo = "";
    int id = -1;
    private String extensionArchivo;

    /**
     * Creates new form EntregaTarea
     */
    public FrmEntregarTarea() {

    }

    public void Tarea(Integer id_estudiante, String codigo, Integer idTareaAsignada, Integer idEstudianteMateria, Integer idDocenteMateria) throws VacioExcepcion {
        this.codigo = codigo;
        this.id_estudiante = id_estudiante;
        this.idEstudianteMateria = idEstudianteMateria;
        this.idDocenteMateria = idDocenteMateria;
        initComponents();
        limpiar();

        System.out.println("\n\n\nCodigo: " + codigo);
        System.out.println("Id docente en frm entregaTarea = " + id_estudiante);
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String fechaActual = dateFormat.format(calendar.getTime());
        txtFechaEntrega.setText(fechaActual);
        txtFechaEntrega.setEnabled(false);

        SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
        String horaActual = horaFormat.format(calendar.getTime());
        txtHoraEntrega.setText(horaActual);
        txtHoraEntrega.setEnabled(false);

        mtll.visualizar(tblTabla, id_estudiante, codigo, idTareaAsignada);

    }

    private Integer buscarIdTarea(String codigo) {

        ControladorCrearTarea tareasCreadas = new ControladorCrearTarea();
        LinkedList<CrearTarea> tareasList = tareasCreadas.listar();
        CrearTarea[] tareasArray = tareasList.toArray();
        System.out.println("Buscar tarea id --> CODIGO: " + codigo);
        for (CrearTarea dm : tareasArray) {
            if (dm.getCodigo().equals(codigo)) {
                return dm.getId();
            }
        }
        System.out.println("No se encontro coincidencias");
        return -1;
    }

    public Boolean validar() {
        return !txtNombreArchivo.getText().trim().isEmpty();
    }

    private void limpiar() throws VacioExcepcion {
        System.out.println("Id tarea: " + id_estudiante);
        txtNombreArchivo.setText("");
        txtTexto.setText("");
        entCon.setEntregaTarea(null);
        entCon.setLista(new LinkedList<>());
        mtll.visualizar(tblTabla, id_estudiante, codigo, idTareaAsignada);
    }

    public void seleccionar_tarea() {
        JFileChooser j = new JFileChooser();

        int se = j.showOpenDialog(this);
        if (se == 0) {
            this.btnSeleccionar.setText("" + j.getSelectedFile().getName());
            ruta_archivo = j.getSelectedFile().getAbsolutePath();
            String nombre_archivo = j.getSelectedFile().getName();

            // Obtener la extensión del archivo seleccionado
            String extension = nombre_archivo.substring(nombre_archivo.lastIndexOf(".") + 1);

            //txtNombreFile.setText(nombre_archivo);
            extensionArchivo = extension;

            System.out.println("Extensión del archivo: " + extension);

            // presentarIcono(extension);
        } else {
        }
    }

    public void guardar() throws VacioExcepcion {
        if (validar()) {
            try {
                Integer idEstudiante = id_estudiante;
                EntregaTarea tarea = new EntregaTarea();
                Integer idCrearTarea = buscarIdTarea(codigo);
//                buscarIdTarea(codigo);
                System.out.println("\nID del Codigo: " + idCrearTarea);
                tarea.setNombreTarea(txtNombreArchivo.getText());
                SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String fechaAsignacionString = txtFechaEntrega.getText() + " " + txtHoraEntrega.getText();
                Date fechaAsignacion = formatoFechaHora.parse(fechaAsignacionString);
                tarea.setFechaEntrega(fechaAsignacion);
                tarea.setTexto(txtTexto.getText());
                tarea.setIdCrearTarea(idCrearTarea);
                tarea.setIdMatriculaCursoMateria(idEstudiante);

                String codigoUnico = entCon.generarCodigoUnico();
                tarea.setCodigo(codigoUnico);

                System.out.println("Id tarea = " + idEstudiante);
                File ruta = new File(ruta_archivo);
                try {
                    byte[] archivo = new byte[(int) ruta.length()];
                    InputStream input = new FileInputStream(ruta);
                    input.read(archivo);
                    Blob blobArchivo = new SerialBlob(archivo);
                    tarea.setArchivo(blobArchivo);
                } catch (IOException | SQLException ex) {
                    tarea.setArchivo(null);
                    System.out.println("Error al agregar archivo " + ex.getMessage());
                }
                String extenArchivo = extensionArchivo;
                tarea.setExtensionArchivo(extenArchivo);

//                tarea.setEstadoEntrega("Entregado");
                entCon.setEntregaTarea(tarea);
                entCon.guardar();
                entCon.setEntregaTarea(null);
                limpiar();

            } catch (ParseException e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void modificarTarea() throws Exception {
        if (validar()) {
            try {

                int filaSeleccionada = tblTabla.getSelectedRow();
                Object idEscondido = tblTabla.getValueAt(filaSeleccionada, 0);
                String codigoTarea = idEscondido.toString();
                Integer codigoTareaInt = Integer.parseInt(codigoTarea);

                Integer idEncontrado = null;

                for (EntregaTarea entregaTarea : entregaTareasArray) {
                    System.out.println("crear Tarea " + entregaTarea.getCodigo());
                    if (entregaTarea.getId().equals(codigoTareaInt)) {
                        System.out.println("Coincide");
                        idEncontrado = entregaTarea.getId();
                        break;
                    } else {
//                        System.out.println("No se encontro coincidencia");
                    }
                }

                EntregaTarea entregaTarea = entCon.obtener(codigoTareaInt);

                Integer id = entregaTarea.getId();
                Integer idCrearTarea = entregaTarea.getIdCrearTarea();
                Integer idMatricula = entregaTarea.getIdMatriculaCursoMateria();

                SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                String fechaAsignacionString = txtFechaEntrega.getText() + " " + txtHoraEntrega.getText();
                Date fechaAsignacion = formatoFechaHora.parse(fechaAsignacionString);

                if (!ruta_archivo.isEmpty()) {
                    File ruta = new File(ruta_archivo);
                    if (ruta.exists()) {
                        try {
                            byte[] archivo = new byte[(int) ruta.length()];
                            InputStream input = new FileInputStream(ruta);
                            input.read(archivo);
                            Blob blobArchivo = new SerialBlob(archivo);
                            entregaTarea.setArchivo(blobArchivo);
                        } catch (IOException | SQLException ex) {
                            entregaTarea.setArchivo(null);
                            System.out.println("Error al agregar archivo " + ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El archivo no existe en la ruta especificada.");
                        return;
                    }
                }

                String extenArchivo = extensionArchivo;

                entregaTarea.setId(id);
                entregaTarea.setFechaEntrega(fechaAsignacion);
                entregaTarea.setTexto(txtTexto.getText());
                entregaTarea.setNombreTarea(txtNombreArchivo.getText());
                entregaTarea.setEstado("Entregado");
                entregaTarea.setIdCrearTarea(idCrearTarea);
                entregaTarea.setIdMatriculaCursoMateria(idMatricula);
                entregaTarea.setExtensionArchivo(extenArchivo);
                entregaTarea.setIdMatriculaCursoMateria(idMatricula);
                entCon.setEntregaTarea(entregaTarea);
                entCon.modificar3(entregaTarea);
                entCon.setEntregaTarea(null);

                limpiar();
            } catch (ParseException e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        panel2 = new org.edisoncor.gui.panel.Panel();
        labelRound1 = new org.edisoncor.gui.label.LabelRound();
        panelLogo = new org.edisoncor.gui.panel.PanelImage();
        btnRegresar = new org.edisoncor.gui.button.ButtonRect();
        txtNombreArchivo = new javax.swing.JTextField();
        txtFechaEntrega = new javax.swing.JTextField();
        txtHoraEntrega = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JTextArea();
        labelRect2 = new org.edisoncor.gui.label.LabelRect();
        labelRect3 = new org.edisoncor.gui.label.LabelRect();
        labelRect4 = new org.edisoncor.gui.label.LabelRect();
        labelRect5 = new org.edisoncor.gui.label.LabelRect();
        labelRect7 = new org.edisoncor.gui.label.LabelRect();
        btnModificar = new org.edisoncor.gui.button.ButtonRect();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        btnGuardar1 = new org.edisoncor.gui.button.ButtonRect();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel2.setColorPrimario(new java.awt.Color(0, 102, 153));
        panel2.setColorSecundario(new java.awt.Color(0, 102, 153));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelRound1.setBackground(new java.awt.Color(0, 102, 153));
        labelRound1.setText("CREAR TAREA\n");
        labelRound1.setColorDeBorde(new java.awt.Color(0, 102, 153));
        labelRound1.setColorDeSegundoBorde(new java.awt.Color(0, 102, 153));
        labelRound1.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelRound1.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        panel2.add(labelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1110, 90));

        panelLogo.setBackground(new java.awt.Color(0, 102, 153));
        panelLogo.setForeground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        panel2.add(panelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 90));

        panel1.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 90));

        btnRegresar.setBackground(new java.awt.Color(0, 102, 153));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        panel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 600, 160, 40));
        panel1.add(txtNombreArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 260, 30));
        panel1.add(txtFechaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, 230, 30));
        panel1.add(txtHoraEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, 230, 30));
        panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, -1, -1));

        txtTexto.setColumns(20);
        txtTexto.setRows(5);
        jScrollPane1.setViewportView(txtTexto);

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 660, 160));

        labelRect2.setBackground(new java.awt.Color(255, 255, 255));
        labelRect2.setForeground(new java.awt.Color(0, 0, 0));
        labelRect2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect2.setText("Seleccionar Archivo:");
        labelRect2.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect2.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 150, 30));

        labelRect3.setBackground(new java.awt.Color(255, 255, 255));
        labelRect3.setForeground(new java.awt.Color(0, 0, 0));
        labelRect3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect3.setText("Texto:");
        labelRect3.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect3.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 150, 30));

        labelRect4.setBackground(new java.awt.Color(255, 255, 255));
        labelRect4.setForeground(new java.awt.Color(0, 0, 0));
        labelRect4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect4.setText("Hora Asignacion (HH:MI:SS): ");
        labelRect4.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect4.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 230, 30));

        labelRect5.setBackground(new java.awt.Color(255, 255, 255));
        labelRect5.setForeground(new java.awt.Color(0, 0, 0));
        labelRect5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect5.setText("Nombre Archivo:");
        labelRect5.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect5.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 150, 30));

        labelRect7.setBackground(new java.awt.Color(255, 255, 255));
        labelRect7.setForeground(new java.awt.Color(0, 0, 0));
        labelRect7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect7.setText("Fecha Entrega: ");
        labelRect7.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect7.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 230, 30));

        btnModificar.setBackground(new java.awt.Color(0, 102, 153));
        btnModificar.setText("Modificar\n");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        panel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 390, 160, 40));

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblTabla);

        panel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 1070, 210));

        btnGuardar1.setBackground(new java.awt.Color(0, 102, 153));
        btnGuardar1.setText("Guardar\n");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });
        panel1.add(btnGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 390, 160, 40));

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        panel1.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 260, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea Regresar a la pagina Principal?", "YES-NO", YES_NO_OPTION);
        if (opcion == 0) {
            TareasAsignadas fpi = new TareasAsignadas();
            System.out.println("Desde boton regresar");
            System.out.println("Id estudiante " + id_estudiante);
            System.out.println("Id estudiantemateria " + idEstudianteMateria);
            System.out.println("Id docentemateria " + idDocenteMateria);
            fpi.setIdEstudiante(id_estudiante, idEstudianteMateria, idDocenteMateria);
            fpi.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            modificarTarea();
        } catch (Exception ex) {
            Logger.getLogger(FrmEntregarTarea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        try {
            // TODO add your handling code here:
            guardar();
        } catch (VacioExcepcion ex) {
            Logger.getLogger(FrmEntregarTarea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        seleccionar_tarea();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmEntregarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEntregarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEntregarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEntregarTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEntregarTarea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRect btnGuardar1;
    private org.edisoncor.gui.button.ButtonRect btnModificar;
    private org.edisoncor.gui.button.ButtonRect btnRegresar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private org.edisoncor.gui.label.LabelRect labelRect2;
    private org.edisoncor.gui.label.LabelRect labelRect3;
    private org.edisoncor.gui.label.LabelRect labelRect4;
    private org.edisoncor.gui.label.LabelRect labelRect5;
    private org.edisoncor.gui.label.LabelRect labelRect7;
    private org.edisoncor.gui.label.LabelRound labelRound1;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.PanelImage panelLogo;
    private javax.swing.JTable tblTabla;
    private javax.swing.JTextField txtFechaEntrega;
    private javax.swing.JTextField txtHoraEntrega;
    private javax.swing.JTextField txtNombreArchivo;
    private javax.swing.JTextArea txtTexto;
    // End of variables declaration//GEN-END:variables
}
