package infrastructure;

import domain.ShoppingCartItem;
import domain.repositories.ShoppingCartRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryShoppingCartRepository implements ShoppingCartRepository {
    private static InMemoryShoppingCartRepository instance = null;

    private List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();

    private InMemoryShoppingCartRepository() {
    }

    public static InMemoryShoppingCartRepository getInstance() {
        if (instance == null) {
            synchronized (InMemoryShoppingCartRepository.class) {
                instance = instance == null ? new InMemoryShoppingCartRepository() : instance;
            }
        }
        return instance;
    }
}
