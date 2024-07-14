package bfs;

import java.util.*;
/**
 * https://leetcode.com/problems/minimum-genetic-mutation/
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 * Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation is defined
 * as one single character changed in the gene string.
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 * There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
 * Given the two gene dypro.strings start and end and the gene bank bank, return the minimum number of mutations needed
 * to mutate from start to end. If there is no such a mutation, return -1.
 * Note that the starting point is assumed to be valid, so it might not be included in the bank.
 * Example 2:
 * Input: start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * Output: 2
 * */
public class MinimumGeneticMutation {

    public static int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.add(start);
        seen.add(start);
        int steps = 0;
        while(!queue.isEmpty()){
            int nodesInQueue = queue.size();
            for(int i=0; i<nodesInQueue; i++){
                String node = queue.remove();
                if(node.equals(end)){
                    return steps;
                }
                for(char c: new char[]{'A','C', 'G', 'T'}){
                    for(int j = 0; j < node.length(); j++){
                        String neighbor = node.substring(0,j)+c+node.substring(j+1);
                        if(!seen.contains(neighbor)&& Arrays.asList(bank).contains(neighbor)){
                            queue.add(neighbor);
                            seen.add(neighbor);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public static int minMutationV2(String startGene, String endGene, String[] bank) {
        int level = 0;
        List<String> visted = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(startGene);
        visted.add(startGene);

        while( !queue.isEmpty()){
            int size = queue.size();
            for ( int i = 0; i < size; i++){
                String tmp = queue.poll();
                if( tmp.equals(endGene)) return level;
                for( int j = 0; j< bank.length; j++){
                    if( checkDiff(tmp, bank[j]) && !visted.contains(bank[j])){
                        visted.add(bank[j]);
                        queue.add(bank[j]);
                    }
                }
            }
            level ++;
        }
        return -1;

    }
    
    private static boolean checkDiff(String s1, String s2){
        int diff = 0;
        return true;
    }

    public static void main(String[] args) {
        String[]  bank = new String[] {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(minMutation("AACCGGTT", "AAACGGTA", bank));
    }
}
