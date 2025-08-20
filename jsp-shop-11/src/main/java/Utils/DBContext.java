/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author shandy
 */
public class DBContext {
    protected Connection connection;
    
    public DBContext()
    {
        try {
            String url = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=JSPShop;"
                    + "user=sa;"
                    + "password=123456x@X;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }    
}
