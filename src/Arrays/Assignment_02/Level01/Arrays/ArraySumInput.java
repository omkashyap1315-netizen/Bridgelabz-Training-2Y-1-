package Arrays.Assignment_02.Level01.Arrays;

import java.util.Scanner;

public class ArraySumInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] values = new double[10];
        double total = 0.0;
        int index = 0;

        System.out.println("Enter up to 10 numbers (enter 0 or a negative number to stop):");
        while (true) {
            System.out.print("Enter number: ");
            double input = scanner.nextDouble();

            if (input <= 0) {
                break;
            }

            if (index == 10) {
                break;
            }

            values[index] = input;
            index++;
        }

        for (int i = 0; i < index; i++) {
            total += values[i];
        }

        System.out.println("Total sum of entered numbers: " + total);
        scanner.close();
    }
}