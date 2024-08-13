<%@page import="com.bank.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
 <div class="img">
 <img src="images\easy money.jpg" alt="money" width="600" height="300" style="float:right">
 </div>
 

</head>

<body>
<%Customer c=(Customer)session.getAttribute("customer"); %>
<%String success=(String)request.getAttribute("success");%>
<%if(success!=null) {%>
  <div class="container">
   <h4><%=success%></h4>
  <%}else
	  {%>
	    <%=c.getName()%>
	    <%}%>
	    <h2 class="success">Welcome <%=c.getName() %></h2>
	    <div class="options">
	    </div>
  </div>
<tr>
<td> <h2><a href="checkbalance.jsp"> Check Balance </a></h2> </td>
<td> <img src="images\balance.jpg" alt="error" height=70px width=70px> </td>
</tr>
<tr>
<td> <h2><a href="deposit.jsp"> Deposit </a> </h2> </td>
<td> <img src="images\deposit.png" height=70px width=70px> </td>
</tr>
<tr>

<td> <h2><a href="transfer.jsp"> Transfer </a> </h2> </td>
<td> <img src="images\transfer.png" height=70px width=70px> </td>
</tr>
<tr>


<tr>
<td> <h2><a href="settings.jsp"> Settings </a> </h2> </td>
<td> <img src="images\setting.png" height=70px width=70px></td>
</tr>

 <li><a href="logout">Log Out</a></li>
</table>
</form>
</div>
</body>
</html>