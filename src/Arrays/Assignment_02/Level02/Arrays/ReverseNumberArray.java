package Arrays.Assignment_02.Level02.Arrays;


import java.util.Scanner;

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int temp = Math.abs(number);
        int count = (temp == 0) ? 1 : 0;
        int t = temp;
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
                digits[index++] = temp % 10;
                temp /= 10;
            }
        }

        int[] reversedDigits = new int[count];
        for (int i = 0; i < count; i++) {
            reversedDigits[i] = digits[count - 1 - i];
        }

        System.out.print("Digits in reverse order array: ");
        for (int d : reversedDigits) {
            System.out.print(d + " ");
        }
        System.out.println();

        scanner.close();
    }
}