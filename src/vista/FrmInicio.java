/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

/**
 *
 * @author Usuario 1
 */
public class FrmInicio extends javax.swing.JFrame {

    /**
     * Creates new form FrmInicio
     */
    public FrmInicio() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnMeterias = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnPeriodoAcademico = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnMalla = new javax.swing.JButton();
        btnMaterias = new javax.swing.JLabel();
        btnMatriculas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnPersona = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnCurso = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnDocente = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnEstudiante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 204));
        jLabel1.setText("Universidad Nacional de Loja");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 650, -1));

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Periodo Academico:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, -1, -1));

        btnMeterias.setBackground(new java.awt.Color(255, 255, 255));
        btnMeterias.setText("|");
        btnMeterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeteriasActionPerformed(evt);
            }
        });
        jPanel1.add(btnMeterias, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 140, 140));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Malla:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        btnPeriodoAcademico.setBackground(new java.awt.Color(255, 255, 255));
        btnPeriodoAcademico.setText("|");
        btnPeriodoAcademico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodoAcademicoActionPerformed(evt);
            }
        });
        jPanel1.add(btnPeriodoAcademico, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, 140, 140));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Matriculas:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        btnMalla.setBackground(new java.awt.Color(255, 255, 255));
        btnMalla.setText("|");
        btnMalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMallaActionPerformed(evt);
            }
        });
        jPanel1.add(btnMalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 140, 140));

        btnMaterias.setBackground(new java.awt.Color(51, 51, 51));
        btnMaterias.setForeground(new java.awt.Color(0, 0, 0));
        btnMaterias.setText("Materias:");
        jPanel1.add(btnMaterias, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, -1));

        btnMatriculas.setBackground(new java.awt.Color(255, 255, 255));
        btnMatriculas.setText("|");
        btnMatriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatriculasActionPerformed(evt);
            }
        });
        jPanel1.add(btnMatriculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 140, 140));

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Persona:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        btnPersona.setBackground(new java.awt.Color(255, 255, 255));
        btnPersona.setText("|");
        btnPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonaActionPerformed(evt);
            }
        });
        jPanel1.add(btnPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 140, 140));

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Curso:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        btnCurso.setBackground(new java.awt.Color(255, 255, 255));
        btnCurso.setText("|");
        btnCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 140, 140));

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 680, -1, -1));

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Docente:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        btnDocente.setBackground(new java.awt.Color(255, 255, 255));
        btnDocente.setText("|");
        btnDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocenteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 140, 140));

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Estudiante:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));

        btnEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        btnEstudiante.setText("|");
        btnEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstudianteActionPerformed(evt);
            }
        });
        jPanel1.add(btnEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 140, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMeteriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeteriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMeteriasActionPerformed

    private void btnPeriodoAcademicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodoAcademicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPeriodoAcademicoActionPerformed

    private void btnMallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMallaActionPerformed

    private void btnMatriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatriculasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMatriculasActionPerformed

    private void btnPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPersonaActionPerformed

    private void btnCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCursoActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        //new FrmLogin.setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDocenteActionPerformed

    private void btnEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEstudianteActionPerformed

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
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCurso;
    private javax.swing.JButton btnDocente;
    private javax.swing.JButton btnEstudiante;
    private javax.swing.JButton btnMalla;
    private javax.swing.JLabel btnMaterias;
    private javax.swing.JButton btnMatriculas;
    private javax.swing.JButton btnMeterias;
    private javax.swing.JButton btnPeriodoAcademico;
    private javax.swing.JButton btnPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
