package Stack.Assignment_05;

import java.util.Stack;

public class Stack_Q2_SortStack {

    static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        sortStack(stack);          // sort the remaining stack
        insertSorted(stack, top);  // insert popped element at correct position
    }

    static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        int top = stack.pop();
        insertSorted(stack, element);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        System.out.println("Before sorting: " + stack);
        sortStack(stack);
        System.out.println("After sorting (bottom -> top): " + stack);
    }
}

