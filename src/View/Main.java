// Main.java
package View;

import Controller.ManageFruit;
import Model.Fruit;
import Model.Other;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Fruit> lf = new ArrayList<>();
        Hashtable<String, ArrayList<Other>> ht = new Hashtable<>();
        ManageFruit manageFruit = new ManageFruit(scanner, lf, ht);
        manageFruit.run();
    }
}
