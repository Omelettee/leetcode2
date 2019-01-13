/**
 *  LC : 754 math easy
 *
 *  You are standing at position 0 on an infinite number line. There is a goal at position target.
 *
 * On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.
 *
 * Return the minimum number of steps required to reach the destination.
 *
 * Example 1:
 *
 * Input: target = 3
 * Output: 2
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second step we step from 1 to 3.
 *
 * Example 2:
 *
 * Input: target = 2
 * Output: 3
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second move we step  from 1 to -1.
 * On the third move we step from -1 to 2.
 *
 * Note:
 * target will be a non-zero integer in the range [-10^9, 10^9].
 */


public class ReachANumber {
    /*
    when we see the integer range is [-10^9, 10^9], the time complexity should be less than O(logN);
    Typically, using a mathematical method to solve the problem.
     */

    public int reachAnumber1 (int target){
        target = Math.abs(target); // step(n) = step(-n)
        int k = 0;
        while ( target > 0){
            target -= ++k;
        }
        return target % 2 == 0 ? k : k + 1 + k %2;
    }


    public int reachNumber2(int target) {
        target = Math.abs(target); // step(n) = step(-n)
        int k = (int) Math.sqrt(target * 2); // (k+1)*k/2 >=  target
        target -= (k+1) * k / 2;
        while ( target > 0){
            target -= ++k;
        }
        return target % 2 == 0 ? k : k + 1 + k %2;
    }
}
