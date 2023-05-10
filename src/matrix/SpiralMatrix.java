package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * https://leetcode.com/problems/spiral-matrix/description/
 * */
public class SpiralMatrix {



    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList();

        if (matrix.length == 0) return answer;

        int row = matrix.length, col = matrix[0].length;
        int left = 0, right=col-1, top= 0, bottom=row-1;
        int direction = 0;

        while(left <= right && top <= bottom){
            switch(direction) {
                case 0: { //left --> right
                    int begin = left, end = right;
                    while(begin <= end){
                        answer.add(matrix[left][begin]);
                        begin++;
                    };
                    direction = 1;
                    top+=1;
                    continue;
                }
                case 1 : { // top --> bottom
                    int begin = top, end = bottom;
                    while(begin <= end){
                        answer.add(matrix[begin][right]);
                        begin++;
                    };
                    direction = 2;
                    right -= 1;
                    continue;
                }
                case 2: { // right --> left
                    int begin = right, end = left;
                    while(begin >= end){
                        answer.add(matrix[bottom][begin]);
                        begin--;
                    };
                    direction = 3;
                    bottom -=1;
                    continue;
                }
                case 3: { // bottom --> top
                    int begin = bottom, end = top;
                    while(begin >= end){
                        answer.add(matrix[begin][left]);
                        begin--;
                    };
                    direction = 0;
                    left +=1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        int[][] mat = new int [][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        List<Integer> res = spiralOrder(mat);
        res.forEach(System.out::println);

    }
}

/**
 * Time Complexity:  O(n)
 * Space complexity: O(1)
 * */
