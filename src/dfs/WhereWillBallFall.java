package dfs;
/**
 * https://leetcode.com/problems/where-will-the-ball-fall/
 * You have a 2-D grid of size m x n representing a box, and you have n balls.
 * The box is open on the top and bottom sides.
 * Each cell in the box has a diagonal board spanning two corners of the cell that can redirect
 * a ball to the right or to the left.
 * A board that redirects the ball to the right spans the top-left corner
 * to the bottom-right corner and is represented in the grid as 1.
 * A board that redirects the ball to the left spans the top-right corner
 * to the bottom-left corner and is represented in the grid as -1.
 * We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom.
 * A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall of the box.
 * Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom
 * after dropping the ball from the ith column at the top, or -1 if the ball gets stuck in the box.
 * Example 3:
 * Input: grid = [[ 1, 1, 1, 1, 1, 1],
 *                [-1,-1,-1,-1,-1,-1],
 *                [ 1, 1, 1, 1, 1, 1],
 *                [-1,-1,-1,-1,-1,-1]]
 * Output: [0,1,2,3,4,-1]
 * */

public class WhereWillBallFall {

    public int[] findBall(int[][] grid) {
        int result[] = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            result[i] = findDropColumn(0, i, grid);
        }
        return result;
    }

    private int findDropColumn(int row, int col, int[][]grid){
        if(row == grid.length)
            return col;
        int nextCol = col + grid[row][col];
        if(nextCol < 0 || nextCol > grid[0].length -1 || grid[row][col] != grid[row][nextCol]){
            return -1;
        }
        return findDropColumn(row+1, nextCol, grid);
    }

}
