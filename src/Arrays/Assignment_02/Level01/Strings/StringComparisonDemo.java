package Arrays.Assignment_02.Level01.Strings;

import java.util.Scanner;

public class StringComparisonDemo {
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
        System.out.print("Enter first string: ");
        String s1 = scanner.next();
        System.out.print("Enter second string: ");
        String s2 = scanner.next();

        boolean customResult = compareStrings(s1, s2);
        boolean builtinResult = s1.equals(s2);

        System.out.println("Result using custom charAt method: " + customResult);
        System.out.println("Result using built-in equals method: " + builtinResult);
        System.out.println("Do both match? " + (customResult == builtinResult));
        scanner.close();
    }
}
