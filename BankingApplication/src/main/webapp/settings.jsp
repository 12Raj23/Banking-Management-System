<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Settings - Change PIN</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 300px;
            margin: 0 auto;
            padding-top: 50px;
        }
        h2 {
            text-align: center;
        }
        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        input[type="password"],
        input[type="submit"] {
            padding: 10px;
            font-size: 16px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .message {
            text-align: center;
            margin-top: 20px;
        }
        .error {
            color: red;
        }
        .success {
            color: green;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Change PIN</h2>
        <form action="settings" method="post">
            <label for="currentPin">Current PIN:</label>
            <input type="password" id="currentPin" name="currentPin" required>

            <label for="newPin">New PIN:</label>
            <input type="password" id="newPin" name="newPin" required>

            <label for="confirmPin">Confirm New PIN:</label>
            <input type="password" id="confirmPin" name="confirmPin" required>

            <input type="submit" value="Update PIN">
        </form>

        <div class="message">
            <% 
                String error = (String) request.getAttribute("error");
                String success = (String) request.getAttribute("success");
                if (error != null) { 
            %>
                <p class="error"><%= error %></p>
            <% } else if (success != null) { %>
                <p class="success"><%= success %></p>
            <% } %>
        </div>

        <div style="text-align:center; margin-top: 20px;">
            <a href="homepage.jsp">Back to Home</a>
        </div>
    </div>
</body>
</html>
