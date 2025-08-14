<%-- 
    Document   : login
    Created on : Aug 14, 2025, 11:14:27?AM
    Author     : shandy
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="jakarta.servlet.*" %>

<%
//    boolean loggedIn = false;
//    Cookie[] cookies = request.getCookies();
//    if (cookies != null) {
//        for (Cookie c : cookies) {
//            if ("username".equals(c.getName())) {
//                loggedIn = true;
//                break;
//            }
//        }
//    }
//    if (loggedIn) {
//        response.sendRedirect("home.jsp");
//        return;
//    }

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "123".equals(password)) {
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60); // 1 hour
            response.addCookie(cookie);

            response.sendRedirect("home.jsp");
            return;
        } else {
            request.setAttribute("loginError", "Username or password are failed!");
        }
    }

    request.setAttribute("contentPage", "login_form_content.jsp");
%>

<jsp:include page="../layouts/layout.jsp" >
    <jsp:param name="pageTitle" value="Login - JSP Shop" />
</jsp:include>