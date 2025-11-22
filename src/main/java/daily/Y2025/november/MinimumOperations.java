package daily.Y2025.november;

public class MinimumOperations {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(minimumOperations(nums));
    }

    public static int minimumOperations(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 3 != 0){
                if((nums[i]-1) % 3 == 0 ){
                    res++;
                    continue;
                }
                if((nums[i]+1) % 3 == 0 ){
                    res++;
                    continue;
                }
            }
        }
        return res;
    }
}
