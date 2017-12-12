/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejmplo_combo;

import Ejmplo_combo.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author David
 */
public class ProvinciaDAO {
 
    public void listar_provincia(JComboBox box, int id){
        
        DefaultComboBoxModel value;
        Conectar conec = new Conectar();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try{
            con = conec.getConexion();
            ps = con.prepareStatement("SELECT * FROM provincia where idDepartamento = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            value = new DefaultComboBoxModel();
            box.setModel(value);
            while(rs.next()){
                value.addElement(new ProvinciaVO(rs.getInt(1),rs.getString(2)));
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                con.close();
            }catch(Exception ex){
            }
        }
        
    }
    
}
