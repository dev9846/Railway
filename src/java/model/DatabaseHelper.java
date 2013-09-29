/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dev
 */
public class DatabaseHelper {

    Connection con = null;
    ResultSet rs = null;

    public DatabaseHelper() {
    }

    public String getDbDriverName(){
        return "jdbc:odbc:account64";
        //get from web.config
    }
    
    public ResultSet getResultSet(String sqlQuery) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Here");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainsystem?zeroDateTimeBehavior=convertToNull","dev","dev");
           // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainsystem?zeroDateTimeBehavior=convertToNull","root","");
            System.out.println("after con");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sqlQuery);
           System.out.println("after query");
            //stmt.executeQuery(sqlQuery);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }
    
    
}
