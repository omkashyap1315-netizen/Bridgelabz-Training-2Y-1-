package Arrays.Assignment_02.Level02.Arrays.Strings;

import java.util.Scanner;

public class CustomTrimDemo {
    public static int[] getTrimIndices(String str) {
        int len = 0;
        try {
            while (true) {
                str.charAt(len);
                len++;
            }
        } catch (Exception e) {}

        int start = 0;
        int end = len - 1;

        while (start < len && str.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end + 1};
    }

    public static String customSubstring(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string with leading/trailing spaces: ");
        String text = scanner.nextLine();

        int[] indices = getTrimIndices(text);
        String customTrimmed = customSubstring(text, indices[0], indices[1]);
        String builtinTrimmed = text.trim();

        boolean result = compareStrings(customTrimmed, builtinTrimmed);
        System.out.println("Custom Trimmed: [" + customTrimmed + "]");
        System.out.println("Built-in Trimmed: [" + builtinTrimmed + "]");
        System.out.println("Are both outputs equal? " + result);
        scanner.close();
    }
}
