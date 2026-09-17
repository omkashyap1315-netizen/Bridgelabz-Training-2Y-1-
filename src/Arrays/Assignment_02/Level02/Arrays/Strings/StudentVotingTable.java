package Arrays.Assignment_02.Level02.Arrays.Strings;

import java.util.Random;

public class StudentVotingTable {
    public static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(83) + 5; // ages between 5 and 87
        }
        return ages;
    }

    public static String[][] checkVotingStatus(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                result[i][1] = "False";
            } else {
                result[i][1] = String.valueOf(ages[i] >= 18);
            }
        }
        return result;
    }

    public static void displayTable(String[][] table) {
        System.out.println("\nAge\tCan Vote");
        System.out.println("----------------");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {
        int[] ages = generateAges(10);
        String[][] table = checkVotingStatus(ages);
        displayTable(table);
    }
}