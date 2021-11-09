package main;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class display {

    public static final char ESC = 27;
    public static List<String> order = new ArrayList<>();

    public static void main(String argv[]) {
        Console c = System.console();
        c.writer().print(ESC + "[2J");
        c.flush();

        for (int i = 0; i < 100; ++i) {
            // reposition the cursor to 1|1
            c.writer().print(ESC + "[1;1H");
            c.flush();

            c.writer().println("hello " + i);
            c.flush();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Thread2 thing didnt work");
                e.printStackTrace();
            }
        }

        Scanner sc = new Scanner(System.in);
        gotopage(c, sc);
    }

    public static void gotopage(Console c, Scanner sc) {
        //print home
        c.writer().print(ESC + "[2J");
        c.writer().print(ESC + "[1;1H");
        c.writer().print("Options\n");
        c.writer().print("1: Select Crust\n");
        c.writer().print("2: Select Sauce\n");
        c.writer().print("3: Select Toppings\n");
        c.writer().print("4: See Current Order\n");
        c.flush();
        
        //validation
        int option = validation.val_int(sc, 4, "Not an option", "Select between 1 - 4: ");
        
        //director
        switch (option) {
        case 1:
            c.writer().print(ESC + "[2J");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.print("Something f up");
                e.printStackTrace();
            }
            crust(c, sc);
            break;
        case 2:
            c.writer().print(ESC + "[2J");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.print("Something f up");
                e.printStackTrace();
            }
            sauce(c, sc);
            break;
        case 3:
            c.writer().print(ESC + "[2J");
            toppings(c, sc);
            break;
        case 4:
            c.writer().print(ESC + "[2J");
            c.writer().println("Going to order");
            gotopage(c, sc);
        }
        c.flush();
    }

    public static void crust(Console c, Scanner sc) {
        //Print menu items
        c.writer().print(ESC + "[2J");
        c.writer().print(ESC + "[1;1H");
        c.writer().print("Options\n");
        c.writer().print("1: Regular Crust\n");
        c.writer().print("2: Gluten Free Crust\n");
        c.writer().print("3: Go back to menu\n");
        c.flush();

        //validation
        int option = validation.val_int(sc, 3, "Not an option", "Select between 1 - 3: ");

        //director
        switch (option) {
        case 1:
            c.writer().print(ESC + "[2J");
            c.writer().println("regular added");
            crust(c, sc);
            break;
        case 2:
            c.writer().print(ESC + "[2J");
            c.writer().println("gluten free added");
            crust(c, sc);
            break;
        case 3:
            gotopage(c, sc);
            ;
            break;
        }
        c.flush();
    }

    public static void sauce(Console c, Scanner sc) {
        //Print menu items
        c.writer().print(ESC + "[2J");
        c.writer().print(ESC + "[1;1H");
        c.writer().print("Options\n");
        c.writer().print("1: Pizza Sauce\n");
        c.writer().print("2: Garlic Sauce\n");
        c.writer().print("3: Go back to menu\n");
        c.flush();

        //validation
        int option = validation.val_int(sc, 3, "Not an option", "Select between 1 - 3: ");

        //director
        switch (option) {
        case 1:
            c.writer().print(ESC + "[2J");
            c.writer().println("regular added");
            crust(c, sc);
            break;
        case 2:
            c.writer().print(ESC + "[2J");
            c.writer().println("gluten free added");
            crust(c, sc);
            break;
        case 3:
            gotopage(c, sc);
            break;
        }
        c.flush();
    }

    public static void toppings(Console c, Scanner sc) {
        //map for director
        Map<Integer, String> itemmap = new HashMap<Integer, String>() {
            {
                put(1, "Pizza Cheese");
                put(2, "Diced Onion");
                put(3, "Diced Green Onion");
                put(4, "Pepporoni");
                put(5, "Sliced Mushrooms");
                put(6, "Diced Jalepenos");
                put(7, "Sardines");
                put(8, "Pineapple Chunks");
                put(9, "Tofu");
                put(10, "Ham Chunks");
                put(11, "back");
            }
        };

        //Prints menu toppings
        c.writer().print(ESC + "[2J");
        c.writer().print(ESC + "[1;1H");
        c.writer().print("Options\n");
        c.writer().print("1: Pizza Cheese\t2: Diced Onion\t\t3: Diced Green Onion\n");
        c.writer().print("4: Pepporoni\t5: Sliced Mushrooms\t6: Diced Jalepenos\n");
        c.writer().print("7: Sardines\t8: Pinapple Chunks\t9: Tofu\n");
        c.writer().print("10: Ham Chunks\n");
        c.writer().print("11: Go back to menu\n");
        c.flush();

        //validation
        int option = validation.val_int(sc, 11, "Not an option", "Select between 1 - 11: ");

        // director
        if (itemmap.containsKey(option)) {
            if (itemmap.get(option).equals("back")) {
                c.writer().print(ESC + "[2J");
                c.writer().print(ESC + "[1;1H");
                gotopage(c, sc);
            }
            c.writer().print(ESC + "[2J");
            c.writer().print(ESC + "[1;1H");
            //checks if item is avaliable
            //if (check.checkifavaliable(itemmap.get(option)) == true,) {
                order.add(itemmap.get(option));
            } else {
                c.writer().print(ESC + "[2J");
                c.writer().print(ESC + "[1;1H");
                c.writer().print(itemmap.get(option)+" Available");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("David you a dumb loser");
                    e.printStackTrace();
                }
                toppings(c, sc);
            }
            
            c.writer().println(itemmap.get(option));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Your so stupid david");
                e.printStackTrace();
            }
            toppings(c, sc);
            c.flush();
        }
        sc.close();
    }
}