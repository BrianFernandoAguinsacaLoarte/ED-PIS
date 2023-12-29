/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.listas;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Usuario iTC
 */
public class FrmRegistro extends javax.swing.JDialog {
    
    //FondoPanel fondoPanel = new FondoPanel();
    
    
    /**
     * Creates new form FrmRegistro
     */
    public FrmRegistro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        //this.setContentPane(fondoPanel);
        initComponents();
        this.setLocationRelativeTo(null);
        rsscalelabel.RSScaleLabel.setScaleLabel(labelPersona,"src/img/persona.jpg");
        rsscalelabel.RSScaleLabel.setScaleLabel(labelDocente,"src/img/docente.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(labelEstudiante,"src/img/estudiante.png");
    }
    
    public FrmRegistro(){
        
        initComponents();
        this.setLocationRelativeTo(null);
        rsscalelabel.RSScaleLabel.setScaleLabel(labelPersona,"src/img/persona.jpg");
        rsscalelabel.RSScaleLabel.setScaleLabel(labelDocente,"src/img/docente.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(labelEstudiante,"src/img/estudiante.png");
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanelFondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEstudiante = new javax.swing.JButton();
        btnPersona = new javax.swing.JButton();
        btnDocente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelEstudiante = new javax.swing.JLabel();
        labelPersona = new javax.swing.JLabel();
        labelDocente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JPanelFondo.setBackground(new java.awt.Color(0, 102, 204));
        JPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel1.setText("Panel De Registros");
        JPanelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 180, -1));

        btnEstudiante.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnEstudiante.setText("Registro Estudiante");
        btnEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstudianteActionPerformed(evt);
            }
        });
        JPanelFondo.add(btnEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 530, 190, 60));

        btnPersona.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnPersona.setText("Registro Persona");
        btnPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonaActionPerformed(evt);
            }
        });
        JPanelFondo.add(btnPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 190, 60));

        btnDocente.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnDocente.setText("Registro Docente");
        btnDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocenteActionPerformed(evt);
            }
        });
        JPanelFondo.add(btnDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, 190, 60));
        JPanelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 580, -1, -1));
        JPanelFondo.add(labelEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 160, 190));

        labelPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/persona.jpg"))); // NOI18N
        JPanelFondo.add(labelPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 160, 190));
        JPanelFondo.add(labelDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 160, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonaActionPerformed
        FrmPersona newFrame = new FrmPersona();
        newFrame.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnPersonaActionPerformed

    private void btnDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocenteActionPerformed
        FrmDocente newFrame = new FrmDocente();
        newFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDocenteActionPerformed

    private void btnEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstudianteActionPerformed
        FrmEstudiante newFrame = new FrmEstudiante  ();
        newFrame.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmRegistro dialog = new FrmRegistro(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel JPanelFondo;
    private javax.swing.JButton btnDocente;
    private javax.swing.JButton btnEstudiante;
    private javax.swing.JButton btnPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelDocente;
    private javax.swing.JLabel labelEstudiante;
    private javax.swing.JLabel labelPersona;
    // End of variables declaration//GEN-END:variables
}

//class FondoPanel extends JPanel{
//    private Image imagen;
//    
//    public void paint (Graphics g){
//        imagen = new ImageIcon(getClass().getResource("/imagenes/fondoAzul.jpg")).getImage();
//        
//        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
//        
//        setOpaque(false);
//        
//        super.paint(g);
//    }
//}
