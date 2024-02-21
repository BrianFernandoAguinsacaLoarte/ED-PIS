/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.listas;

import controlador.TDA.listas.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.Docente;
import modelo.DocenteMateria;
import modelo.Estudiante;
import modelo.Materia;
import modelo.Matricula;
import modelo.MatriculaCursoMateria;
import modelo.controladores.DocenteMateriaController;
import modelo.controladores.EstudianteController;
import modelo.controladores.MatriculaCursoMateriaControlador;
import vista.listas.tablas.ModeloTablaDocenteMateria;
import vista.listas.tablas.ModeloTablaEstudiante;
import vista.listas.tablas.ModeloTablaMatriculaCursoMateria;
import vista.listas.util.UtilVista;

/**
 *
 * @author Usuario iTC
 */
public class FrmDocenteMateria extends javax.swing.JFrame {

    private DocenteMateriaController docCon = new DocenteMateriaController();
    private ModeloTablaDocenteMateria mtll = new ModeloTablaDocenteMateria();

    /**
     * Creates new form FrmMatriculaCursoMateria
     */
    public FrmDocenteMateria() {
        initComponents();
        limpiar();
    }

    public Boolean validar() {
        return true;
    }

    private void limpiar() {
        docCon.setDocenteMateria(null);
        docCon.setLista(new LinkedList<>());
        cargarTabla();
        docCon.setDocenteMateria(null);
        docCon.setIndex(-1);
        try {
            UtilVista.cargarDocente(cbxDocentes);
            UtilVista.cargarMateria(cbxMateria);
            UtilVista.cargarCurso(cbxCurso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarTabla() {
        mtll.setDocentesMateria(docCon.getLista());
        tblTabla.setModel(mtll);
        tblTabla.updateUI();
    }

    public void guardar() {
        if (validar()) {
            try {
                DocenteMateria matriculaCursoMateria = new DocenteMateria();

                Curso cursoSeleccionado = (Curso) cbxCurso.getSelectedItem();
                Integer idCursoSeleccionado = cursoSeleccionado.getId();

                Materia materiaSeleccionado = (Materia) cbxMateria.getSelectedItem();
                Integer idMateriaSeleccionado = materiaSeleccionado.getId();

                Docente matriculaSeleccionada = (Docente) cbxDocentes.getSelectedItem();
                Integer idMatriculaSeleccionada = matriculaSeleccionada.getId();

                System.out.println("Curso: " + idCursoSeleccionado);
                System.out.println("Estudiante: " + idMatriculaSeleccionada);
                System.out.println("Materia: " + idMateriaSeleccionado);

                matriculaCursoMateria.setId_curso(idCursoSeleccionado);
                matriculaCursoMateria.setId_materia(idMateriaSeleccionado);
                matriculaCursoMateria.setId_docente(idMatriculaSeleccionada);

                docCon.setDocenteMateria(matriculaCursoMateria);
                docCon.guardar();
                docCon.setDocenteMateria(null);
                limpiar();
            } catch (Exception e) {
                System.out.println("No se pudo guardar");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        }
    }

    private void modificar() {
        try {
            int filaSeleccionada = tblTabla.getSelectedRow();

            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un ciclo para modificar");
                return;
            }

            DocenteMateria matriculaCursoMateria = new DocenteMateria();

            Curso cursoSeleccionado = (Curso) cbxCurso.getSelectedItem();
            Integer idCursoSeleccionado = cursoSeleccionado.getId();

            Materia materiaSeleccionado = (Materia) cbxMateria.getSelectedItem();
            Integer idMateriaSeleccionado = materiaSeleccionado.getId();

            Docente matriculaSeleccionada = (Docente) cbxDocentes.getSelectedItem();
            Integer idMatriculaSeleccionada = matriculaSeleccionada.getId();

            System.out.println("Curso: " + idCursoSeleccionado);
            System.out.println("Estudiante: " + idMatriculaSeleccionada);
            System.out.println("Materia: " + idMateriaSeleccionado);

            matriculaCursoMateria.setId_curso(idCursoSeleccionado);
            matriculaCursoMateria.setId_materia(idMateriaSeleccionado);
            matriculaCursoMateria.setId_docente(idMatriculaSeleccionada);

            docCon.modificar(matriculaCursoMateria);

            limpiar();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al modificar el ciclo: " + e.getMessage());
        }
    }

    private void cargarVista() {
        docCon.setIndex(tblTabla.getSelectedRow());
        if (docCon.getIndex().intValue() < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona una fila",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                docCon.setDocenteMateria(mtll.getDocentesMateria().get(docCon.getIndex()));
//                UtilVista.setComboDocente(cbxDocentes, mtll.getDocMateria().getId_docente());
//                UtilVista.setComboMateria(cbxMateria, mtll.getDocMateria().getId_materia());
//                UtilVista.setComboCurso(cbxCurso, mtll.getDocMateria().getId_curso());
//                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        panel2 = new org.edisoncor.gui.panel.Panel();
        labelRound1 = new org.edisoncor.gui.label.LabelRound();
        panelLogo = new org.edisoncor.gui.panel.PanelImage();
        btnRegresar = new org.edisoncor.gui.button.ButtonRect();
        btnSeleccionar = new org.edisoncor.gui.button.ButtonRect();
        btnGuardar = new org.edisoncor.gui.button.ButtonRect();
        btnActualizar = new org.edisoncor.gui.button.ButtonRect();
        btnCancelar = new org.edisoncor.gui.button.ButtonRect();
        labelRect2 = new org.edisoncor.gui.label.LabelRect();
        labelRect4 = new org.edisoncor.gui.label.LabelRect();
        labelRect5 = new org.edisoncor.gui.label.LabelRect();
        cbxDocentes = new org.edisoncor.gui.comboBox.ComboBoxRect();
        cbxMateria = new org.edisoncor.gui.comboBox.ComboBoxRect();
        panelRect1 = new org.edisoncor.gui.panel.PanelRect();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        cbxCurso = new org.edisoncor.gui.comboBox.ComboBoxRect();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel2.setColorPrimario(new java.awt.Color(0, 102, 153));
        panel2.setColorSecundario(new java.awt.Color(0, 102, 153));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelRound1.setBackground(new java.awt.Color(0, 102, 153));
        labelRound1.setText("Asignar cursos y materias a estudiantes");
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
        labelRect2.setText("Docente\n");
        labelRect2.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect2.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 150, 30));

        labelRect4.setBackground(new java.awt.Color(255, 255, 255));
        labelRect4.setForeground(new java.awt.Color(0, 0, 0));
        labelRect4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect4.setText("Curso:");
        labelRect4.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect4.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 150, 30));

        labelRect5.setBackground(new java.awt.Color(255, 255, 255));
        labelRect5.setForeground(new java.awt.Color(0, 0, 0));
        labelRect5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect5.setText("Materia:");
        labelRect5.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect5.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 150, 30));
        panel1.add(cbxDocentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 400, 30));
        panel1.add(cbxMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 400, 30));

        panelRect1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTabla);

        panelRect1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 340));

        panel1.add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 680, 360));
        panel1.add(cbxCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 400, 30));

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
        new FrmPantallaAdministrador().setVisible(true);
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
            java.util.logging.Logger.getLogger(FrmDocenteMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDocenteMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDocenteMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDocenteMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrmDocenteMateria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRect btnActualizar;
    private org.edisoncor.gui.button.ButtonRect btnCancelar;
    private org.edisoncor.gui.button.ButtonRect btnGuardar;
    private org.edisoncor.gui.button.ButtonRect btnRegresar;
    private org.edisoncor.gui.button.ButtonRect btnSeleccionar;
    private org.edisoncor.gui.comboBox.ComboBoxRect cbxCurso;
    private org.edisoncor.gui.comboBox.ComboBoxRect cbxDocentes;
    private org.edisoncor.gui.comboBox.ComboBoxRect cbxMateria;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.label.LabelRect labelRect2;
    private org.edisoncor.gui.label.LabelRect labelRect4;
    private org.edisoncor.gui.label.LabelRect labelRect5;
    private org.edisoncor.gui.label.LabelRound labelRound1;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.PanelImage panelLogo;
    private org.edisoncor.gui.panel.PanelRect panelRect1;
    private javax.swing.JTable tblTabla;
    // End of variables declaration//GEN-END:variables
}
