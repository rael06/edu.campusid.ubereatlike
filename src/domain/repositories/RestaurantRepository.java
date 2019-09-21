package domain.repositories;

import domain.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    void add(Restaurant r);
    List<Restaurant> findByType(String type);
}
