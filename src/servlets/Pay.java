package servlets;


import domain.Customer;
import domain.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static servlets.Routes.*;

@WebServlet(PAY)
public class Pay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("cart", new ShoppingCart(((Customer) req.getSession().getAttribute("customer")).getId()));
        if (req.getParameter("goHome") != null) {
            resp.sendRedirect(req.getContextPath() + SEARCH);
        } else
            getServletContext().getRequestDispatcher("/WEB-INF" + PAY_JSP).forward(req, resp);
    }
}
