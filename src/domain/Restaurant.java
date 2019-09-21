package domain;

public class Restaurant {
    private final String id;
    private final String name;
    private final String shippingTime;
    private final String type;

    public Restaurant(String id, String name, String shippingTime, String type) {
        this.id = id;
        this.name = name;
        this.shippingTime = shippingTime;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShippingTime() {
        return shippingTime;
    }

    public String getType() {
        return type;
    }
}
