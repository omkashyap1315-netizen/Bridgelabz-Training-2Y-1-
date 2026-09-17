package Arrays.Assignment_02.Linear_and_Binary_Search;

public class LinearSearchNegative {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 3, -2, 9, -4};
        int index = findFirstNegative(arr);
        System.out.println("First negative number index: " + index);
    }
}
