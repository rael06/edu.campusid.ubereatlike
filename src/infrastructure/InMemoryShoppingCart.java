package infrastructure;

import domain.Menu;
import domain.ShoppingCart;
import domain.repositories.ShoppingCartRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryShoppingCart implements ShoppingCartRepository {
    private static InMemoryShoppingCart instance = null;

    private List<ShoppingCart> shoppingCarts = new ArrayList<>();

    private InMemoryShoppingCart() {
    }

    public static InMemoryShoppingCart getInstance() {
        if (instance == null) {
            synchronized (InMemoryShoppingCart.class) {
                instance = instance == null ? new InMemoryShoppingCart() : instance;
            }
        }
        return instance;
    }

    @Override
    public void add(ShoppingCart sc) {
        shoppingCarts.add(sc);
    }
}
