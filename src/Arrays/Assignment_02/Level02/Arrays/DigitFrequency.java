package Arrays.Assignment_02.Level02.Arrays;

import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();

        long temp = Math.abs(number);
        int count = (temp == 0) ? 1 : 0;
        long t = temp;
        while (t > 0) {
            count++;
            t /= 10;
        }

        int[] digits = new int[count];
        int index = 0;
        if (temp == 0) {
            digits[0] = 0;
        } else {
            while (temp > 0) {
                digits[index++] = (int) (temp % 10);
                temp /= 10;
            }
        }

        int[] frequency = new int[10];
        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]]++;
        }

        System.out.println("\nDigit Frequencies:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " time(s)");
            }
        }

        scanner.close();
    }
}
