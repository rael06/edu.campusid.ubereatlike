package domain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static int id = 0;
    private String customerId;
    private List<String> items = new ArrayList<>();

    public ShoppingCart(String customerId) {
        ShoppingCart.id++;
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<String> getItems() {
        return items;
    }

    public void addItem(String menuId) {
        items.add(menuId);
    }


}
