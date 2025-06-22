package daily.Y2025.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
 *
 * */
public class DivideString {
    public static void main(String[] args) {
        String s = "abcdefghij";
        int k = 3;
        char fill= 'x';
        System.out.println(Arrays.toString(divideString(s, k, fill)));
    }

    public static String[] divideString(String s, int k, char fill) {
        List<String> result = new ArrayList<>();
        for(int i= 0; i < s.length(); i=i+k){
            if(i+k <= s.length()){
                result.add(s.substring(i, i+k));
            }else {
                String last = s.substring(i);
                String fillPart = String.valueOf(fill).repeat(k - last.length());
                result.add(last+fillPart);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
