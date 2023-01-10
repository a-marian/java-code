package dypro;
/***
 * 1155. Number of Dice Rolls With Target Sum
 * You have n dice, and each die has k faces numbered from 1 to k. Given three integers n, k, and target,
 * return the number of possible ways (out of the kn total ways) to roll the dice, so the sum of the face-up
 * numbers equals target. Since the answer may be too large, return it modulo 10^9 + 7.
 *Example:
 * Input: n = 2, k = 6, target = 7
 * Output: 6
 * Explanation: You throw two dice, each with 6 faces.
 * There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
 **/

public class DiceRollsToTarget {

    public static int numRollsToTarget(int n, int k, int target) {
        int MOD = 1000000007;
        int[][]dp = new int[n+1][target+1];
        dp[0][0] =1;

        //how many possibility can i dices sum up to j:
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= target ; j++) {
                //if j is larger than largest possible sum of i dices, there is no possible ways
                if(j > i * k) break;
                //k mustn't be larger than f and j
                for (int l = 1; l <= k && l <=j ; l++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % MOD;
                }

                }
            }
        return dp[n][target];
        }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(2, 6, 7));
    }
}
/**
 * Time complexity: O(n * target)
 * Space complexity: O(n * target)
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 * */
