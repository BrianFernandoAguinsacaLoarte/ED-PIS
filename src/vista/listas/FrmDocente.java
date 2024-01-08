/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.listas;

import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import javax.swing.JOptionPane;
import modelo.Docente;
import modelo.Estudiante;
import modelo.enums.Rol;
import modelo.persona.DocenteController;
import vista.listas.tablas.ModeloTablaDocente;
import vista.listas.util.UtilVista;

/**
 *
 * @author Usuario iTC
 */
public class FrmDocente extends javax.swing.JDialog {

    //Objetos
    DocenteController dc = new DocenteController();
    ModeloTablaDocente mtd = new ModeloTablaDocente();
    
        
    /**
     * Creates new form FrmDocente
     */
    public FrmDocente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limpiar();
        this.setLocationRelativeTo(null);
    }
    public FrmDocente() {
        initComponents();
        limpiar();
        this.setLocationRelativeTo(null);
    }
    
    //Cargo mi tabla en la vista
    private void cargarTabla(){
        mtd.setDocentes(dc.getDocentes());
        jTableDocente.setModel(mtd);
        jTableDocente.updateUI();
    }
    
    //Verifico si el texto sin espacios esta vacio
    private boolean validar(){
        return !txtTitulo.getText().trim().isEmpty();
               
    }
    
    //Cargar datos en la vista
    private void limpiar(){
        txtTitulo.setText("");
        cbxPersona.setSelectedItem(-1);//Limpio Combo
        txtEspecializacion.setText("");
        txtExperiencia.setText("");
        txtCertificaciones.setText("");
        
        dc.setDocente(null);
        dc.setDocentes(new LinkedList<>());
        cargarTabla();
        //Actualizar tabla -BDD desaparece
        jTableDocente.clearSelection();
        dc.setIndex(-1);
         try {
            UtilVista.cargarPersonaDocente(cbxPersona, Rol.Docente);
        } catch (Exception e) {
        }
    }
    
    
    //Guardo la informacion 
    private void guardar(){
        if(validar()){
            try {
                dc.getDocente().setTitulo(txtTitulo.getText());
                dc.getDocente().setId_Persona(UtilVista.getComboPersonaDocente(cbxPersona).getId()); 
                dc.getDocente().setEspecializacion(txtEspecializacion.getText());
                dc.getDocente().setExperienciaLaboral(Integer.parseInt(txtExperiencia.getText()));
                dc.getDocente().setCertificaciones(txtCertificaciones.getText());
                
                //Guardar
                if(dc.getDocente().getId() == null){
                   if(dc.save()){
                    limpiar();
                        JOptionPane.showMessageDialog(null, "Se ha guardado correctamente", 
                            "OK", JOptionPane.INFORMATION_MESSAGE);
                   
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha podido guardar", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    } 
                }else{
                    if(dc.update(dc.getIndex())){
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
        dc.setIndex(jTableDocente.getSelectedRow());
        if(dc.getIndex().intValue() < 0){
            JOptionPane.showMessageDialog(null, "Selecciona una fila", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                dc.setDocente(mtd.getDocentes().get(dc.getIndex()));
                txtTitulo.setText(dc.getDocente().getTitulo());
                cbxPersona.setSelectedItem(UtilVista.getComboPersonaDocente(cbxPersona));
                txtEspecializacion.setText(dc.getDocente().getEspecializacion());
                txtExperiencia.setText(dc.getDocente().getExperienciaLaboral().toString());
                txtCertificaciones.setText(dc.getDocente().getCertificaciones());
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
    
    private void ordenar(){
        //Obtengo el criterio y el ordenamiento de Ascendente y Descendente
        String criterio = cbxCriterio.getSelectedItem().toString().toLowerCase().replaceAll("\\s", "");
        Integer ascdesc = cbxAscDesc.getSelectedIndex();//Me da un valor numerico 0 o 1
         System.out.println(criterio);
            try {
                System.out.println("Ordenando con QuickSOrt");
                mtd.setDocentes(dc.ordenarQuickSort(dc.getDocentes(), ascdesc, criterio));
                jTableDocente.setModel(mtd);
                jTableDocente.updateUI();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(),
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
    }
    
    private void buscar() {
        String text = txtBusqueda.getText().toString().toLowerCase();
        String field = cbxCriterio.getSelectedItem().toString().toLowerCase().replaceAll("\\s", "");
        String busqueda = cbxBusqueda.getSelectedItem().toString();
        

        try {
            LinkedList<Docente> listaResultado;
            switch (busqueda) {
                case "Busqueda Binaria":
                    if (field.equalsIgnoreCase("titulo") || field.equalsIgnoreCase("especializacion")
                            || field.equalsIgnoreCase("certificaciones")) {
                        listaResultado = dc.busquedaBinaria(dc.getDocentes(), text, field);
                    } else if (field.equalsIgnoreCase("id_Persona") || field.equalsIgnoreCase("experienciaLaboral")) {
                        try {
                            int textoEntero = Integer.parseInt(text);
                            listaResultado = dc.busquedaBinariaEntero(dc.getDocentes(), textoEntero, field);
                        } catch (NumberFormatException ex) {
                            throw new IllegalArgumentException("Debe ser entero");
                        }
                    } else {
                        throw new IllegalArgumentException("No existe el campo " + field);
                    }
                    break;

                case "Busqueda Lineal":
                    if (field.equalsIgnoreCase("titulo") || field.equalsIgnoreCase("especializacion")
                            || field.equalsIgnoreCase("certificaciones")) {
                        listaResultado = dc.busquedaLinealBinaria(dc.getDocentes(), text, field);
                    } else if (field.equalsIgnoreCase("id_Persona") || field.equalsIgnoreCase("experienciaLaboral")) {
                        try {
                            int textoEntero = Integer.parseInt(text);
                            listaResultado = dc.busquedaLinealBinariaEntero(dc.getDocentes(), textoEntero, field);
                        } catch (NumberFormatException ex) {
                            throw new IllegalArgumentException("Debe ser entero");
                        }
                    } else {
                        throw new IllegalArgumentException("No existe el campo " + field);
                    }
                    break;

                default:
                    throw new IllegalArgumentException("Tipo de búsqueda no reconocido: " + busqueda);
            }

            mtd.setDocentes(listaResultado);
            jTableDocente.setModel(mtd);
            jTableDocente.updateUI();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        cbxPersona = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDocente = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCertificaciones = new javax.swing.JTextField();
        txtEspecializacion = new javax.swing.JTextField();
        txtExperiencia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabelTexto1 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbxBusqueda = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbxCriterio = new javax.swing.JComboBox<>();
        cbxAscDesc = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel3.setText("Nombres: ");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro Docente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 190, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel4.setText("Persona:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 100, 20));

        jLabel10.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel10.setText("Certificaciones:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 160, 20));

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 240, -1));

        cbxPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 240, -1));

        jTableDocente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableDocente);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 790, 110));

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
        jLabel11.setText("Titulo:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 100, 20));

        jLabel12.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel12.setText("Especialización:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 160, 20));

        jLabel13.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel13.setText("Experiencia Laboral:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 200, 20));
        jPanel1.add(txtCertificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 240, -1));
        jPanel1.add(txtEspecializacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 240, -1));
        jPanel1.add(txtExperiencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 240, -1));

        jLabel15.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Busquedas");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, 200, 40));

        jLabelTexto1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabelTexto1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTexto1.setText("Texto de Busqueda:");
        jPanel1.add(jLabelTexto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 100, 210, 40));

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        jPanel1.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 170, 170, 40));

        jLabel16.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Métodos de Busqueda:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 230, 210, 40));

        cbxBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busqueda Binaria", "Busqueda Lineal", " " }));
        jPanel1.add(cbxBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 290, 210, 40));

        jButton3.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, 160, 60));

        jLabel17.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Ordenamiento");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 60, 200, 40));

        jLabel18.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Criterios:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 100, 130, 40));

        cbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID_PERSONA", "TITULO", "ESPECIALIZACION", "EXPERIENCIA LABORAL", "CERTIFICACIONES", " " }));
        cbxCriterio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCriterioItemStateChanged(evt);
            }
        });
        jPanel1.add(cbxCriterio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 170, -1, 40));

        cbxAscDesc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASCENDENTE", "DESCENDENTE" }));
        cbxAscDesc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAscDescItemStateChanged(evt);
            }
        });
        cbxAscDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAscDescActionPerformed(evt);
            }
        });
        jPanel1.add(cbxAscDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 220, -1, 40));

        jButton4.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jButton4.setText("Ordenar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 350, 160, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1469, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

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
        FrmRegistro newFrame = new FrmRegistro();
        newFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        buscar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbxCriterioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCriterioItemStateChanged
        //ordenar();

        /*
        if(evt.getItem().toString().equalsIgnoreCase("MARCA")){
            txtBusqueda.setVisible(false);
            cbxMarcaB.setVisible(true);

        }else{
            txtBusqueda.setVisible(true);
            cbxMarcaB.setVisible(false);
        }
        */
    }//GEN-LAST:event_cbxCriterioItemStateChanged

    private void cbxAscDescItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAscDescItemStateChanged
        //ordenar();
    }//GEN-LAST:event_cbxAscDescItemStateChanged

    private void cbxAscDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAscDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAscDescActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ordenar();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmDocente dialog = new FrmDocente(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbxAscDesc;
    private javax.swing.JComboBox<String> cbxBusqueda;
    private javax.swing.JComboBox<String> cbxCriterio;
    private javax.swing.JComboBox<String> cbxPersona;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelTexto1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDocente;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCertificaciones;
    private javax.swing.JTextField txtEspecializacion;
    private javax.swing.JTextField txtExperiencia;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
