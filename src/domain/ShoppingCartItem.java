package domain;

public class ShoppingCartItem {
    private static int index = 0;
    private int id;
    private String menuId;
    private String name;
    private String price;
    private static int quantity = 0;

    public ShoppingCartItem(String menuId, String name, String price) {
        index++;
        id = index;
        this.menuId = menuId;
        this.name = name;
        this.price = price;
        quantity++;
    }

    public int getId() {
        return id;
    }

    public Double getPrice() {
        return Double.parseDouble(price);
    }

    public String getName() {
        return name;
    }

    public String getMenuId() {
        return menuId;
    }

    public static int getQuantity() {
        return quantity;
    }

}
