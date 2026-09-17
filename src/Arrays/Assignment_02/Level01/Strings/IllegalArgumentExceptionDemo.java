package Arrays.Assignment_02.Level01.Strings;

import java.util.Scanner;

public class IllegalArgumentExceptionDemo {
    public static void generateException(String text) {
        System.out.println(text.substring(4, 1));
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.substring(4, 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string (at least 5 characters): ");
        String text = scanner.next();

        System.out.println("Calling method that generates exception:");
        try {
            generateException(text);
        } catch (Exception e) {
            System.out.println("Program caught exception: " + e);
        }

        System.out.println("\nCalling method that handles exception safely:");
        handleException(text);
        scanner.close();
    }
}
