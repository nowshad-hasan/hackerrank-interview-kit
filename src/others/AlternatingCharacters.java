package others;

/**
 * @author Nowshad Hasan
 * @since 31/1/22 11:11 pm
 */
//https://www.hackerrank.com/challenges/alternating-characters/problem
public class AlternatingCharacters {
    public static int alternatingCharacters(String s) {
        // Write your code here
        int deletionCounter = 0;
        char checker = s.charAt(0);
        for (int i = 1; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (checker == ch) {
                deletionCounter++;
            } else {
                checker = ch;
            }
        }
        return deletionCounter;
    }
}
