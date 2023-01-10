package greddy;
/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k)
 * such that i < j < k and nums[i] < nums[j] < nums[k].
 * If no such indices exists, return false.
 * */
public class Triplets {

    public static boolean increasingTriplet(int[] nums) {
        int max1 = Integer.MAX_VALUE;
        int max2 = Integer.MAX_VALUE;
        for(int n : nums) {
            if(n <= max1) max1 = n;
            else if(n <= max2) max2 = n;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] b = new int[]{20,100,10,12,5,13};
        System.out.println(increasingTriplet(b));

        int[] a = new int[]{2,1,5,0,4,6};
        System.out.println(increasingTriplet(a));


    }
}
