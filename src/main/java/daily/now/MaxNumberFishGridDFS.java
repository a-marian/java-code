package daily.now;

import java.util.LinkedList;
import java.util.Queue;

public class MaxNumberFishGridDFS {

    // helper function to count the number of fishes in a connected component
    private int calculateFishesDFS(int[][] grid, boolean[][] visited, int row, int col){
        //Check boundary conditions, water cells or already visited cells
        if(row <0 || row >= grid.length || col <0 || col >= grid[0].length || grid[row][col] == 0 || visited[row][col]){
            return 0;
        }

        //Mark the current cell as visited
        visited[row][col] = true;

        //Accumulate the fish count from the current cell and its neighbors
        return( grid[row][col] +
                calculateFishesDFS(grid, visited, row, col + 1) +
                calculateFishesDFS(grid, visited, row, col - 1) +
                calculateFishesDFS(grid, visited, row + 1, col) +
                calculateFishesDFS(grid, visited, row - 1, col));
    }

    public int fidMaxFishDFS(int[][] grid){
        int rows = grid.length, cols=grid[0].length;
        int maxFishCount = 0;

        // A 2D array to track visited cells
        boolean[][] visited =new boolean[rows][cols];

        //Iterate through all cells in the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //Start DFS for unvisted land cells (fish available)
                if(grid[row][col] > 0 && !visited[row][col]){
                    maxFishCount = Math.max(maxFishCount, calculateFishesDFS(grid, visited, row, col));
                }
            }
        }
        //Return the maximum fish count found
        return maxFishCount;
    }



}
