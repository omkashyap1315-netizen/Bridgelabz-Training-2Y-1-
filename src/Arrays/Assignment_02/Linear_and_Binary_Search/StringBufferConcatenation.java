package Arrays.Assignment_02.Linear_and_Binary_Search;

public class StringBufferConcatenation {
    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Java", " ", "is", " ", "powerful", "!"};
        String result = concatenateStrings(words);
        System.out.println("Concatenated String: " + result);
    }
}
