package Arrays.Assignment_01;

import java.util.Scanner;

public class DigitReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer N to reverse: ");
        int n = scanner.nextInt();

        int originalN = n;
        int reversedNumber = 0;

        boolean isNegative = n < 0;
        if (isNegative) {
            n = -n;
        }

        while (n > 0) {
            int digit = n % 10;

            reversedNumber = reversedNumber * 10 + digit;

            n = n / 10;
        }

        if (isNegative) {
            reversedNumber = -reversedNumber;
        }

        System.out.println("Original Number: " + originalN);
        System.out.println("Reversed Number: " + reversedNumber);

        scanner.close();
    }
}
