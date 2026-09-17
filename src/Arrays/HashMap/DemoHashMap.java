package Arrays.HashMap;

import java.util.*;

public class DemoHashMap {
    public static void main(String[] args) {
        Map<String, Integer> studentAges = new HashMap<>();

        studentAges.put("Virat", 18);
        studentAges.put("Rohit", 45);
        studentAges.put("KL", 1);

        System.out.println("KL's age: " + studentAges.get("KL"));

        studentAges.put("KL", 21);
        System.out.println("KL's age: " + studentAges.get("KL"));

        boolean hasRohit = studentAges.containsKey("Rohit");
        System.out.println(hasRohit);

        studentAges.remove("Virat");
        System.out.println(studentAges);

        for (Map.Entry<String, Integer> entry : studentAges.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}