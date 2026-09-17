package Arrays.Assignment_02.Level02.Arrays;

import java.util.Scanner;

public class ZeroBonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] employeeData = new double[10][2]; // [][0] = salary, [][1] = years of service
        double[][] resultData = new double[10][2];   // [][0] = bonus amount, [][1] = new salary

        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        System.out.println("Enter salary and years of service for 10 employees:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1) + ":");
            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();
            System.out.print("Enter years of service: ");
            double years = scanner.nextDouble();

            if (salary < 0 || years < 0) {
                System.out.println("Invalid input! Salary and years of service cannot be negative. Please re-enter.");
                i--; // Decrement index to repeat iteration
                continue;
            }

            employeeData[i][0] = salary;
            employeeData[i][1] = years;
        }

        for (int i = 0; i < 10; i++) {
            double salary = employeeData[i][0];
            double years = employeeData[i][1];
            double bonusPercentage = (years > 5) ? 0.05 : 0.02;

            double bonus = salary * bonusPercentage;
            double newSalary = salary + bonus;

            resultData[i][0] = bonus;
            resultData[i][1] = newSalary;

            totalBonus += bonus;
            totalOldSalary += salary;
            totalNewSalary += newSalary;
        }

        System.out.println("\n--- Company Zara Salary & Bonus Report ---");
        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1) + " -> Old Salary: " + employeeData[i][0] +
                    ", Bonus: " + resultData[i][0] + ", New Salary: " + resultData[i][1]);
        }
        System.out.println("----------------------------------------");
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);

        scanner.close();
    }
}
