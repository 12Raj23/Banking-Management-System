import java.io.IOException;

import com.bank.dto.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Sessions")
public class Sessions extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s=req.getSession(false);
		Customer c=(Customer)s.getAttribute("customer");
		if(c!=null)
		{
			req.setAttribute("success", "Login successful!");
			RequestDispatcher rd=req.getRequestDispatcher("homepage.jsp");
			rd.forward(req,resp);
		}
		else {
			   req.setAttribute("Error", "Session Expired");
			   RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			   rd.forward(req,resp);
		}
	}


}
