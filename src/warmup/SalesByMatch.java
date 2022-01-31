package warmup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Nowshad Hasan
 * @since 31/1/22 10:13 am
 */
public class SalesByMatch {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20};
        List<Integer> list = new ArrayList<>();
        for (int n : arr)
            list.add(n);
        System.out.println(sockMerchant(9, list));
    }

    public static int sockMerchant(int n, List<Integer> list) {
        Set<Integer> map = new HashSet<>();
        int counter = 0;

        for (int item : list) {
            if (map.contains(item)) {
                map.remove(item);
                counter += 1;
            } else map.add(item);
        }

        return counter;
    }
}
