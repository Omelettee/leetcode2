/**
 * LC 400 easy math
 *
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 *
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 *
 * Example 1:
 *
 * Input:
 * 3
 *
 * Output:
 * 3
 *
 * Example 2:
 *
 * Input:
 * 11
 *
 * Output:
 * 0
 *
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */


public class NthDigit {


    /**
     * First thing is to understand what this question means
     * @param n
     * @return
     *
     * Pipeline:
     * 1. make sure the level of the n
     *      [1,9] each number has 1 digit; [10,99] each number 2 digits.....
     * 2. find the actual number where the nth digit is from
     * 3. find out which digit should be return from the number found in the 2nd step
     */

    public static int findNthDigit (int n) {

        int level = 1; // number of digits in each level
        long count = 9; // number of numbers in each level
        int start = 1; // the first number in each level

        while (n > level * count) {
            n -= level * count;
            level++;
            count *= 10;
            start *= 10;
        }
        start += (n-1) / level;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n-1)%level));
    }

    public static void main (String[] args) {


        System.out.println(findNthDigit(11));
        System.out.println(findNthDigit(2147483647));
    }
}
