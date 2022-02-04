package search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Nowshad Hasan
 * @since 4/2/22 12:26 pm
 */
public class IceCreamParlor {
    // 1,3,4,2,8 =>12
// 1,3 => 4
// O(nlogn)
    public static void whatFlavors(List<Integer> costList, int money) {
        // Write your code here
        // O(n)
        Set<Integer> itemSet = new HashSet<>(costList);

        for (int i = 0; i < costList.size() - 1; ++i) {
            int item = costList.get(i);
            int toFind = money - item;
            // int toFindIndex = findItem(costList,i+1, toFind);
            int toFindIndex = findItemWithHashSet(costList, i + 1, toFind, itemSet);
            // System.out.println(toFind+". "+toFindIndex);
            if (toFindIndex != -1) {
                System.out.println((i + 1) + " " + (toFindIndex + 1));
                break;
            }
        }

        // Set<Integer> itemSet = new HashSet<>(costList);
        // for()
    }

    private static int findItemWithHashSet(List<Integer> costList, int startIndex, int target, Set<Integer> itemSet) {
        if (itemSet.contains(target)) {
            for (int i = startIndex; i < costList.size(); ++i) {
                if (costList.get(i) == target) return i;
            }
        }
        return -1;
    }

    // O(logn)
    // 1,3,4,5
    // (1,)4,5,3,2 => 3 ...1,4 (2), 3,4
    private static int findItem(List<Integer> costList, int startIndex, int target) {

        int left = startIndex;
        int right = costList.size() - 1;
        boolean isFound = false;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            System.out.println("mid " + mid + ".  " + costList.get(mid));
            if (costList.get(mid) == target) {
                System.out.println("found " + mid);
                isFound = true;
                break;
            } else if (costList.get(mid) > target) {
                right = mid - 1;
            } else if (costList.get(mid) < target) {
                left = mid + 1;
            }
        }
        if (isFound) return mid;
        return -1;
    }

}
