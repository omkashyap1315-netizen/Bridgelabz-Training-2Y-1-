package Arrays.Assignment_02.Linear_and_Binary_Search;

public class ChallengeChallengeComparison {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String sampleText = "hello";

        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(sampleText);
        }
        long timeBuilder = System.nanoTime() - startBuilder;

        long startBuffer = System.nanoTime();
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sBuffer.append(sampleText);
        }
        long timeBuffer = System.nanoTime() - startBuffer;

        System.out.println("StringBuilder Time: " + timeBuilder + " ns");
        System.out.println("StringBuffer Time: " + timeBuffer + " ns");
    }
}
