<%-- 
    Document   : home
    Created on : Aug 14, 2025, 9:48:37 AM
    Author     : shandy
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="jakarta.servlet.*" %>

<%
    String username = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("username".equals(c.getName())) {
                username = c.getValue();
                break;
            }
        }
    }

    if (username == null) {
        response.sendRedirect(request.getContextPath() + "/views/pages/login.jsp");
        return;
    }

    request.setAttribute("contentPage", "home_content.jsp");
    request.setAttribute("username", username);
%>

<jsp:include page="../layouts/layout.jsp" >
    <jsp:param name="pageTitle" value="Home - JSP Shop" />
</jsp:include>