package greddy;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        HashSet set = new HashSet();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }

    public boolean containsDuplicateLog(int[] nums) {
        Arrays.sort(nums); //this increase complexity logN
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] == nums[i]) return true;
        }
        return false;
    }
}
