package greddy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        int len=s.length();
        Map<Character, Integer> memo = new HashMap<>();
        for(int i =0; i < len; i++){
            memo.put(s.charAt(i), memo.getOrDefault(s.charAt(i), 0)+1);
        }

        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> sorted =  memo.entrySet().stream().sorted(comparingByValue((a,b) -> b - a))
                .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        for(Map.Entry<Character, Integer> letter: sorted.entrySet()){
            int i=0;
           while (i < letter.getValue()){
               sb.append(letter.getKey());
               i++;
           }
        }
        return sb.toString();
    }

    public String frequencySortV2(String s) {
        List<Map.Entry<String, Long>> entry = s.chars().mapToObj(e -> (char) e)
                .map(String::valueOf).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted((e1, e2) -> (int) (e2.getValue() - e1.getValue())).collect(Collectors.toList());

        String ans = "";
        for (Map.Entry<String, Long> e : entry) {
            String temp = e.getKey();
            ans = ans.concat(temp.repeat(Math.toIntExact(e.getValue())));
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(frequencySort("raaeaedere"));
    }
}
