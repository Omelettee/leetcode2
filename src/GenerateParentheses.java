/**
 * LC 22 medium String Backtracking
 *  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */

import java.util.*;


public class GenerateParentheses {


    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        if (n == 0) return ans;
        helper(ans, "", n, n);
        return ans;
    }

    /**
     *
     * @param ans
     * @param s
     * @param left : the number of "(" needed to be added
     * @param right: the number of ")" needed to be added
     */
    public void helper(List<String> ans, String s, int left, int right){

        if (left > right) return;
        if (left == 0 && right == 0) {
            ans.add(s);
            return;
        }
        if (left > 0)  helper(ans, s+"(", left-1, right);
        if (right > 0) helper(ans, s+")", left, right - 1);
    }

    public static void main(String[] Args){

        GenerateParentheses example = new GenerateParentheses();
        List<String> ans = example.generateParenthesis(2);
        for (String str : ans){
            System.out.println(str);
        }

    }
}
