package daily.Y2025.november;
/**
 * https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
 * 1930. Unique Length-3 Palindromic subsequence
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountPalindromeSubsequence {

    public static void main(String[] args) {
        System.out.println(countPalindromeSubsequence("aaba"));
        System.out.println(countPalindromeSubsequence("adc"));
        System.out.println(countPalindromeSubsequence("bbcbab"));
    }

    public static int countPalindromeSubsequence(String s){
        //Map each character to the list of indices where it appears
        Map<Character, List<Integer>> charToPositions= new HashMap<>();

        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            charToPositions.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
        }
        int n = s.length();
        int result = 0;
        for (char outerChar : charToPositions.keySet()) {
            List<Integer> outerPos = charToPositions.get(outerChar);
            int left = outerPos.get(0);
            int right = outerPos.get(outerPos.size() - 1);

            //if the distance between the first and last occurrence is less than 2,
            // we cannot form a palindrome of length 3 skip
            if (right - left < 2) {
                continue;
            }
            //now look for any character that appears at least once strictly between left and right
            for (char innerChar : charToPositions.keySet()) {
                List<Integer> innerPos = charToPositions.get(innerChar);
                //find the smallest index >= left+1 using binary search
                int idx = lowerBound(innerPos, left + 1);
                //if there is at least one ocurrence of innerChar in (left, right)
                if (idx < innerPos.size() && innerPos.get(idx) < right) {
                    result++;
                }
            }
        }
        return result;
    }

    //returns the insertion point (first index >= target)
    private static int lowerBound(List<Integer> list, int target){
        int low= 0, high= list.size();
        while(low < high){
            int mid = (low + high) >>> 1;
            if(list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
