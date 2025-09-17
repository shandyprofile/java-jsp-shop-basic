<%-- 
    Document   : addProduct
    Created on : Aug 20, 2025, 1:00:24?PM
    Author     : shandy
--%>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout pageTitle="Update Product - JSP Shop">
    <h2 class="mb-4">Update Product</h2>
    <form action="${pageContext.request.contextPath}/product?action=update" method="post" class="col-md-4">
        <div class="mb-3">
            <label for="id" class="form-label">Id</label>
            <input type="text" id="id" name="id" class="form-control" readonly value="${product.getId()}" >
        </div>

        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" id="name" name="name" class="form-control" value="${product.getName()}" required>

        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <input type="text" id="description" name="description" class="form-control" value="${product.getDescription()}" required>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price</label>
            <input type="text" id="price" name="price" class="form-control" value="${product.getPrice()}" required>
        </div>

        <div class="mb-3">
            <label for="quantity" class="form-label">Quantity</label>
            <input type="text" id="quantity" name="quantity" class="form-control" value="${product.getQuantity()}" required>
        </div>

        <div class="mb-3">
            <label for="img" class="form-label">Image</label>
            <input type="text" id="img" name="img" class="form-control" value="${product.getImage()}" required>
        </div>

        <button type="submit" class="btn btn-primary">Update Product</button>
        <button type="reset" class="btn btn-outline-primary">Revert</button>
        <a href="${pageContext.request.contextPath}/product" class="btn btn-outline-primary">Back</a>

        <p style="color:red;">${error != null ? error : ""}</p>
    </form>

</t:layout>