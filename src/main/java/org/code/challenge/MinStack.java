package org.code.challenge;

import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */
    Stack<StackPair> stack = null;

    public MinStack() {
        stack = new Stack<>();

    }

    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(new StackPair(x, x));
        }else{
            stack.push(new StackPair(x, Math.min(x, stack.peek().minElement)));
        }

    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().minElement;
    }
}

class StackPair{
    int val;
    int minElement;

    public StackPair(int val, int minElement){
        this.val =val;
        this.minElement = minElement;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */