<%-- 
    Document   : login
    Created on : Aug 14, 2025, 11:14:27?AM
    Author     : shandy
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="jakarta.servlet.*" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Login - JSP Shop</title>
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/views/home.jsp">
                    JSP Shop
                </a>
            </div>
        </nav>
         
        <main class="container py-4">
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

                        response.sendRedirect(request.getContextPath() + "/views/home.jsp");
                        return;
                    } else {
                        request.setAttribute("loginError", "Username or password are failed!");
                    }
                }
            %>
            
            <h2 class="mb-4">Login Form</h2>
                <form action="" method="post" class="col-md-4">
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" id="username" name="username" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" id="password" name="password" class="form-control" required>
                    </div>

                    <button type="submit" class="btn btn-primary">Login</button>
                </form>
            </h2>
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