/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.listas;

import controlador.TDA.listas.LinkedList;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import modelo.enums.Rol;
import modelo.persona.CursaController;
import vista.FrmInicio;
import vista.listas.tablas.ModeloTablaCursa;
import vista.listas.util.UtilVista;

/**
 *
 * @author Usuario iTC
 */
public class FrmCursa extends javax.swing.JDialog {
    
    //Objetos
    CursaController cc = new CursaController();
    ModeloTablaCursa mtc = new ModeloTablaCursa();
    LinkedList<Estudiante> estudiantes = new LinkedList<>();
    
    
    /**
     * Creates new form FrmCursa
     */
    public FrmCursa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limpiar();
        this.setLocationRelativeTo(null);
    }
    
    
    public FrmCursa(){
        initComponents();
        limpiar();
        this.setLocationRelativeTo(null);
    }
    
    //Cargo mi tabla en la vista
    private void cargarTabla(){
        mtc.setCursas(cc.getCursas());
        jTableCursa.setModel(mtc);
        jTableCursa.updateUI();
    }
    
    //Verifico si el texto sin espacios esta vacio
    private boolean validar(){
        return !txtCodigo.getText().trim().isEmpty();
               
    }
    
    //Cargar datos en la vista
    private void limpiar(){
        txtCodigo.setText(cc.generatedCode());
        txtCodigo.setEnabled(false);
        cbxEstudiante.setSelectedItem(-1);//Limpio Combo
       
        
        cc.setCursa(null);
        cc.setCursas(new LinkedList<>());
        cargarTabla();
        //Actualizar tabla -BDD desaparece
        jTableCursa.clearSelection();
        cc.setIndex(-1);
        try {
            UtilVista.cargarPersonaEstudiante(cbxEstudiante, Rol.Estudiante);
        } catch (Exception e) {
        }
        
        
    }
    
    private void agregarEstudianteALista() {
    Estudiante estudianteSeleccionado = UtilVista.getComboEstudiante(cbxEstudiante);

    if (estudianteSeleccionado != null) {
        // Agregar estudiante a la lista de estudiantes del curso actual
        cc.agregarEstudiante(cc.getCursa(), estudianteSeleccionado);
        // Puedes actualizar la vista o realizar otras acciones aquí si es necesario
    } else {
        JOptionPane.showMessageDialog(null, "Selecciona un estudiante antes de agregarlo", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    //Guardo la informacion 
    private void guardar(){
        if(validar()){
            try {
                cc.getCursa().setCodigo(txtCodigo.getText());
                cc.getCursa().getEstudiantes().add((Estudiante) UtilVista.getComboPersonaEstudiante(cbxEstudiante));
                cc.getCursa().setId_Estudiante(UtilVista.getComboPersonaEstudiante(cbxEstudiante).getId()); 
                //Guardar
                if(cc.getCursa().getId() == null){
                   if(cc.save()){
                    limpiar();
                        JOptionPane.showMessageDialog(null, "Se ha guardado correctamente", 
                            "OK", JOptionPane.INFORMATION_MESSAGE);
                   
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha podido guardar", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    } 
                }else{
                    if(cc.update(cc.getIndex())){
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
        cc.setIndex(jTableCursa.getSelectedRow());
        if(cc.getIndex().intValue() < 0){
            JOptionPane.showMessageDialog(null, "Selecciona una fila", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                cc.setCursa(mtc.getCursas().get(cc.getIndex()));
                txtCodigo.setText(cc.getCursa().getCodigo().toString());
                
                cbxEstudiante.setSelectedItem(UtilVista.getComboPersonaEstudiante(cbxEstudiante));
                
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCursa = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        cbxEstudiante = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Curso");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 190, -1));

        jTableCursa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableCursa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 790, 110));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel4.setText("Estudiante");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 100, 20));

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 240, -1));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 170, -1));

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

        cbxEstudiante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 240, -1));

        jLabel5.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel5.setText("Codigo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 100, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCursa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCursa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCursa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCursa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmCursa dialog = new FrmCursa(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbxEstudiante;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCursa;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
