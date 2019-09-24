package servlets;

import domain.Customer;
import domain.ShoppingCart;
import domain.repositories.MenuRepository;
import infrastructure.InMemoryMenuRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static servlets.Routes.MENU;
import static servlets.Routes.MENU_JSP;

@WebServlet(MENU)
public class Menu extends HttpServlet {

    private final MenuRepository menuRepository = InMemoryMenuRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String restaurantId = req.getParameter("restaurant");
        List<domain.Menu> menus = menuRepository.findByRestaurantId(restaurantId);
        req.setAttribute("menus", menus);
        req.setAttribute("restaurantId", restaurantId);
        req.getSession().getAttribute("search");
        if (req.getParameter("order") != null) {
            ((ShoppingCart) req.getSession().getAttribute("cart")).addItem(req.getParameter("order"));
            resp.sendRedirect(req.getContextPath() + MENU);
        }
        getServletContext().getRequestDispatcher("/WEB-INF" + MENU_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
