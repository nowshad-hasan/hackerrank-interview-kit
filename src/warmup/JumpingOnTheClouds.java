package warmup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nowshad Hasan
 * @since 31/1/22 9:55 am
 */
public class JumpingOnTheClouds {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 0, 0, 1, 0};
        List<Integer> list = new ArrayList<>();
        for (int n : arr)
            list.add(n);

        System.out.println(jumpingOnClouds(list));
    }

    public static int jumpingOnClouds(List<Integer> n) {
        // Write your code here
        int length = n.size();
        int position = 0;
        int jump = 0;

        while (position < length) {
            int firstPosition = position + 1;
            int secondPosition = position + 2;
            if (secondPosition < length && n.get(secondPosition) == 0) {
                position = secondPosition;
                jump += 1;
            } else if (firstPosition < length && n.get(firstPosition) == 0) {
                position = firstPosition;
                jump += 1;
            } else position += 1;
        }

        return jump;
    }
}
