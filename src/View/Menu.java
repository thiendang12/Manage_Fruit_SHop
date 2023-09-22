// Menu.java
package View;

import Model.Fruit;
import Model.Other;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public int displayMenu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Please choose an option: ");
        return scanner.nextInt();
    }

    public void displayListFruits(ArrayList<Fruit> lf) {
        System.out.printf("%-10s%-20s%-15s%-10s%-15s\n", "Item", "Fruit name", "Origin", "Price ($)", "Quantity");
        int count = 1;
        for (Fruit fruit : lf) {
            System.out.printf("%-10d%-20s%-15s%-10.2f%-15d\n",
                    count++, fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice(), fruit.getQuantity());
        }
    }

public void displayListOthers(ArrayList<Other> lo, ArrayList<Fruit> lf) {

        if (lo.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }

        String currentCustomer = "";
        double total = 0;

        for (Other order : lo) {
            if (!order.getCustomerName().equals(currentCustomer)) {
                if (!currentCustomer.isEmpty()) {
                    System.out.println("Total: $" + total);
                    System.out.println();
                    total = 0;
                }
                currentCustomer = order.getCustomerName();
                System.out.println("Customer: " + currentCustomer);
                System.out.printf("%-10s%-20s%-15s%-10s%-10s\n", "Item", "Product", "Quantity", "Price ($)", "Amount");
            }

            Fruit fruit = findFruitById(order.getFruitId(), lf);
            if (fruit != null) {
                double amount = order.getQuantity() * fruit.getPrice();
                System.out.printf("%-10s%-20s%-15d%-10.2f%-10.2f\n",
                        order.getFruitId(), fruit.getFruitName(), order.getQuantity(), fruit.getPrice(), amount);
                total += amount;
            }
        }
        System.out.println("Total: $" + total);
    }

    private Fruit findFruitById(String fruitId, ArrayList<Fruit> lf) {
        for (Fruit fruit : lf) {
            if (fruit.getFruitId().equals(fruitId)) {
                return fruit;
            }
        }
        return null;
    }
}
