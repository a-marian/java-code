package daily.Y2025.november;

public class KLenAPart {

    public static boolean kLengthApart(int[] nums, int k) {
        int spaces= -1;
        for(int i =0; i < nums.length; i++){
            if(nums[i] == 1){
               if(spaces != -1 && i -spaces <= k){
                   return false;
               }
               spaces= i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,0,1,0,0,1};
        int[] nums1 = {0,1, 0,0,1,0,0,1};
        System.out.println(kLengthApart(nums1, 2));
    }
}
