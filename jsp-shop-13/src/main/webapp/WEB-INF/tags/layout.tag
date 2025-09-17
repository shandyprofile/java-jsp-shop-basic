<%-- 
    Document   : layout
    Created on : Aug 22, 2025, 11:57:46?AM
    Author     : shandy
--%>

<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>

<%@ tag body-content="scriptless" %>
<%@ attribute name="pageTitle" required="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${pageTitle}</title>
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/product">
                JSP Shop
            </a>
        </div>
    </nav>

    <main class="container py-4">
        <jsp:doBody />
    </main>

    <footer class="bg-light border-top mt-5">
        <div class="container py-3 text-center small text-muted">
            ? 2025 Hieu Nguyen - AI lecturer - FPT University Can Tho
        </div>
    </footer>

    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
</body>
</html>