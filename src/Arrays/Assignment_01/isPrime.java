package Arrays.Assignment_01;

import java.util.Scanner;

public class isPrime {

    public static int reverseNumber(int n) {
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = -n;
        }

        int reversed = 0;
        while (n > 0) {
            int digit = n % 10;
            reversed = (reversed * 10) + digit;
            n = n / 10;
        }

        return isNegative ? -reversed : reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer N: ");
        int n = sc.nextInt();

        System.out.println("Reversed: " + reverseNumber(n));

        System.out.println("\n--- Example Checks ---");
        System.out.println("1234 -> " + reverseNumber(1234));
        System.out.println("806 -> " + reverseNumber(806));

        sc.close();
    }
}
