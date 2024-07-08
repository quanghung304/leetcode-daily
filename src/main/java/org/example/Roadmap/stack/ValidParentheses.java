package org.example.Roadmap.stack;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    //Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    //
    //An input string is valid if:
    //
    //Open brackets must be closed by the same type of brackets.
    //Open brackets must be closed in the correct order.
    //Every close bracket has a corresponding open bracket of the same type.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s;
        while (true) {
            s = input.next();
            if (s.equals("out")) {
                break;
            }
            System.out.println(isValid(s));
        }
        input.close();
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        for (Character c: s.toCharArray()) {
            if (isClosedBracket(stack, c)) {
                stack.pop();
                continue;
            } else {
                stack.push(c);
            }
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isClosedBracket (Stack s, Character c) {
        if (s.empty()) {
            return false;
        }

        switch (c) {
            case ')':
                if (s.peek().equals('(')) return true;
                break;
            case ']':
                if (s.peek().equals('[')) return true;
                break;
            case '}':
                if (s.peek().equals('{')) return true;
                break;
            default:
                return false;
        }

        return false;
    }
}
