/**
 * LC 155
 */


import java.util.*;


public class MinStack2 {

    /**
     * Key: use only one stack
     * The key point for this method is to put the old min in the stack
     * if the old min is replaced by the new one
    **/
    /** initialize your data structure here. */

    private Stack<Integer> stack;
    private int min;
    public MinStack2() {
        stack =  new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);

    }

    public void pop() {
        if (stack.pop() == min) min = stack.pop(); // the second stack.pop() is the old min

    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return min;

    }

}
