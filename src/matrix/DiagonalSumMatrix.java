package matrix;

/**
 * https://leetcode.com/problems/matrix-diagonal-sum/
 *Given a square matrix mat, return the sum of the matrix diagonals.
 * Only include the sum of all the elements on the primary diagonal and all the elements on
 * the secondary diagonal that are not part of the primary diagonal.
 * Example:
 * Input: mat = [[1,2,3],
 *               [4,5,6],
 *               [7,8,9]]
 * Output: 25
 * Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
 * Notice that element mat[1][1] = 5 is counted only once.
 * **/

public class DiagonalSumMatrix {

    public int diagonalSum(int[][] mat) {

        int sum = 0;
        int n = mat.length;

        for(int i = 0; i < n; i++){
            sum += mat[i][i] + mat[i][n-i -1];
        }
        if(n % 2 != 0) sum -= mat[n/2][n/2];

        return sum;
    }

    public int diagonalSumV2(int[][] mat) {
        int len = mat.length;
        if (len <= 1) return mat[0][0];

        int left = 0, right = len-1;
        int res = 0;

        while(left < right){
            res += mat[left][left] + mat[right][left] + mat[right][right] + mat[left][right];
            left++;
            right--;
        }
        if(len % 2 != 0){
            int medium = len/2;
            res += mat[medium][medium];
        }
        return res;
    }
    /**
     * The code traverses the diagonal elements of the matrix using a while loop, with two pointers starting
     * from opposite corners of the matrix. Since the loop iterates over n/2 diagonal elements of the matrix,
     * the time complexity of this loop is O(n/2) or simply O(n).
     * If the size of the matrix is odd, the central element of the matrix is also added to the sum, which takes constant time.
     * Therefore, the overall time complexity of the code is O(n).
     * The space complexity of the code is O(1) because it uses a fixed amount of additional memory to store the variables
     * and does not depend on the size of the input.
     * */
}
/***
 * Time Complexity: O(mat.length)
 * Space complexity: O(1)
 * */
