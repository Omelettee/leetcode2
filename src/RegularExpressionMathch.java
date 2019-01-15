/***
 * LC 10 hard dynamic programming
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 *     s could be empty and contains only lowercase letters a-z.
 *     p could be empty and contains only lowercase letters a-z, and characters like . or *.
 *
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 *
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 */


public class RegularExpressionMathch {

    /**
     * This Quesion is implemented with dynamic programming
     * Pay attention to the third  example
     *
     *  * s = "ab"
     *  * p = ".*"
     *  * Output: true
     *  * Explanation: ".*" means "zero or more (*) of any character (.)".
     *
     *  The code is writtren based on the vedio on youtueb :
     *  https://www.youtube.com/watch?v=l3hda49XcDE
     */

    public boolean isMatch(String s, String p) {

        if (s == null || p == null) return false;
        char[] string = s.toCharArray();
        char[] pattern = p.toCharArray();
        int lenS = s.length(), lenP = p.length();

        boolean[][] dp = new boolean[lenS+1][lenP+1];
        dp[0][0] = true;
        //Except dp[0][0], all the cell in the first col are at default false;
        //preprocessing the first if analog of a*c*c == c appears
        for (int k  = 0; k < lenP; k++){
            if (pattern[k] == '*')
            {
                dp[0][k+1] = dp[0][k-1];
                //System.out.println(0);
            }
        }

        for (int i  = 0; i < lenS; i++){
            for (int j = 0; j < lenP; j++){
               if (string[i] == pattern[j] || pattern[j] == '.'){
                   dp[i+1][j+1] = dp[i][j];
               } else if (pattern[j] == '*'){
                   dp[i+1][j+1] = dp[i+1][j-1]; // * means 0 occurrence
                   if (pattern[j-1] == '.' || string[i] == pattern[j-1]){
                       dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j+1];
                   }
               }
            }
        }


        for (int i = 0; i < dp.length; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < dp[0].length; j++){
                sb.append(dp[i][j] + "  ");
            }
            System.out.println(sb.toString());
        }

        return dp[lenS][lenP];
    }

    public static void main(String[] args){
        String string = "aa";
        String pattern = ".*";
        RegularExpressionMathch example = new RegularExpressionMathch();
        System.out.println(example.isMatch(string, pattern));
    }
}
