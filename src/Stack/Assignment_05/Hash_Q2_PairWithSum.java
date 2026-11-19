package Stack.Assignment_05;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Hash_Q2_PairWithSum {

    static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1, 7};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Pair with sum 9 exists?   " + hasPairWithSum(arr, 9));   // true (2 + 7)
        System.out.println("Pair with sum 100 exists? " + hasPairWithSum(arr, 100)); // false
    }
}

