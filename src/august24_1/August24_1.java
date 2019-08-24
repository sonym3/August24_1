/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package august24_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 1895268
 */
public class August24_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
         try {
        Connection conn = null;
        PreparedStatement stm = null;
        String sql;
        
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                
        conn = DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "HR", "inf5180");
        
            getDetails(conn);
            
            
            
            insertIntoTable(conn);
       
             
        } catch (SQLException ex) {
            Logger.getLogger(August24_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void insertIntoTable(Connection conn) throws SQLException {
        
        conn.setAutoCommit(false);
        String sql="insert into countries  values (?,?,?)";
        PreparedStatement stm;
        stm = conn.prepareStatement(sql);
        stm.setString(1, "e");
        stm.setString(2, "So");
        stm.setInt(3, 21);
        
       
        int x = stm.executeUpdate();
        System.out.println(x);
        conn.commit();
        stm.close();
        conn.close();
        
    }

    private static void getDetails(Connection conn) throws SQLException {
        String sql;
        PreparedStatement stm;
        sql ="select * from regions where region_id =?";
        stm = conn.prepareStatement(sql);
        stm.setInt(1, 2);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt(1) + " - " + rs.getString(2));
        }
    }
    
}
