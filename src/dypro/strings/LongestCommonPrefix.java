package dypro.strings;

import java.util.Arrays;

public class LongestCommonPrefix {

        public static String longestCommonPrefix(String[] strs) {
            if (strs.length < 1) return "";
            if (strs.length == 1) return strs[0];
            if (strs[0].length() == 0) return "";

            StringBuilder sb = new StringBuilder();
            Arrays.sort(strs);
            if(strs[0].length() == 0) return "";

            String initial = strs[0];
            char val = initial.charAt(0);
            int index = 0;
            boolean flag = false;
            while (flag == false) {
                flag = checkIfValueIsNotCommon(val, index, strs);
                if (flag == false ) {
                    index++;
                    sb.append(val);
                    if ( initial.length() > index) {
                        val = initial.charAt(index);
                    } else {
                        flag = true;
                    }

                }
            }
            return sb.toString();
        }
    static boolean checkIfValueIsNotCommon(int value, int index, String[] strs){
        boolean flag = false;
        for(int i = 0; i < strs.length; i++){
            if(strs[i].charAt(index) != value){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
            String[] strs = {"flower","flow","flight"};
            String[] strs1 = {"flower","flower","flower","flower"};
         System.out.println(longestCommonPrefix(strs1));
    }
}
