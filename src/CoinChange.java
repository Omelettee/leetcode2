
import java.util.*;
public class CoinChange {
    //dynamic programming : method 1 top down
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        int[] memo = new int[amount + 1];
        int max = amount + 1;
        memo[0] = 0;
        coinChange(coins, amount, memo, max);
        //System.out.println( memo[186] );
        return memo[amount];
    }

    public int coinChange(int[] coins, int rem, int[] memo,  int max){
        System.out.println(rem);
        if (rem < 0) return max;
        if (rem == 0) return 0;
        if (memo[rem] != 0) return memo[rem];
        int min = max;
        for (int coin : coins){
            int res = coinChange(coins, rem - coin, memo, max);
            if (res >=0 && res < max){
                min = Math.min(min, res+1);
            }
        }
        memo[rem] = min == max? -1: min;
        /**
         *  if memo[i] has been checked, we must update the value.
         *  I made a mistake : assign each cell as max,  and leave it as max after checking.
         *  The previous calculation has been wasted if the memo[i] has been checked again.
         */



        return memo[rem];
    }


    public int coinChange2(int[] coins, int amount){
        int[] memo = new int[amount +1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins){
                int rem = i - coin;
                if (rem >= 0){
                    memo[i] = Math.min(memo[rem] + 1, memo[i]);
                }
            }
        }
        return memo[amount] > amount? -1: memo[amount];


    }

    public static void main(String[] args){
        CoinChange example = new CoinChange();
        int[] coins = {186,419,83,408};
        int amount = 6249;
        System.out.println(example.coinChange(coins, amount));
    }
}
