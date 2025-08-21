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

/**
 *
 * @author shandy
 */
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch (action) {
            case "add":
                request.setAttribute("contentPage", "addProduct_content.jsp");
                request.getRequestDispatcher("/views/pages/addProduct.jsp").forward(request,response);
                break;
            case "update":
                String idProduct = request.getParameter("id");
                ProductDAO productDAO = new ProductDAO();
                Product pro = productDAO.GetProductById(Integer.parseInt(idProduct));
                request.setAttribute("product", pro);
                request.setAttribute("contentPage", "updateProduct_content.jsp");
                request.getRequestDispatcher("/views/pages/updateProduct.jsp").forward(request,response);
                break;
                
            case "delete":
                String idProduct1 = request.getParameter("id");
                ProductDAO productDAO1 = new ProductDAO();
                Product pro1 = productDAO1.GetProductById(Integer.parseInt(idProduct1));
                request.setAttribute("product", pro1);
                request.setAttribute("contentPage", "deleteProduct_content.jsp");
                request.getRequestDispatcher("/views/pages/deleteProduct.jsp").forward(request,response);
                break;
        }

        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch (action) {
            case "add":
                AddActionPost(request, response);
                break;
            case "update":
                UpdateActionPost(request, response);
                break;
                
            case "delete":
                DeleteActionPost(request, response);
                break;
        }
    }
    
    private void AddActionPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String img = request.getParameter("img");
        
        ProductDAO products = new ProductDAO();
        boolean rs = products.CreateProduct(name, Double.parseDouble(price), description, Integer.parseInt(quantity), img);
        if (rs) {           
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            request.setAttribute("contentPage", "addProduct_content.jsp");
            request.setAttribute("error", "Add products Error!");
            request.getRequestDispatcher("/views/pages/addProduct.jsp").forward(request,response);
        }
    }
    
    private void UpdateActionPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String img = request.getParameter("img");
        
        ProductDAO products = new ProductDAO();
        boolean rs = products.UpdateProductById(id, name, Double.parseDouble(price), description, Integer.parseInt(quantity), img);
        if (rs) {           
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            request.setAttribute("contentPage", "updateProduct_content.jsp");
            request.setAttribute("error", "Update products error!");
            request.getRequestDispatcher("/views/pages/updateProduct.jsp").forward(request,response);
        }
    }
    
    private void DeleteActionPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        
        ProductDAO products = new ProductDAO();
        boolean rs = products.DeleteProductById(id);
        if (rs) {           
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            request.setAttribute("contentPage", "deleteProduct_content.jsp");
            request.setAttribute("error", "Delete products error!");
            request.getRequestDispatcher("/views/pages/deleteProduct.jsp").forward(request,response);
        }
    }
}
