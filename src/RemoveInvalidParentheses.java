/**
 * LC 310 hard DFS BFS
 *
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 *
 * Example 2:
 *
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 *
 * Example 3:
 *
 * Input: ")("
 * Output: [""]
 */


import java.util.*;
public class RemoveInvalidParentheses {

    /**
     *
     * Pipeline :
     * 1. know how many left and right parenthesis is invalid
     * 2. remove all the corresponding left and right number of parenthese
     * 3. check whether the modified string is valid
     *
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {

        int l = 0, r = 0; // The number of left/right paranthesese needed to be deleted

        char[] chars = s.toCharArray();
        int right_count = 0;
        for (char c : chars){
            if (c == '(') {l++; continue;}
            if (c == ')') {
                if (l == 0) r++;
                else l--;
            }
        }

        List<String> ans = new ArrayList<>();
        helper(new StringBuilder(s), 0, l, r, ans);
        return ans;
    }

    public boolean isValid(String s){
        int count = 0;
        for (char c : s.toCharArray()){
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }


    public void helper(StringBuilder s, int pos, int l, int r, List<String> ans){
        if (l == 0 && r == 0 && isValid(s.toString())){
            ans.add(s.toString());
            return;
        }

        for (int i = pos; i < s.length(); i++){
            char target = s.charAt(i);
            if (i != pos && target == s.charAt(i-1)) continue;
            if (target == '(' || target == ')'){
                StringBuilder curr = new StringBuilder(s);
                curr.deleteCharAt(i);
                if (r > 0 && target == ')') helper(curr, i, l, r-1, ans);
                if (l > 0 && target == '(') helper(curr, i, l-1, r, ans);
            }
        }
    }
}
