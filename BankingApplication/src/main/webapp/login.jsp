<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login </title>
</head>
<body bgcolor="aquamarine">
<%String success=(String)request.getAttribute("success"); %>
<%String failure=(String)request.getAttribute("failure"); %>
<center>
<img src="images\money deposit.jpg" alt="money" width="350" height="200">
</center>
<div align="center">
<form action="login" method="post">


<%if(success!=null){  %>
<%=success %>
<%} %>
<%if(failure!=null){ %>
<%=failure %>
<%} %>

<h2>Bank Login</h2>
  Enter the Account Number:
  <input type="text" name="acc_no">
  <br> <br>
  Enter your PIN:
  <input type="password" name="pin">
  <br> <br>
  <input type="submit" value="login">
 </div>
</form>
</body>
</html>