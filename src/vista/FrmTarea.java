/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.Conexion.SQL;
import controlador.dao.Tarea.TareaDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.Tarea;
import vista.tablas.ModeloTablaTarea;

/**
 *
 * @author Jhostin
 */
public class FrmTarea extends javax.swing.JFrame {

    /**
     * Creates new form FrmTarea
     */
    
    ModeloTablaTarea mtt = new ModeloTablaTarea();
    String ruta_archivo = "";
    int id = -1;
    private String extensionArchivo;
    
    public FrmTarea() {
        initComponents();
        limpiar();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = dateFormat.format(calendar.getTime());

        txtCreacion.setText(fechaActual);

        mtt.visualizar(tabla);
    }

    
    public Boolean validar() {
        return
                !txtTema.getText().trim().isEmpty()
                && !txtEntrega.getText().trim().isEmpty()
                && !txtCreacion.getText().trim().isEmpty()
                && !txtDescripcion.getText().trim().isEmpty();
    }
    
    public void limpiar() {
        txtTema.setText("");
        btnseleccionar.setText("Seleccionar");
        txtCreacion.setText("");
        txtEntrega.setText("");
        txtDescripcion.setText("");
        imagen.setIcon(null); 
        txtNombreFile.setText(""); 
        calendarioCreacion.setDate(null);  
        calendarioEntrega.setDate(null);  
    }
    
    public void guardar_tarea(int id, String tema, String descripcion, String fechaCreacion, String fechaEntrega, File ruta, String extensionArchivo) {
        TareaDAO ta = new TareaDAO();
        Tarea to = new Tarea();
        to.setId(id);
        to.setTema(tema);
        to.setDescripcion(descripcion); 
        to.setFechaCreacion(fechaCreacion);
        to.setFechaEntrega(fechaEntrega);
        to.setExtensionArchivo(extensionArchivo);
        try {
            byte[] archivo = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(archivo);
            Blob blobArchivo = new SerialBlob(archivo);
            to.setArchivo(blobArchivo);
        } catch (IOException | SQLException ex) {
            to.setArchivo(null);
            System.out.println("Error al agregar archivo " + ex.getMessage());
        }
        ta.Agregar_Archivo(to);
        limpiar();
    }
    
    public void guardar_tarea2(int id, String tema, String descripcion, String fechaCreacion, String fechaEntrega) {
        TareaDAO ta = new TareaDAO();
        Tarea to = new Tarea();
        to.setId(id);
        to.setTema(tema);
        to.setDescripcion(descripcion); 
        to.setFechaCreacion(fechaCreacion);
        to.setFechaEntrega(fechaEntrega);
        to.setExtensionArchivo(null);
        to.setArchivo(null);
        ta.Agregar_Archivo(to);
        limpiar();
    }
    
    public void modificar_tarea(int id, String tema, String descripcion, String fechaCreacion, String fechaEntrega, File ruta, String extensionArchivo) throws SQLException {
        TareaDAO ta = new TareaDAO();
        Tarea to = new Tarea();
        to.setId(id);
        to.setTema(tema);
        to.setDescripcion(descripcion); 
        to.setFechaCreacion(fechaCreacion);
        to.setFechaEntrega(fechaEntrega);
        to.setExtensionArchivo(extensionArchivo);
        try {
            byte[] archivo = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(archivo);
            Blob blobArchivo = new SerialBlob(archivo);
            to.setArchivo(blobArchivo);
        } catch (IOException | SQLException ex) {
            to.setArchivo(null);
            System.out.println("Error al agregar archivo " + ex.getMessage());
        }
        ta.Modificar_Archivo(to);
        limpiar();
    }
    
    public void modificar_tarea(int id, String tema, String descripcion, String fechaCreacion, String fechaEntrega, String extensionArchivo) {
        TareaDAO ta = new TareaDAO();
        Tarea to = new Tarea();
        to.setId(id);
        to.setTema(tema);
        to.setDescripcion(descripcion);
        to.setFechaCreacion(fechaCreacion);
        to.setFechaEntrega(fechaEntrega);
        to.setExtensionArchivo(extensionArchivo);
        ta.Modificar_Archivo2(to);
        limpiar();
    }
    
    public void eliminar_tarea(int id) {
        TareaDAO ta = new TareaDAO();
        Tarea to = new Tarea();
        to.setId(id);
        ta.Eliminar_Archivo(to);
    }
    
    
    public void seleccionar_tarea() {
        JFileChooser j = new JFileChooser();

        int se = j.showOpenDialog(this);
        if (se == 0) {
            this.btnseleccionar.setText("" + j.getSelectedFile().getName());
            ruta_archivo = j.getSelectedFile().getAbsolutePath();
            String nombre_archivo = j.getSelectedFile().getName();

            // Obtener la extensión del archivo seleccionado
            String extension = nombre_archivo.substring(nombre_archivo.lastIndexOf(".") + 1);

            txtNombreFile.setText(nombre_archivo);
            extensionArchivo = extension;

            System.out.println("Extensión del archivo: " + extension);

          // presentarIcono(extension);
        } else {
        }
    }
    
//    public void presentarIcono(String extension) {
//        String rutaImagen = " ";
//        switch (extension) {
//            case "pdf":
//                rutaImagen = "/imgs/pdf.png";
//                break;
//            case "docx":
//                rutaImagen = "/imgs/docx.png";
//                break;
//            case "rar":
//                rutaImagen = "/imgs/rar.png";
//                break;
//            case "zip":
//                rutaImagen = "/imgs/zip.png";
//                break;
//            case "jpg":
//                rutaImagen = "/imgs/jpg.png";
//                break;
//            case "png":
//                rutaImagen = "/imgs/png.png";
//                break;
//            case "xlsx":
//                rutaImagen = "/imgs/excel.png";
//                break;
//            default:
//                rutaImagen = "/imgs/archivo.png";
//                break;
//        }
//
//        ImageIcon icono = new ImageIcon(getClass().getResource(rutaImagen));
//        imagen.setIcon(icono);
//    }
//    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEntrega = new javax.swing.JTextField();
        btnseleccionar = new javax.swing.JButton();
        calendarioEntrega = new com.toedter.calendar.JDateChooser();
        calendarioCreacion = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtTema = new javax.swing.JTextField();
        txtCreacion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        imagen = new javax.swing.JLabel();
        txtNombreFile = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("TAREA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jLabel2.setText("Tema:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 66, -1, -1));

        jLabel3.setText("Seleccionar Archivo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));

        jLabel4.setText("Fecha Entrega:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        jLabel5.setText("Fecha Creacion:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        jLabel6.setText("Descripcion:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));
        jPanel1.add(txtEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 130, -1));

        btnseleccionar.setText("Seleccionar");
        btnseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseleccionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnseleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 93, 110, 30));

        calendarioEntrega.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarioEntregaPropertyChange(evt);
            }
        });
        jPanel1.add(calendarioEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 120, -1));

        calendarioCreacion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarioCreacionPropertyChange(evt);
            }
        });
        jPanel1.add(calendarioCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 120, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 230, 90));
        jPanel1.add(txtTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 160, -1));
        jPanel1.add(txtCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 130, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtNombreFile.setText("...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(txtNombreFile, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(txtNombreFile)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 230, 70));

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Tema", "Descripcion", "Fecha Creacion", "Fecha Entrega", "Archivo"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 670, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        String tema = txtTema.getText();
        String descripcion = txtDescripcion.getText();
        String fechaCreacion = txtCreacion.getText();
        String fechaEntrega = txtEntrega.getText();
        String extenArchivo = extensionArchivo;
        SQL s = new SQL();
        int id = s.auto_increment("SELECT MAX(id) FROM tarea;");
        File ruta = new File(ruta_archivo);
        if (validar() && ruta_archivo.trim().length() != 0) {
            guardar_tarea(id, tema, descripcion, fechaCreacion, fechaEntrega, ruta, extenArchivo);
            mtt.visualizar(tabla);
            ruta_archivo = "";
        } else if (validar()) {
            guardar_tarea2(id, tema, descripcion, fechaCreacion, fechaEntrega);
            mtt.visualizar(tabla);
        } else {
            JOptionPane.showMessageDialog(null, "Rellenar todo los campos");
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        
        String tema = txtTema.getText();
        String descripcion = txtDescripcion.getText();
        String fechaCreacion = txtCreacion.getText();
        String fechaEntrega = txtEntrega.getText();
        String extenArchivo = extensionArchivo;

        File ruta = new File(ruta_archivo);
        try {
            if (tema.trim().length() != 0 && ruta_archivo.trim().length() != 0) {
                modificar_tarea(id, tema, descripcion, fechaCreacion, fechaEntrega, ruta, extenArchivo);
                mtt.visualizar(tabla);
            } else if (ruta_archivo.trim().length() == 0) {
                modificar_tarea(id, tema, descripcion, fechaCreacion, fechaEntrega, extenArchivo);
                mtt.visualizar(tabla);
            }
            ruta_archivo = "";

        } catch (SQLException ex) {
           
            System.out.println("Error al modificar " + ex.getMessage());
        }
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

        eliminar_tarea(id);
        mtt.visualizar(tabla);
        ruta_archivo = "";
    }//GEN-LAST:event_btneliminarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        
        int column = tabla.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tabla.getRowHeight();

        txtTema.setEnabled(true);
        if (row < tabla.getRowCount() && row >= 0 && column < tabla.getColumnCount() && column >= 0) {
            id = (int) tabla.getValueAt(row, 0);
            Object value = tabla.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getText().equals("Vacio")) {
                    JOptionPane.showMessageDialog(null, "No hay archivo");
                } else {
                    TareaDAO pd = new TareaDAO();
                }
            } else {
                String tema = "" + tabla.getValueAt(row, 1);
                txtTema.setText(tema);

                String fechaCreacion = "" + tabla.getValueAt(row, 3);
                txtCreacion.setText(fechaCreacion);

                String fechaEntrega = "" + tabla.getValueAt(row, 4);
                txtEntrega.setText(fechaEntrega);

                String descripcion = "" + tabla.getValueAt(row, 2);
                txtDescripcion.setText(descripcion);
            }
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void btnseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseleccionarActionPerformed
        // TODO add your handling code here:
        seleccionar_tarea();
    }//GEN-LAST:event_btnseleccionarActionPerformed

    private void calendarioCreacionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarioCreacionPropertyChange
        // TODO add your handling code here:
        if (calendarioCreacion.getDate() != null) {
            SimpleDateFormat fc = new SimpleDateFormat("dd/MM/yyyy");
            txtCreacion.setText(fc.format(calendarioCreacion.getDate()));
        }
    }//GEN-LAST:event_calendarioCreacionPropertyChange

    private void calendarioEntregaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarioEntregaPropertyChange
        // TODO add your handling code here:
         if (calendarioEntrega.getDate() != null) {
            SimpleDateFormat fe = new SimpleDateFormat("dd/MM/yyyy");
            txtEntrega.setText(fe.format(calendarioEntrega.getDate()));
        }
    }//GEN-LAST:event_calendarioEntregaPropertyChange

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
            java.util.logging.Logger.getLogger(FrmTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTarea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnseleccionar;
    private com.toedter.calendar.JDateChooser calendarioCreacion;
    private com.toedter.calendar.JDateChooser calendarioEntrega;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCreacion;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtEntrega;
    private javax.swing.JLabel txtNombreFile;
    private javax.swing.JTextField txtTema;
    // End of variables declaration//GEN-END:variables
}
