/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.listas;

import controlador.TDA.listas.LinkedList;
import javax.swing.JOptionPane;
import modelo.enums.Rol;
import modelo.persona.EstudianteController;
import vista.FrmInicio;
import vista.listas.tablas.ModeloTablaEstudiante;
import vista.listas.util.UtilVista;

/**
 *
 * @author Usuario iTC
 */
public class FrmEstudiante extends javax.swing.JDialog {

    
    //Objeto
    EstudianteController ec = new EstudianteController();
    ModeloTablaEstudiante mte = new ModeloTablaEstudiante();
    
    /**
     * Creates new form FrmEstudiante
     */
    
    public FrmEstudiante(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limpiar();
        this.setLocationRelativeTo(null);
    }
    
    public FrmEstudiante() {
        initComponents();
        limpiar();
        this.setLocationRelativeTo(null);
    }

    
    //Cargo mi tabla en la vista
    private void cargarTabla(){
        mte.setEstudiantes(ec.getEstudiantes());
        jTableEstudiante.setModel(mte);
        jTableEstudiante.updateUI();
    }
    
    //Verifico si el texto sin espacios esta vacio
    private boolean validar(){
        return !txtColegio.getText().trim().isEmpty();
               
    }
    
    //Cargar datos en la vista
    private void limpiar(){
        txtColegio.setText("");
        cbxPersona.setSelectedItem(-1);//Limpio Combo
        txtActividadEx.setText("");
        txtCertificaciones.setText("");
        txtProyectoA.setText("");
        txtReconocimientos.setText("");
        
        ec.setEstudiante(null);
        ec.setEstudiantes(new LinkedList<>());
        cargarTabla();
        //Actualizar tabla -BDD desaparece
        jTableEstudiante.clearSelection();
        ec.setIndex(-1);
         try {
            UtilVista.cargarPersonaEstudiante(cbxPersona, Rol.Estudiante);
        } catch (Exception e) {
        }
    }

    
    //Guardo la informacion 
    private void guardar(){
        if(validar()){
            try {
                ec.getEstudiante().setColegioAnterior(txtColegio.getText());
                ec.getEstudiante().setId_Persona(UtilVista.getComboPersonaEstudiante(cbxPersona).getId()); 
                ec.getEstudiante().setActividadExtracurricular(txtActividadEx.getText());
                ec.getEstudiante().setProyectosAcademicos(txtProyectoA.getText());
                ec.getEstudiante().setReconocimientos(txtReconocimientos.getText());
                ec.getEstudiante().setCertificaciones(txtCertificaciones.getText());
                //Guardar
                if(ec.getEstudiante().getId() == null){
                   if(ec.save()){
                    limpiar();
                        JOptionPane.showMessageDialog(null, "Se ha guardado correctamente", 
                            "OK", JOptionPane.INFORMATION_MESSAGE);
                   
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha podido guardar", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    } 
                }else{
                    if(ec.update(ec.getIndex())){
                    limpiar();
                        JOptionPane.showMessageDialog(null, "Se ha editado correctamente", 
                            "OK", JOptionPane.INFORMATION_MESSAGE);
                   
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha podido editar", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    } 
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage() , 
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Llene todos los campos", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    
    private void cargarVista(){
        
        //Cargo-modifico-envio
        ec.setIndex(jTableEstudiante.getSelectedRow());
        if(ec.getIndex().intValue() < 0){
            JOptionPane.showMessageDialog(null, "Selecciona una fila", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                ec.setEstudiante(mte.getEstudiantes().get(ec.getIndex()));
                txtColegio.setText(ec.getEstudiante().getColegioAnterior());
                cbxPersona.setSelectedItem(UtilVista.getComboPersonaEstudiante(cbxPersona));
                txtActividadEx.setText(ec.getEstudiante().getActividadExtracurricular());
                txtProyectoA.setText(ec.getEstudiante().getProyectosAcademicos());
                txtReconocimientos.setText(ec.getEstudiante().getReconocimientos());
                txtCertificaciones.setText(ec.getEstudiante().getCertificaciones());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxPersona = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtColegio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEstudiante = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCertificaciones = new javax.swing.JTextField();
        txtActividadEx = new javax.swing.JTextField();
        txtProyectoA = new javax.swing.JTextField();
        txtReconocimientos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro Estudiante");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 190, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel4.setText("Estudiante:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 130, 20));

        cbxPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 240, -1));

        jLabel10.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel10.setText("Certificaciones: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 170, 40));

        txtColegio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColegioActionPerformed(evt);
            }
        });
        jPanel1.add(txtColegio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 240, -1));

        jTableEstudiante.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableEstudiante);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 970, 110));

        btnGuardar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 170, -1));

        btnLimpiar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnLimpiar.setText("Seleccionar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 170, -1));

        jButton1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, 170, -1));

        jButton2.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, 170, -1));

        btnRegresar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 570, 170, 30));

        jLabel11.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel11.setText("Institución Graudado/a:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 220, 40));

        jLabel12.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel12.setText("Actividad Extracurricular: ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 240, 40));

        jLabel13.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel13.setText("Proyectos Academicos: ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 240, 40));

        jLabel14.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel14.setText("Reconocimientos: ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 170, 40));
        jPanel1.add(txtCertificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 240, -1));
        jPanel1.add(txtActividadEx, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 240, -1));
        jPanel1.add(txtProyectoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 240, -1));
        jPanel1.add(txtReconocimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtColegioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColegioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColegioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cargarVista();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmInicio newFrame = new FrmInicio();
        newFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmEstudiante dialog = new FrmEstudiante(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxPersona;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEstudiante;
    private javax.swing.JTextField txtActividadEx;
    private javax.swing.JTextField txtCertificaciones;
    private javax.swing.JTextField txtColegio;
    private javax.swing.JTextField txtProyectoA;
    private javax.swing.JTextField txtReconocimientos;
    // End of variables declaration//GEN-END:variables
}
