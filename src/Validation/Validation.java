package Validation;

import Model.Fruit;
import Model.Other;
import java.util.ArrayList;
import java.util.Scanner;

public class Validation {
    private static final Scanner in = new Scanner(System.in);

    // Check if an integer input is within the range [min, max]
    public static int checkInputIntLimit(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter a number within the range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    // Check if a string input is not empty
    public static String checkInputString(Scanner scanner) {
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Input cannot be empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    // Check if an input is an integer
    public static int checkInputInt(Scanner scanner) {
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter an integer.");
                System.out.print("Enter again: ");
            }
        }
    }

    // Check if an input is a double
    public static double checkInputDouble(Scanner scanner) {
        while (true) {
            try {
                double result = Double.parseDouble(scanner.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter a valid number.");
                System.out.print("Enter again: ");
            }
        }
    }

    // Check if the input is 'Y' or 'N'
    public static boolean checkInputYN(Scanner scanner) {
        System.out.print("Do you want to continue (Y/N)? ");
        while (true) {
            String result = checkInputString(scanner);
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please enter 'Y' or 'N'.");
            System.out.print("Enter again: ");
        }
    }

    // Check if an ID already exists in a list
    public static boolean checkIdExist(ArrayList<Fruit> fruitList, String id) {
        for (Fruit fruit : fruitList) {
            if (id.equalsIgnoreCase(fruit.getFruitId())) {
                return false;
            }
        }
        return true;
    }

    // Check if an item already exists in an order list
    public static boolean checkItemExist(ArrayList<Other> otherList, String id) {
        for (Other other : otherList) {
            if (other.getFruitId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }
}
