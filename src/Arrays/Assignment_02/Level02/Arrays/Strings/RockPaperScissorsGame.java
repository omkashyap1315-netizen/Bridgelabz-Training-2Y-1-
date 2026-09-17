package Arrays.Assignment_02.Level02.Arrays.Strings;

import java.util.Scanner;

public class RockPaperScissorsGame {
    public static String getComputerChoice() {
        double rand = Math.random();
        if (rand < 0.34) {
            return "rock";
        } else if (rand < 0.67) {
            return "paper";
        } else {
            return "scissors";
        }
    }

    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "Tie";
        }
        if ((user.equals("rock") && computer.equals("scissors")) ||
                (user.equals("paper") && computer.equals("rock")) ||
                (user.equals("scissors") && computer.equals("paper"))) {
            return "User";
        }
        return "Computer";
    }

    public static String[][] computeStats(int userWins, int compWins, int ties, int totalGames) {
        String[][] stats = new String[2][2];
        double userPercentage = (double) userWins / totalGames * 100;
        double compPercentage = (double) compWins / totalGames * 100;

        stats[0][0] = String.valueOf(userWins);
        stats[0][1] = String.format("%.2f%%", userPercentage);
        stats[1][0] = String.valueOf(compWins);
        stats[1][1] = String.format("%.2f%%", compPercentage);
        return stats;
    }

    public static void displayStats(int userWins, int compWins, int ties, int totalGames) {
        String[][] stats = computeStats(userWins, compWins, ties, totalGames);
        System.out.println("\n--- Game Stats ---");
        System.out.println("Player Wins: " + stats[0][0] + " (" + stats[0][1] + ")");
        System.out.println("Computer Wins: " + stats[1][0] + " (" + stats[1][1] + ")");
        System.out.println("Ties: " + ties);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of games to play: ");
        int totalGames = scanner.nextInt();

        int userWins = 0;
        int compWins = 0;
        int ties = 0;

        for (int i = 1; i <= totalGames; i++) {
            System.out.print("Game " + i + " - Enter choice (rock, paper, scissors): ");
            String userChoice = scanner.next().toLowerCase();
            String compChoice = getComputerChoice();
            System.out.println("Computer chose: " + compChoice);

            String winner = findWinner(userChoice, compChoice);
            if (winner.equals("User")) {
                userWins++;
                System.out.println("Result: You win this round!");
            } else if (winner.equals("Computer")) {
                compWins++;
                System.out.println("Result: Computer wins this round!");
            } else {
                ties++;
                System.out.println("Result: It's a tie!");
            }
        }

        displayStats(userWins, compWins, ties, totalGames);
        scanner.close();
    }
}