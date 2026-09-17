package Arrays.Assignment_02.Level_03;

import java.util.Scanner;

public class PalindromeChecker {
    public static boolean checkPalindromeLogic1(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean checkPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return checkPalindromeRecursive(text, start + 1, end - 1);
    }

    public static boolean checkPalindromeLogic3(String text) {
        char[] original = text.toCharArray();
        char[] reverse = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reverse[i] = original[original.length - 1 - i];
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to check palindrome: ");
        String text = scanner.nextLine();

        boolean r1 = checkPalindromeLogic1(text);
        boolean r2 = checkPalindromeRecursive(text, 0, text.length() - 1);
        boolean r3 = checkPalindromeLogic3(text);

        System.out.println("Logic 1 Result: " + r1);
        System.out.println("Logic 2 (Recursive) Result: " + r2);
        System.out.println("Logic 3 (Array) Result: " + r3);
        scanner.close();
    }
}
