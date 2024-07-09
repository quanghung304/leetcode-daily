package org.example.Roadmap.stack;
//acceptd. beats 95%
public class MinStack {
    //Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    //Implement the MinStack class:
    //MinStack() initializes the stack object.
    //void push(int val) pushes the element val onto the stack.
    //void pop() removes the element on the top of the stack.
    //int top() gets the top element of the stack.
    //int getMin() retrieves the minimum element in the stack.
    //You must implement a solution with O(1) time complexity for each function.
    private int[] stackArray;
    private int[] minValue;
    private int top;
    private int min;

    public MinStack() {
        stackArray = new int[30000];
        minValue = new int[30000];
        top = -1;
    }

    public void push(int val) {
        if (top < 0) {
            min = val;
        } else {
            min = Math.min(val, getMin());
        }

        stackArray[++top] = val;
        minValue[top] = min;
    }

    public void pop() {
        if (top < 0) {
            return;
        }

        top--;
    }

    public int top() {
        return stackArray[top];
    }

    public int getMin() {
        return minValue[top];
    }

    public static void main(String[] args) {
        String[] action = {"push","push","push","top","getMin","pop","top","push","push","getMin","push","pop","top","getMin","pop"};
        Integer[] value = {-10,14,-20,null,null,null,null,10,-7,null,-7,null,null,null,null};

        MinStack stack = new MinStack();

        for (int i=0; i<action.length; i++) {
            switch (action[i]) {
                case "push":
                    stack.push(value[i]);
                    break;
                case "getMin":
                    System.out.println("min: " + stack.getMin());
                    break;
                case "top":
                    System.out.println("top: " + stack.top());
                    break;
                case "pop":
                    stack.pop();
                    break;
                default:
                    continue;
            }
        }
    }
}
