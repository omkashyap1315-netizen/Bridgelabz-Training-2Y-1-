package Arrays.Assignment_01;

public class BinarySearchDemo {
    public static int binarySearch(int[] arr, int target) {
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
        int[] sortedArr = {0, 2, 3, 4, 8, 61};
        int target = 4;

        int result = binarySearch(sortedArr, target);
        System.out.println("Target " + target + " found at index: " + result);
    }
}
