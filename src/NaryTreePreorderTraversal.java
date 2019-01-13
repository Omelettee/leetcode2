/**
 * 589 easy tree
 *
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 * Return its preorder traversal as: [1,3,5,6,2,4].

 *
 * Note:
 *
 * Recursive solution is trivial, could you do it iteratively?
 *
 */

import java.util.*;
import Util.*;

public class NaryTreePreorderTraversal {

    // recursive
    List<Integer> ans = new ArrayList<>();
    LinkedList<Node>  stack = new LinkedList<Node>();

    public List<Integer> preorder(Node root) {
        if (root == null) return ans;

        ans.add(root.val);
        for (Node children : root.children) {
            preorder(children);
        }
        return ans;

    }

    //iterative method
    public List<Integer> preorer(Node root){

        if (root == null) return ans;

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            ans.add(node.val);
            for (Node child : node.children){
                stack.add(child);
            }
        }
        return ans;
    }
}
