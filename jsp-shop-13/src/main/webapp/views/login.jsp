<%-- 
    Document   : login
    Created on : Aug 14, 2025, 11:14:27?AM
    Author     : shandy
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout pageTitle="Login - JSP Shop">
    <h2 class="mb-4">Login Form</h2>
    <form action="${pageContext.request.contextPath}/login" method="post" class="col-md-4">
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" id="username" name="username" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" id="password" name="password" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-primary">Login</button>
        <p style="color:red;">${error != null ? error : ""}</p>
    </form>
</t:layout>



