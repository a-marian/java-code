package dypro;
/**
 * 64. Minimum Path Sum
 * Given a grid(m*n) filled with non-negative numbers, find a path
 * from top left to bottom right which minimizes the sum of all numbers along it s path.
 * Note: You can only move either down or right at any point in time.
 * Example:
 * Input:
 *      [[1,3,1],
 *       [1,5,1],
 *       [4,2,1]]
 * Output: 7
 * Explanation: Because the path 1->3->1->1->1 minimizes the sum.
 * */
public class MinimumPathSum {

    public static int minimumPathSum(int[][]grid){
        if(grid == null || grid.length == 0){
            return 0;
        }

        int dp[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dp[i][j] += grid[i][j];
                if(i > 0 && j > 0){
                    dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                } else if (i > 0){
                    dp[i][j] += dp[i-1][j];
                } else if (j > 0){
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[dp.length -1][dp[0].length -1];
    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};

        System.out.println(minimumPathSum(grid));
    }
}
/**
 * Time complexity: O(m*n)
 * Space complexity: O(m*n)
 * https://leetcode.com/problems/minimum-path-sum/
 * */

