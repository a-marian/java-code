package daily.Y2025.agost;

/**
 * https://leetcode.com/problems/power-of-three/description/?envType=daily-question&envId=2025-08-13
 */

public class PowerOfThree {

    public static void main(String[] args) {
            int n=234237;
        System.out.println(isPowerOfThree(n));
    }

    public static boolean isPowerOfThree(int n) {
        if(n % 2 == 0){
            return false;
        }
        while(n%3==0){
            n/=3;
        }
        return n==1;
    }
}
