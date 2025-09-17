/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controllers;

import DALs.ProductDAO;
import Models.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author shandy
 */
public class ProductManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action") != null 
                ? request.getParameter("action") 
                : "";
        
        switch (action) {
            case "add":
                doGetAdd(request,response);
                break;
            case "update":
                doGetUpdate(request,response);
                break;
                
            case "delete":
                doGetDelete(request,response);
                break;
                
            default:
                doGetRead(request,response);
                break;
        }
    } 
    
    private void doGetRead(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.GetAllProducts();
        
        request.setAttribute("products", products);
        request.getRequestDispatcher("/views/product-management/listProduct.jsp").forward(request,response);
    }
    
    private void doGetAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/product-management/addProduct.jsp").forward(request,response);
    }
    
    private void doGetUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idProduct = request.getParameter("id");
        
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.GetProductById(Integer.parseInt(idProduct));
        
        request.setAttribute("product", product);
        request.getRequestDispatcher("/views/product-management/updateProduct.jsp").forward(request,response);
    }
    
    private void doGetDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idProduct = request.getParameter("id");
        
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.GetProductById(Integer.parseInt(idProduct));
        
        request.setAttribute("product", product);
        request.getRequestDispatcher("/views/product-management/deleteProduct.jsp").forward(request,response);
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action") != null 
                ? request.getParameter("action") 
                : "";
        
        switch (action) {
            case "add":
                doPostAdd(request, response);
                break;
            case "update":
                doPostUpdate(request, response);
                break;
            case "delete":
                doPostDelete(request, response);
                break;
        }
    }
    
    private void doPostAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String img = request.getParameter("img");
        
        ProductDAO products = new ProductDAO();
        boolean rs = products.CreateProduct(name, Double.parseDouble(price), description, Integer.parseInt(quantity), img);
       
        if (rs) {           
            response.sendRedirect(request.getContextPath() + "/product");
        } else {
            request.setAttribute("error", "Add products Error!");
            request.getRequestDispatcher("/views/product-management/addProduct.jsp").forward(request,response);
        }
    }
    
    private void doPostUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String img = request.getParameter("img");
        
        ProductDAO products = new ProductDAO();
        boolean rs = products.UpdateProductById(id, name, Double.parseDouble(price), description, Integer.parseInt(quantity), img);
        
        if (rs) {           
            response.sendRedirect(request.getContextPath() + "/product");
        } else {
            request.setAttribute("error", "Update products error!");
            request.getRequestDispatcher("/views/product-management/updateProduct.jsp").forward(request,response);
        }
    }
    
    private void doPostDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        
        ProductDAO products = new ProductDAO();
        boolean rs = products.DeleteProductById(id);
        
        if (rs) {           
            response.sendRedirect(request.getContextPath() + "/product");
        } else {
            request.setAttribute("error", "Delete products error!");
            request.getRequestDispatcher("/views/product-management/deleteProduct.jsp").forward(request,response);
        }
    }
}
