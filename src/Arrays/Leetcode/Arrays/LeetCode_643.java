package Arrays.Leetcode.Arrays;

public class LeetCode_643 {
    public double findMaxAverage(int[] nums, int k) {
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        double maxSum = currentSum;
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum / k;
    }

    public static void main(String[] args) {
        LeetCode_643 solver = new LeetCode_643();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(solver.findMaxAverage(nums, k)); // Output: 12.75
    }
}
