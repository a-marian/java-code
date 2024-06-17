package daily.code.june;

public class SubarrayDivbyK {
    public static int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        int collect = 0;
        for(int i=0; i< nums.length; i++){
            if (nums[i] % k == 0 ){
                res++;
            }else if(collect != 0 && collect % k == 0){
                res++;
            }
            collect= collect + nums[i];

        }
        return res;
    }
    public static void main(String[] args) {
        int[] array= {4,5,0,-2,-3,1};
        int k= 5;
        System.out.println(subarraysDivByK(array, k));
    }
}
