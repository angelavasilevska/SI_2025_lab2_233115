

public class Item {
    private String name;
    private int price;
    private int quantity;
    private float discount;

    public Item(String name, int price, int quantity, float discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getDiscount() {
        return discount;
    }
}

