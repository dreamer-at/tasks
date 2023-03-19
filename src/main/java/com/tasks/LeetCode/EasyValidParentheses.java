package com.tasks.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class EasyValidParentheses {

    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string
    // is valid.
    // An input string is valid if:
    // Open brackets must be closed by the same type of brackets.
    // Open brackets must be closed in the correct order.
    // Every close bracket has a corresponding open bracket of the same type.

    public static void main(String[] args) {


        String s = "()"; // Output: true
        String s1 = "()[){}"; // Output: false
        String s3 = "(]"; // Output: false
        String s4 = "()[]{}"; // Output: true
        String s5 = "{[]}"; // Output: true

        System.out.println(isValid(s));
        System.out.println(isValid(s1));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
    }

    // We put second part of '(' on top, then if second char ')' not equal to {,[ that means our '(' has a second char
    // we use method of exclusion
    // Без СТЕКА мы никак не отследим 2й символ если он имеется конечно
    // Complexity analysis

    //Time complexity : O(n)O(n)O(n) because we simply traverse the given string one character at a time and push and
    // pop operations on a stack take O(1)O(1)O(1) time.
    //Space complexity : O(n)O(n)O(n) as we push all opening brackets onto the stack and in the worst case, we will
    // end up pushing all the brackets onto the stack. e.g. ((((((((((.
  public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) // check second char with current closed brackets
                // 1) if our char not equal to remaining types, and if stack empty or char in stack not equal
                // to current char we don't have second closed char
                return false;
        }
        return stack.isEmpty();
    }

    /*private static boolean isValid(String s) {
        // Hash table that takes care of the mappings.
        // Initialize hash map with mappings. This simply makes the code easier to read.
        HashMap<Character, Character> mappings;
        mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
*/
  /*  private static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();
        stack.push()

        if (s.isEmpty() || s.length() == 1) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                map.get(s.charAt(i));
            }
        }
        return true;
    }*/

}
