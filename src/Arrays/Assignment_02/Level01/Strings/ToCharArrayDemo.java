package Arrays.Assignment_02.Level01.Strings;

import java.util.Arrays;
import java.util.Scanner;

public class ToCharArrayDemo {
    public static char[] getCharacters(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }

    public static boolean compareArrays(char[] arr1, char[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = scanner.next();

        char[] customChars = getCharacters(text);
        char[] builtinChars = text.toCharArray();

        boolean result = compareArrays(customChars, builtinChars);
        System.out.println("Custom Character Array: " + Arrays.toString(customChars));
        System.out.println("Built-in Character Array: " + Arrays.toString(builtinChars));
        System.out.println("Are both arrays identical? " + result);
        scanner.close();
    }
}
