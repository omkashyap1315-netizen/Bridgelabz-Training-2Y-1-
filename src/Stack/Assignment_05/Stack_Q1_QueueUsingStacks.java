package Stack.Assignment_05;

import java.util.Stack;

public class Stack_Q1_QueueUsingStacks {

    static class MyQueue {
        private final Stack<Integer> in = new Stack<>();   // used for enqueue
        private final Stack<Integer> out = new Stack<>();  // used for dequeue

        void enqueue(int x) {
            in.push(x);
        }

        int dequeue() {
            shift();
            if (out.isEmpty()) throw new RuntimeException("Queue is empty");
            return out.pop();
        }

        int peek() {
            shift();
            if (out.isEmpty()) throw new RuntimeException("Queue is empty");
            return out.peek();
        }

        boolean isEmpty() {
            return in.isEmpty() && out.isEmpty();
        }

        // Transfer only when 'out' is empty -> amortized O(1)
        private void shift() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) out.push(in.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("Dequeue: " + q.dequeue()); // 10
        q.enqueue(40);
        System.out.println("Peek: " + q.peek());       // 20
        System.out.println("Dequeue: " + q.dequeue()); // 20
        System.out.println("Dequeue: " + q.dequeue()); // 30
        System.out.println("Dequeue: " + q.dequeue()); // 40
        System.out.println("Is empty? " + q.isEmpty()); // true
    }
}
