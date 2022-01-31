package warmup;

import java.util.Stack;

/**
 * @author Nowshad Hasan
 * @since 31/1/22 10:47 am
 */
public class CountingValleys {
    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUUDU"));
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        Stack<Character> mountainStack = new Stack<>();
        Stack<Character> valleyStack = new Stack<>();
        int count = 0;
        boolean isGoingMountain = false;
        boolean isGoiningValley = false;
        for (char ch : path.toCharArray()) {

            if (mountainStack.isEmpty() && valleyStack.isEmpty()) {
                // sea level
                if (ch == 'D') {
                    count += 1;
                    isGoiningValley = true;
                    isGoingMountain = false;
                } else {
                    isGoingMountain = true;
                    isGoiningValley = false;
                }
            }
            if (isGoiningValley) {
                if (ch == 'D') valleyStack.push(ch);
                else valleyStack.pop();
            } else if (isGoingMountain) {
                if (ch == 'U') mountainStack.push(ch);
                else mountainStack.pop();
            }
        }
        return count;
    }
}
