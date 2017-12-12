/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejmplo_combo;

import java.sql.*;






/**
 *
 * @author cleyder
 */
public class sqluser extends Conexion{
        PreparedStatement ps=null;
        ResultSet rs=null;
//    public boolean registrar(usuarios usr)
//    {
////
////        Connection cn=getConnection();
////        String sql="insert into (IdUsuarios,IdPerfiles,Contenido,Leido) values (?,1,?,0 " ;
////        try {
////            ps=cn.prepareStatement(sql);
////            ps.setInt(1, usr.getId());
////            ps.setString(2, usr.getContenido());
////            ps.execute();
////            return true;
////        } catch (SQLException e) {
////            return false;
////        }
////    }
 public boolean login (usuarios usr) 
    {
        Connection cn=getConnection();
        String sql="select IdUsuarios, IdPerfiles, NombreUsuario, HashContra from usuarios where NombreUsuario = ? " ;
        try {
            ps=cn.prepareStatement(sql);
            ps.setString(1, usr.nombre);
            rs=ps.executeQuery();
            if(rs.next()){
                if(usr.getPassword().equals(rs.getString(4))){
                    usr.setId(1);
                    usr.setNombre(rs.getString(3));
                    usr.setTipo(rs.getInt(2));
                    return true;
                }
                else{
                    return false;
                }
                
            }
            
            return false;
        } catch (SQLException e) {
            return false;
        }
    }
    
}
