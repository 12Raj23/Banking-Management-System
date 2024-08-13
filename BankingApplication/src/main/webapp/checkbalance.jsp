<%@page import="com.bank.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Balance</title>
</head>
<body>
<% Customer c=(Customer)session.getAttribute("customer"); %>
  <h2>Account Balance for <%=c.getAccno()%></h2>
  <h3>Your Balance is <%=c.getBal()%></h3>
  <a href="homepage.jsp">Back to Home</a>


</body>
</html>