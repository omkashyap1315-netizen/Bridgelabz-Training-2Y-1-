package Arrays.Assignment_02.Level02.Arrays.Strings;

import java.util.Scanner;

public class VowelConsonantCounter {
    public static String checkCharType(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char) (c + 32);
        }
        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    public static int[] countVowelsConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        int len = 0;
        try {
            while (true) {
                text.charAt(len);
                len++;
            }
        } catch (Exception e) {}

        for (int i = 0; i < len; i++) {
            String type = checkCharType(text.charAt(i));
            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        int[] counts = countVowelsConsonants(text);
        System.out.println("Vowels count: " + counts[0]);
        System.out.println("Consonants count: " + counts[1]);
        scanner.close();
    }
}
