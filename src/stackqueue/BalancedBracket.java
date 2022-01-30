package stackqueue;

import java.util.Stack;

/**
 * @author Nowshad Hasan
 * @since 30/1/22 10:59 pm
 */
public class BalancedBracket {
    static String leftBrackets = "({[";
    static String rightBrackets = ")}]";

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[[(())]]}}"));
    }

    public static String isBalanced(String s) {
        if (s == null)
            throw new IllegalStateException();
        // Write your code here
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (leftBrackets.indexOf(ch) != -1) {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return "NO";
                char lastChar = stack.peek();
                if (!isBracketMatched(lastChar, ch))
                    return "NO";
                else stack.pop();
            }
        }

        if (stack.isEmpty()) return "YES";
        else return "NO";
    }

    public static boolean isBracketMatched(char first, char second) {
        return leftBrackets.indexOf(first) == rightBrackets.indexOf(second);
    }
}
