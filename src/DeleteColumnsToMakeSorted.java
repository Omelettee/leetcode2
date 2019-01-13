/***
 * 944 easy greedy
 *
 */


public class DeleteColumnsToMakeSorted {

    public int minDeletionSize(String[] A) {
        int ans = 0;

        for (int i = 0; i < A[0].length(); i++){
            for (int k = 0; k < A.length - 1; k++){
                if (A[k].charAt(i) > A[k+1].charAt(i)){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main (String[] args){

        String[] test = {"zyx","wvu","tsr"};
        DeleteColumnsToMakeSorted example = new DeleteColumnsToMakeSorted();
        System.out.println(example.minDeletionSize(test));
    }
}
