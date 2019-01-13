/**
 *
 * LC 479 easy String
 *
 *
 *
 * Find the largest palindrome made from the product of two n-digit numbers.
 *
 * Since the result could be very large, you should return the largest palindrome mod 1337.
 *
 * Example:
 *
 * Input: 2
 *
 *
 * Output: 987
 *
 * Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
 *
 * Note:
 *
 * The range of n is [1,8].
 */


public class LargestPaindromeProduct {


    /**
     * Pipeline :
     * There are two approaches to solve this quesiton:
     * 1. Find out all the palindrome and check whether it could be factored to be 2 n-digits number
     * 2. Calculate all the product and check out whether the product would be a palindrome
     *
     * The following method is written with the first approach
     *
     * @param n
     * @return the largest palindorme which could be factored to be 2 n-digits
     */
    public int largestPalindrome (int n) {

        if (n == 1) return 9;

        int upperBound = (int) Math.pow(10,n) - 1, lowerBound = (int) Math.pow(10, n-1);
        long maxProduct = (long) upperBound * (long) upperBound;

        //Each Palindrome could be each 2n or 2n-1 digits, we first consider about 2n
        long leftHalf = (long) (maxProduct) / (int) Math.pow(10, n);

        boolean palindromeFound = false;
        long palindrome = 0;

        while (!palindromeFound){
            palindrome = createPalindrome(leftHalf);
            //System.out.println("palindrome: " + palindrome);

            for(long i = upperBound; upperBound > lowerBound; i--){
                if (palindrome / i > upperBound || i * i < palindrome){
                    break;
                }
                palindromeFound = (palindrome % i) == 0;
                if (palindromeFound) break;

            }
            leftHalf--;

        }
        return (int) (palindrome % 1337);

    }

    public long createPalindrome(long n){
        String str = n + new StringBuilder().append(n).reverse().toString();
        System.out.println(Long.parseLong(str));
        return Long.parseLong(str);
    }


    public static void main(String[] args){

        int n = 6;
        LargestPaindromeProduct example = new LargestPaindromeProduct();
        System.out.println(example.largestPalindrome(n));
    }
}
