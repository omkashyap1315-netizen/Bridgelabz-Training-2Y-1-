package Arrays.Assignment_02.Linear_and_Binary_Search;

public class StringBufferVsBuilderComparison {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";

        long startBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        long startBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        System.out.println("Time taken by StringBuffer: " + timeBuffer + " ns (" + (timeBuffer / 1_000_000) + " ms)");
        System.out.println("Time taken by StringBuilder: " + timeBuilder + " ns (" + (timeBuilder / 1_000_000) + " ms)");
    }
}
