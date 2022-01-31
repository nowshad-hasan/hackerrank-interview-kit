package others;

import java.util.List;

/**
 * @author Nowshad Hasan
 * @since 31/1/22 10:39 pm
 */
//https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
public class BubbleSort {
    public static void main(String[] args) {

    }

    public static void countSwaps(List<Integer> a) {
        // Write your code here
        int len = a.size();
        int[] arr = new int[len];
        for (int i = 0; i < len; ++i) {
            arr[i] = a.get(i);
        }

        int minSwap = 0;
        for (int i = 0; i < len; ++i) {
            boolean isSwaped = false;
            for (int j = 0; j < (len - i - 1); ++j) {
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    isSwaped = true;
                    minSwap += 1;
                }
            }
            if (!isSwaped) break;
        }
        System.out.println("Array is sorted in " + minSwap + " swaps.");
        System.out.println("First Element: " + arr[0]);
        System.out.println("Last Element: " + arr[len - 1]);

    }
}
