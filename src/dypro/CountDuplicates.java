package dypro;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountDuplicates {

    // Approach 1 : In this approach we are using SET .
    // If we iterating first k elements from starting ,
    // We will delete the elements having same value from set because we want
    // the difference between there indicies equal to or less than 'k'.
    // And we will check everytime that we can add to set or not .
    // If not it means element already exists and its difference is less than or equal to 'k' , so we will return true.

    public boolean containsNearbyDuplicateSet(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
    // Approach 2 : In this approach we are using MAP . This one is simple , In this one will add make map with key as number and value as index . Every time we iterate we will check if value exists in map , if it exists we will check the difference of indices if it is less then or equal to 'k' , we will return true .

    public boolean containsNearbyDuplicateMap(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i])<=k) return true;
            }
            map.put(nums[i],i);
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
