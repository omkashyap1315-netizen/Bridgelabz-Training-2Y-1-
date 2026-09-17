package Arrays.Assignment_02.Level02.Arrays.Strings;

import java.util.Arrays;
import java.util.Scanner;

public class CustomSplitDemo {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {}
        return count;
    }

    public static String[] customSplit(String text) {
        int len = findLength(text);
        if (len == 0) return new String[0];

        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ' && i > 0 && i < len - 1 && text.charAt(i - 1) != ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                if (currentWord.length() > 0) {
                    words[wordIndex++] = currentWord.toString();
                    currentWord.setLength(0);
                }
            } else {
                currentWord.append(c);
            }
        }
        if (currentWord.length() > 0 && wordIndex < words.length) {
            words[wordIndex] = currentWord.toString();
        }
        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] customWords = customSplit(text);
        String[] builtinWords = text.trim().split("\\s+");

        boolean result = compareArrays(customWords, builtinWords);
        System.out.println("Custom split words: " + Arrays.toString(customWords));
        System.out.println("Built-in split words: " + Arrays.toString(builtinWords));
        System.out.println("Are both arrays identical? " + result);
        scanner.close();
    }
}
