package Arrays.Leetcode;

public class LeetCode_643 {

    static class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            int maxSum = sum;

            for (int i = 1; i <= nums.length - k; i++) {
                sum = sum - nums[i - 1] + nums[i + k - 1];
                maxSum = Math.max(sum, maxSum);
            }

            return (double) maxSum / k;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int k1 = 4;
        System.out.println("Test 1: " + sol.findMaxAverage(nums1, k1));

        int[] nums2 = {5};
        int k2 = 1;
        System.out.println("Test 2: " + sol.findMaxAverage(nums2, k2));
    }
}
