package Arrays.Assignment_02.Level01.Strings;

import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {
    public static void generateException(String[] names) {
        System.out.println(names[names.length]);
    }

    public static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = new String[3];
        System.out.println("Enter 3 names:");
        for (int i = 0; i < 3; i++) {
            names[i] = scanner.next();
        }

        System.out.println("Calling method that generates exception:");
        try {
            generateException(names);
        } catch (Exception e) {
            System.out.println("Program caught exception: " + e);
        }

        System.out.println("\nCalling method that handles exception safely:");
        handleException(names);
        scanner.close();
    }
}
