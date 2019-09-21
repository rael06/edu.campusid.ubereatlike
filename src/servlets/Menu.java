package servlets;

import domain.repositories.MenuRepository;
import infrastructure.InMemoryMenuRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

import static servlets.Routes.*;

@WebServlet(MENU)
public class Menu extends HttpServlet {

    private final MenuRepository menuRepository = InMemoryMenuRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        domain.Menu menu = menuRepository.findByRestaurantId(req.getParameter("restaurant")).get();
        req.setAttribute("menu", menu);
        req.getSession().getAttribute("search");
        getServletContext().getRequestDispatcher("/WEB-INF" + MENU_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
