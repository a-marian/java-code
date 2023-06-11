package dypro;
/**
 * 121. Best Time to Buy and Sell Stock
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 * Example:
 *     Input: prices = [7,6,4,3,1]
 *     Output: 0
 *     Explanation: In this case, no transactions are done and the max profit = 0.
 * */
public class BestTimeToBuySellStock {
    public static int maxProfit(int[] prices) {
        if(prices.length <=1) return 0;

        int N = prices.length;
        int maxProfit = 0;
        int buyProfit = prices[0];
        for(int i=0; i <  N; i++){
                buyProfit = Math.min(prices[i] , buyProfit);
                maxProfit = Math.max(prices[i]-buyProfit, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
       System.out.println(maxProfit(prices));

        int[] prices1 = {7,6,4,3,1};
        System.out.println(maxProfit(prices1));
    }
}
/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * https://leetcode.com/problems/best-time-to-buy-and-selﬁl-stock/
 * **/
