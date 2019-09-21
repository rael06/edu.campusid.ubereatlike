package domain;

public class Menu {
    private final String id;
    private final String name;
    private final String price;
    private final String restaurantId;

    public Menu(String id, String name, String price, String restaurantId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurantId = restaurantId;
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
}
