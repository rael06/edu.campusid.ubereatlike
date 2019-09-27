package domain.repositories;

import domain.ShoppingCart;

import java.util.List;

public interface ShoppingCartRepository {
    void add(ShoppingCart shoppingCart);
    List<ShoppingCart> findByCustomerId(String customerId);
}
