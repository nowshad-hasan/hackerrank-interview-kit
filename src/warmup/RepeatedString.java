package warmup;

/**
 * @author Nowshad Hasan
 * @since 31/1/22 9:26 am
 */
public class RepeatedString {
    public static void main(String[] args) {
        System.out.println(repeatedString("a",1000000));
    }

    public static long repeatedString(String s, long n) {
        // Write your code here
        long strLen = s.length();
        long repeatNess = n / strLen;
        long extra = n % strLen;

        long aOccurrence = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'a') aOccurrence += 1;
        }
        long result = repeatNess * aOccurrence;
        for (int i = 0; i < extra; ++i) {
            if (s.charAt(i) == 'a') result += 1;
        }

        return result;
    }
}
