/**
 * 151 medium String
 *
 * Given an input string, reverse the string word by word.
 *
 * Example:
 *
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 *
 * Note:
 *
 *     A word is defined as a sequence of non-space characters.
 *     Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 *     You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 */

public class ReserveWordsInString {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strs = s.trim().split("\\s+");
        for (int i = strs.length -1; i >=0; i--){
            sb.append(strs[i] + " ");
        }
        return sb.toString().trim();
    }


}
