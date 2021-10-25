/**
 * 20. Valid Parentheses
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and 
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * - Open brackets must be closed by the same type of brackets.
 * - Open brackets must be closed in the correct order.
 */

class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        // go through all brackets in string, one-by-one
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // if open bracket, add to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // if closing bracket, see if previous bracket matches
            else {
                if (c == ')') {
                    if (stack.size() > 0 && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (c == '}') {
                    if (stack.size() > 0 && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (c == ']') {
                    if (stack.size() > 0 && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        
        // check if all brackets closed by end of string
        return stack.size() == 0;
    }
}

/**
 * Notes:
 * 
 * ArrayDeque = convenient data structure for stack problems.
 * 
 * Could have improved readability with HashMap from open to closed brackets.
 */