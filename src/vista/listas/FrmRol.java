/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.listas;

import controlador.TDA.listas.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Rol;
import modelo.controladores.RolController;
import vista.listas.tablas.ModeloTablaRol;

/**
 *
 * @author Usuario iTC
 */
public class FrmRol extends javax.swing.JFrame {

    
    private RolController gc = new RolController();
    private ModeloTablaRol mtg = new ModeloTablaRol();

    /**
     * Creates new form FrmCurso
     */
    public FrmRol() {
        initComponents();
        panelLogo.setIcon(new ImageIcon("multimedia/LogoUNL.jpg"));
        this.setLocationRelativeTo(null);
        limpiar();
    }

    public Boolean validar() {
        return !txtNombre.getText().trim().isEmpty();
    }

    private void limpiar() {
        
        txtNombre.setText("");
        
        gc.setRol(null);
        gc.setLista(new LinkedList<>());
        cargarTabla();
        gc.setRol(null);
        gc.setIndex(-1);
        
       
    }
    
    public void cargarTabla() {
        mtg.setRoles(gc.getLista());
        jTableGenero.setModel(mtg);
        jTableGenero.updateUI();
    }

    public void guardar() {
        if (validar()) {
            try {
                Rol rol = new Rol();
                rol.setNombre(txtNombre.getText());
                gc.setRol(rol);
                gc.guardar();
                gc.setRol(null);
                limpiar();
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        }
    }

    private void modificar() {
        try {
            int filaSeleccionada = jTableGenero.getSelectedRow();

            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un ciclo para modificar");
                return;
            }

            Rol RolesSeleccionados = mtg.getRoles().get(filaSeleccionada);

            RolesSeleccionados.setNombre(txtNombre.getText());

            gc.modificar(RolesSeleccionados);

            limpiar();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al modificar el ciclo: " + e.getMessage());
        }
    }
    
    
    
    private void cargarVista(){
        gc.setIndex(jTableGenero.getSelectedRow());
        if(gc.getIndex().intValue() < 0){
            JOptionPane.showMessageDialog(null, "Selecciona una fila", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                gc.setRol(mtg.getRoles().get(gc.getIndex()));
                txtNombre.setText(gc.getRol().getNombre());
              
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

        panel1 = new org.edisoncor.gui.panel.Panel();
        panel2 = new org.edisoncor.gui.panel.Panel();
        labelRound1 = new org.edisoncor.gui.label.LabelRound();
        panelLogo = new org.edisoncor.gui.panel.PanelImage();
        labelRect2 = new org.edisoncor.gui.label.LabelRect();
        txtNombre = new org.edisoncor.gui.textField.TextField();
        panelRect1 = new org.edisoncor.gui.panel.PanelRect();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGenero = new javax.swing.JTable();
        btnGuardar = new org.edisoncor.gui.button.ButtonRect();
        btnActualizar = new org.edisoncor.gui.button.ButtonRect();
        btnSeleccionar = new org.edisoncor.gui.button.ButtonRect();
        btnCancelar = new org.edisoncor.gui.button.ButtonRect();
        btnRegresar = new org.edisoncor.gui.button.ButtonRect();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel2.setColorPrimario(new java.awt.Color(0, 102, 153));
        panel2.setColorSecundario(new java.awt.Color(0, 102, 153));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelRound1.setBackground(new java.awt.Color(0, 102, 153));
        labelRound1.setText("Registro de los Roles");
        labelRound1.setColorDeBorde(new java.awt.Color(0, 102, 153));
        labelRound1.setColorDeSegundoBorde(new java.awt.Color(0, 102, 153));
        labelRound1.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelRound1.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        panel2.add(labelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 650, 90));

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

        labelRect2.setBackground(new java.awt.Color(255, 255, 255));
        labelRect2.setForeground(new java.awt.Color(0, 0, 0));
        labelRect2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect2.setText("Nombre:");
        labelRect2.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect2.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 30));
        panel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 400, 30));

        panelRect1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableGenero.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableGenero);

        panelRect1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 300));

        panel1.add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 680, 320));

        btnGuardar.setBackground(new java.awt.Color(0, 102, 153));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, 130, 40));

        btnActualizar.setBackground(new java.awt.Color(0, 102, 153));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        panel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 360, 130, 40));

        btnSeleccionar.setBackground(new java.awt.Color(0, 102, 153));
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        panel1.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 240, 130, 40));

        btnCancelar.setBackground(new java.awt.Color(0, 102, 153));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 130, 40));

        btnRegresar.setBackground(new java.awt.Color(0, 102, 153));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        panel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 570, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        modificar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        cargarVista();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        new FrmVistaGeneral().setVisible(true);
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
            java.util.logging.Logger.getLogger(FrmRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new FrmRol().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRect btnActualizar;
    private org.edisoncor.gui.button.ButtonRect btnCancelar;
    private org.edisoncor.gui.button.ButtonRect btnGuardar;
    private org.edisoncor.gui.button.ButtonRect btnRegresar;
    private org.edisoncor.gui.button.ButtonRect btnSeleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGenero;
    private org.edisoncor.gui.label.LabelRect labelRect2;
    private org.edisoncor.gui.label.LabelRound labelRound1;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.PanelImage panelLogo;
    private org.edisoncor.gui.panel.PanelRect panelRect1;
    private org.edisoncor.gui.textField.TextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
