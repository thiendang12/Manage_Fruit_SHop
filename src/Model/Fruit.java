// Fruit.java
package Model;

public class Fruit {
    private String fruitId;
    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    public Fruit(String fruitId, String fruitName, double price, int quantity, String origin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getFruitId() {
        return fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
