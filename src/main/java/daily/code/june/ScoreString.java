package daily.code.june;

public class ScoreString {

/**
 * javascript solution
 * @param {string} s
 * @return {number}
 *    var scoreOfString = function(s) {
 *         let answer = 0;
 *         for(var i=1; i < s.length; ++i){
 *             answer += Math.abs(s.charCodeAt(i) - s.charCodeAt(i-1));
 *         }
 *         return answer;
 *     };
 ***/

/**
 * function scoreOfString(s: string): number {
 *     let ans =0;
 *     for(var i=1; i < s.length; ++i){
 *         ans += Math.abs(s.charCodeAt(i)- s.charCodeAt(i-1));
 *     }
 *     return ans;
 * };
 * **/

/**
 * class Solution:
 *     def scoreOfString(self, s: str) -> int:
 *         return sum(abs(a-b) for a,b in pairwise(map(ord, s)))
 * */

    public static int scoreOfString(String s) {
        int answer=0;
        char[] array = s.toCharArray();
        for(int i=1; i < array.length; ++i){
            answer += Math.abs(array[i] - array[i-1]);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(scoreOfString("marianela"));

    }
}
