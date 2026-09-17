package Arrays.Assignment_02.Level01.Strings;

import java.util.Scanner;

public class NumberFormatDemo {
    public static void generateException(String text) {
        int num = Integer.parseInt(text);
        System.out.println(num);
    }

    public static void handleException(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-numeric string: ");
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
