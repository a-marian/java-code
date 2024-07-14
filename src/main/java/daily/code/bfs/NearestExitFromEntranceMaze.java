package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+').
 * You are also given the entrance of the maze, where entrance = [entrance row, entrance col] denotes the row and column
 * of the cell you are initially standing at. In one step, you can move one cell up, down, left, or right.
 * You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit
 * from the entrance. An exit is defined as an empty cell that is at the border of the maze.
 * The entrance does not count as an exit.
 * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 *
 * */

public class NearestExitFromEntranceMaze {

        public int nearestExit(char[][] maze, int[] entrance) {
            int rows = maze.length, cols = maze[0].length;
            int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            // Mark the entrance as visited since its not a exit.
            int startRow = entrance[0], startCol = entrance[1];
            maze[startRow][startCol] = '+';

            // Start BFS from the entrance, and use a queue `queue` to store all
            // the cells to be visited.
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{startRow, startCol, 0});

            while (!queue.isEmpty()) {
                int[] currState = queue.poll();
                int currRow = currState[0], currCol = currState[1], currDistance = currState[2];

                // For the current cell, check its four neighbor cells.
                for (int[] dir : dirs) {
                    int nextRow = currRow + dir[0], nextCol = currCol + dir[1];

                    // If there exists an unvisited empty neighbor:
                    if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols
                            && maze[nextRow][nextCol] == '.') {

                        // If this empty cell is an exit, return distance + 1.
                        if (nextRow == 0 || nextRow == rows - 1 || nextCol == 0 || nextCol == cols - 1)
                            return currDistance + 1;

                        // Otherwise, add this cell to 'queue' and mark it as visited.
                        maze[nextRow][nextCol] = '+';
                        queue.offer(new int[]{nextRow, nextCol, currDistance + 1});
                    }
                }
            }
            // If we finish iterating without finding an exit, return -1.
            return -1;
    }

}
