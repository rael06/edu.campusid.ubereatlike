package servlets;

import domain.ShoppingCart;
import domain.ShoppingCartItem;
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
        if(req.getParameter("restaurant") != null)
                req.getSession().setAttribute("restaurantId", req.getParameter("restaurant"));
        String restaurantId = (String) req.getSession().getAttribute("restaurantId");

        List<domain.Menu> menus = menuRepository.findByRestaurantId(restaurantId);
        req.setAttribute("menus", menus);

        if (req.getParameter("order") != null) {
            domain.Menu menu = menuRepository.findById(req.getParameter("order")).get();
            ShoppingCartItem item = new ShoppingCartItem(menu.getId(), menu.getName(), menu.getPrice());
            ((ShoppingCart) req.getSession().getAttribute("cart")).add(item);
        }

        getServletContext().getRequestDispatcher("/WEB-INF" + MENU_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
