package Arrays.Leetcode.Arrays;

public class LeetCode_1876 {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);
            if (a != b && b != c && a != c) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode_1876 solver = new LeetCode_1876();
        String s = "xyzzaz";
        System.out.println(solver.countGoodSubstrings(s)); // Output: 1
    }
}
