package daily.Y2025.july;

public class FindLuckyInteger {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,2,3,3,3};
        int[] test2 = new int[]{2,2,2,3,3};
        System.out.println(findLucky(test2));
    }

    public static int findLucky(int[] arr){
        int[] count=new int[arr.length+1];
        for(final int a: arr){
            if(a <= arr.length)
                ++count[a];
        }
        for(int i = arr.length; i >=1; --i){
            if(count[i] == i)
                return i;
        }
        return -1;
    }
}
