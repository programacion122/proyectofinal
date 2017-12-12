package Forms;

import BO.PerfilesBO;
import BO.PersonalBO;
import BO.UsuarioBO;
import DAO.UsuarioDAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author md
 */
public class dlgUsuarios extends javax.swing.JDialog {
    private UsuarioBO objUsuBo;
    private PersonalBO objPersBo;
    private int[] idsPerf;
    private String[] idsPerso;
    private ArrayList <PerfilesBO> listaPerfiles;
    private ArrayList <PersonalBO> listaPersonal;
    private int cont;
    private int contd;
    private boolean editar;
    private boolean mostrarDat;
    private String claveSelec;
    private String contraG;

    /**
     * Creates new form dlgUsuarios
     * @param parent
     * @param modal
     */
    public dlgUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        objUsuBo = new UsuarioBO();
        objPersBo = new PersonalBO();
        listaPerfiles = UsuarioDAO.consultarPerfiles();
        cont = 0;
        contd = 0;
        editar = false;
        mostrarDat = false;
        claveSelec = "";
        contraG = "";
        
        initComponents();
        
        listarUsuarios(0, "", "", 0, 0);//Trae todos los registros
        lblCodPerf.setVisible(false);
        lblUserID.setVisible(false);
        lblClave.setVisible(false);
        mostrarPerfiles();//Muestra los perfiles en el combobox
        mostrarPersonal("");//Muestra el personal en el combobox
        setTextFieldChanged(txtEmpleado);
        lblCodPerf.setText("1");
        lblClave.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtusuario = new javax.swing.JTextField();
        jcmbPersonal = new javax.swing.JComboBox<>();
        txtContrasena = new javax.swing.JTextField();
        lblClave = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JCmbPerfiles = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {

                return false; //Las celdas no son editables.

            }
        };
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCodPerf = new javax.swing.JLabel();
        lblUserID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuarios");
        setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        setLocation(new java.awt.Point(200, 200));
        setName("dlgUsuarios"); // NOI18N
        setResizable(false);

        txtusuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jcmbPersonal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcmbPersonal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcmbPersonal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbPersonalItemStateChanged(evt);
            }
        });

        txtContrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtContrasena.setAutoscrolls(false);
        txtContrasena.setMaximumSize(new java.awt.Dimension(20, 10));

        lblClave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblClave.setText("jLabel5");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Perfil:");

        JCmbPerfiles.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JCmbPerfiles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JCmbPerfiles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCmbPerfilesItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Empleado:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Contraseña:");

        txtEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icond.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setPreferredSize(new java.awt.Dimension(120, 40));

        jTableUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableUsuariosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUsuarios);

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icong.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setPreferredSize(new java.awt.Dimension(120, 40));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setPreferredSize(new java.awt.Dimension(120, 40));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/iconca.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(120, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCodPerf, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(JCmbPerfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcmbPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClave))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCodPerf, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcmbPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lblClave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCmbPerfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcmbPersonalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbPersonalItemStateChanged
        // TODO add your handling code here:
        if(jcmbPersonal.getItemCount() > 0) {
            int select = jcmbPersonal.getSelectedIndex();
            if(contd == 0) {
                lblClave.setText("0");
            }else {

                if(select == 0) {
                    lblClave.setText("0");
                }else {
                    lblClave.setText("" + idsPerso[select - 1]);
                    //System.out.println(jcmbPersonal.getSelectedItem().toString());
                }
            }
            contd++;
        }
    }//GEN-LAST:event_jcmbPersonalItemStateChanged

    private void JCmbPerfilesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCmbPerfilesItemStateChanged
        // TODO add your handling code here:
        int select = JCmbPerfiles.getSelectedIndex();
        if(cont == 0) {
            lblCodPerf.setText("1");
        }else {
            lblCodPerf.setText("" + idsPerf[select]);
        }
        cont++;
    }//GEN-LAST:event_JCmbPerfilesItemStateChanged

    private void jTableUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuariosMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int fila = jTableUsuarios.getSelectedRow();//Obtiene el indice de la fila
            if(fila >=0) {//Verifica que se haya seleccionado una fila
                mostrarDat = true;
                editar = true;//Activa la opcion de editar
                btnCancelar.setEnabled(true);//Activa el boton de cancelar
                btnBuscar.setEnabled(false);//Bloquea el boton de busar
                lblUserID.setText(jTableUsuarios.getValueAt(fila, 0).toString());//obtiene el código del usuario
                txtusuario.setText(jTableUsuarios.getValueAt(fila, 1).toString());//Muestra el nombre del perfil seleccionado
                txtContrasena.setText(jTableUsuarios.getValueAt(fila, 2).toString());//obtiene la contra del perfil
                contraG = txtContrasena.getText();
                txtContrasena.setEditable(false);
                lblCodPerf.setText(jTableUsuarios.getValueAt(fila, 3).toString());//obtiene el codigo del perfil
                lblClave.setText(jTableUsuarios.getValueAt(fila, 4).toString());//obtiene el código del empleao
                claveSelec = jTableUsuarios.getValueAt(fila, 4).toString();
                String empl = UsuarioDAO.buscarEmp(Integer.parseInt(lblClave.getText()));
                txtEmpleado.setText(empl);

                bloquearCamposEntrada();
                btnEliminar.setEnabled(true);
                btnGuardar.setText("Modificar");
            }else {
                JOptionPane.showMessageDialog(null, "Porfavor seleccione una fila...");
            }
        }
    }//GEN-LAST:event_jTableUsuariosMousePressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(verificarCampos() == false) {
            JOptionPane.showMessageDialog(null, "Error! porfavor ingrese los datos requeridos..");
        }else {
            if(editar == false) {
                if(Guardar()) {
                    JOptionPane.showMessageDialog(null, "Registro agregado correctamente!!!");
                    listarUsuarios(0, "", "", 0, 0);//Actualiza los registros que se muestran
                    resetearCampos();

                }else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al agregar el perfil!");
                }
            }else {
                if(btnGuardar.getText().trim().equals("Modificar")) {
                    desbloquearCamposEntrada();
                    txtEmpleado.requestFocus();
                    btnGuardar.setText("Guardar");
                }else {
                    if(Modificar()) {
                        JOptionPane.showMessageDialog(null, "Registro modificado correctamente!!!");
                        listarUsuarios(0, "", "", 0, 0);//Actualiza los registros que se muestran
                        resetearCampos();
                    }else {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error al modificar el perfil!");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        if(txtEmpleado.getText().trim().equals("") && txtusuario.getText().trim().equals("") && txtContrasena.getText().trim().equals("")) {
            listarUsuarios(0, "", "", 0, 0);
        }else {
            listarUsuarios(Integer.parseInt(lblCodPerf.getText().trim()), txtusuario.getText().trim(), "", Integer.parseInt(lblClave.getText().trim()), 1);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        resetearCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void setTextFieldChanged(JTextField txt) {
        DocumentListener documentL = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                /*System.out.println("insert");
                lblClave.setText(txtEmpleado.getText());*/
                try{
                mostrarPersonal(txtEmpleado.getText());
                }catch(Exception er) {
                    System.out.println("Ninguna coincidencia");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                /*System.out.println("remove");
                lblClave.setText(txtEmpleado.getText());*/
                try{
                mostrarPersonal(txtEmpleado.getText());
                }catch(Exception er) {
                    System.out.println("Ninguna coincidencia");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                /*System.out.println("change");
                lblClave.setText(txtEmpleado.getText());*/
                try{
                mostrarPersonal(txtEmpleado.getText());
                }catch(Exception er) {
                    System.out.println("Ninguna coincidencia");
                }
            }
        };
        txt.getDocument().addDocumentListener(documentL);
    }
    
    private void mostrarPerfiles() {
        JCmbPerfiles.removeAllItems();
        idsPerf = new int[listaPerfiles.size()];
        for (int i = 0; i < listaPerfiles.size(); i++) {
            JCmbPerfiles.addItem(listaPerfiles.get(i).getNombrePerfil());
            idsPerf[i] = listaPerfiles.get(i).getIdPerfil();
            //System.out.println(idsPerf[i]);
        }
    }
    
    private void mostrarPersonal(String Nombre) {
        listaPersonal = UsuarioDAO.buscarPersonal(Nombre);
        jcmbPersonal.removeAllItems();
        jcmbPersonal.addItem("Seleccionar...");
        if(listaPersonal.size() > 0) {
            idsPerso = new String[listaPersonal.size()];
            for (int i = 0; i < listaPersonal.size(); i++) {
                jcmbPersonal.addItem(listaPersonal.get(i).getNombre());
                idsPerso[i] = listaPersonal.get(i).getClave();
                //System.out.println(idsPerf[i]);
            }
        }else{System.out.println("Sin resultado");}
    }
    
    public boolean verificarCampos() {
        if( txtusuario.getText().trim().equals("")    ||
            txtContrasena.getText().trim().equals("") ||
            jcmbPersonal.getSelectedIndex() == 0 ) {
            return false;
        }else {
            return true;
        }
    }
    
    private void listarUsuarios(int idPerfil, String usuario, String contra, int idPersonal, int opcion) {
        try{
            ResultSet result;
            result = UsuarioDAO.Lista(idPerfil, usuario, contra, idPersonal, opcion);
            DefaultTableModel modelo = new DefaultTableModel();
            this.jTableUsuarios.setModel(modelo);
            
            java.sql.ResultSetMetaData mtDatos = result.getMetaData();
            int numColumn = mtDatos.getColumnCount();
            Object[] nomCampos = new Object[numColumn];
            for(int i = 0; i < numColumn; i++) {
                nomCampos[i] = mtDatos.getColumnLabel(i+1);
            }
            modelo.setColumnIdentifiers(nomCampos);
            while(result.next()) {
                Object[] fila = new Object[numColumn];
                for(int j = 0; j < numColumn; j++) {
                    fila[j] = result.getObject(j+1);
                }
                modelo.addRow(fila);
            }
            //result.close();
        }catch(Exception err) {
            System.out.println("Error! no hay nada en la base de datos...");
        }
    }
    
    public boolean Guardar() {
        String passw = util.SHA1.cifrarContra(txtContrasena.getText().trim());
        try{
            objUsuBo.setIdPerfil(Integer.parseInt(lblCodPerf.getText().trim()));
            objUsuBo.setNombreUsuario(txtusuario.getText().trim());
            objUsuBo.setHashContra(passw);
            objUsuBo.setClaveEmp(lblClave.getText().trim());
            
            UsuarioDAO.AgregarUsuario(objUsuBo);
            return true;
        }catch(Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error! Puede que el código ya esté registrado...");
            return false;
        }
    }
    
    public boolean Modificar() {
        try{
            objUsuBo.setIdUsuario(Integer.parseInt(lblUserID.getText().trim()));
            objUsuBo.setIdPerfil(Integer.parseInt(lblCodPerf.getText().trim()));
            objUsuBo.setNombreUsuario(txtusuario.getText().trim());
            //objUsuBo.setHashContra(objUsuBo.encriptarContrasena(txtContrasena.getText().trim()));
            objUsuBo.setClaveEmp(lblClave.getText().trim());
            
            UsuarioDAO.Modificarusuarios(objUsuBo);
            return true;
        }catch(Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error!...");
            return false;
        }
    }
    
    public boolean Eliminar(int codUser) {
        try{
            objUsuBo.setIdUsuario(codUser);
            
            UsuarioDAO.EliminarUsuario(objUsuBo);
            return true;
        }catch(Exception e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error!...");
            return false;
        }
    }
    
    public void desbloquearCamposEntrada() {
        txtEmpleado.requestFocus();
        //chkEditar.setEnabled(true);
        txtEmpleado.setEditable(true);
        txtusuario.setEditable(true);
        //txtContrasena.setEditable(true);
        JCmbPerfiles.setEnabled(true);
        jcmbPersonal.setEnabled(true);
    }
    
    public void bloquearCamposEntrada() {
        //chkEditar.setEnabled(false);
        txtEmpleado.setEditable(false);
        txtusuario.setEditable(false);
        txtContrasena.setEditable(false);
        JCmbPerfiles.setEnabled(false);
        jcmbPersonal.setEnabled(false);
    }
    
    public void resetearCampos() {
        txtEmpleado.requestFocus();
        txtEmpleado.setText("");
        txtusuario.setText("");
        txtContrasena.setText("");
        lblClave.setText("0");
        lblCodPerf.setText("1");
        lblUserID.setText("0");
        btnGuardar.setEnabled(true);
        btnBuscar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(false);
        //chkEditar.setEnabled(false);
        txtContrasena.setEditable(true);
        JCmbPerfiles.setEnabled(true);
        jcmbPersonal.setEnabled(true);
        
        txtEmpleado.setEditable(true);
        txtusuario.setEditable(true);
        txtContrasena.setEditable(true);
        JCmbPerfiles.setEnabled(true);
        jcmbPersonal.setEnabled(true);
        
        cont = 0;
        listarUsuarios(0, "", "", 0, 0);
        claveSelec = "";
        mostrarDat = false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCmbPerfiles;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JComboBox<String> jcmbPersonal;
    public static javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblCodPerf;
    private javax.swing.JLabel lblUserID;
    private javax.swing.JTextField txtContrasena;
    public static javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
