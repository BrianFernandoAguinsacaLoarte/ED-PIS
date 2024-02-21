/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.listas;

import controlador.TDA.listas.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import modelo.controladores.EstudianteController;
import vista.listas.tablas.ModeloTablaEstudiante;
import vista.listas.util.UtilVista;

/**
 *
 * @author Usuario iTC
 */
public class FrmEstudiante extends javax.swing.JFrame {

    EstudianteController ec = new EstudianteController();
    ModeloTablaEstudiante mte = new ModeloTablaEstudiante();
    
    public FrmEstudiante() {
        initComponents();
        panelLogo.setIcon(new ImageIcon("multimedia/LogoUNL.jpg"));
        this.setLocationRelativeTo(null);
        limpiar();
        
    }
    
    
    public Boolean validar() {
        return !txtNombre.getText().trim().isEmpty() &&
               !txtApellido.getText().trim().isEmpty() &&
               !txtCedula.getText().trim().isEmpty() &&
               !txtCorreo.getText().trim().isEmpty() &&
               !txtDireccion.getText().trim().isEmpty() &&
               !txtTelefono.getText().trim().isEmpty() &&
               !txtTitulo.getText().trim().isEmpty();
    
    }
    
    public void cargarTabla() {
        mte.setEstudiantes(ec.getLista());
        jTablaEstudiante.setModel(mte);
        jTablaEstudiante.updateUI();
    }
     
    private void limpiar() {
        
        
        txtNombre.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
        jDate.setDate(null);
        cbxGenero.setSelectedItem(-1);//Limpio COmbo
        cbxRol.setSelectedItem(-1);//Limpio Combo
        txtCedula.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtTitulo.setText("");
        
        
        
        ec.setEstudiante(null);
        ec.setLista(new LinkedList<>());
        ec.setEstudiante(null);
        ec.setIndex(-1);
        cargarTabla();
        try {
            UtilVista.cargarGenero(cbxGenero);
            UtilVista.cargarRoles(cbxRol, "Estudiante");
        } catch (Exception e) {
        }

    }
    
     public void guardar() {
        if (validar()) {
            try {
                Estudiante estudiante = new Estudiante();
                estudiante.setNombres(txtNombre.getText());
                estudiante.setApellidos(txtApellido.getText());
                estudiante.setCorreo(txtCorreo.getText());
                estudiante.setFechaNacimiento(jDate.getDate());
                estudiante.setId_genero(UtilVista.getComboGenero(cbxGenero).getId());
                estudiante.setId_rol(UtilVista.getComboRol(cbxRol).getId());
                estudiante.setCedula(txtCedula.getText());
                estudiante.setDireccion(txtDireccion.getText());
                estudiante.setTelefono(txtTelefono.getText());
                estudiante.setTituloBachiller(txtTitulo.getText());
                
                ec.setEstudiante(estudiante);
                ec.guardar();
                ec.setEstudiante(null);
                limpiar();
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        }
    }
    
    
     private void modificar() {
        try {
            int filaSeleccionada = jTablaEstudiante.getSelectedRow();

            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un ciclo para modificar");
                return;
            }

            Estudiante estudianteSel = mte.getEstudiantes().get(filaSeleccionada);

            estudianteSel.setNombres(txtNombre.getText());
            estudianteSel.setApellidos(txtApellido.getText());
            estudianteSel.setCorreo(txtCorreo.getText());
            estudianteSel.setFechaNacimiento(jDate.getDate());
            estudianteSel.setId_genero(UtilVista.getComboGenero(cbxGenero).getId());
            estudianteSel.setId_rol(UtilVista.getComboRol(cbxRol).getId());
            estudianteSel.setCedula(txtCedula.getText());
            estudianteSel.setDireccion(txtDireccion.getText());
            estudianteSel.setTelefono(txtTelefono.getText());
            estudianteSel.setTituloBachiller(txtTitulo.getText());

            ec.modificar(estudianteSel);

            limpiar();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al modificar el ciclo: " + e.getMessage());
        }
    }
    
    private void cargarVista(){
        ec.setIndex(jTablaEstudiante.getSelectedRow());
        if(ec.getIndex().intValue() < 0){
            JOptionPane.showMessageDialog(null, "Selecciona una fila", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                ec.setEstudiante(mte.getEstudiantes().get(ec.getIndex()));
                txtNombre.setText(ec.getEstudiante().getNombres());
                txtApellido.setText(ec.getEstudiante().getApellidos());
                txtCorreo.setText(ec.getEstudiante().getCorreo());
                jDate.setDate(ec.getEstudiante().getFechaNacimiento());
                UtilVista.setComboGenero(cbxGenero, ec.getEstudiante().getId_genero());
                txtCedula.setText(ec.getEstudiante().getCedula());
                txtDireccion.setText(ec.getEstudiante().getDireccion());
                txtTelefono.setText(ec.getEstudiante().getTelefono());
                txtTitulo.setText(ec.getEstudiante().getTituloBachiller().toString());
                
              
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
        labelRect3 = new org.edisoncor.gui.label.LabelRect();
        txtTitulo = new org.edisoncor.gui.textField.TextField();
        btnRegresar = new org.edisoncor.gui.button.ButtonRect();
        btnSeleccionar = new org.edisoncor.gui.button.ButtonRect();
        btnGuardar = new org.edisoncor.gui.button.ButtonRect();
        btnActualizar = new org.edisoncor.gui.button.ButtonRect();
        btnCancelar = new org.edisoncor.gui.button.ButtonRect();
        labelRect2 = new org.edisoncor.gui.label.LabelRect();
        txtNombre = new org.edisoncor.gui.textField.TextField();
        labelRect4 = new org.edisoncor.gui.label.LabelRect();
        txtApellido = new org.edisoncor.gui.textField.TextField();
        labelRect5 = new org.edisoncor.gui.label.LabelRect();
        txtCorreo = new org.edisoncor.gui.textField.TextField();
        labelRect6 = new org.edisoncor.gui.label.LabelRect();
        labelRect7 = new org.edisoncor.gui.label.LabelRect();
        cbxGenero = new org.edisoncor.gui.comboBox.ComboBoxRect();
        labelRect8 = new org.edisoncor.gui.label.LabelRect();
        cbxRol = new org.edisoncor.gui.comboBox.ComboBoxRect();
        labelRect1 = new org.edisoncor.gui.label.LabelRect();
        txtCedula = new org.edisoncor.gui.textField.TextField();
        panelRect1 = new org.edisoncor.gui.panel.PanelRect();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaEstudiante = new javax.swing.JTable();
        jDate = new com.toedter.calendar.JDateChooser();
        labelRect10 = new org.edisoncor.gui.label.LabelRect();
        labelRect11 = new org.edisoncor.gui.label.LabelRect();
        txtDireccion = new org.edisoncor.gui.textField.TextField();
        txtTelefono = new org.edisoncor.gui.textField.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel2.setColorPrimario(new java.awt.Color(0, 102, 153));
        panel2.setColorSecundario(new java.awt.Color(0, 102, 153));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelRound1.setBackground(new java.awt.Color(0, 102, 153));
        labelRound1.setText("Registro de Estudiante");
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

        labelRect3.setBackground(new java.awt.Color(255, 255, 255));
        labelRect3.setForeground(new java.awt.Color(0, 0, 0));
        labelRect3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect3.setText("Titulo Bachiller");
        labelRect3.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect3.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 150, 30));
        panel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 570, 400, 30));

        btnRegresar.setBackground(new java.awt.Color(0, 102, 153));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        panel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 580, 130, 40));

        btnSeleccionar.setBackground(new java.awt.Color(0, 102, 153));
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        panel1.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 130, 40));

        btnGuardar.setBackground(new java.awt.Color(0, 102, 153));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 130, 40));

        btnActualizar.setBackground(new java.awt.Color(0, 102, 153));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        panel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 140, 130, 40));

        btnCancelar.setBackground(new java.awt.Color(0, 102, 153));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 140, 130, 40));

        labelRect2.setBackground(new java.awt.Color(255, 255, 255));
        labelRect2.setForeground(new java.awt.Color(0, 0, 0));
        labelRect2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect2.setText("Nombre:");
        labelRect2.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect2.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, 30));
        panel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 400, 30));

        labelRect4.setBackground(new java.awt.Color(255, 255, 255));
        labelRect4.setForeground(new java.awt.Color(0, 0, 0));
        labelRect4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect4.setText("Apellido:");
        labelRect4.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect4.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 150, 30));
        panel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 400, 30));

        labelRect5.setBackground(new java.awt.Color(255, 255, 255));
        labelRect5.setForeground(new java.awt.Color(0, 0, 0));
        labelRect5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect5.setText("Correo:");
        labelRect5.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect5.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 150, 30));
        panel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 400, 30));

        labelRect6.setBackground(new java.awt.Color(255, 255, 255));
        labelRect6.setForeground(new java.awt.Color(0, 0, 0));
        labelRect6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect6.setText("Fecha de Nacimiento:");
        labelRect6.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect6.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 150, 30));

        labelRect7.setBackground(new java.awt.Color(255, 255, 255));
        labelRect7.setForeground(new java.awt.Color(0, 0, 0));
        labelRect7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect7.setText("Género:");
        labelRect7.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect7.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 150, 30));
        panel1.add(cbxGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 400, 30));

        labelRect8.setBackground(new java.awt.Color(255, 255, 255));
        labelRect8.setForeground(new java.awt.Color(0, 0, 0));
        labelRect8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect8.setText("Rol:");
        labelRect8.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect8.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 150, 30));
        panel1.add(cbxRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 400, 30));

        labelRect1.setBackground(new java.awt.Color(255, 255, 255));
        labelRect1.setForeground(new java.awt.Color(0, 0, 0));
        labelRect1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect1.setText("Cédula:");
        labelRect1.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect1.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 150, 30));
        panel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 400, 30));

        panelRect1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablaEstudiante.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablaEstudiante);

        panelRect1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 340));

        panel1.add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 680, 360));
        panel1.add(jDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 400, -1));

        labelRect10.setBackground(new java.awt.Color(255, 255, 255));
        labelRect10.setForeground(new java.awt.Color(0, 0, 0));
        labelRect10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect10.setText("Dirección:");
        labelRect10.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect10.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 150, 30));

        labelRect11.setBackground(new java.awt.Color(255, 255, 255));
        labelRect11.setForeground(new java.awt.Color(0, 0, 0));
        labelRect11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect11.setText("Teléfono:");
        labelRect11.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect11.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 150, 30));
        panel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 400, 30));
        panel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 400, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
       new FrmRegistroDocenteGeneral().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        cargarVista();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        modificar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
                new FrmEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRect btnActualizar;
    private org.edisoncor.gui.button.ButtonRect btnCancelar;
    private org.edisoncor.gui.button.ButtonRect btnGuardar;
    private org.edisoncor.gui.button.ButtonRect btnRegresar;
    private org.edisoncor.gui.button.ButtonRect btnSeleccionar;
    private org.edisoncor.gui.comboBox.ComboBoxRect cbxGenero;
    private org.edisoncor.gui.comboBox.ComboBoxRect cbxRol;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaEstudiante;
    private org.edisoncor.gui.label.LabelRect labelRect1;
    private org.edisoncor.gui.label.LabelRect labelRect10;
    private org.edisoncor.gui.label.LabelRect labelRect11;
    private org.edisoncor.gui.label.LabelRect labelRect2;
    private org.edisoncor.gui.label.LabelRect labelRect3;
    private org.edisoncor.gui.label.LabelRect labelRect4;
    private org.edisoncor.gui.label.LabelRect labelRect5;
    private org.edisoncor.gui.label.LabelRect labelRect6;
    private org.edisoncor.gui.label.LabelRect labelRect7;
    private org.edisoncor.gui.label.LabelRect labelRect8;
    private org.edisoncor.gui.label.LabelRound labelRound1;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.PanelImage panelLogo;
    private org.edisoncor.gui.panel.PanelRect panelRect1;
    private org.edisoncor.gui.textField.TextField txtApellido;
    private org.edisoncor.gui.textField.TextField txtCedula;
    private org.edisoncor.gui.textField.TextField txtCorreo;
    private org.edisoncor.gui.textField.TextField txtDireccion;
    private org.edisoncor.gui.textField.TextField txtNombre;
    private org.edisoncor.gui.textField.TextField txtTelefono;
    private org.edisoncor.gui.textField.TextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
