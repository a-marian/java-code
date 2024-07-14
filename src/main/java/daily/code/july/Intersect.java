package daily.code.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersect {

        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            List<Integer> res;
            if (nums1.length > nums2.length){
                res= checkRepeatedValues(nums2, nums1);
            }else{
                res = checkRepeatedValues(nums1, nums2);
            }
            return res.stream().mapToInt(Integer::intValue).toArray();
        }

    private List<Integer> checkRepeatedValues(int[]a, int[]b){
        List<Integer> res = new ArrayList<>();
        for(int i=0; i < a.length; i++){
            if(Arrays.binarySearch(b, a[i]) == 0){
                res.add(a[i]);
            }
        }
        return res;
    }
}


