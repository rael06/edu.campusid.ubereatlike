package servlets;

import domain.Customer;
import domain.ShoppingCart;
import infrastructure.InMemoryShoppingCartRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static servlets.Routes.ORDERS;
import static servlets.Routes.ORDERS_JSP;

@WebServlet(ORDERS)
public class Orders extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InMemoryShoppingCartRepository inMemoryShoppingCartRepository = InMemoryShoppingCartRepository.getInstance();
        List<ShoppingCart> shoppingCarts = inMemoryShoppingCartRepository.findByCustomerId(((Customer) req.getSession().getAttribute("customer")).getId());
        req.setAttribute("shoppingCarts", shoppingCarts);
        getServletContext().getRequestDispatcher("/WEB-INF" + ORDERS_JSP).forward(req, resp);
    }
}
