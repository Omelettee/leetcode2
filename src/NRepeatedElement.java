/**
 * LC 961 easy hash table
 *
 * n a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 *
 * Return the element repeated N times.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,3]
 * Output: 3
 *
 * Example 2:
 *
 * Input: [2,1,2,5,3,2]
 * Output: 2
 *
 * Example 3:
 *
 * Input: [5,1,5,2,5,3,5,4]
 * Output: 5
 *
 *
 *
 * Note:
 *
 *     4 <= A.length <= 10000
 *     0 <= A[i] < 10000
 *     A.length is even
 */

import java.util.*;


public class NRepeatedElement {

    public int repeatedNTimes1(int[] A) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        for (i = 0; i < A.length; i++){
            if (set.contains(A[i])) break;
            set.add(A[i]);
        }
        return A[i];
    }



    public int repeatedNTimes2(int[] A) {
        int i = 0;
        for (int k = 1; k <= 3; k++){
            for(i = 0; i < A.length - k; i++){
                if (A[i] == A[i+k])
                    break;
            }
        }
        return A[i];
    }
}
