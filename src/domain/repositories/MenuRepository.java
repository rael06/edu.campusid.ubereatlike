package domain.repositories;

import domain.Menu;

import java.util.Optional;

public interface MenuRepository {
    void add(Menu m);
    Optional<Menu> findByRestaurantId(String restaurantId);
}
