package Arrays.Assignment_02.Linear_and_Binary_Search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderLineReader {
    public static void readFileLineByLine(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "sample.txt";
        readFileLineByLine(filePath);
    }
}