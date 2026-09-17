package Arrays.Assignment_02.Level02.Arrays;

import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int n = scanner.nextInt();

        double[] weights = new double[n];
        double[] heights = new double[n];
        double[] bmis = new double[n];
        String[] statuses = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.print("Enter weight (kg): ");
            weights[i] = scanner.nextDouble();
            System.out.print("Enter height (m): ");
            heights[i] = scanner.nextDouble();

            bmis[i] = weights[i] / (heights[i] * heights[i]);

            if (bmis[i] < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmis[i] < 25.0) {
                statuses[i] = "Normal weight";
            } else if (bmis[i] < 30.0) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }

        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) + " -> Height: " + heights[i] + "m, Weight: " +
                    weights[i] + "kg, BMI: " + bmis[i] + ", Status: " + statuses[i]);
        }

        scanner.close();
    }
}