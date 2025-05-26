package daily.now;

import java.util.Arrays;
/**
* https://leetcode.com/problems/coin-change/description/?source=submission-ac
*/
public class CoinChanges {

    public static void main(String[] args) {
        int[] coins= new int[] {1,2,5};
        int amount = 11;
       int res =  coinChange(coins, amount);
        System.out.println(res);
    }

        public static int coinChange(int[] coins, int amount) {
            int [] minCoins = new int[amount+1];
            Arrays.fill(minCoins, amount+1);
            minCoins[0]= 0;

            for(int i=1; i<= amount; i++){
                for(int j=0; j < coins.length; j++){
                    if(i - coins[j] >= 0){
                        minCoins[i] = Math.min(minCoins[i], 1+minCoins[i-coins[j]]);
                    }
                }
            }
            return minCoins[amount] != amount+1 ? minCoins[amount]:-1;
        }

}
