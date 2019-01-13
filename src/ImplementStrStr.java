/**
 * Leetcode 28 easy
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */


public class ImplementStrStr {

    /**
     *
     * @param haystack
     * @param needle
     * @return
     * this is a naive method, check with the method substirng()
     * time : O(N*M)
     * space : O(1)
     */
    public int strStr1 (String haystack, String needle){
        if (needle.length() == 0) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }


    /**
     *
     * @param haystack
     * @param needle
     * @return int
     *
     * Knuth morris pratt Algorithm
     * https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
     * To be solved later.
     */
    public int strStr2 (String haystack, String needle){

        return -1;

    }
}
