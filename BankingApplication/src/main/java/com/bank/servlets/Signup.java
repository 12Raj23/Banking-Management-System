package com.bank.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDAOImpl;
import com.bank.dto.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/signup")
public class Signup extends HttpServlet {
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
  {
	String name=req.getParameter("name");
	String mobile=req.getParameter("phone");
	String mail=req.getParameter("mail");
	String string_pin=req.getParameter("pin");
	String confirm_pin=req.getParameter("confirm");
	
	//Conversion or parsing the data 
	long phone=Long.parseLong(mobile);
	int pin=Integer.parseInt(string_pin);
	int confirm=Integer.parseInt(confirm_pin);
	
	//jdbc  logic
	Customer c=new Customer();
	CustomerDAO cdao=new CustomerDAOImpl();
	PrintWriter out=resp.getWriter();
	c.setName(name);
	c.setPhone(phone);
	c.setMail(mail);
	if(pin==confirm) {
		c.setPin(pin);
		boolean res=cdao.insertCustomer(c);
		if(res)
		{
			c=cdao.getCustomer(phone,mail);
			req.setAttribute("customer", c);
			req.setAttribute("success","Account created successfully,Your account number is "+c.getAccno());
			RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
			rd.forward(req, resp);
			
		}
		else {
			req.setAttribute("customer", c);
			req.setAttribute("Failure","Failed to create account!!. Try again later");
			RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
			rd.forward(req, resp);
		}
	}
	
	
}
}
