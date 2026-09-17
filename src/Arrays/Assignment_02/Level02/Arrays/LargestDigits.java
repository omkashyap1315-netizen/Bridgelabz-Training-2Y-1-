package Arrays.Assignment_02.Level02.Arrays;

import java.util.Scanner;

public class LargestDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        long temp = Math.abs(number);
        if (temp == 0) {
            digits[0] = 0;
            index = 1;
        } else {
            while (temp != 0 && index < maxDigit) {
                digits[index] = (int) (temp % 10);
                temp /= 10;
                index++;
            }
        }

        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < index; i++) {
            int current = digits[i];
            if (current > largest) {
                secondLargest = largest;
                largest = current;
            } else if (current > secondLargest && current != largest) {
                secondLargest = current;
            }
        }

        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);

        scanner.close();
    }
}
