package daily.code.bitman;

import java.util.HashMap;

public class CountTriplets {

    public static int countTriplets(int[] arr){
        int N = arr.length;
        int res = 0;
        int prefix=0;

        HashMap<Integer, Integer> prevXORCnt = new HashMap<>();
        prevXORCnt.put(0,1);
        HashMap<Integer, Integer> prevXORIndexSum = new HashMap<>();

        for (int i = 0; i < N; i++) {
            prefix ^= arr[i];
            if(prevXORCnt.containsKey(prefix)){
                res += i * prevXORCnt.get(prefix) -prevXORIndexSum.getOrDefault(prefix, 0);
            }
            prevXORCnt.put(prefix, prevXORCnt.getOrDefault(prefix,0)+1);
            prevXORIndexSum.put(prefix, prevXORIndexSum.getOrDefault(prefix, 0)+i+1);
        }
        return res;
    }
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        System.out.println(countTriplets(arr));
    }
}
