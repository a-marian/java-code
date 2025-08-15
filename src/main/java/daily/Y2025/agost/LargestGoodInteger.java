package daily.Y2025.agost;
/**
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string/submissions/1735522082/?envType=daily-question&envId=2025-08-14
 * */
public class LargestGoodInteger {

    public static void main(String[] args) {
        System.out.println(largestGoodInteger("6777133339"));
        System.out.println(largestGoodInteger("222"));
        System.out.println(largestGoodInteger("3200014888"));
    }

    public static String largestGoodInteger(String num) {
        if(num.length() < 3)
            return "";
        String res ="";
        char[] aaa= num.toCharArray();
        for(int i=0; i<= aaa.length-3; i++){
            if(Character.isDigit(aaa[i] )
                    && (aaa[i] == aaa[i+1] && aaa[i+1] == aaa[i+2])
                    && num.substring(i,i+3).compareTo(res) >0){
                res=num.substring(i,i+3);
            }
        }
        return res;
    }

}
