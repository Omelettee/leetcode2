/**
 * LC 168 easy Math
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 *
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 *
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"
 */


public class ExcelSheetColumnTitle {


    /**
     * Pipeline : could be treated as a 26 scale math
     * @param n
     * @return
     */
    public String convertToTitle(int n) {

        StringBuilder sb = new StringBuilder();
        int remainder = 0;
        char col = 'A';

        while (n > 0) {

            remainder = (n-1) % 26;
            //System.out.println("remainder: " + remainder);
            col = (char) ('A' + remainder);
            sb.append(col);
            n = (n-1)/26;
            //System.out.println("n:  " + n);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args){
        int test = 1;
        ExcelSheetColumnTitle example = new ExcelSheetColumnTitle();
        System.out.println(example.convertToTitle(test));
    }



}
