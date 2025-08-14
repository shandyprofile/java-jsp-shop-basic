<%-- 
    Document   : home_content
    Created on : Aug 14, 2025, 9:49:45 AM
    Author     : shandy
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="jakarta.servlet.*" %>

<h2>Welcome, ${username} (Cookie Based)</h2>
<a href="${pageContext.request.contextPath}/views/pages/logout.jsp">Logout</a>