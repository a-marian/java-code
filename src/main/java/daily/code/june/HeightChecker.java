package daily.code.june;

import java.util.Arrays;

public class HeightChecker {

    public int heightChecker(int[] heights) {
        int res =   0;

        int[] expected = Arrays.stream(heights).sorted().toArray();
        Arrays.sort(heights);
         Arrays.stream(expected).forEach(System.out::print);
        for(int i=0; i < heights.length; i++){
            if (expected[i] != heights[i]){
                res++;
            }
        }
        return res;

    }


}
