package daily.Y2025.november;

/**
 * https://leetcode.com/problems/keep-multiplying-found-values-by-two/
 * 2154. Keep Multiplying Found Values by Two
 * */

import java.util.Arrays;

public class FindFinalValue {

    public int findFinalValue(int[] nums, int original) {
        int compareVal = original;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == compareVal){
                compareVal *= 2;
            }
        }
        return compareVal;
    }

    public int findFinalValue2(int[] nums, int original) {
        boolean x=true;
        while(x){
            x=found(nums,original);
            original*=2;
        }
        return original/2;

    }
    public boolean found(int [] nums,int compareVal){
        for(int ele:nums){
            if(ele==compareVal){
                return true;
            }
        }
        return false;
    }
}
