package Arrays.Assignment_02.Level02.Arrays.Strings;

import java.util.Scanner;

public class CharacterTypeTabular {
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

    public static String[][] getCharacterTable(String text) {
        int len = 0;
        try {
            while (true) {
                text.charAt(len);
                len++;
            }
        } catch (Exception e) {}

        String[][] table = new String[len][2];
        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            table[i][0] = String.valueOf(c);
            table[i][1] = checkCharType(c);
        }
        return table;
    }

    public static void displayTable(String[][] table) {
        System.out.println("\nCharacter\tType");
        System.out.println("---------------------");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[][] table = getCharacterTable(text);
        displayTable(table);
        scanner.close();
    }
}
