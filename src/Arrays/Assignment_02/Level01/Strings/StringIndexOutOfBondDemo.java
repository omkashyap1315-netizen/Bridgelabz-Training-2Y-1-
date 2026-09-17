package Arrays.Assignment_02.Level01.Strings;

import java.util.Scanner;

public class StringIndexOutOfBondDemo {
    public static void generateException(String text) {
        System.out.println(text.charAt(text.length()));
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
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
