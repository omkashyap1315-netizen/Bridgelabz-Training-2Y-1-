package Arrays.Assignment_02.Linear_and_Binary_Search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleToFileWriter {
    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter("user_output.txt"))) {

            System.out.println("Enter lines to write to file (type 'exit' to stop):");
            String line;
            while (true) {
                line = consoleReader.readLine();
                if (line == null || line.equalsIgnoreCase("exit")) {
                    break;
                }
                fileWriter.write(line);
                fileWriter.newLine();
            }
            System.out.println("Input successfully written to file.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }
}
