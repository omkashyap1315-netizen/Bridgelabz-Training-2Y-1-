package Arrays.Assignment_02.Level02.Arrays.Strings;

import java.util.Scanner;

public class WordLengthTabular {
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

    public static String[][] getWordLengthTable(String[] words) {
        String[][] table = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(findLength(words[i]));
        }
        return table;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] words = customSplit(text);
        String[][] table = getWordLengthTable(words);

        System.out.println("\nWord\tLength");
        System.out.println("----------------");
        for (int i = 0; i < table.length; i++) {
            String word = table[i][0];
            int length = Integer.parseInt(table[i][1]);
            System.out.println(word + "\t" + length);
        }
        scanner.close();
    }
}
