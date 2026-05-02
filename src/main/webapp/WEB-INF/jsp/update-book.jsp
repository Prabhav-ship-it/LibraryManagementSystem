<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Book</title>
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
    <h2>Update Book</h2>
    <c:if test="${not empty error}"><p class="error">${error}</p></c:if>
    <form action="/update/${book.id}" method="post">
        <div class="form-group">
            <label>Title:</label>
            <input type="text" name="title" value="${book.title}" required />
        </div>
        <div class="form-group">
            <label>Author:</label>
            <select name="author.id" required>
                <c:forEach var="author" items="${authors}">
                    <option value="${author.id}" ${author.id == book.author.id ? 'selected' : ''}>${author.name}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit">Update Book</button>
    </form>
</body>
</html>
