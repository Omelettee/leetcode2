/***
 * LC 297 DFS hard
 *
 *

 Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

 Example:

 You may serialize the following tree:

 1
 / \
 2   3
 / \
 4   5

 as "[1,2,3,null,null,4,5]"

 Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

 */

import Util.TreeNode;
import java.util.*;

public class SerializeAndDeserializeBinaryTree {

    // This question is implemented with depth first search: details was listed int the solution

    public String serialize (TreeNode root){
        StringBuilder sb = new StringBuilder();
        preSerialize(root, sb);
        return sb.toString();
    }

    public void preSerialize (TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append("#,");
            return;
        }
        //System.out.println(root.val);
        sb.append(root.val).append(',');
        //System.out.println(sb);
        preSerialize(root.left, sb);
        preSerialize(root.right, sb);
    }

    public TreeNode deserialize(String data){
        String[] data_array = data.split(",");
        int[] index = new int[]{0}; // this is to store the address of the array
        return preDeserialize(data_array, index);
    }

    public TreeNode preDeserialize(String[] data, int[] index){
        //System.out.println(data.get(0));
        if (data[index[0]].equals("#")){
            index[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(data[index[0]]));
        index[0]++; // do not forget to remove used values
        root.left = preDeserialize(data, index);
        root.right = preDeserialize(data, index);

        return root;
    }
}
