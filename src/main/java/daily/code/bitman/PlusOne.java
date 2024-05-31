package daily.code.bitman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlusOne {

    public static int[] plusOne(int[] digits) {

        int[] res = new int[digits.length+1];
        int resi = res.length-1;
        int last = digits.length-1;
        int carry = 1;
        while(last >= 0){
            int sum = digits[last] + carry;
            digits[last--] = sum%10;
            res[resi--] = sum%10;
            carry = sum/10;
        }
        if(carry > 0){
            res[0] = carry;
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        int [] digits = new int[]{9};
        int [] res = plusOne(digits);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+", ");
        }

    }
}