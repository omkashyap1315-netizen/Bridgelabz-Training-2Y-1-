package Arrays.Assignment_02.Level_03;

import java.util.Scanner;

public class BmiTeamCalculator {
    public static String[][] computeBmiAndStatus(double[][] data) {
        String[][] result = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);

            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);

            if (bmi < 18.5) {
                result[i][3] = "Underweight";
            } else if (bmi < 25.0) {
                result[i][3] = "Normal";
            } else if (bmi < 30.0) {
                result[i][3] = "Overweight";
            } else {
                result[i][3] = "Obese";
            }
        }
        return result;
    }

    public static String[][] processTeamData(double[][] inputData) {
        return computeBmiAndStatus(inputData);
    }

    public static void displayTable(String[][] table) {
        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1] + "\t\t" + table[i][2] + "\t" + table[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] inputData = new double[10][2];

        System.out.println("Enter weight (kg) and height (cm) for 10 members:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            inputData[i][0] = scanner.nextDouble();
            System.out.print("Height (cm): ");
            inputData[i][1] = scanner.nextDouble();
        }

        String[][] report = processTeamData(inputData);
        displayTable(report);
        scanner.close();
    }
}