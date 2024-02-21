/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.listas.informacion;

import controlador.TDA.listas.LinkedList;
import javax.swing.ImageIcon;
import modelo.controladores.LogroEducativoController;
import vista.listas.tablas.ModeloTablaLogroEducativo;
import vista.listas.util.informacion.UtilVistaInfo;

/**
 *
 * @author Usuario iTC
 */
public class FrmLogroEducativoTabla extends javax.swing.JFrame {
    
    LogroEducativoController dc = new LogroEducativoController();
    ModeloTablaLogroEducativo mtd = new ModeloTablaLogroEducativo();
    
    public FrmLogroEducativoTabla() {
        initComponents();
        panelLogo.setIcon(new ImageIcon("multimedia/LogoUNL.jpg"));
        this.setLocationRelativeTo(null);
        limpiar();
    }
    
     private void cargarTabla(){
        mtd.setLogros(dc.getLogros());
        jTablaDocente.setModel(mtd);
        jTablaDocente.updateUI();
    }
     
    private void limpiar() {
        try {
            UtilVistaInfo.cargarOrden(cbxOrden);
            UtilVistaInfo.cargarCriterio(cbxCriterio);
        } catch (Exception e) {
        }

        dc.setLogroEducativo(null);
        dc.setLista(new LinkedList<>());
        cargarTabla();
        //Actualizar tabla -BDD desaparece
        jTablaDocente.clearSelection();
        dc.setIndex(-1);
       
    }
    
//    private void ordenar() {
//        //String criterio = cbxCriterio.getSelectedItem().toString().toLowerCase();
//        String criterio = cbxCriterio.getSelectedItem().toString().replaceAll("\\s", "").toLowerCase();
//        System.out.println(criterio);
//        Integer ascdesc = cbxOrden.getSelectedIndex();
//        try {
//            mtd.setDocentes(dc.ordenarporQuickSort(ascdesc, criterio, dc.getLista()));
//            jTablaDocente.setModel(mtd);
//            jTablaDocente.updateUI();
//        } catch (Exception ex) {
//            //Logger.getLogger(FrmDivorcio.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private void buscar() {
//        String criterio = cbxCriterio.getSelectedItem().toString().toLowerCase();
//        System.out.println(criterio);
//
//        try {
//            String textoBusqueda = txtBusqueda.getText();
//            System.out.println(textoBusqueda);
//            if (dc.getDocentes()!= null) {
//                LinkedList<Docente> resultados = dc.listar();
//
//                
//                // Búsqueda Lineal
//                resultados = dc.buscarporBusquedaLineal(textoBusqueda, criterio, mtd.getDocentes().toArray());
//                System.out.println(resultados.imprimir());
//
//                mtd.setDocentes(resultados);
//            } else {
//                // Manejo adecuado si divorciadas es null
//            }
//
//            jTablaDocente.setModel(mtd);
//            jTablaDocente.updateUI();
//        } catch (Exception ex) {
//            //Logger.getLogger(FrmDivorcio.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }


    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        panel2 = new org.edisoncor.gui.panel.Panel();
        panelLogo = new org.edisoncor.gui.panel.PanelImage();
        panelRect1 = new org.edisoncor.gui.panel.PanelRect();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaDocente = new javax.swing.JTable();
        panel3 = new org.edisoncor.gui.panel.Panel();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        labelRound1 = new org.edisoncor.gui.label.LabelRound();
        cbxOrden = new org.edisoncor.gui.comboBox.ComboBoxRect();
        labelRect1 = new org.edisoncor.gui.label.LabelRect();
        cbxCriterio = new org.edisoncor.gui.comboBox.ComboBoxRect();
        labelRect2 = new org.edisoncor.gui.label.LabelRect();
        txtBusqueda = new org.edisoncor.gui.textField.TextField();
        buttonRect1 = new org.edisoncor.gui.button.ButtonRect();
        buttonRect2 = new org.edisoncor.gui.button.ButtonRect();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel2.setColorPrimario(new java.awt.Color(0, 102, 153));
        panel2.setColorSecundario(new java.awt.Color(0, 102, 153));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        panelRect1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablaDocente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablaDocente);

        panelRect1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1030, 440));

        panel1.add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 460));

        panel3.setColorPrimario(new java.awt.Color(0, 102, 153));
        panel3.setColorSecundario(new java.awt.Color(0, 102, 153));
        panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel3.add(panelCurves1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 90));

        panel1.add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1300, 90));

        labelRound1.setBackground(new java.awt.Color(0, 102, 153));
        labelRound1.setText("Registro de los Logros Educativos");
        labelRound1.setColorDeBorde(new java.awt.Color(0, 102, 153));
        labelRound1.setColorDeSegundoBorde(new java.awt.Color(0, 102, 153));
        labelRound1.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelRound1.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        labelRound1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        panel1.add(labelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1500, 30));

        cbxOrden.setBackground(new java.awt.Color(204, 204, 204));
        cbxOrden.setBorder(null);
        cbxOrden.setForeground(new java.awt.Color(0, 0, 0));
        cbxOrden.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cbxOrden.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        panel1.add(cbxOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 210, 180, 50));

        labelRect1.setBackground(new java.awt.Color(0, 102, 153));
        labelRect1.setText("Busqueda");
        panel1.add(labelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 280, 130, 40));

        cbxCriterio.setBackground(new java.awt.Color(204, 204, 204));
        cbxCriterio.setBorder(null);
        cbxCriterio.setForeground(new java.awt.Color(0, 0, 0));
        cbxCriterio.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cbxCriterio.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        panel1.add(cbxCriterio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 210, 180, 50));

        labelRect2.setBackground(new java.awt.Color(0, 102, 153));
        labelRect2.setText("Ordenar");
        panel1.add(labelRect2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 150, 130, 40));

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        panel1.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 350, 360, 50));

        buttonRect1.setBackground(new java.awt.Color(0, 102, 153));
        buttonRect1.setText("Buscar");
        buttonRect1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRect1ActionPerformed(evt);
            }
        });
        panel1.add(buttonRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 530, 130, 50));

        buttonRect2.setBackground(new java.awt.Color(0, 102, 153));
        buttonRect2.setText("Ordenar");
        buttonRect2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRect2ActionPerformed(evt);
            }
        });
        panel1.add(buttonRect2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 530, 130, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void buttonRect2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRect2ActionPerformed
        //ordenar();
    }//GEN-LAST:event_buttonRect2ActionPerformed

    private void buttonRect1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRect1ActionPerformed
        //buscar();
    }//GEN-LAST:event_buttonRect1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLogroEducativoTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogroEducativoTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogroEducativoTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogroEducativoTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrmLogroEducativoTabla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRect buttonRect1;
    private org.edisoncor.gui.button.ButtonRect buttonRect2;
    private org.edisoncor.gui.comboBox.ComboBoxRect cbxCriterio;
    private org.edisoncor.gui.comboBox.ComboBoxRect cbxOrden;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaDocente;
    private org.edisoncor.gui.label.LabelRect labelRect1;
    private org.edisoncor.gui.label.LabelRect labelRect2;
    private org.edisoncor.gui.label.LabelRound labelRound1;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.Panel panel3;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelImage panelLogo;
    private org.edisoncor.gui.panel.PanelRect panelRect1;
    private org.edisoncor.gui.textField.TextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
