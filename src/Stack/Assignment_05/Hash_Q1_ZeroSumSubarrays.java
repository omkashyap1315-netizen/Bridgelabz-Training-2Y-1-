package Stack.Assignment_05;

import java.util.*;

public class Hash_Q1_ZeroSumSubarrays {

    static List<int[]> zeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        // cumulative sum -> list of indices where this sum occurred
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(List.of(-1))); // handles subarrays starting at index 0

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(new int[]{start + 1, i});
                }
            }
            map.computeIfAbsent(sum, x -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        System.out.println("Array: " + Arrays.toString(arr));

        List<int[]> res = zeroSumSubarrays(arr);
        if (res.isEmpty()) {
            System.out.println("No zero-sum subarray found");
        }
        for (int[] r : res) {
            System.out.println("Index " + r[0] + " to " + r[1] + " -> "
                    + Arrays.toString(Arrays.copyOfRange(arr, r[0], r[1] + 1)));
        }
    }
}

