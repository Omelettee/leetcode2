/**
 * LC258:
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 *
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {

    public int addDigits1 (int num){ // with recursion
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum < 10) {
            return sum;
        }
        else {
            return addDigits1(sum);
        }
    }

    public int addDigits2 (int num){ // without recursion -> use the trick : https://leetcode.com/problems/add-digits/discuss/68572/3-methods-for-python-with-explains
        if (num == 0) {
            return 0;
        } else if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }

    public int addDigits3 (int num){
        if(num==0)return 0;
        return 1 + (num - 1) % 9;
    }


    public static void main (String[] args){
        AddDigits test = new AddDigits();
        System.out.println(test.addDigits1(0));
        System.out.println(test.addDigits3(8888));

    }

}
