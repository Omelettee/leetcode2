import javax.swing.plaf.synth.SynthRootPaneUI;

/**
 * LC 905 easy Array
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 *
 *
 * Note:
 *
 *     1 <= A.length <= 5000
 *     0 <= A[i] <= 5000
 */


public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];

        int start = 0, end = A.length-1;
        for (int i = 0; i < A.length; i++){
            if (A[i] % 2 == 0) ans[start++] = A[i];
            else ans[end--] = A[i];
        }
        return ans;
    }

    /**
     * This method is to edit the Array A in-place.
     * @param A
     * @return
     */
    public int[] sortArrayByParity2(int[] A){

        int i = 0, j = A.length - 1;
        while (i < j){
            if (A[i] % 2 == 1 && A[j] %2 == 0 ){
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;

    }


    public static void main(String[] args){
        int[] test = new int[]{3,1,2,4};
        SortArrayByParity example = new SortArrayByParity();
        int[] ans = example.sortArrayByParity2(test);
        for (int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
    }

}
