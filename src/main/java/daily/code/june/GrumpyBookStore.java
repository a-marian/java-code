package daily.code.june;

public class GrumpyBookStore {

    public static void main(String[] args) {
        int[]customers= {1,0,1,2,1,1,7,5};
        int[]grumpy =   {0,1,0,1,0,1,0,1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));

    }
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int curr=0;
        for(int i=0; i < customers.length;i++){
            curr += grumpy[i]==1 ?0: customers[i];
        }
        int res=curr;
        for(int i=0; i < customers.length;i++){
            curr += grumpy[i]==1 ?customers[i]: 0;
            if(i >= minutes){
                curr -= grumpy[i -minutes] == 1 ? customers[i-minutes]:0;
            }
            res= Math.max(res, curr);
        }
        return res;
    }
}
//time O(n)
//space O(1)
