package Arrays.Leetcode.Arrays;


import java.util.*;

public class LeetCode_904 {

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < fruits.length; right++) {
            count.merge(fruits[right], 1, Integer::sum);
            while (count.size() > 2) {
                count.merge(fruits[left], -1, Integer::sum);
                if (count.get(fruits[left]) == 0) {
                    count.remove(fruits[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fruits = new int[n];
        for (int i = 0; i < n; i++) {
            fruits[i] = sc.nextInt();
        }
        LeetCode_904 sol = new LeetCode_904();
        System.out.println(sol.totalFruit(fruits));
    }
}
