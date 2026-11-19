package Stack.Assignment_05;

import java.util.Arrays;
import java.util.Stack;

public class Stack_Q3_StockSpan {

    static int[] stockSpan(int[] price) {
        int n = price.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Span  : " + Arrays.toString(stockSpan(prices)));
        // Expected: [1, 1, 1, 2, 1, 4, 6]
    }
}

