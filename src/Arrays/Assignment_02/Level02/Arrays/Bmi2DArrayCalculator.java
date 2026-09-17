package Arrays.Assignment_02.Level02.Arrays;

import java.util.Scanner;

public class Bmi2DArrayCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int n = scanner.nextInt();

        double[][] personData = new double[n][3]; // [][0] = weight, [][1] = height, [][2] = BMI
        String[] weightStatus = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.print("Enter weight (kg): ");
            double weight = scanner.nextDouble();
            System.out.print("Enter height (m): ");
            double height = scanner.nextDouble();

            if (weight <= 0 || height <= 0) {
                System.out.println("Values must be positive. Please re-enter.");
                i--;
                continue;
            }

            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = weight / (height * height);

            double bmi = personData[i][2];
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25.0) {
                weightStatus[i] = "Normal weight";
            } else if (bmi < 30.0) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\n--- 2D Array BMI Report ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + " -> Height: " + personData[i][1] +
                    "m, Weight: " + personData[i][0] + "kg, BMI: " + personData[i][2] +
                    ", Status: " + weightStatus[i]);
        }

        scanner.close();
    }
}
