package infrastructure;

import domain.Menu;
import domain.repositories.MenuRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryMenuRepository implements MenuRepository {
    private static InMemoryMenuRepository instance = null;

    private List<Menu> menus = new ArrayList<>();

    private InMemoryMenuRepository() {
    }

    public static InMemoryMenuRepository getInstance() {
        if (instance == null) {
            synchronized (InMemoryMenuRepository.class) {
                instance = instance == null ? new InMemoryMenuRepository() : instance;
                instance.add(new Menu("1", "Big Mac", "10", "1"));
                instance.add(new Menu("2", "Reine", "15.60", "3"));
                instance.add(new Menu("3", "Twister BK", "12.5", "2"));
            }
        }
        return instance;
    }

    @Override
    public void add(Menu m) {
        menus.add(m);
    }

    @Override
    public Optional<Menu> findByRestaurantId(String restaurantId) {
        return menus.stream().filter(menu -> menu.getRestaurantId().equals(restaurantId)).findFirst();
    }
}
