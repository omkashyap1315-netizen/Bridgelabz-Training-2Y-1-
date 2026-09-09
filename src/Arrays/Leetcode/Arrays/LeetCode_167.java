package Arrays.Leetcode.Arrays;

public class LeetCode_167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{left + 1, right + 1};
            else if (sum < target) left++;
            else right--;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        LeetCode_167 solver = new LeetCode_167();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solver.twoSum(numbers, target);
        System.out.println(java.util.Arrays.toString(result)); // Output: [1, 2]
    }
}