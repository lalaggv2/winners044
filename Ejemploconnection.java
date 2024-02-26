/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploconnection;

/**
 *
 * @author Usuario
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Ejemploconnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/ejemploprueba";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ejemploconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO USUARIO(NOMBRE,IDENTIFICACION,ARTICULO) VALUES('HUMBERTO','223129212321232992','13')");
            rs = statement.executeQuery("SELECT * from usuario");
            rs.next();
            do{
                System.out.println(rs.getInt("nombre")+" : "+rs.getString("identificacion"));
            }while(rs.next());
                    
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Ejemploconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
