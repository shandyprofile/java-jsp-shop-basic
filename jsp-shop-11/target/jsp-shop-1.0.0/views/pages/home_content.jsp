<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : home_content
    Created on : Aug 14, 2025, 9:49:45 AM
    Author     : shandy
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
    
<c:if test="${not empty username}">
    <h2>Welcome, ${username} (Cookie Based)</h2>
    
    <form action="${pageContext.request.contextPath}/logout" method="post">
        <button type="submit" class="btn btn-outline-primary">Logout</button>
    </form>
</c:if>

<!-- Show message if user not logged in -->
<c:if test="${empty username}">
    <h2 class="text-danger">You are not logged in.</h2>
    <a href="${pageContext.request.contextPath}/login" class="btn btn-primary">Login</a>
</c:if>
    
    
<hr/>
<h3>Available Products</h3>
<c:choose>
    <c:when test="${not empty requestScope.products}">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${products}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${p.getName()}</td>
                        <td><fmt:formatNumber value="${p.getPrice()}" type="currency" currencySymbol="$" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p class="text-muted">No products available at the moment.</p>
    </c:otherwise>
</c:choose>