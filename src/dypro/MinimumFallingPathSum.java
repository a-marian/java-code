package dypro;
/**
 * 931. Minimum Falling Path Sum
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 * A falling path starts at any element in the first row and chooses the element in the next row that
 * is either directly below or diagonally left/right. Specifically, the next element from position
 * (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 * Example:
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * Explanation: There are two falling paths with a minimum sum as shown.
 * */
public class MinimumFallingPathSum {

    public static int minFallingPathSum(int[][] matrix) {
        int size = matrix.length;
        int minPathSum =  Integer.MAX_VALUE;
        int[][] dp = new int[size][size];

        for(int j=0; j< size; j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1; i< size; i++){
            for(int j=0; j< size; j++){
                if(j==0){
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
                } else if(j==matrix.length-1){
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
                } else {
                    dp[i][j]=matrix[i][j]+ Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i-1][j+1]);
                }
            }
        }

        for(int i=0; i < size; i++){
            if(dp[size-1][i] < minPathSum) minPathSum=dp[size-1][i];
        }

        return minPathSum;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(mat));
    }
}


/**
 * Time complexity: O(N)
 * Space complexity: O(1)
 * https://leetcode.com/problems/minimum-falling-path-sum/
 * */
