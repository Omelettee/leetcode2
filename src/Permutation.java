/**
 * Lc 46 medium backtracking
 *
 *     public List<List<Integer>> permute(int[] nums) {
 *         List<List<Integer>> ans = new ArrayList<>();
 *         if (nums == null || nums.length == 0) return ans;
 *
 *         helper(ans, nums, 0);
 *         return ans;
 *     }
 *
 *     public void helper(List<List<Integer>> ans, int[] nums, int start){
 *         if (start == nums.length) {
 *             List<Integer> list = new ArrayList<>();
 *             for (int num : nums){
 *                 list.add(num);
 *             }
 *             ans.add(list);
 *         }
 *
 *         for (int i = start; i < nums.length; i++){
 *             swap(nums, start, i);
 *             helper(ans, nums, start+1);
 *             swap(nums, start, i); //swap back
 *         }
 *     }
 *
 *     public void swap(int[] nums, int a, int b){
 *         int temp = nums[a];
 *         nums[a] = nums[b];
 *         nums[b] = temp;
 *     }
 */

import java.util.*;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;

        helper(ans, nums, 0);
        return ans;
    }

    public void helper(List<List<Integer>> ans, int[] nums, int start){
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums){
                list.add(num);
            }
            ans.add(list);
        }

        for (int i = start; i < nums.length; i++){
            swap(nums, start, i);
            helper(ans, nums, start+1);
            swap(nums, start, i); //swap back
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
