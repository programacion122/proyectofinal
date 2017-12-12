
package Ejmplo_combo;


import java.sql.*;



public class Conectar {

    static String usuario = "root";
    static String contra = "root";
    static String bd = "erp";
    static String url = "jdbc:mysql://localhost:3306/"+bd;
    public Connection con = null;
    
    public Conectar(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, contra);
            
            if(con!=null){
                System.out.println("En linea");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Connection getConexion(){
        return con;
    }
    
    public void desconectar(){
        con = null;
    }
    
    public static void main(String[] args) throws SQLException {
        Conexion c = new Conexion();
        c.getConnection();
    }
    
}
