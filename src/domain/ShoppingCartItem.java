package domain;

public class ShoppingCartItem {
    private String menuId;
    private String name;
    private String price;
    private static int quantity = 0;

    public ShoppingCartItem(String menuId, String name, String price) {
        this.menuId = menuId;
        this.name = name;
        this.price = price;
        quantity++;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public static int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
