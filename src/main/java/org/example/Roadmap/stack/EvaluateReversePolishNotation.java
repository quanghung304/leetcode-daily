package org.example.Roadmap.stack;

import java.util.Stack;
//accepted. beats 70%
public class EvaluateReversePolishNotation {
    //You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
    //Evaluate the expression. Return an integer that represents the value of the expression.
    //Example:
    //Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
    //Output: 22
    //Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
    //= ((10 * (6 / (12 * -11))) + 17) + 5
    //= ((10 * (6 / -132)) + 17) + 5
    //= ((10 * 0) + 17) + 5
    //= (0 + 17) + 5
    //= 17 + 5
    //= 22
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int first, second;

        for (String s: tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                switch (s) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        second = stack.pop();
                        first = stack.pop();
                        stack.push(first - second);
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        second = stack.pop();
                        first = stack.pop();
                        stack.push(first / second);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.pop();
    }
}
