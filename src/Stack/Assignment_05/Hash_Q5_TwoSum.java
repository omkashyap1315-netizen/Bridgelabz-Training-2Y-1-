package Stack.Assignment_05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hash_Q5_TwoSum {

    static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value -> index
        for (int i = 0; i < arr.length; i++) {
            int need = target - arr[i];
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1}; // not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Array: " + Arrays.toString(arr) + ", target = " + target);
        System.out.println("Indices: " + Arrays.toString(twoSum(arr, target))); // [0, 1]
    }
}

