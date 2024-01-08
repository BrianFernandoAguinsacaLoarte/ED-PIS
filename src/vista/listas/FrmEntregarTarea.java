/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.listas;

import controlador.ControladorEntregaTarea;
import controlador.ControladorTarea;
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
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.EntregaTarea;
import vista.listas.tablas.ModeloTablaEntregaTarea;

/**
 *
 * @author juanc
 */
public class FrmEntregarTarea extends javax.swing.JFrame {

    private Integer id_docente;
    private ControladorEntregaTarea tarCon = new ControladorEntregaTarea();
    private ModeloTablaEntregaTarea mtll = new ModeloTablaEntregaTarea();
    String ruta_archivo = "";
    int id = -1;
    private String extensionArchivo;

    /**
     * Creates new form EntregaTarea
     */
    public FrmEntregarTarea() throws VacioExcepcion {
        initComponents();
        limpiar();
        System.out.println("Id docente en frm entregaTarea = " + id_docente);
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String fechaActual = dateFormat.format(calendar.getTime());
        txtFechaEntrega.setText(fechaActual);
        txtFechaEntrega.setEnabled(false);

        SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
        String horaActual = horaFormat.format(calendar.getTime());
        txtHoraEntrega.setText(horaActual);
        txtHoraEntrega.setEnabled(false);

        mtll.visualizar(tblTabla);
    }

    public Boolean validar() {
        return !txtNombreArchivo.getText().trim().isEmpty();
    }

    private void limpiar() throws VacioExcepcion {
        System.out.println("Id tarea: " + id_docente);
        txtNombreArchivo.setText("");
        txtTexto.setText("");
        tarCon.setEntregaTarea(null);
        tarCon.setLista(new LinkedList<>());
        mtll.visualizar(tblTabla);
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
                Integer id_tarea = id_docente;
                EntregaTarea tarea = new EntregaTarea();
                tarea.setNombreTarea(txtNombreArchivo.getText());
                SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String fechaAsignacionString = txtFechaEntrega.getText() + " " + txtHoraEntrega.getText();
                Date fechaAsignacion = formatoFechaHora.parse(fechaAsignacionString);
                tarea.setFechaEntrega(fechaAsignacion);
                tarea.setTextoTarea(txtTexto.getText());
                File ruta = new File(ruta_archivo);
                try {
                    byte[] archivo = new byte[(int) ruta.length()];
                    InputStream input = new FileInputStream(ruta);
                    input.read(archivo);
                    Blob blobArchivo = new SerialBlob(archivo);
                    tarea.setArchivoTarea(blobArchivo);
                } catch (IOException | SQLException ex) {
                    tarea.setArchivoTarea(null);
                    System.out.println("Error al agregar archivo " + ex.getMessage());
                }
                String extenArchivo = extensionArchivo;
                tarea.setExtensionTarea(extenArchivo);
                System.out.println("Id tarea = " + id_tarea);
                tarea.setId_tarea(id_tarea);
//                tarea.setEstadoEntrega("Entregado");
                tarCon.setEntregaTarea(tarea);
                tarCon.guardar();
                tarCon.setEntregaTarea(null);
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
                EntregaTarea tarea = new EntregaTarea();
                tarea.setId(id);
                tarea.setNombreTarea(txtNombreArchivo.getText());

                SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                String fechaAsignacionString = txtFechaEntrega.getText() + " " + txtHoraEntrega.getText();
                Date fechaAsignacion = formatoFechaHora.parse(fechaAsignacionString);

                tarea.setFechaEntrega(fechaAsignacion);
                tarea.setTextoTarea(txtTexto.getText());

                if (!ruta_archivo.isEmpty()) {
                    File ruta = new File(ruta_archivo);
                    if (ruta.exists()) {
                        try {
                            byte[] archivo = new byte[(int) ruta.length()];
                            InputStream input = new FileInputStream(ruta);
                            input.read(archivo);
                            Blob blobArchivo = new SerialBlob(archivo);
                            tarea.setArchivoTarea(blobArchivo);
                        } catch (IOException | SQLException ex) {
                            tarea.setArchivoTarea(null);
                            System.out.println("Error al agregar archivo " + ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El archivo no existe en la ruta especificada.");
                        return;
                    }
                }

                String extenArchivo = extensionArchivo;
                tarea.setExtensionTarea(extenArchivo);
                tarea.setId_tarea(id_docente);
                tarCon.setEntregaTarea(tarea);
                tarCon.modificar(tarea);
                tarCon.setEntregaTarea(null);

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

        calendarioAsignacion = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtFechaAsignacion = new javax.swing.JTextField();
        txtHoraAsignacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreArchivo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtFechaEntrega = new javax.swing.JTextField();
        txtHoraEntrega = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        calendarioAsignacion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarioAsignacionPropertyChange(evt);
            }
        });

        jLabel8.setText("Fecha Asignacion: ");

        jLabel5.setText("Hora Asignacion (HH:MI:SS): ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Entrega Tarea");

        jLabel2.setText("Nombre Archivo:");

        jLabel3.setText("Seleccionar Archivo:");

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        jLabel9.setText("Fecha Entrega: ");

        jLabel6.setText("Hora Asignacion (HH:MI:SS): ");

        txtTexto.setColumns(20);
        txtTexto.setRows(5);
        jScrollPane1.setViewportView(txtTexto);

        jLabel4.setText("Texto");

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
        tblTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTabla);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jButton1)
                        .addGap(101, 101, 101)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(93, 93, 93))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(28, 28, 28)
                                        .addComponent(txtNombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFechaEntrega))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHoraEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39)))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(btnSeleccionar)
                            .addComponent(jLabel6)
                            .addComponent(txtHoraEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        seleccionar_tarea();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void calendarioAsignacionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarioAsignacionPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_calendarioAsignacionPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            guardar();
        } catch (VacioExcepcion ex) {
            Logger.getLogger(FrmEntregarTarea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            modificarTarea();
        } catch (Exception ex) {
            Logger.getLogger(FrmAsignacionTarea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaMouseClicked
        // TODO add your handling code here:
        int column = tblTabla.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblTabla.getRowHeight();

        if (row < tblTabla.getRowCount() && row >= 0 && column < tblTabla.getColumnCount() && column >= 0) {
            id = (int) tblTabla.getValueAt(row, 0);
            Object value = tblTabla.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getText().equals("Vacio")) {
                    JOptionPane.showMessageDialog(null, "No hay archivo");
                } else {
                    ControladorTarea pd = new ControladorTarea();
                }
            }
        }
    }//GEN-LAST:event_tblTablaMouseClicked

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmEntregarTarea().setVisible(true);
                } catch (VacioExcepcion ex) {
                    Logger.getLogger(FrmEntregarTarea.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private com.toedter.calendar.JDateChooser calendarioAsignacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTabla;
    private javax.swing.JTextField txtFechaAsignacion;
    private javax.swing.JTextField txtFechaEntrega;
    private javax.swing.JTextField txtHoraAsignacion;
    private javax.swing.JTextField txtHoraEntrega;
    private javax.swing.JTextField txtNombreArchivo;
    private javax.swing.JTextArea txtTexto;
    // End of variables declaration//GEN-END:variables

    public Integer getId_docente() {
        return id_docente;
    }

    public void setId_docente(Integer id_docente) {
        this.id_docente = id_docente;
        System.out.println("Id docente en frm entregaTarea = " + id_docente);
    }
}
