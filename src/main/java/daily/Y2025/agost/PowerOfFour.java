package daily.Y2025.agost;
/**
 * https://leetcode.com/problems/power-of-four/
 * */

public class PowerOfFour {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(-232342348));
    }

    public static boolean isPowerOfFour(int n){
        return n>0 && Integer.bitCount(n) == 1 && (n-1) % 3 == 0;
    }
}
