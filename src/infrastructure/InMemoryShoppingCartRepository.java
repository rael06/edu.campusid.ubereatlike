package infrastructure;

import domain.Restaurant;
import domain.ShoppingCart;
import domain.repositories.ShoppingCartRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return shoppingCarts.stream().filter(sc-> sc.getCustomerId().equals(customerId)).collect(Collectors.toList());
    }
}
