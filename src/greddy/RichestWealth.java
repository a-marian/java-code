package greddy;

/**
 * https://leetcode.com/problems/richest-customer-wealth/
 * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the ith
 * customer has in the jth  bank.
 * Return the wealth that the richest customer has.
 * A customer's wealth is the amount of money they have in all their bank accounts.
 * The richest customer is the customer that has the maximum wealth.
 * Example 1:
 * Input: accounts = [[1,5],[7,3],[3,5]]
 * Output: 10
 * Explanation:
 * 1st customer has wealth = 6
 * 2nd customer has wealth = 10
 * 3rd customer has wealth = 8
 * The 2nd customer is the richest with a wealth of 10.
 * */
public class RichestWealth {

    public int maximumWealth(int[][] accounts) {
        int richest= 0;
        for(int i = 0; i < accounts.length; i++){
            int banks = accounts[i].length;
            int wealth= 0;
            for(int j=0; j < banks; j++){
                wealth += accounts[i][j];
            }
            richest = Math.max(richest, wealth);
        }
        return richest;
    }

    public int maximumWealthV2(int[][] accounts) {
        int maxWealth = 0;
        for(int[] customer:accounts){
            int wealth = 0;
            for(int bank: customer){
                wealth += bank;
            }
            maxWealth = Math.max(maxWealth, wealth);
        }
        return maxWealth;
    }
}
