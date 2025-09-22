<%-- 
    Document   : home
    Created on : Sep 17, 2025, 5:08:50 PM
    Author     : shandy
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Home - JSP Shop</title>
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/home">
                    JSP Shop
                </a>
            </div>
        </nav>
         
        <main class="container py-4">
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h1 class="h3 mb-3">
                                Welcome ${username} to JSP Shop
                                <form class="d-inline m-5" action="${pageContext.request.contextPath}/logout" method="post">
                                    <button type="submit" class="btn btn-outline-primary">Logout</button>
                                </form>
                            </h1>
                            <p class="mb-0">
                                This is a simple Home page.
                                for consistent UI with Bootstrap.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <footer class="bg-light border-top mt-5">
            <div class="container py-3 text-center small text-muted">
                © 2025 Hieu Nguyen - AI lecturer - FPT University Can Tho
            </div>
        </footer>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
    </body>
</html>