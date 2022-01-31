package warmup;

import java.util.Stack;

/**
 * @author Nowshad Hasan
 * @since 31/1/22 10:47 am
 */
public class CountingValleys {
    public static void main(String[] args) {
        System.out.println(countingValleysWithStack(8, "UDDDUDUUDU"));
        System.out.println(countingValleysWithoutStack(8, "UDDDUDUUDU"));
    }

    public static int countingValleysWithStack(int steps, String path) {
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

    public static int countingValleysWithoutStack(int steps, String path) {
        // Write your code here
        int valleyCounter = 0;
        int upCounter = 0;
        int downCounter = 0;
        boolean isGoingMountain = false;
        boolean isGoingValley = false;

        for (char ch : path.toCharArray()) {
            if (upCounter == 0 && downCounter == 0) {
                // sea level
                if (ch == 'D') {
                    valleyCounter += 1;
                    isGoingValley = true;
                    isGoingMountain = false;
                } else {
                    isGoingValley = false;
                    isGoingMountain = true;
                }
            }

            if (isGoingValley) {
                if (ch == 'D') {
                    downCounter += 1;
                } else {
                    downCounter -= 1;
                }
            }

            if (isGoingMountain) {
                if (ch == 'U') {
                    upCounter += 1;
                } else {
                    upCounter -= 1;
                }
            }
        }
        return valleyCounter;
    }

}
