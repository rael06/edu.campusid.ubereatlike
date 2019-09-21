package infrastructure;

import domain.Menu;
import domain.repositories.MenuRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMenuRepository implements MenuRepository {
    private static InMemoryMenuRepository instance = null;

    private List<Menu> menus = new ArrayList<>();

    private InMemoryMenuRepository() { }

    public static InMemoryMenuRepository getInstance() {
        if (instance == null) {
            synchronized (InMemoryMenuRepository.class) {
                instance = instance == null ? new InMemoryMenuRepository() : instance;
            }
        }
        return instance;
    }
}
