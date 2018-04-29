/**
 * leetcode题目：https://leetcode-cn.com/problems/valid-parentheses/description/
 * 方法二：使用自定义的ArrayStack实现
 */

class ValidParentheses {
    public boolean isValid(String s) {

        ArrayStack<Character> stack = new ArrayStack<>();
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

        System.out.println((new ValidParentheses()).isValid("()"));
        System.out.println((new ValidParentheses()).isValid("()[]{}"));
        System.out.println((new ValidParentheses()).isValid("(]"));
        System.out.println((new ValidParentheses()).isValid("([)]"));
        System.out.println((new ValidParentheses()).isValid("{[]}"));
    }
}