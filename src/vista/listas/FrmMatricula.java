/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.listas;

import controlador.TDA.listas.LinkedList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import modelo.Matricula;
import modelo.PeriodoAcademico;
import modelo.controladores.EstudianteController;
import modelo.controladores.MatriculaControlador;
import vista.listas.tablas.ModeloTablaEstudiante;
import vista.listas.tablas.ModeloTablaMatricula;
import vista.listas.util.Estudiante_Util_VistaLinked;
import vista.listas.util.PeriodoAcademico_Util_VistaLinked;
import vista.listas.util.UtilVista;

/**
 *
 * @author Usuario iTC
 */
public class FrmMatricula extends javax.swing.JFrame {

    private MatriculaControlador estudianteCon = new MatriculaControlador();
    private ModeloTablaMatricula mtll = new ModeloTablaMatricula();

    /**
     * Creates new form FrmMatricula
     */
    public FrmMatricula() {
        initComponents();
        limpiar();
    }

    public Boolean validar() {
        return true;
    }

    private void limpiar() {
        estudianteCon.setMatricula(null);
        estudianteCon.setLista(new LinkedList<>());
        cargarTabla();
        estudianteCon.setMatricula(null);
        estudianteCon.setIndex(-1);
        try {
            Estudiante_Util_VistaLinked.cargaEstudiante(cbxEstudiante);
            PeriodoAcademico_Util_VistaLinked.cargaPeriodoAcademico(cbxPeriodo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarTabla() {
        mtll.setMatriculas(estudianteCon.getLista());
        tblTabla.setModel(mtll);
        tblTabla.updateUI();
    }

    public void guardar() {
        if (validar()) {
            try {
                Matricula matricula = new Matricula();

                String modalidad = (String) cbxModalidad.getSelectedItem();
                String estado = (String) cbxEstado.getSelectedItem();
                String gratuidad = (String) cbxGratuidad.getSelectedItem();
                String turno = (String) cbxTurno.getSelectedItem();

                System.out.println("Modalidad: " + modalidad);
                System.out.println("Estado: " + estado);
                System.out.println("Gratuidad: " + gratuidad);
                System.out.println("Turno: " + turno);

                Estudiante estudianteSeleccionado = (Estudiante) cbxEstudiante.getSelectedItem();
                Integer idEstudianteSeleccionado = estudianteSeleccionado.getId();

                PeriodoAcademico periodoSelecccionado = (PeriodoAcademico) cbxPeriodo.getSelectedItem();
                Integer idPeriodoSelecccionado = periodoSelecccionado.getId();

                matricula.setModalidad(modalidad);
                matricula.setTurno(turno);
                matricula.setEstado(estado);
                matricula.setGratuidad(gratuidad);
                matricula.setFechaMatricula(jDate.getDate());
                matricula.setId_estudiante(idEstudianteSeleccionado);
                matricula.setId_periodoAcademico(idPeriodoSelecccionado);

                estudianteCon.setMatricula(matricula);
                estudianteCon.guardar();
                estudianteCon.setMatricula(null);
                limpiar();
            } catch (Exception e) {
                System.out.println("No se pudo guardar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        }
    }

    private void cargarVista() {
        estudianteCon.setIndex(tblTabla.getSelectedRow());
        if (estudianteCon.getIndex() < 0) {
            JOptionPane.showMessageDialog(null, "No");
        } else {
            try {
//                estudianteCon.setEstudiantePrueba(mtll.getEstudiantesPrueba().get(estudianteCon.getIndex()));

            } catch (Exception e) {
            }
        }
    }

    private void modificar() {
        try {
            // Obtener el índice de la fila seleccionada en la tabla
            int filaSeleccionada = tblTabla.getSelectedRow();

            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un ciclo para modificar");
                return;
            }

            Matricula matriculaSeleccionada = mtll.getMatriculas().get(filaSeleccionada);

            String modalidad = (String) cbxModalidad.getSelectedItem();
            String estado = (String) cbxEstado.getSelectedItem();
            String gratuidad = (String) cbxGratuidad.getSelectedItem();
            String turno = (String) cbxTurno.getSelectedItem();

            Estudiante estudianteSeleccionado = (Estudiante) cbxEstudiante.getSelectedItem();
            Integer idEstudianteSeleccionado = estudianteSeleccionado.getId();

            PeriodoAcademico periodoSelecccionado = (PeriodoAcademico) cbxPeriodo.getSelectedItem();
            Integer idPeriodoSelecccionado = periodoSelecccionado.getId();

            matriculaSeleccionada.setModalidad(modalidad);
            matriculaSeleccionada.setTurno(turno);
            matriculaSeleccionada.setEstado(estado);
            matriculaSeleccionada.setGratuidad(gratuidad);
            matriculaSeleccionada.setFechaMatricula(jDate.getDate());
            matriculaSeleccionada.setId_estudiante(idEstudianteSeleccionado);
            matriculaSeleccionada.setId_periodoAcademico(idPeriodoSelecccionado);

            estudianteCon.modificar(matriculaSeleccionada);

            limpiar();
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante la modificación
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al modificar el ciclo: " + e.getMessage());
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
        labelRect6 = new org.edisoncor.gui.label.LabelRect();
        labelRect7 = new org.edisoncor.gui.label.LabelRect();
        labelRect8 = new org.edisoncor.gui.label.LabelRect();
        labelRect1 = new org.edisoncor.gui.label.LabelRect();
        panelRect1 = new org.edisoncor.gui.panel.PanelRect();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        jDate = new com.toedter.calendar.JDateChooser();
        cbxEstado = new javax.swing.JComboBox<>();
        cbxGratuidad = new javax.swing.JComboBox<>();
        cbxEstudiante = new javax.swing.JComboBox<>();
        cbxPeriodo = new javax.swing.JComboBox<>();
        cbxModalidad = new javax.swing.JComboBox<>();
        cbxTurno = new javax.swing.JComboBox<>();

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

        btnRegresar.setBackground(new java.awt.Color(0, 102, 153));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        panel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 580, 130, 40));

        btnSeleccionar.setBackground(new java.awt.Color(0, 102, 153));
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        panel1.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 130, 40));

        btnGuardar.setBackground(new java.awt.Color(0, 102, 153));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 130, 40));

        btnActualizar.setBackground(new java.awt.Color(0, 102, 153));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        panel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 140, 130, 40));

        btnCancelar.setBackground(new java.awt.Color(0, 102, 153));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 140, 130, 40));

        labelRect2.setBackground(new java.awt.Color(255, 255, 255));
        labelRect2.setForeground(new java.awt.Color(0, 0, 0));
        labelRect2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect2.setText("Estudiante:");
        labelRect2.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect2.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, 30));

        labelRect4.setBackground(new java.awt.Color(255, 255, 255));
        labelRect4.setForeground(new java.awt.Color(0, 0, 0));
        labelRect4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect4.setText("Periodo:");
        labelRect4.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect4.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 150, 30));

        labelRect5.setBackground(new java.awt.Color(255, 255, 255));
        labelRect5.setForeground(new java.awt.Color(0, 0, 0));
        labelRect5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect5.setText("Fecha:");
        labelRect5.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect5.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 150, 30));

        labelRect6.setBackground(new java.awt.Color(255, 255, 255));
        labelRect6.setForeground(new java.awt.Color(0, 0, 0));
        labelRect6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect6.setText("Gratuidad:");
        labelRect6.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect6.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 150, 30));

        labelRect7.setBackground(new java.awt.Color(255, 255, 255));
        labelRect7.setForeground(new java.awt.Color(0, 0, 0));
        labelRect7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect7.setText("Turno:");
        labelRect7.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect7.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 150, 30));

        labelRect8.setBackground(new java.awt.Color(255, 255, 255));
        labelRect8.setForeground(new java.awt.Color(0, 0, 0));
        labelRect8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect8.setText("Modalidad:");
        labelRect8.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect8.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 150, 30));

        labelRect1.setBackground(new java.awt.Color(255, 255, 255));
        labelRect1.setForeground(new java.awt.Color(0, 0, 0));
        labelRect1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect1.setText("Estado:");
        labelRect1.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect1.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 150, 30));

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

        panel1.add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 680, 360));
        panel1.add(jDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 310, 30));

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", " " }));
        panel1.add(cbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 310, 30));

        cbxGratuidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", " " }));
        panel1.add(cbxGratuidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 310, 30));

        cbxEstudiante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel1.add(cbxEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 310, 30));

        cbxPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel1.add(cbxPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 310, 30));

        cbxModalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Presencial", "Virtual", " " }));
        panel1.add(cbxModalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 310, 30));

        cbxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "matutino", "vespertino", "nocturno", "intersivo", " " }));
        panel1.add(cbxTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 310, 30));

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
            java.util.logging.Logger.getLogger(FrmMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMatricula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRect btnActualizar;
    private org.edisoncor.gui.button.ButtonRect btnCancelar;
    private org.edisoncor.gui.button.ButtonRect btnGuardar;
    private org.edisoncor.gui.button.ButtonRect btnRegresar;
    private org.edisoncor.gui.button.ButtonRect btnSeleccionar;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxEstudiante;
    private javax.swing.JComboBox<String> cbxGratuidad;
    private javax.swing.JComboBox<String> cbxModalidad;
    private javax.swing.JComboBox<String> cbxPeriodo;
    private javax.swing.JComboBox<String> cbxTurno;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.label.LabelRect labelRect1;
    private org.edisoncor.gui.label.LabelRect labelRect2;
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
    private javax.swing.JTable tblTabla;
    // End of variables declaration//GEN-END:variables
}
