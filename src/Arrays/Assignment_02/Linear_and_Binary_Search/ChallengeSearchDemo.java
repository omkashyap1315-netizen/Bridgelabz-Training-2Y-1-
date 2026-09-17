package Arrays.Assignment_02.Linear_and_Binary_Search;

import java.util.Arrays;

public class ChallengeSearchDemo {
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static int binarySearchIndex(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int missing = findFirstMissingPositive(arr);
        System.out.println("First missing positive: " + missing);

        int[] sortedSearchArr = {1, 2, 4, 6, 8, 10};
        int index = binarySearchIndex(sortedSearchArr, 6);
        System.out.println("Target index via Binary Search: " + index);
    }
}