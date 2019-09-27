package domain;

import java.util.List;

public class Menu {
    private final String id;
    private final String name;
    private final String price;
    private final String restaurantId;
    private final List<String> content;

    public Menu(String id, String name, String price, String restaurantId, List<String> content) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurantId = restaurantId;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public List<String> getContent() {
        return content;
    }
}
