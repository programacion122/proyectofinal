/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejmplo_combo;

import Ejmplo_combo.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author David
 */
public class DepartamentoDAO {

    public void listar_departamento(JComboBox box){
        int contador=0;
        DefaultComboBoxModel value;//
        Conectar conec = new Conectar();//
        Statement st = null;//
        Connection con = null;//
        ResultSet rs = null;//
        try{
            con = conec.getConexion();//
            st = con.createStatement();//
            rs = st.executeQuery("SELECT * FROM usuarios");//
            value = new DefaultComboBoxModel();
            box.setModel(value);
            while(rs.next()){
                value.addElement(new DepartamentoVO(rs.getInt(2),rs.getString(3)));
            }
            contador++;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                st.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){
            }
        }
        
    }
    
}
