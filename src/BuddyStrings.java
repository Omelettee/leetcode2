/***
 * LC 859 easy String
 *
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
 *
 *
 *
 * Example 1:
 *
 * Input: A = "ab", B = "ba"
 * Output: true
 *
 * Example 2:
 *
 * Input: A = "ab", B = "ab"
 * Output: false
 *
 * Example 3:
 *
 * Input: A = "aa", B = "aa"
 * Output: true
 *
 * Example 4:
 *
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 *
 * Example 5:
 *
 * Input: A = "", B = "aa"
 * Output: false
 *
 *
 *
 * Note:
 *
 *     0 <= A.length <= 20000
 *     0 <= B.length <= 20000
 *     A and B consist only of lowercase letters.
 *
 */


public class BuddyStrings {

    /**
     * Pipeline :
     * There are two conditions for true:
     * 1. A == B && there are at least two same characters
     * 2. A != B && only 2 diff && A[first] == B[second] && A[second] == B[first]
     *
     * @param A
     * @param B
     * @return whether A and B has only two swappable characters.
     */

    public boolean buddyStrings(String A, String B){

        if (A.length() != B.length() || A.length() < 2) return false;
        if (A.equals(B)){
            int[] counts = new int[26];
            for (int i = 0; i < A.length(); i++){
                counts[A.charAt(i) - 'a']++;
            }
            for (int count : counts){
                if (count > 1) return true;
            }
            return false;
        } else {
            int first = -1;
            int second = -1;
            for (int i = 0; i < A.length(); i++){
                if (A.charAt(i) != B.charAt(i)){
                    if (first == -1) first = i;
                    else if (second == -1) second = i;
                    else return false; // more than 2 diff, return false;
                }
            }
            return ((second != -1) && (A.charAt(first) == B.charAt(second)) && (A.charAt(second) == B.charAt(first)));

        }

    }


    public static void main(String[] args){
        String A = "a";
        String B = "a";
        BuddyStrings example = new BuddyStrings();
        System.out.println(example.buddyStrings(A,B));
    }
}
