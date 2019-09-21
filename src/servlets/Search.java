package servlets;

import domain.Restaurant;
import domain.repositories.RestaurantRepository;
import infrastructure.InMemoryRestaurantRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static servlets.Routes.SEARCH;
import static servlets.Routes.SEARCH_JSP;

@WebServlet(SEARCH)
public class Search extends HttpServlet {

    private final RestaurantRepository restaurantRepository = InMemoryRestaurantRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF" + SEARCH_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Restaurant> restaurants = restaurantRepository.findByType(req.getParameter("type"));
        req.setAttribute("restaurants", restaurants);
        req.setAttribute("searched", req.getParameter("searched"));
        getServletContext().getRequestDispatcher("/WEB-INF" + SEARCH_JSP).forward(req, resp);
    }
}
