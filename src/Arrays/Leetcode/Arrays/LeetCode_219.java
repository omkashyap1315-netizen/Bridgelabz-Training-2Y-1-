package Arrays.Leetcode.Arrays;

import java.util.HashMap;

public class LeetCode_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode_219 solver = new LeetCode_219();
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(solver.containsNearbyDuplicate(nums, k)); // Output: true
    }
}
