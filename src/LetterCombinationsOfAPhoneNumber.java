/**
 * LC 17 medium String Backtracking
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */


import java.util.*;
public class LetterCombinationsOfAPhoneNumber {

    //only to remember the last sentence
    String[] templet = {"", "", "abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits  == null || digits.length() == 0) return ans;
        char[] chDigits = digits.toCharArray();
        helper("", chDigits, 0, ans);
        return ans;
    }

    public void helper(String sb, char[] digits, int index, List<String> ans){

        if (index == digits.length) {
            ans.add(sb.toString());
            return;
        }
        int tmp = digits[index] - '0';
        for (char ch : templet[tmp].toCharArray()){
            helper(sb + ch, digits, index + 1, ans); // shb +  ch -> no need to create new sb, Wonderful!
        }
    }
}
