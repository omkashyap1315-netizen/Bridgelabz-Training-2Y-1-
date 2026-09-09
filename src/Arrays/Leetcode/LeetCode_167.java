package Arrays.Leetcode;

import java.util.*;

public class LeetCode_167 {
    public static int[] twoSumII(int[] nums, int target) {

    int start = 0;
    int end = nums.length - 1;

    while(start>end)

    {
        int sum = nums[start] + nums[end];
        if (sum == target) {
            return new int[]{start + 1, end + 1};
        } else if (sum > target) {
            end--;
        } else {
            start++;
        }
    }
    return new int[]{1,2};
    }

    static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] arr = twoSumII(nums,target);
        System.out.println(Arrays.toString(arr));
    }
}
