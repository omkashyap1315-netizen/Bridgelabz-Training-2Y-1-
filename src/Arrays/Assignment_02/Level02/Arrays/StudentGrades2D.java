package Arrays.Assignment_02.Level02.Arrays;

import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        double[][] studentMarks = new double[n][3];
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

            studentMarks[i][0] = phy;
            studentMarks[i][1] = chem;
            studentMarks[i][2] = math;

            percentages[i] = (studentMarks[i][0] + studentMarks[i][1] + studentMarks[i][2]) / 3.0;
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

        System.out.println("\n--- Student 2D Array Grades Report ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + " -> Marks [Phy: " + studentMarks[i][0] +
                    ", Chem: " + studentMarks[i][1] + ", Math: " + studentMarks[i][2] +
                    "], Percentage: " + percentages[i] + "%, Grade: " + grades[i]);
        }

        scanner.close();
    }
}
