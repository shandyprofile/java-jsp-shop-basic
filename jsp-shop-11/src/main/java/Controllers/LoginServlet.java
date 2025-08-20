/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controllers;

import DALs.UserDAO;
import Utils.PasswordValidator;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setAttribute("contentPage", "login_form_content.jsp");
        request.getRequestDispatcher("/views/pages/login.jsp").forward(request,response);
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (!PasswordValidator.isValid(password)) {
            request.setAttribute("loginError", "Password must contain uppercase, lowercase, number, special char, and be at least 8 characters.");
            
            request.setAttribute("contentPage", "login_form_content.jsp");
            request.getRequestDispatcher("views/pages/login.jsp").forward(request, response);
            return;
        }
        
        UserDAO users = new UserDAO();
        String uName = users.CheckUser(username, password);
        if (uName != null) {
            Cookie cookie1 = new Cookie("username", uName);
            cookie1.setMaxAge(60 * 60); // 1 hour
            response.addCookie(cookie1);

            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            request.setAttribute("contentPage", "login_form_content.jsp");
            request.setAttribute("loginError", "Username or password are failed!");
            request.getRequestDispatcher("/views/pages/login.jsp").forward(request,response);
        }
    }
}
