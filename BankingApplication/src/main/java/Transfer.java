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

@WebServlet("/transfer")
public class Transfer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recipientAccountNumberStr = req.getParameter("recipientAccountNumber");
        String amountStr = req.getParameter("amount");
        String pinStr = req.getParameter("password");

        // Parsing the inputs
        long recipientAccountNumber = Long.parseLong(recipientAccountNumberStr);
        double amount = Double.parseDouble(amountStr);
        int pin = Integer.parseInt(pinStr);

        // Getting the current session
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("customer") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        // Getting the customer object from the session
        Customer sender = (Customer) session.getAttribute("customer");

        // Verifying the pin before allowing the transfer
        if (sender.getPin() != pin) {
            req.setAttribute("error", "Invalid PIN. Please try again.");
            req.getRequestDispatcher("transfer.jsp").forward(req, resp);
            return;
        }

        // Checking if the sender has sufficient balance
        if (sender.getBal() < amount) {
            req.setAttribute("error", "Insufficient balance. Please try again.");
            req.getRequestDispatcher("transfer.jsp").forward(req, resp);
            return;
        }

        // Creating an instance of CustomerDAO to fetch the recipient and update both customers in the database
        CustomerDAO cdao = new CustomerDAOImpl();
        Customer recipient = cdao.getCustomer(recipientAccountNumber);

        if (recipient == null) {
            req.setAttribute("error", "Recipient account number not found. Please try again.");
            req.getRequestDispatcher("transfer.jsp").forward(req, resp);
            return;
        }

        // Updating the balances
        sender.setBal(sender.getBal() - amount);
        recipient.setBal(recipient.getBal() + amount);

        boolean senderUpdated = cdao.updateCustomer(sender);
        boolean recipientUpdated = cdao.updateCustomer(recipient);

        if (senderUpdated && recipientUpdated) {
            req.setAttribute("success", "Amount of Rs. " + amount + " has been transferred successfully.");
            session.setAttribute("customer", sender); // Update session with the new balance
        } else {
            req.setAttribute("error", "Transfer failed. Please try again.");
        }

        // Forwarding the request to the appropriate JSP page
        req.getRequestDispatcher("transfer.jsp").forward(req, resp);
    }
}
