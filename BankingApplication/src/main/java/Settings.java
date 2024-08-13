

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDAOImpl;
import com.bank.dto.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/settings")
public class Settings extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Getting the parameters from the request
        String currentPinStr = req.getParameter("currentPin");
        String newPinStr = req.getParameter("newPin");
        String confirmPinStr = req.getParameter("confirmPin");

        // Parsing PINs to integers
        int currentPin = Integer.parseInt(currentPinStr);
        int newPin = Integer.parseInt(newPinStr);
        int confirmPin = Integer.parseInt(confirmPinStr);

        // Getting the current session
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("customer") == null) {
            // Redirect to login if session is null or customer attribute is missing
            resp.sendRedirect("login.jsp");
            return;
        }

        // Fetching the customer object from the session
        Customer customer = (Customer) session.getAttribute("customer");

        // Verifying the current PIN
        if (customer.getPin() != currentPin) {
            req.setAttribute("error", "Current PIN is incorrect.");
            req.getRequestDispatcher("settings.jsp").forward(req, resp);
            return;
        }

        // Checking if the new PIN matches the confirmation PIN
        if (newPin != confirmPin) {
            req.setAttribute("error", "New PIN and confirm PIN do not match.");
            req.getRequestDispatcher("settings.jsp").forward(req, resp);
            return;
        }

        // Updating the PIN
        customer.setPin(newPin);
        CustomerDAO customerDAO = new CustomerDAOImpl();
        boolean isUpdated = customerDAO.updateCustomer(customer);

        if (isUpdated) {
            req.setAttribute("success", "PIN updated successfully.");
            session.setAttribute("customer", customer); // Updating session with new PIN
        } else {
            req.setAttribute("error", "Failed to update PIN. Please try again.");
        }

        // Forwarding the request back to settings.jsp
        req.getRequestDispatcher("settings.jsp").forward(req, resp);
    }
}
