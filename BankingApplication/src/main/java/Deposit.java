import java.io.IOException;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDAOImpl;
import com.bank.dto.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/deposit")
public class Deposit extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String amount = req.getParameter("amount");
        String pin = req.getParameter("password");

        // Parsing the amount and pin from the request
        double amt = Double.parseDouble(amount);
        int pins = Integer.parseInt(pin);

        // Getting the current session
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("customer") == null) {
            // Redirect to login page if session is null or customer attribute is missing
            resp.sendRedirect("login.jsp");
            return;
        }

        // Getting the customer object from the session
        Customer c = (Customer) session.getAttribute("customer");

        // Verifying the pin before allowing the deposit
        if (c.getPin() != pins) {
            req.setAttribute("error", "Invalid PIN. Please try again.");
            req.getRequestDispatcher("deposit.jsp").forward(req, resp);
            return;
        }

        // Updating the customer's balance
        c.setBal(amt + c.getBal());

        // Creating an instance of CustomerDAO to update the customer in the database
        CustomerDAO cdao = new CustomerDAOImpl();
        boolean res = cdao.updateCustomer(c);

        if (res) {
            req.setAttribute("success", "Amount of Rs. " + amt + " has been deposited successfully.");
            session.setAttribute("customer", c); // Update session with the new balance
        } else {
            req.setAttribute("error", "Deposit failed. Please try again.");
        }

        // Forwarding the request to the appropriate JSP page
        req.getRequestDispatcher("deposit.jsp").forward(req, resp);
    }
}