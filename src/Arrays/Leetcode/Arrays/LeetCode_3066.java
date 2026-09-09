package Arrays.Leetcode.Arrays;

import java.util.PriorityQueue;

public class LeetCode_3066 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer((long) num);
        }
        int operations = 0;
        while (pq.peek() < k) {
            if (pq.size() < 2) break;
            long x = pq.poll();
            long y = pq.poll();
            long newVal = Math.min(x, y) * 2 + Math.max(x, y);
            pq.offer(newVal);
            operations++;
        }
        return operations;
    }

    public static void main(String[] args) {
        LeetCode_3066 solver = new LeetCode_3066();
        int[] nums = {2, 11, 10, 1, 3};
        int k = 10;
        System.out.println(solver.minOperations(nums, k)); // Output: 2
    }
}
