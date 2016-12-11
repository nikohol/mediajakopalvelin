/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stuff;

import java.sql.*;

/**
 *
 * @author Miikka
 */
//User validation
public class Validation {
    public static boolean uValidate(String username, String pword){
        boolean uv = false;
        try{
        //DB connection 
        String connectionURL = "jdbc:mysql://10.114.32.81:3306/Sharing"; 
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(connectionURL, "miikkatk", "seagh3id");
        
        PreparedStatement ps =connection.prepareStatement
                             ("SELECT * FROM user WHERE username=? AND pword=?");
        ps.setString(1, username);
        ps.setString(2, pword);
        ResultSet rs = ps.executeQuery();
        uv = rs.next();
        
      }catch(Exception e)
        {
          e.printStackTrace();
      }
         return uv;  
    }
    
}
