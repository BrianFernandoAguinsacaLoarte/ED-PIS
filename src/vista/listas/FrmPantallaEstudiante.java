/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.listas;

import controlador.TDA.listas.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.DocenteMateria;
import modelo.Malla;
import modelo.Materia;
import modelo.Matricula;
import modelo.MatriculaCursoMateria;
import modelo.controladores.CursoController;
import modelo.controladores.DocenteController;
import modelo.controladores.DocenteMateriaController;
import modelo.controladores.MallaController;
import modelo.controladores.MateriaController;
import modelo.controladores.MatriculaController;
import modelo.controladores.MatriculaCursoMateriaControlador;
import vista.listas.tablas.ModeloTablaMalla;
import vista.listas.util.UtilVista;

/**
 *
 * @author Usuario iTC
 */

public class FrmPantallaEstudiante extends javax.swing.JFrame {

    private int idMateriaSeleccionada;
    private int idCursoSeleccionado;

    private Integer idEstudiante;
    private Integer idDocente;

    MatriculaCursoMateria[] coincidenciasArray = null;

    MatriculaController matriculaControlador = new MatriculaController();
    LinkedList<Matricula> matriculasLinkedList = matriculaControlador.listar();

    MateriaController materiaControlador = new MateriaController();
    CursoController cursoControlador = new CursoController();

    MatriculaCursoMateriaControlador mcmControlador = new MatriculaCursoMateriaControlador();

    LinkedList<MatriculaCursoMateria> matriculaCursoMateriaList = mcmControlador.listar();
    MatriculaCursoMateria[] matriculaCursoMateriaArray = matriculaCursoMateriaList.toArray();

    LinkedList<MatriculaCursoMateria> coincidenciasList = new LinkedList<>();

    public FrmPantallaEstudiante() {

    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
        initComponents();
        System.out.println("idEstudiante desde Pantalla estudiante: " + idEstudiante);
        buscarCursoMaterias();
        presentarMateriasCursos();
    }

    private void buscarCursoMaterias() {

        Matricula[] matriculaArray = matriculasLinkedList.toArray();

        Integer estudiante = idEstudiante;
        System.out.println("idEstudiante" + estudiante);

        Matricula matriculaEstudiante = null;
        for (Matricula matricula : matriculaArray) {
            if (matricula.getId_estudiante().equals(estudiante)) {
                matriculaEstudiante = matricula;
                System.out.println("Encontrado");
                break;
            }
        }

        if (matriculaEstudiante != null) {
            System.out.println("La matrícula del estudiante con ID " + estudiante + " es: " + matriculaEstudiante.getId());

            for (MatriculaCursoMateria mcm : matriculaCursoMateriaArray) {
                if (mcm.getId_matricula() == matriculaEstudiante.getId()) {
                    coincidenciasList.add(mcm);
                }
            }

            coincidenciasArray = coincidenciasList.toArray();
        }

    }

    private void presentarMateriasCursos() {
        cbxMaterias.removeAllItems();

        if (coincidenciasArray != null) {
            for (MatriculaCursoMateria matriculaCursoMateria : coincidenciasArray) {

                Materia materia = materiaControlador.obtener(matriculaCursoMateria.getId_materia());
                Curso curso = cursoControlador.obtener(matriculaCursoMateria.getId_curso());

                String materiaCurso = "(" + materia.getId() + ") - (" + curso.getId() + ") "
                        + materia.getNombre() + " - " + curso.toString();
                cbxMaterias.addItem(materiaCurso);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay tareas asignadas aun");
        }

    }

    private void obtenerIdDocenteMateriaSeleccionada() {

        System.out.println("FRM PANTALLA ESTUDIANTE -- obtener id Docente - estudiante");
        MatriculaCursoMateriaControlador mcmControlador = new MatriculaCursoMateriaControlador();
        DocenteMateriaController dmControlador = new DocenteMateriaController();

        LinkedList<MatriculaCursoMateria> estudianteMateria = mcmControlador.listar();
        MatriculaCursoMateria[] estudianteMateriaArray = estudianteMateria.toArray();

        LinkedList<DocenteMateria> docenteMateria = dmControlador.listar();
        DocenteMateria[] docenteMateriaArray = docenteMateria.toArray();

        System.out.println("verificar esto: id estudiante" + idEstudiante);
        System.out.println("");
        String seleccion = (String) cbxMaterias.getSelectedItem();

        Integer idDocenteMateria = null;
        Integer idEstudianteMateria = null;

        String[] partes = seleccion.split("\\) - \\(");
        Integer idMateria = Integer.parseInt(partes[0].substring(1));
        Integer idCurso = Integer.parseInt(partes[1].substring(0, partes[1].indexOf(")")));

        System.out.println("Materia id: " + idMateria);
        System.out.println("Curso id: " + idCurso);

        for (DocenteMateria coincidenciaDocente : docenteMateriaArray) {
            if (coincidenciaDocente.getId_materia().equals(idMateria) && coincidenciaDocente.getId_curso().equals(idCurso)) {
                idDocenteMateria = coincidenciaDocente.getId();
                System.out.println("ID del docente de la materia seleccionada: " + idDocenteMateria);
                break;
            }
        }

        for (MatriculaCursoMateria coincidenciaEstudiante : estudianteMateriaArray) {
            if (coincidenciaEstudiante.getId_materia().equals(idMateria) && coincidenciaEstudiante.getId_curso().equals(idCurso) && coincidenciaEstudiante.getId_matricula().equals(idEstudiante)) {
                idEstudianteMateria = coincidenciaEstudiante.getId();
                System.out.println("ID del estudiante de la materia seleccionada: " + idEstudianteMateria);
                break;
            }
        }

        TareasAsignadas tareaAsignadas = new TareasAsignadas();
        tareaAsignadas.setIdEstudiante(idEstudiante, idEstudianteMateria, idDocenteMateria);
        tareaAsignadas.setVisible(true);
        this.dispose();

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
        labelRect2 = new org.edisoncor.gui.label.LabelRect();
        btnSeleccionar = new org.edisoncor.gui.button.ButtonRect();
        cbxMaterias = new org.edisoncor.gui.comboBox.ComboBoxRect();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel2.setColorPrimario(new java.awt.Color(0, 102, 153));
        panel2.setColorSecundario(new java.awt.Color(0, 102, 153));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelRound1.setBackground(new java.awt.Color(0, 102, 153));
        labelRound1.setText("Pantalla Estudiante\n");
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
        labelRect2.setText("Materias A Cursar\n");
        labelRect2.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect2.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 180, 30));

        btnSeleccionar.setBackground(new java.awt.Color(0, 102, 153));
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        panel1.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 130, 40));
        panel1.add(cbxMaterias, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 400, 30));

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

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        obtenerIdDocenteMateriaSeleccionada();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPantallaEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPantallaEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPantallaEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPantallaEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrmPantallaEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRect btnSeleccionar;
    private org.edisoncor.gui.comboBox.ComboBoxRect cbxMaterias;
    private org.edisoncor.gui.label.LabelRect labelRect2;
    private org.edisoncor.gui.label.LabelRound labelRound1;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.PanelImage panelLogo;
    // End of variables declaration//GEN-END:variables
}
