package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.addFirst(val);
        if (minStack.isEmpty() || val <= getMin()) {
            minStack.addFirst(val);
        }
    }

    public void pop() {
        int top = this.stack.removeFirst();
        if (top == getMin()) {
            minStack.removeFirst();
        }
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {
        return minStack.getFirst();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
//        obj.pop();
    }
}




/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */