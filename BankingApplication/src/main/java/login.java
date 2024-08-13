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
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String accno=req.getParameter("acc_no");
		String pins=req.getParameter("pin");
		
		long acc_no=Long.parseLong(accno);
		int pin=Integer.parseInt(pins);
		
		HttpSession session=req.getSession();
		PrintWriter out=resp.getWriter();
		CustomerDAO cdao=new CustomerDAOImpl();
		Customer c= cdao.getCustomer(acc_no, pin);
		if(c!=null) {
			session.setAttribute("customer", c);
			resp.sendRedirect("Sessions");
		}
		else {
			req.setAttribute("failure","Login failed");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req,resp);
		}
	}

}
