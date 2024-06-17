package daily.code.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonChars {

    public List<String> commonChars(String[] words) {
        Arrays.sort(words);
        int[] memo = new int[128];
        List<String> res = new ArrayList<String>();
        int len = words.length;
        for(int i = 0; i < len; i++){
            for(char c : words[i].toCharArray()){
                memo[c]++;
            }
        }
        char a = 'a';
        for(int j=0; j < memo.length; j++){
            if (memo[j] >= len){
                char ca = (char) j;
                int div= memo[j]%2;
                if(div == len){
                    res.add(String.valueOf(ca));
                }
                res.add(String.valueOf(ca));
            }

        }
        return res;
    }
}

