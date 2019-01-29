/**
 * LC 41 hard Array
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 *
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 *
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 */


public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i< nums.length; i++){
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i+1){ // if nums[i] > nums.length, i could not be the answer.
                int toIndex = nums[i] -1;
                if (nums[toIndex] == toIndex +1) break; // This is used to avoid the limited loop
                else {
                    int temp = nums[toIndex];
                    nums[toIndex] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        for (int i = 0; i < nums.length; i++){
            if(nums[i] != i+1) return i+1;
        }

        return nums.length + 1;
    }
}
