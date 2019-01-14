/**
 * LC 42 hard stack array two pointer
 */

import java.util.*;
public class TrappingRainWater {
    /**
     * Dynamic programming
     * K : to the leftBound and rightBound on each position
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int ans = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = height[0]; // important : do not forget
        right[height.length-1] = height[height.length-1]; // important : do not forget

        for (int i = 1; i < height.length; i++){
            left[i] = Math.max(left[i-1], height[i]); //find out the left determining height
        }
        for (int i = height.length - 2; i >=0; i--){
            right[i] = Math.max(height[i], right[i+1]) ; // find out the right determine height
        }

        for (int i = 1; i < height.length-1; i++){
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }


    /**
     * Two pointers
     * K : the volumn of trapping water is dependent on the the highest point on the relatively lower side.
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if (height == null || height.length == 0) return 0;

        int l = 0, r = height.length-1, ans = 0;
        int leftMax = 0, rightMax = 0;

        while (l < r) {
            if (height[l] < height[r]){
                leftMax = Math.max(height[l], leftMax);
                ans += (leftMax - height[l]);
                l++;
            } else {
                rightMax = Math.max(height[r], rightMax);
                ans += (rightMax - height[r]);
                r--;
            }
        }

        return ans;

    }
}
