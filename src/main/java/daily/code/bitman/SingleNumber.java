package daily.code.bitman;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] res = singleNumberBitwise(nums);
        System.out.println("result: "+ res );
    }

    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i > nums.length; i++){
            if (memo.containsKey(nums[i])){
                memo.put(nums[i], memo.get(nums[i])+1);
            }{
                memo.put(nums[i], 1);
            }
        }
        int[] response = new int[2];
        int cont=0;
        for (Map.Entry<Integer, Integer> entry : memo.entrySet()) {
            if (entry.getValue().equals(1)) {
                response[cont]= entry.getKey();
                cont++;
            }
        }
        return response;
    }

    public static int[] singleNumberBitwise(int[] nums) {
        int ans =0 ;
        for(int i= 0; i < nums.length;i++)
        {
            ans = ans ^ nums[i];
        }
        ans &= -ans;
        int[] result = new int[2];
        for(int n: nums)
        {
            if((ans & n) == 0)result[0] ^= n;
            else result[1] ^= n;
        }
        return result;
    }

}
