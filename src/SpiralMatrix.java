/**
 * LC 54 medium Array
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */


import java.util.*;
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0){
            return ans;
        }

        int rStart = 0, rEnd = matrix.length - 1;
        int cStart = 0, cEnd = matrix[0].length - 1;
        while(rStart <= rEnd && cStart <= cEnd){

            for(int i = cStart; i <= cEnd; i++){
                ans.add(matrix[rStart][i]);
            }
            rStart++;
            for(int j = rStart; j <= rEnd; j++){
                ans.add(matrix[j][cEnd]);
            }
            cEnd--;


            if (rEnd >= rStart){
                for (int i = cEnd; i >= cStart; i--) {
                    ans.add(matrix[rEnd][i]);
                }
                rEnd--;
            }
            if (cEnd >= cStart){
                for (int j = rEnd; j >= rStart; j--){
                    ans.add(matrix[j][cStart]);
                }
                cStart++;
            }
        }

        return ans;
    }

}
