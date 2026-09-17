package Arrays.Assignment_02.Level01.Strings;

public class NullPointerExceptionDemo {
    public static void generateException() {
        String text = null;
        System.out.println(text.length());
    }

    public static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Calling method to generate exception:");
        try {
            generateException();
        } catch (Exception e) {
            System.out.println("Program caught exception from generateException(): " + e);
        }

        System.out.println("\nCalling method to handle exception safely:");
        handleException();
    }
}