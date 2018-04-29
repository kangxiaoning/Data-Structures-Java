/**
 * leetcode题目：https://leetcode-cn.com/problems/valid-parentheses/description/
 * 方法一：使用java自带的Stack实现
 */

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        // https://leetcode-cn.com/problems/valid-parentheses/description/
        // 示例

        System.out.println((new Solution()).isValid("()"));
        System.out.println((new Solution()).isValid("()[]{}"));
        System.out.println((new Solution()).isValid("(]"));
        System.out.println((new Solution()).isValid("([)]"));
        System.out.println((new Solution()).isValid("{[]}"));
    }
}


