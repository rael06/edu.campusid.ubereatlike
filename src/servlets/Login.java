package servlets;

import domain.Customer;
import domain.repositories.CustomerRepository;
import infrastructure.InMemoryCustomerRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static servlets.Routes.*;

@WebServlet(INDEX)
public class Login extends HttpServlet {

    private final CustomerRepository customerRepository = InMemoryCustomerRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Optional<Customer> customer = customerRepository.findByEmailAndPassword(email, password);
        if (customer.isPresent()) {
            session.setAttribute("authenticated", true);
            req.getSession().setAttribute("customer", customer.get());
            resp.sendRedirect(req.getContextPath() + SEARCH);
        } else {
            getServletContext().getRequestDispatcher(INDEX_JSP).forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("authenticated") != null &&
                (Boolean) session.getAttribute("authenticated")) {
            resp.sendRedirect(req.getContextPath() + SEARCH_JSP);
        } else {
            getServletContext().getRequestDispatcher(INDEX_JSP).forward(req, resp);
        }
    }
}
