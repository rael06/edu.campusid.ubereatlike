package domain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int nbItems = 0;
    private int price = 0;
    private String customerId;
    private List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();

    public ShoppingCart(String customerId) {
        this.customerId = customerId;
    }

    public int getPrice() {
        return price;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getNbItems() {
        return nbItems;
    }

    public List<ShoppingCartItem> getShoppingCartItems() {
        return shoppingCartItems;
    }

    public void add(ShoppingCartItem item) {
        shoppingCartItems.add(item);
    }
}
