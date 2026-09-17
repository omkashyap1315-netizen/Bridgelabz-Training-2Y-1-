package Arrays.Assignment_02.Level02.Arrays.Strings;

import java.util.Scanner;

public class CustomStringLength {
    public static int getLengthWithoutBuiltin(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Reached end of string
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.next();

        int customLength = getLengthWithoutBuiltin(text);
        int builtinLength = text.length();

        System.out.println("Length using custom method: " + customLength);
        System.out.println("Length using built-in method: " + builtinLength);
        System.out.println("Are both lengths equal? " + (customLength == builtinLength));
        scanner.close();
    }
}
