package Arrays.Leetcode.Arrays;

public class LeetCode_1299 {
    public int[] replaceElements(int[] arr) {
        int maxFromRight = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = maxFromRight;
            maxFromRight = Math.max(maxFromRight, temp);
        }
        return arr;
    }

    public static void main(String[] args) {
        LeetCode_1299 solver = new LeetCode_1299();
        int[] arr = {17, 18, 5, 4, 6, 1};
        solver.replaceElements(arr);
        System.out.println(java.util.Arrays.toString(arr)); // Output: [18, 6, 6, 6, 1, -1]
    }
}
