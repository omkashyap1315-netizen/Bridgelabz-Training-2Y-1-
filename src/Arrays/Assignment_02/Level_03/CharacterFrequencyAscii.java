package Arrays.Assignment_02.Level_03;

import java.util.Scanner;

public class CharacterFrequencyAscii {
    public static String[][] getCharacterFrequency(String text) {
        int[] freq = new int[256];
        int len = text.length();

        for (int i = 0; i < len; i++) {
            freq[text.charAt(i)]++;
        }

        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                uniqueCount++;
            }
        }

        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            if (freq[c] > 0) {
                result[index][0] = String.valueOf(c);
                result[index][1] = String.valueOf(freq[c]);
                freq[c] = 0; // prevent duplicates
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[][] freqTable = getCharacterFrequency(text);
        System.out.println("\nCharacter\tFrequency");
        System.out.println("-------------------------");
        for (String[] row : freqTable) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
        scanner.close();
    }
}