package matrix;

/**
 * 59. Spiral Matrix II
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * Example:
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * https://leetcode.com/problems/spiral-matrix-ii/
 * */
public class SpiralMatrixII {

        public int[][] generateMatrix(int n) {
            int [][] mat = new int [n][n];
            if (n == 1) return new int[][]{{n}};

            int left = 0, right = n-1;
            int top = 0, bottom = n-1;
            int direction = 0;
            int nums = 1;
            while( left <= right && top <= bottom && nums <= (n*n) ){
                switch(direction) {
                    case 0: { // left --> right
                        int begin = left, end = right;
                        while(begin <= end) {
                            mat[top][begin] = nums++;
                            begin++;
                        };
                        top += 1;
                        direction = 1;
                        continue;
                    }
                    case 1: { // top --> bottom
                        int begin = top, end = bottom;
                        while(begin <= end){
                            mat[begin][right] = nums++;
                            begin++;
                        };
                        right -= 1;
                        direction = 2;
                        continue;
                    }
                    case 2: { // right --> left
                        int begin = right, end = left;
                        while(begin >= end){
                            mat[bottom][begin] = nums++;
                            begin--;
                        };
                        bottom -= 1;
                        direction = 3;
                        continue;
                    }
                    case 3: { //bottom --> top
                        int begin = bottom, end = top;
                        while(begin >= end){
                            mat[begin][left] = nums++;
                            begin--;
                        };
                        left += 1;
                        direction = 0;
                    }
                }
            }
            return mat;
        }

}
