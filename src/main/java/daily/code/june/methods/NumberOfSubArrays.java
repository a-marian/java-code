package daily.code.june.methods;

public class NumberOfSubArrays {

    public static int numberOfSubArrays(int[]nums, int k){
        int l=0;
        int mid = 0, odds=0, res=0;
        for (int r = 0; r < nums.length; r++) {
            if(odds > k){
                mid++;
                l=mid;
                odds++;
            }
            while(odds == k && nums[mid] % 2 == 0){
                mid++;
            }
            if(odds == k){
                res += mid -l +1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {1,1,2,1};
        int k = 3;
        System.out.println(numberOfSubArrays(numbers, k));
    }
}
