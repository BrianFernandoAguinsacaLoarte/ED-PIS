/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.listas;

import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import modelo.CrearTarea;
import modelo.Matricula;
import modelo.controladores.ControladorCrearTarea;
import vista.listas.tablas.Tareas.ModeloTablaCrearTarea;
import vista.listas.util.UtilVista;

/**
 *
 * @author Usuario iTC
 */
public class FrmCrearTarea extends javax.swing.JFrame {

   private ControladorCrearTarea tarCon = new ControladorCrearTarea();
//    private ModeloTablaCrearTarea mtll = new ModeloTablaCrearTarea();
    String ruta_archivo = "";
    int id = -1;
    private String extensionArchivo;
    private Integer idDocente;
    private Integer idDocenteRegreso;

    ControladorCrearTarea controladorCrearTarea = new ControladorCrearTarea();
    LinkedList<CrearTarea> crearTareasList = controladorCrearTarea.listar();
    CrearTarea[] crearTareasArray = crearTareasList.toArray();
    
    public FrmCrearTarea() {

    }
    
    
    public void setIdDocente(Integer idDocente, Integer idDocenteRegreso) throws VacioExcepcion {
        this.idDocente = idDocente;
        this.idDocenteRegreso = idDocenteRegreso;
        initComponents();

        limpiar();
//        Calendar calendar = Calendar.getInstance();
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        String fechaActual = dateFormat.format(calendar.getTime());
//        txtFechaAsignacion.setText(fechaActual);
//
//        SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
//        String horaActual = horaFormat.format(calendar.getTime());
//        txtHoraAsignacion.setText(horaActual);

//        mtll.visualizar(tblTabla);
    }
    
     public Boolean validar() {
        return !txtTema.getText().trim().isEmpty()
                && !txtFechaAsignacion.getText().trim().isEmpty()
                && !txtHoraAsignacion.getText().trim().isEmpty()
                && !txtFechaEntrega.getText().trim().isEmpty()
                && !txtHoraEntrega.getText().trim().isEmpty()
                && !txtDescripcion.getText().trim().isEmpty();
    }
     
      private void limpiar() throws VacioExcepcion {

        txtTema.setText("");
        txtFechaAsignacion.setText("");
        txtFechaEntrega.setText("");
        txtHoraAsignacion.setText("");
        txtHoraEntrega.setText("");
        txtDescripcion.setText("");
        tarCon.setTarea(null);
        tarCon.setLista(new LinkedList<>());
//        cargarTabla();
//        tarCon.setTarea(null);
//        tarCon.setIndex(-1);
//        mtll.visualizar(tblTabla);
    }
    
    public void seleccionar_tarea() {
        JFileChooser j = new JFileChooser();

        int se = j.showOpenDialog(this);
        if (se == 0) {
            this.btnSeleccionar.setText("" + j.getSelectedFile().getName());
            ruta_archivo = j.getSelectedFile().getAbsolutePath();
            String nombre_archivo = j.getSelectedFile().getName();

            // Obtener la extensión del archivo seleccionado
            String extension = nombre_archivo.substring(nombre_archivo.lastIndexOf(".") + 1);

            //txtNombreFile.setText(nombre_archivo);
            extensionArchivo = extension;

            System.out.println("Extensión del archivo: " + extension);

            // presentarIcono(extension);
        } else {
        }
    }
    
    public void guardar() throws VacioExcepcion {
        if (validar()) {
            try {
                CrearTarea tarea = new CrearTarea();
                tarea.setTema(txtTema.getText());

                // Convertir las cadenas de fecha y hora a objetos Date
//                SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                String fechaAsignacionString = txtFechaAsignacion.getText() + " " + txtHoraAsignacion.getText();
                String fechaEntregaString = txtFechaEntrega.getText() + " " + txtHoraEntrega.getText();

//                String fechaAsignacionString = txtFechaAsignacion.getText();
//                String fechaEntregaString = txtFechaEntrega.getText();
                Date fechaAsignacion = formatoFechaHora.parse(fechaAsignacionString);
                Date fechaEntrega = formatoFechaHora.parse(fechaEntregaString);

                String codigoUnico = tarCon.generarCodigoUnico();
                tarea.setCodigo(codigoUnico);

                tarea.setFechaCreacion(fechaAsignacion);
                tarea.setFechaEntrega(fechaEntrega);
                tarea.setDescripcion(txtDescripcion.getText());

//                tarea.setArchivo(null);
//                tarea.setExtensionArchivo("pdf");
                File ruta = new File(ruta_archivo);
                try {
                    byte[] archivo = new byte[(int) ruta.length()];
                    InputStream input = new FileInputStream(ruta);
                    input.read(archivo);
                    Blob blobArchivo = new SerialBlob(archivo);
                    tarea.setArchivo(blobArchivo);
                } catch (IOException | SQLException ex) {
                    tarea.setArchivo(null);
                    System.out.println("Error al agregar archivo " + ex.getMessage());
                }
//                tarea.setExtensionArchivo("pdf");
                String extenArchivo = extensionArchivo;
                tarea.setExtensionArchivo(extenArchivo);
                tarea.setId_docenteMateria(idDocente);
                tarCon.setTarea(tarea);
                tarCon.guardar();
                tarCon.setTarea(null);

                // Limpiar la interfaz después de guardar
                limpiar();
                // Cargar y mostrar la lista actualizada de tareas
//                cargarTabla();

            } catch (ParseException e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    
    private void cargarVista() {
        tarCon.setIndex(tblTabla.getSelectedRow());
        if (tarCon.getIndex().intValue() < 0) {
            JOptionPane.showMessageDialog(null, "Selecciona una fila",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
//                tarCon.setTarea(mtll.getTareas().get(tarCon.getIndex()));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void modificarTarea() throws Exception {
        if (validar()) {
            try {

                int filaSeleccionada = tblTabla.getSelectedRow();
                Object idEscondido = tblTabla.getValueAt(filaSeleccionada, 0);
                String codigoTarea = idEscondido.toString();
                Integer codigoTareaInt = Integer.parseInt(codigoTarea);

                Integer idEncontrado = null;

                for (CrearTarea crearTarea : crearTareasArray) {
                    System.out.println("crear Tarea " + crearTarea.getCodigo());
                    if (crearTarea.getId().equals(codigoTareaInt)) {
                        System.out.println("Coincide");
                        idEncontrado = crearTarea.getId();
                        break;
                    } else {
                    }
                }
                
                System.out.println("Id encontrado: " + idEncontrado);

                CrearTarea tarea = controladorCrearTarea.obtener(idEncontrado);

                Integer id_Docente = tarea.getId_docenteMateria();
                Integer id = tarea.getId();

                // Convertir las cadenas de fecha y hora a objetos Date
                SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                String fechaAsignacionString = txtFechaAsignacion.getText() + " " + txtHoraAsignacion.getText();
                String fechaEntregaString = txtFechaEntrega.getText() + " " + txtHoraEntrega.getText();

                Date fechaAsignacion = formatoFechaHora.parse(fechaAsignacionString);
                Date fechaEntrega = formatoFechaHora.parse(fechaEntregaString);

                if (!ruta_archivo.isEmpty()) {
                    File ruta = new File(ruta_archivo);
                    if (ruta.exists()) {
                        try {
                            byte[] archivo = new byte[(int) ruta.length()];
                            InputStream input = new FileInputStream(ruta);
                            input.read(archivo);
                            Blob blobArchivo = new SerialBlob(archivo);
                            tarea.setArchivo(blobArchivo);
                        } catch (IOException | SQLException ex) {
                            tarea.setArchivo(null);
                            System.out.println("Error al agregar archivo " + ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El archivo no existe en la ruta especificada.");
                        return;
                    }
                }

                String extenArchivo = extensionArchivo;

                tarea.setId(id);
                tarea.setTema(txtTema.getText());
                tarea.setFechaCreacion(fechaAsignacion);
                tarea.setFechaEntrega(fechaEntrega);
                tarea.setCodigo(codigoTarea);
                tarea.setDescripcion(txtDescripcion.getText());
                tarea.setExtensionArchivo(extenArchivo);
                tarea.setId_docenteMateria(id_Docente);

                tarCon.setTarea(tarea);
                tarCon.modificar2(tarea);
                tarCon.setTarea(null);

                limpiar();

            } catch (ParseException e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
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
        btnRegresar = new org.edisoncor.gui.button.ButtonRect();
        txtTema = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        calendarioAsignacion = new com.toedter.calendar.JDateChooser();
        txtFechaAsignacion = new javax.swing.JTextField();
        txtHoraAsignacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        calendarioEntrega = new com.toedter.calendar.JDateChooser();
        txtFechaEntrega = new javax.swing.JTextField();
        txtHoraEntrega = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        labelRect2 = new org.edisoncor.gui.label.LabelRect();
        labelRect3 = new org.edisoncor.gui.label.LabelRect();
        labelRect4 = new org.edisoncor.gui.label.LabelRect();
        labelRect5 = new org.edisoncor.gui.label.LabelRect();
        labelRect6 = new org.edisoncor.gui.label.LabelRect();
        labelRect7 = new org.edisoncor.gui.label.LabelRect();
        labelRect8 = new org.edisoncor.gui.label.LabelRect();
        btnModificar = new org.edisoncor.gui.button.ButtonRect();
        btnGuardar = new org.edisoncor.gui.button.ButtonRect();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel1.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel2.setColorPrimario(new java.awt.Color(0, 102, 153));
        panel2.setColorSecundario(new java.awt.Color(0, 102, 153));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelRound1.setBackground(new java.awt.Color(0, 102, 153));
        labelRound1.setText("CREAR TAREA\n");
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
        panel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 590, 160, 40));
        panel1.add(txtTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 260, 30));

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        panel1.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 260, 30));

        calendarioAsignacion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarioAsignacionPropertyChange(evt);
            }
        });
        panel1.add(calendarioAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 230, 30));
        panel1.add(txtFechaAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 170, 230, 30));
        panel1.add(txtHoraAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, 230, 30));
        panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, -1, -1));

        calendarioEntrega.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarioEntregaPropertyChange(evt);
            }
        });
        panel1.add(calendarioEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 230, 30));
        panel1.add(txtFechaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 300, 230, 30));

        txtHoraEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraEntregaActionPerformed(evt);
            }
        });
        panel1.add(txtHoraEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 340, 230, 30));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 430, 160));

        labelRect2.setBackground(new java.awt.Color(255, 255, 255));
        labelRect2.setForeground(new java.awt.Color(0, 0, 0));
        labelRect2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect2.setText("Seleccionar Archivo: ");
        labelRect2.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect2.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 150, 30));

        labelRect3.setBackground(new java.awt.Color(255, 255, 255));
        labelRect3.setForeground(new java.awt.Color(0, 0, 0));
        labelRect3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect3.setText("Descripcion:\n");
        labelRect3.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect3.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 150, 30));

        labelRect4.setBackground(new java.awt.Color(255, 255, 255));
        labelRect4.setForeground(new java.awt.Color(0, 0, 0));
        labelRect4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect4.setText("Hora Entrega  (HH:MI:SS): ");
        labelRect4.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect4.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 230, 30));

        labelRect5.setBackground(new java.awt.Color(255, 255, 255));
        labelRect5.setForeground(new java.awt.Color(0, 0, 0));
        labelRect5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect5.setText("Tema:\n");
        labelRect5.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect5.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 150, 30));

        labelRect6.setBackground(new java.awt.Color(255, 255, 255));
        labelRect6.setForeground(new java.awt.Color(0, 0, 0));
        labelRect6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect6.setText("Fecha Entrega: ");
        labelRect6.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect6.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 200, 30));

        labelRect7.setBackground(new java.awt.Color(255, 255, 255));
        labelRect7.setForeground(new java.awt.Color(0, 0, 0));
        labelRect7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect7.setText("Fecha Asignacion: ");
        labelRect7.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect7.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 200, 30));

        labelRect8.setBackground(new java.awt.Color(255, 255, 255));
        labelRect8.setForeground(new java.awt.Color(0, 0, 0));
        labelRect8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRect8.setText("Hora Asignacion (HH:MI:SS): ");
        labelRect8.setColorDeBorde(new java.awt.Color(255, 255, 255));
        labelRect8.setColorDeSombra(new java.awt.Color(255, 255, 255));
        panel1.add(labelRect8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 230, 30));

        btnModificar.setBackground(new java.awt.Color(0, 102, 153));
        btnModificar.setText("Modificar\n");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        panel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 390, 160, 40));

        btnGuardar.setBackground(new java.awt.Color(0, 102, 153));
        btnGuardar.setText("Guardar\n");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 160, 40));

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tema", "Fecha Asignacion", "Fecha Entrega", "Archivo", "Extension"
            }
        ));
        tblTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTabla);

        panel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 640, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
       int opcion = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea Regresar a la pagina Principal?", "YES-NO", YES_NO_OPTION);
        if (opcion == 0) {
            FrmPantallDocente fpi = new FrmPantallDocente();
            System.out.println("Desde boton regresar");
            System.out.println("Id docenteregreso " + idDocenteRegreso);
            fpi.setIdDocente(idDocenteRegreso);
            fpi.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        seleccionar_tarea();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void calendarioAsignacionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarioAsignacionPropertyChange
        // TODO add your handling code here:
        if (calendarioAsignacion.getDate() != null) {
            SimpleDateFormat fc = new SimpleDateFormat("dd-MM-yyyy");
            txtFechaAsignacion.setText(fc.format(calendarioAsignacion.getDate()));
        }
    }//GEN-LAST:event_calendarioAsignacionPropertyChange

    private void calendarioEntregaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarioEntregaPropertyChange
        // TODO add your handling code here:
        if (calendarioEntrega.getDate() != null) {
            SimpleDateFormat fc = new SimpleDateFormat("dd-MM-yyyy");
            txtFechaEntrega.setText(fc.format(calendarioEntrega.getDate()));
        }
    }//GEN-LAST:event_calendarioEntregaPropertyChange

    private void txtHoraEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraEntregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraEntregaActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       try {
           modificarTarea();
       } catch (Exception ex) {
           Logger.getLogger(FrmCrearTarea.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       try {
           // TODO add your handling code here:
           guardar();
       } catch (VacioExcepcion ex) {
           Logger.getLogger(FrmCrearTarea.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tblTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaMouseClicked
        // TODO add your handling code here:
        int column = tblTabla.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblTabla.getRowHeight();
        //
        ////        txtTema.setEnabled(true);
        //        if (row < tblTabla.getRowCount() && row >= 0 && column < tblTabla.getColumnCount() && column >= 0) {
            //            id = (int) tblTabla.getValueAt(row, 5);
            Object value = tblTabla.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getText().equals("Vacio")) {
                    JOptionPane.showMessageDialog(null, "No hay archivo");
                } else if (boton.getText().equals("Ver Tareas Entregadas")){
                    //                this.dispose();
                }
            }
            //            else {
                //                String tema = "" + tblTabla.getValueAt(row, 1);
                //                txtTema.setText(tema);
                //
                //                String fechaCreacion = "" + tblTabla.getValueAt(row, 3);
                //                txtFechaAsignacion.setText(fechaCreacion);
                //
                //                String fechaEntrega = "" + tblTabla.getValueAt(row, 4);
                //                txtFechaEntrega.setText(fechaEntrega);
                //
                //                String descripcion = "" + tblTabla.getValueAt(row, 2);
                //                txtDescripcion.setText(descripcion);
                //
                //                CrearTarea tarea = new CrearTarea();
                //                tarea.setId(id);
                //
                //                Date fechCompleta = tarea.getFechaEntrega();
                //                System.out.println("fehca completa : " + fechCompleta);
                //                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //                String fechaComoString = formatoFecha.format(fechCompleta);
                //                String horaAsignacion = fechaComoString.substring(11, 19);
                //                System.out.println(horaAsignacion);
                //                txtHoraEntrega.setText(horaAsignacion);
                //
                //            }
            //        }
    }//GEN-LAST:event_tblTablaMouseClicked

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
            java.util.logging.Logger.getLogger(FrmCrearTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCrearTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCrearTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCrearTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrmCrearTarea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRect btnGuardar;
    private org.edisoncor.gui.button.ButtonRect btnModificar;
    private org.edisoncor.gui.button.ButtonRect btnRegresar;
    private javax.swing.JButton btnSeleccionar;
    private com.toedter.calendar.JDateChooser calendarioAsignacion;
    private com.toedter.calendar.JDateChooser calendarioEntrega;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JTable tblTabla;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFechaAsignacion;
    private javax.swing.JTextField txtFechaEntrega;
    private javax.swing.JTextField txtHoraAsignacion;
    private javax.swing.JTextField txtHoraEntrega;
    private javax.swing.JTextField txtTema;
    // End of variables declaration//GEN-END:variables
}
