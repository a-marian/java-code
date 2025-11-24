package daily.Y2025.november;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-prefix-divisible-by-5/
 * 1018. Binary Prefix Divisible By 5
 * */

public class PrefixDivisibleBy5 {

    public static void main(String[] args) {
        int[] arr = new int[] {0,1,1};
        prefixesDivBy5(arr).stream().forEach(System.out::println);
    }

        public static  List<Boolean> prefixesDivBy5(int[] nums) {
            List<Boolean> result = new ArrayList<>();
            int current=0; // this will store the running total
            for(int num:nums){
                //update the running total and take modulo 5
                current = (current * 2 + num) % 5;
                //add true or false base on divisibility by 5
                result.add(current == 0);
            }
            return result;
        }
}
