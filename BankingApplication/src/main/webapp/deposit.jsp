<%@page import="com.bank.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit</title>
</head>
<body>
<div align="center">
<%Customer c=(Customer)session.getAttribute("customer");%>
<h2>Deposit Money</h2>
<form action="deposit" method="post">
<table>
<tr>
    <td><h3>Enter the amount to be deposited:</h3></td>
    <td><input type="number" name="amount"></td>
    </tr>
    <tr>
      <td><h3>Enter the Pin:</h3></td>
      <td><input type="password" name="password"></td>
      </tr>
      <tr>
      <td><input type="submit" value="Deposit"></td>
      <td><a href="homepage.jsp">Back to Home</a></td>
      </tr>
</table>
</form>
</div>

</body>
</html>