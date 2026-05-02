<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input[type="text"], select { width: 300px; padding: 8px; }
        button { background-color: #4CAF50; color: white; padding: 10px 15px; border: none; cursor: pointer; }
        .error { color: red; }
    </style>
</head>
<body>
    <h2>Add New Book</h2>
    <c:if test="${not empty error}"><p class="error">${error}</p></c:if>
    <form action="/add" method="post">
        <div class="form-group">
            <label>Title:</label>
            <input type="text" name="title" required />
        </div>
        <div class="form-group">
            <label>Author:</label>
            <select name="author.id" required>
                <c:forEach var="author" items="${authors}">
                    <option value="${author.id}">${author.name}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit">Save Book</button>
    </form>
</body>
</html>
