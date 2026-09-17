package Arrays.Assignment_02.Linear_and_Binary_Search;

import java.util.Arrays;

public class BinarySearchFirstLastOccurrence {
    public static int[] searchRange(int[] arr, int target) {
        int[] result = {-1, -1};
        result[0] = findBound(arr, target, true);
        result[1] = findBound(arr, target, false);
        return result;
    }

    private static int findBound(int[] arr, int target, boolean isFirst) {
        int left = 0, right = arr.length - 1, bound = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                bound = mid;
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] range = searchRange(arr, target);
        System.out.println("First and Last occurrences: " + Arrays.toString(range));
    }
}
