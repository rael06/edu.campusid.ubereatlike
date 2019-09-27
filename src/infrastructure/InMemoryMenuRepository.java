package infrastructure;

import domain.Menu;
import domain.Restaurant;
import domain.repositories.MenuRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryMenuRepository implements MenuRepository {
    private static InMemoryMenuRepository instance = null;

    private List<Menu> menus = new ArrayList<>();

    private InMemoryMenuRepository() {
    }

    public static InMemoryMenuRepository getInstance() {
        if (instance == null) {
            synchronized (InMemoryMenuRepository.class) {
                instance = instance == null ? new InMemoryMenuRepository() : instance;

                //menu 1
                List<String> content1 = new ArrayList<>();
                content1.add("burger");
                content1.add("frite");
                content1.add("boisson");
                instance.add(new Menu("1", "Big Mac", "7.9", "1", content1));

                //menu 2
                List<String> content2 = new ArrayList<>();
                content2.add("pizza");
                content2.add("boisson");
                instance.add(new Menu("2", "Reine", "15.6", "3", content2));

                //menu 3
                List<String> content3 = new ArrayList<>();
                content3.add("burger");
                content3.add("frite");
                instance.add(new Menu("3", "Cheeseburger", "4.9", "2", content3));

                //menu 4
                instance.add(new Menu("4", "Cheeseburger", "4.9", "1", content3));
            }
        }
        return instance;
    }

    @Override
    public void add(Menu m) {
        menus.add(m);
    }

    @Override
    public List<Menu> findByRestaurantId(String restaurantId) {
        return menus.stream().filter(menu -> menu.getRestaurantId().equals(restaurantId)).collect(Collectors.toList());
    }

    @Override
    public Optional<Menu> findById(String id) {
        return menus.stream().filter(menu -> menu.getId().equals(id)).findFirst();
    }


}
