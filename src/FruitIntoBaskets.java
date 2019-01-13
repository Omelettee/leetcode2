/***
 *
 * LC 907
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 *
 * You start at any tree of your choice, then repeatedly perform the following steps:
 *
 *     Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 *     Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 *
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 *
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 *
 * What is the total amount of fruit you can collect with this procedure?
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,1]
 * Output: 3
 * Explanation: We can collect [1,2,1].
 *
 * Example 2:
 *
 * Input: [0,1,2,2]
 * Output: 3
 * Explanation: We can collect [1,2,2].
 * If we started at the first tree, we would only collect [0, 1].
 *
 * Example 3:
 *
 * Input: [1,2,3,2,2]
 * Output: 4
 * Explanation: We can collect [2,3,2,2].
 * If we started at the first tree, we would only collect [1, 2].
 *
 * Example 4:
 *
 * Input: [3,3,3,1,2,1,1,2,3,3,4]
 * Output: 5
 * Explanation: We can collect [1,2,1,1,2].
 * If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 *
 *
 *
 * Note:
 *
 *     1 <= tree.length <= 40000
 *     0 <= tree[i] < tree.length
 */

import java.util.*;
public class FruitIntoBaskets {

    public int totalFruit(int[] tree) {

        int max = 0, curr = 0;
        int t1= -1, t2 = -2;
        int c1 = 0, c2 = 0;

        for (int i = 0; i < tree.length; i++) {
            curr = (t1 == tree[i]|| t2 == tree[i]) ? (curr + 1): (c2 + 1); // mistake : curr - c1

            if (t2 != tree[i]) {
                t1 = t2; t2 = tree[i];
                c1 = c2; c2 = 1;
            } else{ // mistake 2 : must write as else;
                c2++;
            }
            max = Math.max(curr, max);
        }

        return max;
    }


    // the second method is sliding window
    public int totalFruit2(int[] tree){

        int ans = 0, j = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < tree.length; i++){
            count.put(tree[i], count.getOrDefault(tree[i], 0) + 1);
            while(count.size() > 2){
                count.put(tree[j], count.get(tree[j]) - 1);
                if (count.get(tree[j]) == 0) count.remove(tree[j]);
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }

        return ans;
    }

    public static void main(String[] args){
        int[] tree = {5,0,0,7,0,7,2,7};
        FruitIntoBaskets example = new FruitIntoBaskets();
        System.out.println(example.totalFruit(tree));
    }
}


