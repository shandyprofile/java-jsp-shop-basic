<%-- 
    Document   : addProduct
    Created on : Aug 20, 2025, 1:00:24?PM
    Author     : shandy
--%>
<h2 class="mb-4">Add Product</h2>
<form action="${pageContext.request.contextPath}/product?action=delete" method="post" class="col-md-4">
    <div class="mb-3">
        <label for="id" class="form-label">Id</label>
        <input type="text" id="id" name="id" class="form-control" readonly value="${product.getId()}" >
    </div>
    
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" id="name" class="form-control" value="${product.getName()}" readonly>
    </div>
    <div class="mb-3">
        <label for="description" class="form-label">Description</label>
        <input type="text" id="description" class="form-control" value="${product.getDescription()}" readonly>
    </div>
    <div class="mb-3">
        <label for="price" class="form-label">Price</label>
        <input type="text" id="price" class="form-control" value="${product.getPrice()}" readonly>
    </div>

    <div class="mb-3">
        <label for="quantity" class="form-label">Quantity</label>
        <input type="text" id="quantity" class="form-control" value="${product.getQuantity()}" readonly>
    </div>

    <div class="mb-3">
        <label for="img" class="form-label">Image</label>
        <input type="text" id="img" class="form-control" value="${product.getImage()}" readonly>
    </div>
    
    <button type="submit" class="btn btn-danger">Delete Product</button>
    
    <a href="${pageContext.request.contextPath}/home" class="btn btn-outline-info">Back</a>

    <p style="color:red;"><%= request.getAttribute("error") != null ? request.getAttribute("error") : ""%></p>

</form>
