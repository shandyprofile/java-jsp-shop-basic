/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DALs;


import Utils.DBContext;
import Models.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shandy
 */
public class UserDAO extends DBContext {
    public UserDAO() {
        super();
    }
    
    public List<User> GetAll() {
        List<User> list = new ArrayList<>();
        String query = "Select * from Users";
        try {
            PreparedStatement ps = connection.prepareStatement(query);            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User cus = new User(
                        rs.getString("UserID"), 
                        rs.getString("Username"), 
                        rs.getString("Password"),
                        rs.getString("Role"));
                list.add(cus); 
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public String CheckUser(String userName, String password) {
        String query = "Select * from Users where Username = ? and Password = ?;";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User cus = new User(
                        rs.getString("UserID"), 
                        rs.getString("Username"), 
                        rs.getString("Password"),
                        rs.getString("Role"));
                return rs.getString("Username");
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return null;
    }
}
