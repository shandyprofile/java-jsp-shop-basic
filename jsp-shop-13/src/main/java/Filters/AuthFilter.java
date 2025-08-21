/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */

package Filters;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author shandy
 */
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
	throws IOException, ServletException {

	HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        // Option 1: Login URL
        String loginURI = req.getContextPath() + "/login";
        boolean loginRequest = req.getRequestURI().toLowerCase().contains(loginURI.toLowerCase());
        
        // Option 2: Resources
        boolean resourceRequest = req.getRequestURI().startsWith(req.getContextPath() + "/assets");
        
        // Option 3: Session/Cookie
        String key = "username";
        boolean loggedIn = false;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (key.equals(c.getName())) {
                    loggedIn = true;
                    request.setAttribute(key, c.getValue());
                    break;
                }
            }
        }
        
        if (loggedIn || loginRequest || resourceRequest) {
            chain.doFilter(request, response); 
        } else {
            res.sendRedirect(loginURI); 
        }
    }
}
