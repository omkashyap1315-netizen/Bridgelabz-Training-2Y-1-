package Arrays.Assignment_02.Level_03;

import java.util.Scanner;

public class UniqueCharacters {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }

    public static char[] getUniqueCharacters(String text) {
        int len = findLength(text);
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        char[] uniques = getUniqueCharacters(text);
        System.out.print("Unique characters: ");
        for (char c : uniques) {
            System.out.print(c + " ");
        }
        System.out.println();
        scanner.close();
    }
}
