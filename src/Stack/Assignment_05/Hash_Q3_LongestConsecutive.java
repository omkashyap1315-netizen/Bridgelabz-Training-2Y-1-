package Stack.Assignment_05;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Hash_Q3_LongestConsecutive {

    static int longestConsecutive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);

        int longest = 0;
        for (int x : set) {
            // start counting only from the beginning of a sequence
            if (!set.contains(x - 1)) {
                int current = x;
                int length = 1;
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Longest consecutive sequence length: " + longestConsecutive(arr)); // 4
    }
}
