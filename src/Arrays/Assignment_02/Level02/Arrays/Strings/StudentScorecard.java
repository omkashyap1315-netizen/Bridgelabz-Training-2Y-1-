package Arrays.Assignment_02.Level02.Arrays.Strings;

import java.util.Random;
import java.util.Scanner;

public class StudentScorecard {
    public static double[][] generateScores(int n) {
        Random rand = new Random();
        double[][] scores = new double[n][3];
        for (int i = 0; i < n; i++) {
            scores[i][0] = rand.nextInt(90) + 10; // Physics
            scores[i][1] = rand.nextInt(90) + 10; // Chemistry
            scores[i][2] = rand.nextInt(90) + 10; // Maths
        }
        return scores;
    }

    public static double[][] calculateMetrics(double[][] scores) {
        int n = scores.length;
        double[][] metrics = new double[n][3]; // [][0] = Total, [][1] = Average, [][2] = Percentage
        for (int i = 0; i < n; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percentage = avg;

            metrics[i][0] = Math.round(total * 100.0) / 100.0;
            metrics[i][1] = Math.round(avg * 100.0) / 100.0;
            metrics[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return metrics;
    }

    public static String[] calculateGrades(double[][] metrics) {
        int n = metrics.length;
        String[] grades = new String[n];
        for (int i = 0; i < n; i++) {
            double p = metrics[i][2];
            if (p >= 90) grades[i] = "A+";
            else if (p >= 80) grades[i] = "A";
            else if (p >= 70) grades[i] = "B";
            else if (p >= 60) grades[i] = "C";
            else if (p >= 50) grades[i] = "D";
            else grades[i] = "F";
        }
        return grades;
    }

    public static void displayScorecard(double[][] scores, double[][] metrics, String[] grades) {
        System.out.println("\nStudent\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        System.out.println("------------------------------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t" +
                    scores[i][2] + "\t" + metrics[i][0] + "\t" + metrics[i][1] + "\t" +
                    metrics[i][2] + "%\t" + grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        double[][] scores = generateScores(n);
        double[][] metrics = calculateMetrics(scores);
        String[] grades = calculateGrades(metrics);

        displayScorecard(scores, metrics, grades);
        scanner.close();
    }
}