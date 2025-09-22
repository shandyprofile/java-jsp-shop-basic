<%-- 
    Document   : logout
    Created on : Aug 14, 2025, 12:17:49 PM
    Author     : shandy
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="jakarta.servlet.*" %>

<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("username".equals(c.getName())) {
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }
    }
    response.sendRedirect(request.getContextPath() + "/views/login.jsp");
%>
