package domain;

public class Menu {
    private final String id;
    private final String name;
    private final String price;

    public Menu(String id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
}
