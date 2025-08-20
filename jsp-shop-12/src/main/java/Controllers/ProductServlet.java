/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controllers;

import DALs.ProductDAO;
import DALs.UserDAO;
import Utils.PasswordValidator;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
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
        }

        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
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
            request.setAttribute("Error", "Add products Error!");
            request.getRequestDispatcher("/views/pages/addProduct.jsp").forward(request,response);
        }
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
