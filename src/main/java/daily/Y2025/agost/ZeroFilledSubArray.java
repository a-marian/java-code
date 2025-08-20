package daily.Y2025.agost;

/**
 * https://leetcode.com/problems/number-of-zero-filled-subarrays/
 * **/
import java.util.HashMap;
import java.util.Map;


public class ZeroFilledSubArray {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,0,0,2,0,0,4};
        System.out.println(zeroFilledSubarray(a));
        int[] b = new int[]{0,0,0,2,0,0,0};
        System.out.println(zeroFilledSubarray(b));
        int[] c = new int[]{0,0,0,2,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0};
        System.out.println(zeroFilledSubArrayEfficient(c));
    }

    public static long zeroFilledSubArrayEfficient(int[] nums) {
        long totalZeroFilledSubArray=0;
        long currentConsecutiveZeros=0;

        for (int num:nums) {
            if(num == 0){
                currentConsecutiveZeros++;
                totalZeroFilledSubArray += currentConsecutiveZeros;
            } else{
                currentConsecutiveZeros =0;
            }
        }
        return totalZeroFilledSubArray;
    }

    public static long zeroFilledSubarray(int[] nums) {

        long res= 0;
        Map<Integer, Integer> memo= new HashMap<>();
        int cont=0;
        for (int num : nums) {
            if (num == 0) {
                cont++;
                for (int j = 1; j <= cont; j++) {
                    memo.put(j, memo.getOrDefault(j, 0) + 1);

                }

            } else {
                cont = 0;
            }
        }
        for(Map.Entry<Integer,Integer> key: memo.entrySet()){
            res+= key.getValue();
        }
        return res;
    }
}
