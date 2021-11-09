package main;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class check {
    public static Map<String, Integer> othermap = new HashMap<String, Integer>() {
        {
            put("Gluten Free Crust", 1);
            put("Red Sauce", 2);
            put("Diced Onion", 3);
            put("Diced Green Onion", 2);
            
        }
    };

    public static boolean checkifavaliable(String input, Scanner sc) {
        if (othermap.containsKey(input)) {
            if (othermap.get(input) > 0) {
                int value = othermap.get(input);
                othermap.replace(input, value - 1);
                System.out.println("The " + input + " is available");
                Main.order.add(input);
                Main.orderSauce(sc);
                return true;
            } else {
                System.out.println(input + " is not available");
                Main.orderSauce(sc);
                return false;
            }
        }
        return false;
    }
}