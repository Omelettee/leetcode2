/**
 * LC 95 binary tree medium
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: true
 *
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 *              is 5 but its right child's value is 4.
 *
 */



import Util.TreeNode;
import java.util.*;
public class ValidateBinarySearchTree {


    //recursion!!!!! make the same mistakes again and again.
    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer lowerLimit, Integer upperLimit){
        if (root == null) return true;
        if (lowerLimit != null && lowerLimit >= root.val) return false;
        if (upperLimit != null && root.val >= upperLimit) return false;

        return helper(root.left, lowerLimit, root.val) && helper(root.right, root.val, upperLimit);
    }

    //iteration :
    public boolean isValidBST2(TreeNode root) {

        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> lowerLimit = new Stack<>();
        Stack<Integer> upperLimit = new Stack<>();
        stack.push(root);
        lowerLimit.push(null);
        upperLimit.push(null);


        while (!stack.isEmpty()){
            root = stack.pop();
            Integer min = lowerLimit.pop();
            Integer max = upperLimit.pop();

            if (min != null && min >= root.val) return false;
            if (max != null && max <= root.val) return false;

            if (root.left != null){
                stack.push(root.left);
                lowerLimit.add(min);
                upperLimit.add(root.val);
            }
            if (root.right != null){
                stack.push(root.right);
                lowerLimit.add(root.val);
                upperLimit.add(max);
            }
        }
        return true;
    }


}
