/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.listas;

import controlador.TDA.listas.LinkedList;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import modelo.persona.EstudianteController;
import vista.listas.tablas.ModeloTablaEstudiante;

/**
 *
 * @author Usuario iTC
 */
public class FrmEstudianteRegistros extends javax.swing.JDialog {

    //Objeto
    EstudianteController ec = new EstudianteController();
    ModeloTablaEstudiante mte = new ModeloTablaEstudiante();
    
    public FrmEstudianteRegistros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarTabla();
        this.setLocationRelativeTo(null);
    }

    public FrmEstudianteRegistros() {
        initComponents();
        cargarTabla();
        this.setLocationRelativeTo(null);
    }

    
    //Cargo mi tabla en la vista
    private void cargarTabla(){
        mte.setEstudiantes(ec.getEstudiantes());
        jTableEstudiante.setModel(mte);
        jTableEstudiante.updateUI();
    }
    
    private void ordenar(){
        //Obtengo el criterio y el ordenamiento de Ascendente y Descendente
        String criterio = cbxCriterio.getSelectedItem().toString().toLowerCase().replaceAll("\\s", "");
        Integer ascdesc = cbxAscDesc.getSelectedIndex();//Me da un valor numerico 0 o 1
         System.out.println(criterio);
            try {
                System.out.println("Ordenando con QuickSOrt");
                mte.setEstudiantes(ec.ordenarQuickSort(ec.getEstudiantes(), ascdesc, criterio));
                jTableEstudiante.setModel(mte);
                jTableEstudiante.updateUI();
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
            LinkedList<Estudiante> listaResultado;
            switch (busqueda) {
                case "Busqueda Binaria":
                    if (field.equalsIgnoreCase("colegioanterior") || field.equalsIgnoreCase("actividadExtracurricular")
                            || field.equalsIgnoreCase("proyectosacademicos") || field.equalsIgnoreCase("reconocimientos")
                            || field.equalsIgnoreCase("Certificaciones")) {
                        listaResultado = ec.busquedaBinaria(ec.getEstudiantes(), text, field);
                    } else if (field.equalsIgnoreCase("id") || field.equalsIgnoreCase("id_Persona")) {
                        try {
                            int textoEntero = Integer.parseInt(text);
                            listaResultado = ec.busquedaBinariaEntero(ec.getEstudiantes(), textoEntero, field);
                        } catch (NumberFormatException ex) {
                            throw new IllegalArgumentException("Debe ser entero");
                        }
                    } else {
                        throw new IllegalArgumentException("No existe el campo " + field);
                    }
                    break;

                case "Busqueda Lineal":
                    if (field.equalsIgnoreCase("colegioAnterior") || field.equalsIgnoreCase("actividadExtracurricular")
                            || field.equalsIgnoreCase("proyectosacademicos") || field.equalsIgnoreCase("reconocimientos")
                            || field.equalsIgnoreCase("Certificaciones")) {
                        listaResultado = ec.busquedaLinealBinaria(ec.getEstudiantes(), text, field);
                    } else if (field.equalsIgnoreCase("id") || field.equalsIgnoreCase("id_Persona")) {
                        try {
                            int textoEntero = Integer.parseInt(text);
                            listaResultado = ec.busquedaLinealBinariaEntero(ec.getEstudiantes(), textoEntero, field);
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

            mte.setEstudiantes(listaResultado);
            jTableEstudiante.setModel(mte);
            jTableEstudiante.updateUI();

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelTexto1 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cbxBusqueda = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbxCriterio = new javax.swing.JComboBox<>();
        cbxAscDesc = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEstudiante = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel1.setText("Registro de Personas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 210, -1));

        jLabel13.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Busquedas");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 200, 40));

        jLabelTexto1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabelTexto1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTexto1.setText("Texto de Busqueda:");
        jPanel1.add(jLabelTexto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 210, 40));

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        jPanel1.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 170, 40));

        jButton2.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 160, 60));

        jLabel14.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Métodos de Busqueda:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 210, 40));

        cbxBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busqueda Binaria", "Busqueda Lineal", " " }));
        jPanel1.add(cbxBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 210, 40));

        jLabel12.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Ordenamiento");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 200, 40));

        jLabel11.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Criterios:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 130, 40));

        cbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Colegio Anterior", "Actividad Extracurricular", "Proyectos Academicos", "Reconocimientos", "Certificaciones", "Id_Persona" }));
        cbxCriterio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCriterioItemStateChanged(evt);
            }
        });
        jPanel1.add(cbxCriterio, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, -1, 40));

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
        jPanel1.add(cbxAscDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, -1, 40));

        jButton1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jButton1.setText("Ordenar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 160, 60));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 720, 130));

        jButton3.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 540, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        buscar();
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ordenar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FrmEstudiante newFrame = new FrmEstudiante();
        newFrame.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(FrmEstudianteRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEstudianteRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEstudianteRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEstudianteRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmEstudianteRegistros dialog = new FrmEstudianteRegistros(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbxAscDesc;
    private javax.swing.JComboBox<String> cbxBusqueda;
    private javax.swing.JComboBox<String> cbxCriterio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabelTexto1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEstudiante;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
