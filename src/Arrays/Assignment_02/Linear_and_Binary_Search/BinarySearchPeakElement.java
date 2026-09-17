package Arrays.Assignment_02.Linear_and_Binary_Search;

public class BinarySearchPeakElement {
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[left];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int peak = findPeakElement(arr);
        System.out.println("Peak element: " + peak);
    }
}