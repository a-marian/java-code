package daily.Y2025.november;
/**
 * https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/
 * 3228. Maximum Number of Operations to Move Ones to the End
 * */
public class MaxNumberOpMoveOnesToEnd {

    public int maxOperations(String s) {
        int countOne=0;
        int ans = 0;
        char[] sarray = s.toCharArray();
        for (int i = 0; i < sarray.length; i++) {
            if(sarray[i] == '0'){
                while((i+1) < sarray.length && sarray[i+1] == '0'){
                    i++;
                }
                ans += countOne;
            }else {
                countOne++;
            }
        }
        return ans;
    }
}
