/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.Excepcion.VacioExcepcion;
import controlador.MatriculaController;
import controlador.TDA.listas.LinkedList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import modelo.persona.EstudianteController;
import vista.listas.FrmBuscarEstudiante;
import vista.listas.tablas.ModeloTablaMatricula;
import vista.listas.util.UtilVista;

/**
 *
 * @author Usuario
 */
public class FrmMatricula extends javax.swing.JFrame {

    MatriculaController mc = new MatriculaController();
    ModeloTablaMatricula ml = new ModeloTablaMatricula();
    EstudianteController ec = new EstudianteController();
    
    /**
     * Creates new form FrmMatricula
     */
    public FrmMatricula() {
        initComponents();
        limpiarCampos();
        cerrar();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String fechaActual = dateFormat.format(calendar.getTime());
        txtFechaAsignacion.setText(fechaActual);
        
    }
    
    private void cargarTabla(){
        ml.setLista(mc.listAll());
        tblTabla.setModel(ml);
        tblTabla.updateUI();
        
    }
    
    private void limpiarCampos() {
        txtEstudiante.setText("");
        txtEstudiante.setEnabled(false);
        mc.setMatricula(null);
        mc.setMatriculas(new LinkedList<>());
        cargarTabla();
        tblTabla.clearSelection();
        mc.setIndex(-1);
        cbxCurso.removeAllItems();
        cbxMaterias.removeAllItems();
        cbxPeriodo.removeAllItems();
        try {
            UtilVista.cargarMateria(cbxMaterias);
            cbxMaterias.setVisible(true);
            UtilVista.cargarPeriodoAcademico(cbxPeriodo);
            cbxPeriodo.setVisible(true);
        } catch (Exception e) {
        }
        
    }
    
    private void agregarmateria(){
        mc.getMatricula().setMateria(UtilVista.getComboMateria(cbxMaterias));
    }
    private void guardar(){
        Estudiante es = null;
            try {
                
//                SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd-MM-yyyy");
//
//                String fechaAsignacionString = txtFechaAsignacion.getText();
//                Date fechaAsignacion = formatoFechaHora.parse(fechaAsignacionString);
                
                es = ec.buscarEstudiantePorNombre(txtEstudiante.getText());
                mc.getMatricula().setEstudiante(es);
                mc.getMatricula().setCurso(null);
//                mc.getMatricula().setFechaMatricula(fechaAsignacion);
//                mc.getMatricula().setMateria(UtilVista.getComboMateria(cbxMaterias));
//                mc.getMatricula().setP_academico(UtilVista.getComboPeriodoAcademico(cbxPeriodo));
//                mc.getMatricula().setFechaMatricula(fechaAsignacion);
                mc.save();
                
              
                
//                if (mc.getMatricula().getId() == null) {
//                if(mc.save()){
////                    cargarTabla();
//                    limpiarCampos();
//                    JOptionPane.showMessageDialog(null, "Se ha guardado correctamente", "Error", JOptionPane.INFORMATION_MESSAGE);
//                    
//                    
//                } else {
//                    JOptionPane.showMessageDialog(null, "No se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);
//                    
//                }
//                }else{
//                    if (mc.update(mc.getIndex())) {
//                        limpiarCampos();
//                        JOptionPane.showMessageDialog(null,
//                                "Se Modifico correctamente",
//                                "Mensaje",
//                                JOptionPane.INFORMATION_MESSAGE);
//
//                    } else {
//                        JOptionPane.showMessageDialog(null,
//                                "Error al Modificar",
//                                "Error",
//                                JOptionPane.ERROR_MESSAGE);
//                    }
//
//                }
                
        

            } catch (Exception e) {
                System.out.println("Error Inesperado");
            }
//         else {
//            JOptionPane.showMessageDialog(null,
//                    "Llene todos los campos",
//                    "Error",
//                    JOptionPane.ERROR_MESSAGE);
//        }
    
    
    }
    
    public void cerrar(){
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(
               new WindowAdapter() {
                  public void windowClosing(WindowEvent e){
                      confirmarSalida();
                  }
               }
            );
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   public void confirmarSalida(){
            this.setVisible(false);
            System.exit(0);
        }
   
   public static void cargarEstudiante(Estudiante estudiante) throws VacioExcepcion{
       EstudianteController ec = new EstudianteController(); 
       String nombrePersona = ec.obtenerNombre(estudiante.getId_Persona());
       txtEstudiante.setText(nombrePersona);
   }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEstudiante = new javax.swing.JTextField();
        btnElegir = new javax.swing.JButton();
        cbxMaterias = new javax.swing.JComboBox<>();
        cbxCurso = new javax.swing.JComboBox<>();
        cbxPeriodo = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        CalendarioFecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtFechaAsignacion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        btnGuardar.setText("Guardar Matrícula");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(btnGuardar)
                .addGap(86, 86, 86)
                .addComponent(btnCancelar)
                .addContainerGap(230, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Matrícula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Estudiante:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 45, 60, -1));

        jLabel3.setText("Materias:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 60, -1));

        jLabel4.setText("Curso:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel5.setText("Periodo :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));
        jPanel3.add(txtEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 220, -1));

        btnElegir.setText("Elegir");
        btnElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirActionPerformed(evt);
            }
        });
        jPanel3.add(btnElegir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 70, -1));

        cbxMaterias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbxMaterias, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 220, -1));

        cbxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbxCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 220, -1));

        cbxPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbxPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 200, -1));

        btnAgregar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Desktop\\mas.png")); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 40, 30));

        btnQuitar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Desktop\\menos.png")); // NOI18N
        jPanel3.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 30, 30));

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
        jScrollPane1.setViewportView(tblTabla);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 650, 310));

        CalendarioFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CalendarioFechaPropertyChange(evt);
            }
        });
        jPanel3.add(CalendarioFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 160, -1));

        jLabel2.setText("Fecha Matricula:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 100, -1));
        jPanel3.add(txtFechaAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 170, -1));

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed
        new FrmBuscarEstudiante().setVisible(true);
    }//GEN-LAST:event_btnElegirActionPerformed

    private void CalendarioFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CalendarioFechaPropertyChange
        if (CalendarioFecha.getDate() != null) {
            SimpleDateFormat fc = new SimpleDateFormat("dd-MM-yyyy");
            txtFechaAsignacion.setText(fc.format(CalendarioFecha.getDate()));
        }
    }//GEN-LAST:event_CalendarioFechaPropertyChange

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregarmateria();
        tblTabla.updateUI();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMatricula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser CalendarioFecha;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnElegir;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxMaterias;
    private javax.swing.JComboBox<String> cbxPeriodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTabla;
    private static javax.swing.JTextField txtEstudiante;
    private javax.swing.JTextField txtFechaAsignacion;
    // End of variables declaration//GEN-END:variables
}
