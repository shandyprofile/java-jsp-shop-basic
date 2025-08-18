<%-- 
    Document   : home_content
    Created on : Aug 14, 2025, 9:49:45 AM
    Author     : shandy
--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<h2>Welcome, ${username} (Cookie Based)</h2>

<form action="${pageContext.request.contextPath}/logout" method="post">
    <button type="submit" class="btn btn-outline-primary">Logout</button>
</form>

    