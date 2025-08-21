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

/**
 *
 * @author shandy
 */
public class ProductDAO extends DBContext {
    public ProductDAO() {
        super();
    }
    
    public List<Product> GetAllProducts() {
        List<Product> listProducts = new ArrayList<>();
        String query = "Select * from Products";
        try {
            PreparedStatement ps = connection.prepareStatement(query);            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getInt("quantity"),
                        rs.getString("image"));
                
                listProducts.add(product); 
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return listProducts;
    }
    
    public Product GetProductById(int id) {
        String query = "Select * from Products where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Product product = new Product(
                        rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getInt("quantity"),
                        rs.getString("image"));
                
                return product;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public boolean CreateProduct(String name, double price, String description, int quantity, String img) {
        String query = "INSERT INTO Products (name, description, price, quantity, image)\n" +
"VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, img);
            int rs = ps.executeUpdate();
            return rs > 0;
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;        
    }
    
    public boolean UpdateProductById(String id, String name, double price, String description, int quantity, String img) {
        String query = "Update Products SET "
                + "name = ?, "
                + "description = ?, "
                + "price = ?, "
                + "quantity = ?, "
                + "image = ? "
                + "where id = ? ;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.setString(5, img);
            ps.setString(6, id);
            int rs = ps.executeUpdate();
            return rs > 0;
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;        
    }

    public boolean DeleteProductById(String id) {
        String query = "Delete Products where id = ? ;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            int rs = ps.executeUpdate();
            return rs > 0;
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false; 
    }
}
