<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transfer Funds</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h2>Transfer Funds</h2>

    <!-- Display success or error messages -->
    <c:if test="${not empty success}">
        <div class="success-message">${success}</div>
    </c:if>

    <c:if test="${not empty error}">
        <div class="error-message">${error}</div>
    </c:if>

    <!-- Transfer Form -->
    <form action="transfer" method="post">
        <label for="recipientAccountNumber">Recipient Account Number:</label>
        <input type="text" id="recipientAccountNumber" name="recipientAccountNumber" required><br><br>

        <label for="amount">Amount to Transfer:</label>
        <input type="number" step="0.01" id="amount" name="amount" required><br><br>

        <label for="password">Enter PIN:</label>
        <input type="password" id="password" name="password" required><br><br>

        <button type="submit">Transfer</button>
    </form>

    <!-- Link back to the home page -->
    <br><a href="homepage.jsp">Back to Home Page</a>
</body>
</html>
