package domain.repositories;

import domain.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuRepository {
    void add(Menu m);
    List<Menu> findByRestaurantId(String restaurantId);
    Optional<Menu> findById(String id);
}
