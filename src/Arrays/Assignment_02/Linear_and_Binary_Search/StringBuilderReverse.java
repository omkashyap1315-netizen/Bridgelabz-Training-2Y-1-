package Arrays.Assignment_02.Linear_and_Binary_Search;

public class StringBuilderReverse {
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        String reversed = reverseString(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }
}
