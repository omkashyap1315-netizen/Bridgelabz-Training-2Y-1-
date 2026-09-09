package Arrays.Leetcode.Arrays;

import java.util.HashSet;

public class LeetCode_2716 {
    public int minimizedStringLength(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }

    public static void main(String[] args) {
        LeetCode_2716 solver = new LeetCode_2716();
        String s = "aaabc";
        System.out.println(solver.minimizedStringLength(s)); // Output: 3
    }
}
