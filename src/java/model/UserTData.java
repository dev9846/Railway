/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DbClasses.UserT;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dev
 */
public class UserTData {

    DatabaseHelper db;

    public UserTData() {
        db = new DatabaseHelper();

    }

    public ArrayList<DbClasses.UserT> getUsers() {
        ArrayList<DbClasses.UserT> users = new ArrayList<UserT>();

        ResultSet rs = db.getResultSet("Select * From UserT");
        UserT user;

        try {
            while (rs.next()) {
                user = new UserT();
                user.setUserId(rs.getInt("UserId"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                users.add(user);
            }
        } catch (SQLException se) {
        }
        return users;
    }

    public UserT getUser(String username, String password) {

           
        ResultSet rs = db.getResultSet("Select * From UserT Where Username='"+username+"' and Password = '"+password+"'");
        UserT user = new UserT();

        try {
            while (rs.next()) {
                user.setUserId(rs.getInt("UserId"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
            }
        } catch (SQLException se) {
        }
        return user;
    }



        
    public UserT getTestUser() {

        UserT user = new UserT();
        user.setUsername("manas");
        user.setPassword("manas");
        return user;
    }
}
