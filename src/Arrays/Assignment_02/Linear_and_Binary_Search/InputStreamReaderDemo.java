package Arrays.Assignment_02.Linear_and_Binary_Search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputStreamReaderDemo {
    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return count;
    }

    public static void main(String[] args) {
        String filePath = "sample.txt";
        String targetWord = "java";
        int count = countWordOccurrences(filePath, targetWord);
        System.out.println("The word '" + targetWord + "' appeared " + count + " times.");
    }
}