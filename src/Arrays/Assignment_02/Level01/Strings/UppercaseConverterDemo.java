package Arrays.Assignment_02.Level01.Strings;

import java.util.Scanner;

public class UppercaseConverterDemo {
    public static String convertToUppercase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char) (c - 32);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String customUpper = convertToUppercase(text);
        String builtinUpper = text.toUpperCase();

        boolean result = compareStrings(customUpper, builtinUpper);
        System.out.println("Custom Uppercase: " + customUpper);
        System.out.println("Built-in Uppercase: " + builtinUpper);
        System.out.println("Are both outputs identical? " + result);
        scanner.close();
    }
}
