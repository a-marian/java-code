package greddy;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 *
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses/
 */
public class FindPlayersWithZeroOrOneLosses {

    public static List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;
        HashMap<Integer, Integer> memo = new HashMap<>();
        for(int i=0; i < n; i++){
            if(memo.containsKey(matches[i][1])){
                memo.put(matches[i][1], memo.get(matches[i][1])+1);
            }else{
                memo.put(matches[i][1], 1);
            }
            if(!memo.containsKey(matches[i][0])){
                memo.put(matches[i][0], 0);
            }
        }
        memo.entrySet().stream().sorted((a,b) -> a.getKey() - b.getKey()).collect(Collectors.toSet());
        List<List<Integer>> answer =  Arrays.asList(new ArrayList<>(), new ArrayList<>());

        for (Map.Entry<Integer, Integer> entry: memo.entrySet()) {
            if(entry.getValue() == 0){
                answer.get(0).add(entry.getKey());
            }
            if(entry.getValue() == 1){
                answer.get(1).add(entry.getKey());
            }
        }
        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));
        return answer;
    }

    public static void main(String[] args) {
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        findWinners(matches);
    }
}
