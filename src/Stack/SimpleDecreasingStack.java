package Stack;

import java.util.*;
public class SimpleDecreasingStack {
    public static void main(String[] args) {
        int [] nums = {5, 3, 4, 2, 6};
        Stack<Integer> stack = new Stack<>();

        for(int num : nums){
            // Remove smaller numbers so the stack stays in decresing order
            while (!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
            }
            stack.push(num);
        }

        // Stack holds numbers from largest (bottom) to smallest (top)
        System.out.println("Decreasing Stack: " + stack); //Output:[6]
        System.out.println("Minimum element: " + stack.peek()); //Output: 6
    }
}
