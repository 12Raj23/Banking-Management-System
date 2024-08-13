<%@page import="com.bank.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>

</head>
<body bgcolor="sky-blue">
<img src="images\money.jpg" alt="money" width="220" height="200">
<img src="images\money-transfer.jpg" alt="money" width="220" height="200">
<img src="images\settings.jpg" alt="money" width="220" height="200">
<img src="images\checkbalance.jpeg" alt="money" width="220" height="200">
<img src="images\balance.jpg" alt="money" width="220" height="200">
<img src="images\logo111.png" alt="money" width="220" height="200">

<%Customer c=(Customer)request.getAttribute("customer"); %>
<%String success=(String)request.getAttribute("success"); %>
<%String failure=(String)request.getAttribute("Failure"); %>

<div align="center">
<form action="signup" method="post">
<h1> Welcome to New Bank</h1>
<h2> Application form </h2>

<%if(success!=null&&c!=null){  %>
<%=success %>
<%} %>
<%if(failure!=null){ %>
<%=failure %>
<%} %>
<table>
<tr>
     <td><h3>Enter your Name:</h3></td>
     <td><input type="text" name="name" required="required"></td>
     </tr>
     <tr>
     <td><br></td>
     <td><br></td>
     </tr>
     <tr>
     <td><h3>Enter your PhoneNo:</h3></td>
     <td><input type="tel" name="phone" required="required"></td>
     </tr>
     <tr>
     <td><br></td>
     <td><br></td>
     </tr>
     <tr>
     <td><h3>Enter your Mail:</h3></td>
     <td><input type="text" name="mail" required="required"></td>
     </tr>
     <tr>
     <td><br></td>
     <td><br></td>
     </tr>
     <tr>
     <td><h3>Set the PIN:</h3></td>
     <td><input type="password" name="pin" maxlength="4" required="required"></td>
     </tr>
     <tr>
     <td><br></td>
     <td><br></td>
     </tr>
     <tr>
     <td><h3>Confirm the PIN:</h3></td>
     <td><input type="password" name="confirm" maxlength="4" required="required"></td>
     </tr>
     <tr>
     <td><br></td>
     <td><br></td>
     </tr>
     <td><input type="Submit" value="Sign up"></td>
     <td><button><a href="login.jsp">login</a></button></td>
</table>
</form>
</div>

</body>
</html>