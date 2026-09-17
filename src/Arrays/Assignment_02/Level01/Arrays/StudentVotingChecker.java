package Arrays.Assignment_02.Level01.Arrays;

import java.util.Scanner;

public class StudentVotingChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[10];

        System.out.println("Enter the age of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
        }

        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            if (age < 0) {
                System.out.println("Invalid age");
            } else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            } else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }
        scanner.close();
    }
}
