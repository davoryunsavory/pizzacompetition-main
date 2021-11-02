package main;
import java.util.HashMap;
import java.util.Map;

public class check {
    public static Map<String, Integer> othermap = new HashMap<String, Integer>() {
        {
            put("Diced Onion", 3);
            put("gluten free crust", 1);
            put("red sauce", 2);
        }
    };

    public static boolean checkifavaliable(String input) {
        if (othermap.containsKey(input)) {
            if (othermap.get(input) > 0) {
                System.out.println("Contains item " + input);
                int value = othermap.get(input);
                othermap.replace(input, value - 1);
                return true;
            } else {
                System.out.println("Does not contain item " + input);
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        checkifavaliable("Crust");
    }

}
