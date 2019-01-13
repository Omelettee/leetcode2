/***
 * LC 760 easy hash table
 */

import java.util.*;

public class FindAnagramMappings {

    public int[] anagramMappings(int[] A, int[] B){
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[A.length];
        for (int i = 0; i < B.length; i++){
            map.put(B[i], i);
        }

        for (int i = 0; i < A.length; i++){
            ans[i] = map.get(A[i]);
        }
        return ans;
    }
}

