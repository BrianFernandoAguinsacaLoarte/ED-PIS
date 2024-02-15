/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.listas;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author Usuario iTC
 */
public class FrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrmLogin
     */
    public FrmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        panelLadoDerecho.setIcon(new ImageIcon("multimedia/LogoUniversidad.png"));
        panelconoUsuario.setIcon(new ImageIcon("multimedia/IconoLogin.jpg"));
        panelconoContraseña.setIcon(new ImageIcon("multimedia/IconoContraseña.png"));
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        panelLadoDerecho = new org.edisoncor.gui.panel.PanelImage();
        jLabel2 = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passwordLabel = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        panel4 = new org.edisoncor.gui.panel.Panel();
        userLabel1 = new javax.swing.JLabel();
        panelconoUsuario = new org.edisoncor.gui.panel.PanelImage();
        panelconoContraseña = new org.edisoncor.gui.panel.PanelImage();
        panel3 = new org.edisoncor.gui.panel.Panel();
        panelCurves2 = new org.edisoncor.gui.panel.PanelCurves();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        userLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panelLadoDerechoLayout = new javax.swing.GroupLayout(panelLadoDerecho);
        panelLadoDerecho.setLayout(panelLadoDerechoLayout);
        panelLadoDerechoLayout.setHorizontalGroup(
            panelLadoDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        panelLadoDerechoLayout.setVerticalGroup(
            panelLadoDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        panel1.add(panelLadoDerecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 220, 240));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel2.setText("INICIAR SESIÓN");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        userTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        userTxt.setForeground(new java.awt.Color(204, 204, 204));
        userTxt.setText("Ingrese su nombre de Usuario");
        userTxt.setBorder(null);
        userTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxtMousePressed(evt);
            }
        });
        userTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTxtActionPerformed(evt);
            }
        });
        panel1.add(userTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 310, 20));

        passwordLabel.setFont(new java.awt.Font("Roboto Thin", 1, 18)); // NOI18N
        passwordLabel.setText("CONTRASEÑA");
        panel1.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 140, -1));

        passwordTxt.setForeground(new java.awt.Color(204, 204, 204));
        passwordTxt.setText("********");
        passwordTxt.setBorder(null);
        passwordTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passwordTxtMousePressed(evt);
            }
        });
        panel1.add(passwordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        panel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 310, 20));

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        panel1.add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 890, 10));

        userLabel1.setFont(new java.awt.Font("Roboto Thin", 1, 18)); // NOI18N
        userLabel1.setText("USUARIO");
        panel1.add(userLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 90, -1));

        javax.swing.GroupLayout panelconoUsuarioLayout = new javax.swing.GroupLayout(panelconoUsuario);
        panelconoUsuario.setLayout(panelconoUsuarioLayout);
        panelconoUsuarioLayout.setHorizontalGroup(
            panelconoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panelconoUsuarioLayout.setVerticalGroup(
            panelconoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        panel1.add(panelconoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 40, 40));

        javax.swing.GroupLayout panelconoContraseñaLayout = new javax.swing.GroupLayout(panelconoContraseña);
        panelconoContraseña.setLayout(panelconoContraseñaLayout);
        panelconoContraseñaLayout.setHorizontalGroup(
            panelconoContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panelconoContraseñaLayout.setVerticalGroup(
            panelconoContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        panel1.add(panelconoContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 40, 40));

        panel3.setColorPrimario(new java.awt.Color(0, 102, 153));
        panel3.setColorSecundario(new java.awt.Color(0, 102, 153));
        panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCurves1.setBackground(new java.awt.Color(153, 204, 255));
        panelCurves1.setForeground(new java.awt.Color(153, 204, 255));
        panelCurves2.add(panelCurves1, java.awt.BorderLayout.LINE_START);

        userLabel.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        userLabel.setForeground(new java.awt.Color(0, 0, 0));
        userLabel.setText("Servicio de Autenticación");
        panelCurves2.add(userLabel, java.awt.BorderLayout.LINE_END);

        panel3.add(panelCurves2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 60));

        panel1.add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxtMousePressed
        if (userTxt.getText().equals("Ingrese su nombre de Usuario")){
            userTxt.setText("");
            userTxt.setForeground(Color.black);
        }
        if (String.valueOf(passwordTxt.getPassword()).isEmpty()){
            passwordTxt.setText("********");
            passwordTxt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_userTxtMousePressed

    private void userTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxtActionPerformed

    private void passwordTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordTxtMousePressed
        if (String.valueOf(passwordTxt.getPassword()).equals("********")){
            passwordTxt.setText("");
            passwordTxt.setForeground(Color.black);
        }

        if (userTxt.getText().isEmpty()){
            userTxt.setText("Ingrese su nombre de Usuario");
            userTxt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_passwordTxtMousePressed

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel3;
    private org.edisoncor.gui.panel.Panel panel4;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelCurves panelCurves2;
    private org.edisoncor.gui.panel.PanelImage panelLadoDerecho;
    private org.edisoncor.gui.panel.PanelImage panelconoContraseña;
    private org.edisoncor.gui.panel.PanelImage panelconoUsuario;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
