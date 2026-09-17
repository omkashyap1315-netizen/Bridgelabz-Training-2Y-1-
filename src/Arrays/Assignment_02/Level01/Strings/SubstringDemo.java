package Arrays.Assignment_02.Level01.Strings;

import java.util.Scanner;

public class SubstringDemo {
    public static String getCustomSubstring(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(str.charAt(i));
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
        System.out.print("Enter a string: ");
        String text = scanner.next();
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();
        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        String customSub = getCustomSubstring(text, start, end);
        String builtinSub = text.substring(start, end);

        boolean areEqual = compareStrings(customSub, builtinSub);
        System.out.println("Custom Substring: " + customSub);
        System.out.println("Built-in Substring: " + builtinSub);
        System.out.println("Are both substrings equal? " + areEqual);
        scanner.close();
    }
}