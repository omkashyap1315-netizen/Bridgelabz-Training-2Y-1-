package Arrays.Leetcode.Arrays;

public class LeetCode_204 {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] isPrime = new boolean[n];
        java.util.Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (boolean b : isPrime) {
            if (b) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode_204 solver = new LeetCode_204();
        int n = 10;
        System.out.println(solver.countPrimes(n)); // Output: 4
    }
}