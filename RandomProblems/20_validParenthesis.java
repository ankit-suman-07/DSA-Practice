/*
20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true
*/

// Method 1: (Without using Stack)
public boolean isValid(String s) {
        int open = -1;
        char[] chars = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                chars[++open] = c;
            } else {
                if (open == -1) {
                    return false;
                }
                char lastOpen = chars[open--];
                if ((c == ')' && lastOpen != '(') ||
                    (c == '}' && lastOpen != '{') ||
                    (c == ']' && lastOpen != '[')) {
                    return false;
                }
            }
        }
        return open == -1;
    }

// Method 2: (Using Stack)
public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } 
            else {
                return false;
            }
        }

        return stack.isEmpty();
    }
