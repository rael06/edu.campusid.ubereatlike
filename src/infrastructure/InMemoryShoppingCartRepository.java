package infrastructure;

import domain.Restaurant;
import domain.ShoppingCart;
import domain.repositories.ShoppingCartRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryShoppingCartRepository implements ShoppingCartRepository {
    private static InMemoryShoppingCartRepository instance = null;

    private List<ShoppingCart> shoppingCarts = new ArrayList<>();

    private InMemoryShoppingCartRepository() { }

    public static InMemoryShoppingCartRepository getInstance() {
        if (instance == null) {
            synchronized (InMemoryShoppingCartRepository.class) {
                instance = instance == null ? new InMemoryShoppingCartRepository() : instance;
            }
        }
        return instance;
    }

    @Override
    public void add(ShoppingCart shoppingCart) {
        shoppingCarts.add(shoppingCart);
    }

    @Override
    public List<ShoppingCart> findByCustomerId(String customerId) {
        return null;
    }
}
