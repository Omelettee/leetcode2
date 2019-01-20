/**
 * LC 31 NextPermutation medium Array
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 */


public class NextPermutation {

    //This method is from cspiration on the youtube
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;

        int firstSmall = -1;
        for (int i = nums.length - 2; i >= 0; i--){
            if (nums[i+1]> nums[i]){
                firstSmall = i;
                break;
            }
        }

        if (firstSmall == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstSmall; i--){
            if (nums[i] > nums[firstSmall]) {
                firstLarge = i;
                swap(nums, firstSmall, firstLarge);
                break;
            }
        }

        reverse(nums, firstSmall+1, nums.length-1);
        return;

    }




    public void reverse(int[] nums, int i, int j){
        while (i < j){
            swap(nums, i++, j--);
        }
        return;
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
