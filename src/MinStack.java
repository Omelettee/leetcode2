/**
 * LC 155 easy stack
 *
 *  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *     push(x) -- Push element x onto stack.
 *     pop() -- Removes the element on top of the stack.
 *     top() -- Get the top element.
 *     getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */

import java.util.*;
public class MinStack {

    //The first method is to implement with 2 stacks
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();

    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()){
            int min = minStack.peek();
            if (x <= min) minStack.push(x); // must be <= not <
        } else {
            minStack.push(x);
        }

    }

    public void pop() {
        int x = stack.pop();
        if (!minStack.isEmpty()){
          if (x == minStack.peek()) {
              minStack.pop();
          }
        }

    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minStack.peek();

    }
}
