/**
 * LC 686
 *
 *
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
 *
 * For example, with A = "abcd" and B = "cdabcdab".
 *
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 *
 * Note:
 * The length of A and B will be between 1 and 10000.
 * Accepted
 * 54,849
 * Submissions
 * 175,278
 */

public class RepeatedStringMatch {

    public static int repeatedStringMatch1 (String a, String b){

        /*
        Time complexity :  O(N*(M+N))
        Space complexity : O(M+N)
         */

        StringBuilder sb = new StringBuilder(a);
        int q = 1;
        while(sb.length() < b.length()){
            sb.append(a);
            q++;
        }
        if (sb.indexOf(b) >=0 ) return q;
        if (sb.append(a).indexOf(b) >= 0) return q+1; // make sure every elements in a could be the starting point for substring searching
        return -1;

    }

    public static int repeatedStringMatch2 (String a, String b){
        /*
        * The second method is in Hash:
        * https://leetcode.com/problems/repeated-string-match/solution/
        * */
        return 1;
    }

    public static void main(String[] args){
        String a = "abcd";
        String b = "abcd";
        System.out.println(repeatedStringMatch1(a,b));
    }

}
