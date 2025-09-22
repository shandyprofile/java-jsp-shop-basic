/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Utils.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;

@WebServlet(name = "TestDBServlet", urlPatterns = {"/TestDBServlet"})
public class TestDBServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            DBContext db = new DBContext();
            Connection conn = db.connection;
            if (conn != null && !conn.isClosed()) {
                out.println("<h1>Database Connection Successful!</h1>");
            } else {
                out.println("<h1>Database Connection Failed!</h1>");
            }
            // Optionally close the connection here if DBContext didn't manage it.
            try {
                if (conn != null && !conn.isClosed()) conn.close();
            } catch (Exception ignored) {}
        } catch (Exception ex) {
            // Print a friendly message to browser and full stack trace to server logs
            response.getWriter().println("<h1>Test failed: " + ex.getMessage() + "</h1>");
            ex.printStackTrace();
        }
    }
}
