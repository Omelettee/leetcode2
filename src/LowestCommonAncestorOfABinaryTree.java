/**
 * LC 235 medium Tree
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 *
 *
 * Note:
 *
 *     All of the nodes' values will be unique.
 *     p and q are different and both values will exist in the binary tree.
 */

import Util.TreeNode;
import java.util.*;
public class LowestCommonAncestorOfABinaryTree {

    //First method is recursion
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // This method is inspired by the vedio of Zhou yu on the youtube
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }

    public int subarraySum2(int[] nums, int k) {
        /** This method is called prefix , and it could be applied to most of the questions
         related to the sum of subarray
         Time : O(n)
         Space : O(n)
         **/

        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> record =  new HashMap<>();
        record.put(0, 1);

        int prefix = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            prefix += nums[i];
            count += record.getOrDefault(prefix - k, 0);
            record.put(prefix, record.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
}
