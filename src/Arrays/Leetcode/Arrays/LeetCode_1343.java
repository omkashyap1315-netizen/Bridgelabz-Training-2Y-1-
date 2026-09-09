package Arrays.Leetcode.Arrays;

public class LeetCode_1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int currentSum = 0;
        int targetSum = k * threshold;
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        if (currentSum >= targetSum) count++;
        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - k];
            if (currentSum >= targetSum) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode_1343 solver = new LeetCode_1343();
        int[] arr = {2, 2, 2, 2, 5, 5, 2, 2, 6};
        int k = 3, threshold = 4;
        System.out.println(solver.numOfSubarrays(arr, k, threshold)); // Output: 3
    }
}
