package Stack.Assignment_05;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Stack_Q4_SlidingWindowMax {

    static int[] slidingWindowMax(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // indices, values in decreasing order

        for (int i = 0; i < n; i++) {
            // remove index that is out of the window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            // remove smaller elements, they can never be the maximum
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            dq.addLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = arr[dq.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println("Array: " + Arrays.toString(arr) + ", k = " + k);
        System.out.println("Max of each window: " + Arrays.toString(slidingWindowMax(arr, k)));
        // Expected: [3, 3, 5, 5, 6, 7]
    }
}
