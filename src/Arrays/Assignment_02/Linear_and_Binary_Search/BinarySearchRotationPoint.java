package Arrays.Assignment_02.Linear_and_Binary_Search;

public class BinarySearchRotationPoint {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "Programming in python is fun",
                "Learning Java data structures",
                "Algorithms are essential"
        };
        String targetWord = "Java";
        String result = findSentenceWithWord(sentences, targetWord);
        System.out.println("Result: " + result);
    }
}
