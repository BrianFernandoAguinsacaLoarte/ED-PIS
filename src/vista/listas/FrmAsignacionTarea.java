/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.listas;

import controlador.ControladorTarea;
import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import controlador.dao.AdaptadorDao;
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
import modelo.Tarea;
import vista.tablas.ModeloTablaTarea;

public class FrmAsignacionTarea extends javax.swing.JFrame {

    private ControladorTarea tarCon = new ControladorTarea();
    private ModeloTablaTarea mtll = new ModeloTablaTarea();
    String ruta_archivo = "";
    int id = -1;
    private String extensionArchivo;

    /**
     * Creates new form FrmAsignacionTarea
     */
    public FrmAsignacionTarea() throws VacioExcepcion {
        initComponents();
        limpiar();
        this.setLocationRelativeTo(null);
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String fechaActual = dateFormat.format(calendar.getTime());
        txtFechaAsignacion.setText(fechaActual);

        SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
        String horaActual = horaFormat.format(calendar.getTime());
        txtHoraAsignacion.setText(horaActual);
        
        mtll.visualizar(tblTabla);
    }

    public Boolean validar() {
        return !txtTema.getText().trim().isEmpty()
                && !txtFechaAsignacion.getText().trim().isEmpty()
                && !txtHoraAsignacion.getText().trim().isEmpty()
                && !txtFechaEntrega.getText().trim().isEmpty()
                && !txtHoraEntrega.getText().trim().isEmpty()
                && !txtDescripcion.getText().trim().isEmpty();
    }


    private void limpiar() throws VacioExcepcion {

        txtTema.setText("");
        txtFechaAsignacion.setText("");
        txtFechaEntrega.setText("");
        txtHoraAsignacion.setText("");
        txtHoraEntrega.setText("");
        txtDescripcion.setText("");
        tarCon.setTarea(null);
        tarCon.setLista(new LinkedList<>());
//        cargarTabla();
//        tarCon.setTarea(null);
//        tarCon.setIndex(-1);
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
                Tarea tarea = new Tarea();
                tarea.setTema(txtTema.getText());

                // Convertir las cadenas de fecha y hora a objetos Date
//                SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                String fechaAsignacionString = txtFechaAsignacion.getText() + " " + txtHoraAsignacion.getText();
                String fechaEntregaString = txtFechaEntrega.getText() + " " + txtHoraEntrega.getText();

//                String fechaAsignacionString = txtFechaAsignacion.getText();
//                String fechaEntregaString = txtFechaEntrega.getText();
                Date fechaAsignacion = formatoFechaHora.parse(fechaAsignacionString);
                Date fechaEntrega = formatoFechaHora.parse(fechaEntregaString);

                tarea.setFechaCreacion(fechaAsignacion);
                tarea.setFechaEntrega(fechaEntrega);
                tarea.setDescripcion(txtDescripcion.getText());
//                tarea.setArchivo(null);
//                tarea.setExtensionArchivo("pdf");
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
//                tarea.setExtensionArchivo("pdf");
                String extenArchivo = extensionArchivo;
                tarea.setExtensionArchivo(extenArchivo);
                tarCon.setTarea(tarea);
                tarCon.guardar();
                tarCon.setTarea(null);

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
                Tarea tarea = new Tarea();
                tarea.setId(id);
                tarea.setTema(txtTema.getText());

                // Convertir las cadenas de fecha y hora a objetos Date
                SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                String fechaAsignacionString = txtFechaAsignacion.getText() + " " + txtHoraAsignacion.getText();
                String fechaEntregaString = txtFechaEntrega.getText() + " " + txtHoraEntrega.getText();

                Date fechaAsignacion = formatoFechaHora.parse(fechaAsignacionString);
                Date fechaEntrega = formatoFechaHora.parse(fechaEntregaString);

                tarea.setFechaCreacion(fechaAsignacion);
                tarea.setFechaEntrega(fechaEntrega);
                tarea.setDescripcion(txtDescripcion.getText());

                if (!ruta_archivo.isEmpty()) {
                    File ruta = new File(ruta_archivo);
                    if (ruta.exists()) {
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
                    } else {
                        JOptionPane.showMessageDialog(null, "El archivo no existe en la ruta especificada.");
                        return;
                    }
                }

                String extenArchivo = extensionArchivo;
                tarea.setExtensionArchivo(extenArchivo);

                tarCon.setTarea(tarea);
                tarCon.modificar(tarea);
                tarCon.setTarea(null);

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        txtTema = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        calendarioEntrega = new com.toedter.calendar.JDateChooser();
        txtHoraEntrega = new javax.swing.JTextField();
        txtFechaAsignacion = new javax.swing.JTextField();
        calendarioAsignacion = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        txtHoraAsignacion = new javax.swing.JTextField();
        txtFechaEntrega = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Asignar Tarea");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 24, -1, -1));

        jLabel2.setText("Tema:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel3.setText("Seleccionar Archivo: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 121, -1));
        getContentPane().add(txtTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 184, -1));

        jLabel4.setText("Descripcion:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel5.setText("Hora Asignacion (HH:MI:SS): ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        jLabel6.setText("Fecha Entrega: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        jLabel7.setText("Hora Entrega  (HH:MI:SS): ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, -1));

        calendarioEntrega.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarioEntregaPropertyChange(evt);
            }
        });
        getContentPane().add(calendarioEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 140, -1));
        getContentPane().add(txtHoraEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 153, -1));
        getContentPane().add(txtFechaAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 153, -1));

        calendarioAsignacion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarioAsignacionPropertyChange(evt);
            }
        });
        getContentPane().add(calendarioAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 83, 150, -1));

        jLabel8.setText("Fecha Asignacion: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 180, 96));

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tema", "Fecha Asignacion", "Fecha Entrega", "Archivo", "Extension"
            }
        ));
        tblTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTabla);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 640, 120));
        getContentPane().add(txtHoraAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 153, -1));
        getContentPane().add(txtFechaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 153, -1));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, -1, -1));

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calendarioAsignacionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarioAsignacionPropertyChange
        // TODO add your handling code here:
        if (calendarioAsignacion.getDate() != null) {
            SimpleDateFormat fc = new SimpleDateFormat("dd-MM-yyyy");
            txtFechaAsignacion.setText(fc.format(calendarioAsignacion.getDate()));
        }
    }//GEN-LAST:event_calendarioAsignacionPropertyChange

    private void calendarioEntregaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarioEntregaPropertyChange
        // TODO add your handling code here:
        if (calendarioEntrega.getDate() != null) {
            SimpleDateFormat fc = new SimpleDateFormat("dd-MM-yyyy");
            txtFechaEntrega.setText(fc.format(calendarioEntrega.getDate()));
        }
    }//GEN-LAST:event_calendarioEntregaPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            guardar();
        } catch (VacioExcepcion ex) {
            Logger.getLogger(FrmAsignacionTarea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        seleccionar_tarea();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void tblTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaMouseClicked
        // TODO add your handling code here:
        int column = tblTabla.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblTabla.getRowHeight();

        txtTema.setEnabled(true);
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
            } else {
                String tema = "" + tblTabla.getValueAt(row, 1);
                txtTema.setText(tema);

                String fechaCreacion = "" + tblTabla.getValueAt(row, 3);
                txtFechaAsignacion.setText(fechaCreacion);

                String fechaEntrega = "" + tblTabla.getValueAt(row, 4);
                txtFechaEntrega.setText(fechaEntrega);

                String descripcion = "" + tblTabla.getValueAt(row, 2);
                txtDescripcion.setText(descripcion);

                Tarea tarea = new Tarea();
                tarea.setId(id);
               
                Date fechCompleta = tarea.getFechaEntrega();
                System.out.println("fehca completa : " + fechCompleta);
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String fechaComoString = formatoFecha.format(fechCompleta);
                String horaAsignacion = fechaComoString.substring(11, 19);
                System.out.println(horaAsignacion);
                txtHoraEntrega.setText(horaAsignacion);

            }
        }
    }//GEN-LAST:event_tblTablaMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            modificarTarea();
        } catch (Exception ex) {
            Logger.getLogger(FrmAsignacionTarea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAsignacionTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAsignacionTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAsignacionTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAsignacionTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmAsignacionTarea().setVisible(true);
                } catch (VacioExcepcion ex) {
                    Logger.getLogger(FrmAsignacionTarea.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private com.toedter.calendar.JDateChooser calendarioAsignacion;
    private com.toedter.calendar.JDateChooser calendarioEntrega;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTabla;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFechaAsignacion;
    private javax.swing.JTextField txtFechaEntrega;
    private javax.swing.JTextField txtHoraAsignacion;
    private javax.swing.JTextField txtHoraEntrega;
    private javax.swing.JTextField txtTema;
    // End of variables declaration//GEN-END:variables
}
