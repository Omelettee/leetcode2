/**
 * LC 238 medium Array
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 */

public class ProductOfArrayExceptSelf {


    /**
     * **Note: Please solve it without division and in O(n).**
     * Time : O (N) , Space O (N)
     * Pileline : res[i] = left(res[0 * 1 * .... i-1]) * right(res[i + 1 * ... ])
     * Use dynamic programming to create left and right
     **/
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        int len = nums.length;
        int[] ans = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len-1] = 1;

        for (int i = 1; i < len; i++){
            left[i] = left[i-1] * nums[i-1];
        }
        for (int i = len-2; i >= 0; i--){
            right[i] = right[i+1] * nums[i+1];
        }
        for (int i = 0; i < len; i++){
            ans[i] = left[i]*right[i];
        }
        return ans;
    }

    /**
     * Follow up:
     * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
     */

    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];

        ans[0] = 1;
        for (int i = 1; i < len; i++){
            ans[i] = nums[i-1] * ans[i-1];
        }
        int right = 1;
        for (int i = len-1; i >=0; i--){
            ans[i] *= right;
            right *= nums[i];
        }
        return ans;
    }

}
