package others;

/**
 * @author Nowshad Hasan
 * @since 31/1/22 10:55 pm
 */
//https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
public class MakingAnagrams {
    public static int makeAnagram(String a, String b) {
        // Write your code here
        int[] arr = new int[26];
        int anagramLen = 0;

        for (char ch : a.toCharArray()) {
            int index = ch - 'a';
            arr[index]++;
        }

        for (char ch : b.toCharArray()) {
            int index = ch - 'a';
            if (arr[index] > 0) {
                arr[index]--;
                anagramLen += 2;
            }
        }
        int result = a.length() + b.length() - anagramLen;
        return result;
    }
}
