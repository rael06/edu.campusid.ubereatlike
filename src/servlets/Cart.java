package servlets;

import domain.Customer;
import domain.ShoppingCart;
import domain.ShoppingCartItem;
import domain.repositories.ShoppingCartRepository;
import infrastructure.InMemoryShoppingCartRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import static servlets.Routes.*;

@WebServlet(CART)
public class Cart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setServletValues(req);

        getServletContext().getRequestDispatcher("/WEB-INF" + CART_JSP).forward(req, resp);
    }

    private void setServletValues(HttpServletRequest req) {
        ShoppingCart cart = ((ShoppingCart) req.getSession().getAttribute("cart"));
        req.setAttribute("cart", cart);

        int nbItems = cart.getNbItems();
        req.setAttribute("nbItems", nbItems);
        req.setAttribute("nbItemsStr", String.valueOf(nbItems));

        double price = cart.getPrice();
        req.setAttribute("price", new DecimalFormat("0.00").format(price));

        if (req.getParameter("remove") != null) {
            cart.remove(cart.getShoppingCartItems().stream().filter(item -> item.getId() == Integer.parseInt(req.getParameter("remove"))).findFirst());
        }

        List<ShoppingCartItem> items = cart.getShoppingCartItems();
        req.setAttribute("items", items);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setServletValues(req);

        if (req.getParameter("cartPayButton") != null) {
            ShoppingCart lastCart = (ShoppingCart) req.getSession().getAttribute("cart");
            InMemoryShoppingCartRepository.getInstance().add(lastCart);
            req.getSession().setAttribute("lastCart", lastCart);
            req.getSession().setAttribute("cart", new ShoppingCart(((Customer) req.getSession().getAttribute("customer")).getId()));
            resp.sendRedirect(req.getContextPath() + PAY);
            return;
        }

        resp.sendRedirect(req.getContextPath() + CART);
    }
}
