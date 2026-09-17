package Arrays.Assignment_02.Level_03;

import java.util.Scanner;

public class CharacterFrequencyUnique {
    public static char[] uniqueCharacters(String text) {
        int len = text.length();
        char[] tempArr = new char[len];
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == c) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                tempArr[uniqueCount++] = c;
            }
        }

        char[] uniqueArr = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueArr[i] = tempArr[i];
        }
        return uniqueArr;
    }

    public static String[][] getFrequencyWithUniques(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        char[] uniques = uniqueCharacters(text);
        String[][] table = new String[uniques.length][2];

        for (int i = 0; i < uniques.length; i++) {
            table[i][0] = String.valueOf(uniques[i]);
            table[i][1] = String.valueOf(freq[uniques[i]]);
        }
        return table;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[][] table = getFrequencyWithUniques(text);
        System.out.println("\nCharacter\tFrequency");
        System.out.println("-------------------------");
        for (String[] row : table) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
        scanner.close();
    }
}
