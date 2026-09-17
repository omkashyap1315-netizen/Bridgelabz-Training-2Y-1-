package Arrays.Assignment_02.Level_03;

import java.util.Scanner;

public class AnagramChecker {
    public static boolean areAnagrams(String t1, String t2) {
        if (t1.length() != t2.length()) return false;
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        for (int i = 0; i < t1.length(); i++) {
            freq1[t1.charAt(i)]++;
            freq2[t2.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first text: ");
        String t1 = scanner.next();
        System.out.print("Enter second text: ");
        String t2 = scanner.next();

        boolean result = areAnagrams(t1, t2);
        System.out.println("Are both texts anagrams? " + result);
        scanner.close();
    }
}
