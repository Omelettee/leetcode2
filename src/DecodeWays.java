/**
 * LC 91 String dynamic programming
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */


public class DecodeWays {

    // pay attention, could see many times
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        // implement with dynamic programming
        char[] chars = s.toCharArray();


        int prev = Character.getNumericValue(chars[0]);
        int r1 = 1, r2 = 1;
        for (int i = 1; i < chars.length; i++){
            int cur = Character.getNumericValue(chars[i]);
            int temp = 10 * prev + cur;
            prev = cur;

            if (chars[i] == '0') {
                if (temp == 10 || temp == 20) continue;
                else return 0;
            }
            else {
                if (temp < 10) {
                    int a = r1;
                    r1 = r2;
                    r2 = a;
                }
                else if (temp > 10 && temp < 27){
                    r2 = r1 + r2;
                    r1 = r2 - r1;
                } else {
                    r1 = r2;
                }
            }
        }
        return chars[chars.length-1] == '0'? r1 : r2;
    }
}
