/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.listas;

import controlador.TDA.listas.LinkedList;
import javax.swing.JOptionPane;
import modelo.Persona;
import modelo.persona.PersonaController;
import vista.listas.tablas.ModeloTablaPersona;
import vista.listas.util.UtilVista;

/**
 *
 * @author Usuario iTC
 */
public class FrmPersona extends javax.swing.JDialog {

    //Objetos
    PersonaController pc = new PersonaController();
    ModeloTablaPersona mtp = new ModeloTablaPersona();
    
    
    public FrmPersona(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limpiar();
        this.setLocationRelativeTo(null);
    }
    
    public FrmPersona() {
        initComponents();
        limpiar();
        this.setLocationRelativeTo(null);
    }
    
    
    //Cargo mi tabla en la vista
    private void cargarTabla(){
        mtp.setPersonas(pc.getPersonas());
        jTablePersona.setModel(mtp);
        jTablePersona.updateUI();
    }
    
    //Verifico si el texto sin espacios esta vacio
    private boolean validar(){
        return !txtNombre.getText().trim().isEmpty() &&
               !txtApellido.getText().trim().isEmpty() &&
               !txtEdad.getText().trim().isEmpty() &&
               !txtCorreo.getText().trim().isEmpty() &&
               !txtDireccion.getText().trim().isEmpty() &&
               !txtTelefono.getText().trim().isEmpty() &&
               !txtCedula.getText().trim().isEmpty();
    }
    
    //Cargar datos en la vista
    private void limpiar(){
        UtilVista.cargarGenero(cbxGenero);//CargoCombo
        UtilVista.cargarRol(cbxRol);//CargoCombo
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        cbxGenero.setSelectedItem(-1);//Limpio Combo
        cbxRol.setSelectedItem(-1);//Limpio Combo
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCedula.setText("");
        
        pc.setPersona(null);
        pc.setPersonas(new LinkedList<>());
        cargarTabla();
        //Actualizar tabla -BDD desaparece
        jTablePersona.clearSelection();
        pc.setIndex(-1);
    }
    
    
    //Guardo la informacion 
    private void guardar(){
        if(validar()){
            try {
                pc.getPersona().setNombres(txtNombre.getText());
                pc.getPersona().setApellidos(txtApellido.getText());
                pc.getPersona().setEdad(Integer.parseInt(txtEdad.getText()));
                pc.getPersona().setGenero(UtilVista.getComboGenero(cbxGenero));
                pc.getPersona().setRol(UtilVista.getComboRol(cbxRol)); 
                pc.getPersona().setCorreo(txtCorreo.getText());
                pc.getPersona().setDireccion(txtDireccion.getText());
                pc.getPersona().setTelefono(txtTelefono.getText());
                pc.getPersona().setCedula(txtCedula.getText());
                
                //Guardar
                if(pc.getPersona().getId() == null){
                   if(pc.save()){
                    limpiar();
                        JOptionPane.showMessageDialog(null, "Se ha guardado correctamente", 
                            "OK", JOptionPane.INFORMATION_MESSAGE);
                   
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha podido guardar", 
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    } 
                }else{
                    if(pc.update(pc.getIndex())){
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
        pc.setIndex(jTablePersona.getSelectedRow());
        if(pc.getIndex().intValue() < 0){
            JOptionPane.showMessageDialog(null, "Selecciona una fila", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                pc.setPersona(mtp.getPersonas().get(pc.getIndex()));
                txtNombre.setText(pc.getPersona().getNombres());
                txtApellido.setText(pc.getPersona().getApellidos());
                txtEdad.setText(pc.getPersona().getEdad().toString());
                cbxGenero.setSelectedItem(pc.getPersona().getGenero());
                cbxRol.setSelectedItem(pc.getPersona().getRol());
                txtCorreo.setText(pc.getPersona().getCorreo());
                txtDireccion.setText(pc.getPersona().getDireccion());
                txtTelefono.setText(pc.getPersona().getTelefono());
                txtCedula.setText(pc.getPersona().getCedula());
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
        
     
            try {
                System.out.println("Ordenando con QuickSOrt");
                mtp.setPersonas(pc.ordenarQuickSort(pc.getPersonas(), ascdesc, criterio));
                jTablePersona.setModel(mtp);
                jTablePersona.updateUI();
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
            LinkedList<Persona> listaResultado;
            switch (busqueda) {
                case "Busqueda Binaria":
                    if (field.equalsIgnoreCase("nombres") || field.equalsIgnoreCase("apellidos")
                            || field.equalsIgnoreCase("correo") || field.equalsIgnoreCase("genero")
                            || field.equalsIgnoreCase("rol") || field.equalsIgnoreCase("direccion")
                            || field.equalsIgnoreCase("telefono") || field.equalsIgnoreCase("cedula")) {
                        listaResultado = pc.busquedaBinaria(pc.getPersonas(), text, field);
                    } else if (field.equalsIgnoreCase("id") || field.equalsIgnoreCase("edad")) {
                        try {
                            int textoEntero = Integer.parseInt(text);
                            listaResultado = pc.busquedaBinariaEntero(pc.getPersonas(), textoEntero, field);
                        } catch (NumberFormatException ex) {
                            throw new IllegalArgumentException("Debe ser entero");
                        }
                    } else {
                        throw new IllegalArgumentException("No existe el campo " + field);
                    }
                    break;

                case "Busqueda Lineal":
                    if (field.equalsIgnoreCase("nombres") || field.equalsIgnoreCase("apellidos")
                            || field.equalsIgnoreCase("correo") || field.equalsIgnoreCase("genero")
                            || field.equalsIgnoreCase("rol") || field.equalsIgnoreCase("direccion")
                            || field.equalsIgnoreCase("telefono") || field.equalsIgnoreCase("cedula")) {
                        listaResultado = pc.busquedaLinealBinaria(pc.getPersonas(), text, field);
                    } else if (field.equalsIgnoreCase("id") || field.equalsIgnoreCase("edad")) {
                        try {
                            int textoEntero = Integer.parseInt(text);
                            listaResultado = pc.busquedaLinealBinariaEntero(pc.getPersonas(), textoEntero, field);
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

            mtp.setPersonas(listaResultado);
            jTablePersona.setModel(mtp);
            jTablePersona.updateUI();

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
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbxGenero = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePersona = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbxRol = new javax.swing.JComboBox<>();
        jLabelTexto1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbxBusqueda = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbxCriterio = new javax.swing.JComboBox<>();
        cbxAscDesc = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel3.setText("Nombres: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 100, 20));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 240, -1));

        jLabel10.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel10.setText("Apellidos:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 100, 20));

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 240, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel4.setText("Edad:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 100, 20));

        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 240, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel8.setText("Rol:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 100, 20));

        cbxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 240, -1));

        jLabel5.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel5.setText("Correo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 100, 20));

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 240, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel2.setText("Teléfono: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 100, 20));

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 240, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel7.setText("Cédula: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 100, 20));

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 240, -1));

        jTablePersona.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablePersona);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 790, 110));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro Persona");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 190, -1));

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

        btnActualizar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, -1, -1));

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

        jLabel6.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel6.setText("Dirección: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 100, 20));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 240, -1));

        btnRegresar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 570, 170, 30));

        jLabel9.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel9.setText("Género:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 100, 20));

        cbxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbxRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 240, -1));

        jLabelTexto1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabelTexto1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTexto1.setText("Texto de Busqueda:");
        jPanel1.add(jLabelTexto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 100, 210, 40));

        jLabel13.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Busquedas");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, 200, 40));

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        jPanel1.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 170, 170, 40));

        jLabel14.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Métodos de Busqueda:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 230, 210, 40));

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

        jLabel12.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Ordenamiento");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 60, 200, 40));

        jLabel11.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Criterios:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 100, 130, 40));

        cbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOMBRES", "APELLIDOS", "DIRECCION", "ROL", "GENERO", "CORREO", "CEDULA", "TELEFONO", "ID", "EDAD", " " }));
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
        jPanel1.add(cbxAscDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 250, -1, 40));

        jButton4.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jButton4.setText("Ordenar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 350, 160, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1504, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cargarVista();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPersona dialog = new FrmPersona(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxAscDesc;
    private javax.swing.JComboBox<String> cbxBusqueda;
    private javax.swing.JComboBox<String> cbxCriterio;
    private javax.swing.JComboBox<String> cbxGenero;
    private javax.swing.JComboBox<String> cbxRol;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTexto1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePersona;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
