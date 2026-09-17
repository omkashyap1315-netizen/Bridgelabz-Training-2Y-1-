package Arrays.Leetcode.Arrays;

import java.util.*;

public class LeetCode_2030 {

    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int n = s.length();
        int totalLetter = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) totalLetter++;
        }

        Deque<Character> stack = new ArrayDeque<>();
        int remainLetter = totalLetter;
        int usedLetter = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            while (!stack.isEmpty() && stack.peek() > c
                    && stack.size() + (n - i) > k
                    && (stack.peek() != letter || usedLetter - 1 + remainLetter >= repetition)) {
                char removed = stack.pop();
                if (removed == letter) usedLetter--;
            }

            if (stack.size() < k) {
                if (c == letter) {
                    stack.push(c);
                    usedLetter++;
                } else if (k - stack.size() > repetition - usedLetter) {
                    stack.push(c);
                }
            }

            if (c == letter) remainLetter--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        char letter = sc.next().charAt(0);
        int repetition = sc.nextInt();
        LeetCode_2030 sol = new LeetCode_2030();
        System.out.println(sol.smallestSubsequence(s, k, letter, repetition));
    }
}
