package Arrays.Assignment_02.Level02.Arrays;

import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        double[][] marks = new double[n][3]; // [][0] = Physics, [][1] = Chemistry, [][2] = Maths
        double[] percentages = new double[n];
        String[] grades = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.print("Physics marks: ");
            double phy = scanner.nextDouble();
            System.out.print("Chemistry marks: ");
            double chem = scanner.nextDouble();
            System.out.print("Maths marks: ");
            double math = scanner.nextDouble();

            if (phy < 0 || chem < 0 || math < 0) {
                System.out.println("Marks cannot be negative. Re-enter.");
                i--;
                continue;
            }

            marks[i][0] = phy;
            marks[i][1] = chem;
            marks[i][2] = math;

            percentages[i] = (phy + chem + math) / 3.0;
            double p = percentages[i];

            if (p >= 90) {
                grades[i] = "A+";
            } else if (p >= 80) {
                grades[i] = "A";
            } else if (p >= 70) {
                grades[i] = "B";
            } else if (p >= 60) {
                grades[i] = "C";
            } else if (p >= 50) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }

        System.out.println("\n--- Student Performance Report ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + " -> Marks [Phy: " + marks[i][0] +
                    ", Chem: " + marks[i][1] + ", Math: " + marks[i][2] +
                    "], Percentage: " + percentages[i] + "%, Grade: " + grades[i]);
        }

        scanner.close();
    }
}
