package Arrays.Assignment_02.Linear_and_Binary_Search;

import java.util.HashSet;

public class StringBuilderRemoveDuplicates {
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!seen.contains(c)) {
                seen.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);
        System.out.println("Original: " + input);
        System.out.println("Without Duplicates: " + result);
    }
}
