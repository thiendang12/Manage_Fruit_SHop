package Controller;

import Model.Fruit;
import Model.Other;
import View.Menu;
import Validation.Validation;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class ManageFruit {
    private Scanner scanner;
    private ArrayList<Fruit> lf;
    private Hashtable<String, ArrayList<Other>> ht;
    private Menu menu;

    public ManageFruit(Scanner scanner, ArrayList<Fruit> lf, Hashtable<String, ArrayList<Other>> ht) {
        this.scanner = scanner;
        this.lf = lf;
        this.ht = ht;
        this.menu = new Menu(scanner);
    }

    public void run() {
        while (true) {
            int choice = menu.displayMenu();

            switch (choice) {
                case 1:
                    createFruit();
                    break;
                case 2:
                    viewOthers();
                    break;
                case 3:
                    shopping();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private void createFruit() {
        System.out.println("Creating a new fruit...");
        while (true) {
            System.out.print("Enter fruit id: ");
            String fruitId = Validation.checkInputString(scanner);

            if (!Validation.checkIdExist(lf, fruitId)) {
                System.err.println("Id exists.");
                return;
            }

            System.out.print("Enter fruit name: ");
            String fruitName = Validation.checkInputString(scanner);
            System.out.print("Enter price: ");
            double price = Validation.checkInputDouble(scanner);
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputInt(scanner);
            System.out.print("Enter origin: ");
            String origin = Validation.checkInputString(scanner);

            lf.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            System.out.println("Fruit added successfully!");

            if (!Validation.checkInputYN(scanner)) {
                break;
            }
        }
    }

    private void viewOthers() {
        System.out.println("Viewing others...");
        if (ht.isEmpty()) {
            System.out.println("No others available.");
            return;
        }

        for (String customer : ht.keySet()) {
            System.out.println("Customer: " + customer);
            ArrayList<Other> others = ht.get(customer);
            Menu.displayListOthers(others);
        }
    }

    private void shopping() {
        System.out.println("Shopping...");
        if (lf.isEmpty()) {
            System.err.println("No items available.");
            return;
        }

        ArrayList<Other> lo = new ArrayList<>();
        while (true) {
            Menu.displayListFruit(lf);
            System.out.print("Enter item: ");
            int item = Validation.checkInputIntLimit(scanner, 1, lf.size());
            Fruit fruit = getFruitByItem(item);

            if (fruit == null) {
                System.err.println("Invalid item.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputIntLimit(scanner, 1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);

            if (!Validation.checkItemExist(lo, fruit.getFruitId())) {
                updateOrder(lo, fruit.getFruitId(), quantity);
            } else {
                lo.add(new Other(fruit.getFruitId(), fruit.getFruitName(),
                        quantity, fruit.getPrice()));
            }

            if (!Validation.checkInputYN(scanner)) {
                break;
            }
        }

        Menu.displayListOthers(lo);
        System.out.print("Enter name: ");
        String name = Validation.checkInputString(scanner);
        ht.put(name, lo);
        System.err.println("Order added successfully!");
    }

    private Fruit getFruitByItem(int item) {
        int countItem = 1;
        for (Fruit fruit : lf) {
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    private void updateOrder(ArrayList<Other> lo, String id, int quantity) {
        for (Other other : lo) {
            if (other.getFruitId().equalsIgnoreCase(id)) {
                other.setQuantity(other.getQuantity() + quantity);
                return;
            }
        }
    }
}
