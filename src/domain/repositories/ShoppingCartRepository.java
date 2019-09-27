package domain.repositories;

import domain.ShoppingCartItem;

import java.util.List;

public interface ShoppingCartRepository {
    void add(ShoppingCartItem item);
    List<ShoppingCartItem> getShoppingCartItems();
}
