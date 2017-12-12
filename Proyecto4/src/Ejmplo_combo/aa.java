/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejmplo_combo;

import ds.desktop.notify.DesktopNotify;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**a
 *
 * @author cleyder
 */
public class aa extends javax.swing.JFrame {

    DepartamentoDAO de = new DepartamentoDAO();
   // DepartamentoDAO a=new DepartamentoDAO();
    //ProvinciaDAO pr = new ProvinciaDAO();
   //DistritoDAO di = new DistritoDAO();
    int contador=0;
    int color;
    

    public aa() {
        initComponents();
        combo_de.addItem("Select..");
        de.listar_departamento(combo_de);
        AutoCompleteDecorator.decorate(combo_de);
        CargarDato();
        
        
        //txtid.hide();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        combo_de = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtmensaje = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        combo_de.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_deActionPerformed(evt);
            }
        });

        jLabel1.setText("Destinatario");

        jLabel2.setText("Mensaje");

        txtmensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmensajeActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\cleyder\\Downloads\\letter.png")); // NOI18N
        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(combo_de, 0, 168, Short.MAX_VALUE)
                        .addComponent(txtmensaje)))
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_de, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void holamundo() {
        String nom = "Hola mundo";
        try {

        } catch (Exception e) {
        }
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String hola = txtmensaje.getText();
        DesktopNotify.showDesktopMessage("Contenido del mensaje ", "" + hola, DesktopNotify.TIP, 14000L);
        
        String username = txtmensaje.getText();

        Connection con = null;
        PreparedStatement pst = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/erp", "root", "root");
            pst = con.prepareStatement("insert into notificaciones (IdUsuarios,IdPerfiles,Contenido,Leido) values (?,1,?,0)");
            pst.setInt(1, color);
            pst.setString(2, username);

            int i = pst.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Data is saved");
            } else {
                JOptionPane.showMessageDialog(null, "Data no saved");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void combo_deActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_deActionPerformed
        Conexion cn= new Conexion() ;
        cn.getConnection();
        
        try {
            
            Connection con1 =DriverManager.getConnection("jdbc:mysql://localhost/erp","root","root");
            Statement sta1=con1.createStatement();
            String sql="select * from usuarios where NombreUsuario='"+this.combo_de.getSelectedItem()+"'";
            ResultSet rs1=sta1.executeQuery(sql);
            while(rs1.next()){
                //this.txtid.setText(String.valueOf(rs1.getInt("IdUsuarios")));
                color=rs1.getInt("IdUsuarios");
                System.out.println();
            }
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, e);
        }
         
    }//GEN-LAST:event_combo_deActionPerformed

    private void txtmensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmensajeActionPerformed

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
            java.util.logging.Logger.getLogger(aa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(aa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(aa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(aa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new aa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_de;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtmensaje;
    // End of variables declaration//GEN-END:variables
    public void CargarDato(){
     String aaa="";   
     Conexion con=new Conexion();
     
        try {
            
            
           Statement sta1=con.getConnection().createStatement();
            String cadena="select contenido from notificaciones where IdUsuarios="+color+" and leido =0";
            
            //ResultSet rs1=sta1.executeQuery();
            ResultSet rs1=sta1.executeQuery(cadena);
            while(rs1.next()){
                //this.txtid.setText(String.valueOf(rs1.getInt("IdUsuarios")));
                
                aaa=rs1.getString("Contenido");
                DesktopNotify.showDesktopMessage("Contenido del mensaje ", "" + aaa, DesktopNotify.TIP, 14000L);
                
            }
            
            Statement sta1l=con.getConnection().createStatement();
             String cadena2="UPDATE notificaciones SET leido=1 where IdUsuarios="+color+";";
             //ResultSet rs1a=s
                     sta1l.executeUpdate(cadena2);
             System.out.println(cadena2);
            
            
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, e);
        }
    
    }
}
