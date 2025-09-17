<%-- 
    Document   : home
    Created on : Aug 14, 2025, 9:48:37?AM
    Author     : shandy
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<t:layout pageTitle="List Products - JSP Shop">
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

    <a href="${pageContext.request.contextPath}/product?action=add" 
       class="btn btn-primary">
       Add product 
    </a>

    <h3>Available Products</h3>
    <c:choose>
        <c:when test="${not empty requestScope.products}">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>description</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Image</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="p" items="${products}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${p.getName()}</td>
                            <td>${p.getDescription()}</td>
                            <td><fmt:formatNumber value="${p.getPrice()}" type="currency" currencySymbol="VND" /></td>
                            <td>${p.getQuantity()}</td>
                            <td>
                                <img height='50px' src="./assets/images/${p.getImage()}" alt="${p.getName()}"/>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/product?action=update&id=${p.getId()}" class="btn btn-warning">
                                    Update
                                </a>

                                <a href="${pageContext.request.contextPath}/product?action=delete&id=${p.getId()}" class="btn btn-danger">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p class="text-muted">No products available at the moment.</p>
        </c:otherwise>
    </c:choose>
        
</t:layout>