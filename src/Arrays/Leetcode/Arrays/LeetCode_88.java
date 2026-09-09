package Arrays.Leetcode.Arrays;

import java.util.*;

public class LeetCode_88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter m (elements in nums1): ");
        int m = sc.nextInt();

        System.out.print("Enter n (elements in nums2): ");
        int n = sc.nextInt();

        int[] nums1 = new int[m + n];
        System.out.println("Enter " + m + " elements for nums1: ");
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }

        int[] nums2 = new int[n];
        System.out.println("Enter " + n + " elements for nums2: ");
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }

        merge(nums1, m, nums2, n);

        for (int i = 0; i < m + n; i++) {
            System.out.print(nums1[i] + " ");
        }
    }
}
