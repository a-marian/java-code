package dfs;

import java.util.Arrays;

/***
 * 1020. Number of Enclaves
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 * A move consists of walking from one land cell to another adjacent (4-directionally)
 * land cell or walking off the boundary of the grid.
 * Return the number of land cells in grid for which we cannot walk off the boundary of
 * the grid in any number of moves.
 *
 * Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation:
 * There are three 1s that are enclosed by 0s, and one 1 that is not enclosed
 * because its on the boundary.
 * https://leetcode.com/problems/number-of-enclaves/description/
 */


public class NumberOfEnclaves {

    public static int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return Arrays.stream(grid).mapToInt(row -> Arrays.stream(row).sum()).sum();
    }

    private static  void dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                dfs(grid, x, y);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};

         int res = numEnclaves(grid);

         System.out.println(res);
    }
}
