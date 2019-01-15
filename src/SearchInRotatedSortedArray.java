/***
 *
 * LC 33 medium Array / Binary Search
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 */


public class SearchInRotatedSortedArray {

    /**
     *
     * @param nums
     * @param target
     * @return boolean
     *
     * Pipeline : binary search -> only cares about the ordered
     *
     */

    public static int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target? 0 : -1;

        int l = 0, r = nums.length - 1;
        while (l + 1 < r){
            System.out.println("l: " + l + " | r: " + r);
            int mid = l + (r-l)/2;
            if (nums[mid] == target) return mid;
            // To see which part is ordered
            if (nums[l] <= nums[mid]){
                if (nums[l] <= target &&  target <= nums[mid]){
                    r = mid;
                } else {
                    l = mid+1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]){
                    l = mid+1;
                } else {
                    r = mid;
                }
            }
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }

    public static void main(String[] args){
        int[] test = new int[]{4,5,6,7,0,1,2,3};
        System.out.println(search(test, 10));

    }
}
