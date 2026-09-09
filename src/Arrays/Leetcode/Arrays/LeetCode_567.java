package Arrays.Leetcode.Arrays;

public class LeetCode_567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        if (java.util.Arrays.equals(s1Count, s2Count)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            s2Count[s2.charAt(i) - 'a']++;
            s2Count[s2.charAt(i - s1.length()) - 'a']--;

            if (java.util.Arrays.equals(s1Count, s2Count)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode_567 solver = new LeetCode_567();
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(solver.checkInclusion(s1, s2)); // Output: true
    }
}
