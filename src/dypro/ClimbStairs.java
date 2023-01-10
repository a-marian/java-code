package dypro;

/**
 * 70. Climbing Stairs
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * */
public class ClimbStairs {
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1+sqrt5)/2, n+1) - Math.pow((1-sqrt5)/2, n+1);
        return (int)(fibn/sqrt5);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}

/**
 * Time complexity: O(1)
 * Space complexity: O(1)
 * https://leetcode.com/problems/climbing-stairs/
 * */
