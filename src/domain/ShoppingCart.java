package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingCart {
    private String customerId;
    private List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();

    public ShoppingCart(String customerId) {
        this.customerId = customerId;
    }

    public Double getPrice() {
        return new Double(String.valueOf(shoppingCartItems.stream().mapToDouble(item-> item.getPrice().doubleValue()).sum()));
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getNbItems() {
        return shoppingCartItems.size();
    }

    public List<ShoppingCartItem> getShoppingCartItems() {
        return shoppingCartItems;
    }

    public void add(ShoppingCartItem item) {
        shoppingCartItems.add(item);
    }

    public void remove(Optional<ShoppingCartItem> item) {
        item.ifPresent(shoppingCartItem -> shoppingCartItems.remove(shoppingCartItem));
    }
}
