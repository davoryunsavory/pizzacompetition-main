package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<String> order = new ArrayList<>();

    public static void border(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("*");
        }
        System.out.print("\n");
    }

    public static void order(Scanner sc) {
        border(50);
        System.out.println("Options");
        System.out.println("1: Select Crust");
        System.out.println("2: Select Sauce");
        System.out.println("3: Select Toppings");
        System.out.println("4: See Current Order");
        int option = validation.val_int(sc, 4, "Not an option", "Select between 1 - 4: ");
        System.out.print("\n");

        switch (option) {
        case 1:
            orderCrust(sc);
            break;
        case 2:
            System.out.println("Entered Sauce");
            orderSauce(sc);

            break;
        case 3:
            orderToppings(sc);
            break;
        case 4:
            System.out.println(order);
            order(sc);
        }

    }

    public static void orderCrust(Scanner sc) {
        System.out.println("Entered Crust");
        border(50);
        System.out.println("Options");
        System.out.println("1: Regular Crust");
        System.out.println("2: Gluten Free Crust");
        System.out.println("3: Return to Order Menu");

        int option = validation.val_int(sc, 3, "Not an option", "Select between 1 - 3: ");
        System.out.print("\n");

        switch (option) {
        case 1:
            System.out.println("Regular Crust Added");
            order.add("Regular Crust");
            orderCrust(sc);
            break;
        case 2:
            System.out.println("Gluten Free Crust Added");
            order.add("Gluten Free Crust");
            orderCrust(sc);
            break;
        case 3:
            order(sc);
            ;
            break;
        }
    }

    public static void orderSauce(Scanner sc) {

        border(50);
        System.out.println("Options");
        System.out.println("1: Red Sauce");
        System.out.println("2: Garlic Sauce");
        System.out.println("3: Balsamic Vineger");
        System.out.println("4: Return to Order Menu");
        int option = validation.val_int(sc, 4, "Not an option", "Select between 1 - 4: ");

        switch (option) {
        case 1:
            check.checkifavaliable("Red Sauce", sc);
            break;
        case 2:
            order.add("Garlic Sauce");
            orderSauce(sc);
            break;
        case 3:
            System.out.println("Balsamic Vineger Added");
            order.add("Balsamic Vineger");
            orderSauce(sc);
            break;
        case 4:
            order(sc);
            break;
        }

    }

    public static void orderToppings(Scanner sc) {
        System.out.println("Entered Toppings");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome!");
        order(sc);

    }

}