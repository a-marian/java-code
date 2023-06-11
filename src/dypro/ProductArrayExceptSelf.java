package dypro;

import java.util.Arrays;

public class ProductArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] pf = new int[nums.length];
        int len =nums.length;

        Arrays.fill(pf,1);
        for(int i=1; i < len; i++){
            pf[i] = nums[i-1] * pf[i-1];
        }

        for (int j = len - 1, m = 1; j >= 0; j--) {
            pf[j] *= m;
            m *= nums[j];
        }

        return  pf;
    }

    public static void main(String[] args) {
       int[] array = new int[]{1,2,3,4};
        //int[] array = new int[]{-1,1,0,-3,3};
        int[] prod = productExceptSelf(array);
        for (int i = 0; i < prod.length; i++) {
            System.out.print(" " + prod[i]);
            System.out.println(" ");
        }
    }
}
