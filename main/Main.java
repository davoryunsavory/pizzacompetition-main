package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import financelib.*;

public class Main {

    public static List<String> order = new ArrayList<>();

    public static void login(Scanner sc) {
        System.out.print("Would you like to login or register? (l or r) ");
        String ans = sc.nextLine();
        if (ans.equals("l")) {
            if (validation.val_login(sc, "incorrect credentials try again\n", "passwords.txt", "usernames.txt") == true) {
                System.out.println("You have logged in\n");
            }
        } else if (ans.equals("r")) {
            register(sc);
        }
    }

    public static void register (Scanner sc) {
        System.out.print("Enter a username --> ");
        String username = sc.nextLine();
        System.out.print("Enter a password --> ");
        String pass = sc.nextLine();
        configure.append(encode.enc_pass(pass), "passwords.txt");
        configure.append(username, "usernames.txt");
        login(sc);
    }

    public static void border (int length) {
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
        
        switch(option) {
            case 1: orderCrust(sc);
                break;
            case 2: orderSauce(sc);
                break;
            case 3: orderToppings(sc);
                break;
            case 4: System.out.println(order);
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

        switch(option) {
            case 1:
            if (check.checkifavaliable("regular crust") == true) {
                System.out.println("Regular Crust Added");
                order.add("Regular Crust");
                orderCrust(sc);
            } else {
                System.out.println("Reached max ingrediants");
                orderCrust(sc);
            }
            
                break;
            case 2: System.out.println("Gluten Free Crust Added");
            order.add("Gluten Free Crust");
            orderCrust(sc);
                break;
            case 3: order(sc);;
                break;
        }
    }

    public static void orderSauce(Scanner sc) {
        System.out.println("Entered Sauce");
        border(50);
        System.out.println("Options");
        System.out.println("1: Red Sauce");
        System.out.println("2: Garlic Sauce");
        System.out.println("3: Balsamic Vineger");
        System.out.println("4: Return to Order Menu");
        int option = validation.val_int(sc, 4, "Not an option", "Select between 1 - 4: ");

        switch (option) {
            case 1: System.out.println("Red Sauce Added");
            order.add("Red Sauce");
            orderSauce(sc);
            break;
            case 2: System.out.println("Garlic Sauce Added");
            order.add("Garlic Sauce");
            orderSauce(sc);
            break;
            case 3: System.out.println("Balsamic Vineger Added");
            order.add("Balsamic Vineger");
            orderSauce(sc);
            break;
            case 4: order(sc);
            break;
        }

    }

    public static void orderToppings(Scanner sc) {
        System.out.println("Entered Toppings");
        border(50);
        System.out.println("Options");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome!");
        login(sc);
        order(sc);

    }
        
}