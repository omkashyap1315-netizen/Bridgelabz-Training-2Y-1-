package Arrays.Leetcode.Arrays;

import java.util.*;

public class LeetCode_442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) {
                res.add(idx + 1);
            } else {
                nums[idx] = -nums[idx];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        LeetCode_442 sol = new LeetCode_442();
        System.out.println(sol.findDuplicates(nums));
    }
}
