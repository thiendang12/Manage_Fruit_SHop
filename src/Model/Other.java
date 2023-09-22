// Order.java
package Model;

public class Other {
    private String customerName;
    private String fruitId;
    private int quantity;

    public Other(String customerName, String fruitId, int quantity) {
        this.customerName = customerName;
        this.fruitId = fruitId;
        this.quantity = quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getFruitId() {
        return fruitId;
    }

    public int getQuantity() {
        return quantity;
    }
}
