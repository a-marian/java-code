package daily.now;

/**
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/description/
 * */
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols= grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        //Add all rotten oranges to the queue and count the fresh oranges
        for(int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j}); //Add rotten oranges to the queue
                } else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        //Directions for moving in the grid (up, down, left, right)
        int[][] directions = {{-1,0},{1,0}, {0,-1}, {0,1}};
        int minutes = 0;

        //Perform BFS to spread the rot
        while(!queue.isEmpty() && freshCount > 0){
            int size=queue.size();
            for(int i=0; i < size; i++){
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                //Explore all 4 directions
                for(int[] direction: directions){
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    //Check if the new position is valid and contains a frech orange
                    if(newRow >= 0 && newRow < rows && newCol >=0 && newCol < cols && grid[newRow][newCol] ==1){
                        grid[newRow][newCol] = 2; //Rotten the fresh orange
                        freshCount--; //Decrease fresh orange count
                        queue.add(new int[]{newRow, newCol}); //Add the new rotten orange to the queue

                    }
                }
            }
            minutes++; // Increment the minutes after processing

        }
        //if there are still fresh oranges left, return -1
        return freshCount == 0 ? minutes : -1;
    }
}
