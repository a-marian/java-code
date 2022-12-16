package dypro;



import java.util.*;

public class GroupAnagrams {


    public static List<List<String>> groupAnagrams(String[] strs) {

        if(strs.length == 1) return  Arrays.asList(Arrays.asList(strs[0]));

        int[] count = new int[26];
        Map<String, List<String>>  memo= new HashMap<>();
        for (int i = 0; i < strs.length; i++){
            Arrays.fill(count, 0);
            for (char c : strs[i].toCharArray()) count[c-'a']++;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 26;j++) {
                sb.append('#');
                sb.append(count[j]);
            }
            String key = sb.toString();
            if(!memo.containsKey(key)){
                memo.put(key, new ArrayList());
            }
            memo.get(key).add(strs[i]);
        }

        return new ArrayList(memo.values());

        /**
         * Time Complexity:
         * O(NK), where N is the length of strs, and K is the maximum length of a string in strs.
         * Counting each string is linear in the size of the string, and we count every string.
         * Space Complexity:
         * O(NK), the total information content stored in memo.
         * **/
    }

    public static void main(String[] args) {

        String[] str1 = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res1 = groupAnagrams(str1);
        printvalues(res1);

        String[] str2 = new String[]{"",""};
        List<List<String>> res2 = groupAnagrams(str2);
        printvalues(res2);

    }

    private static void printvalues(List<List<String>> res1){
        for (int i = 0; i < res1.size(); i++) {
            for (int j = 0; j < res1.get(i).size(); j++) {
                System.out.print(" "+res1.get(i).get(j));
            }
            System.out.println();
        }
    }
}
