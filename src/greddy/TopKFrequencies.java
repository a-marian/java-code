package greddy;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequencies {

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList();
        Map<String, Integer> memo = new TreeMap<>(String::compareTo);
        for (int i= 0; i < words.length; i++){
            if(memo.containsKey(words[i])){
                memo.put(words[i], memo.get(words[i])+1);
            } else {
                memo.put(words[i], 1);
            }
        }
        memo.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((a,b) -> b - a))
                .forEach(entry -> {
                    if (result.size()<k){
                        result.add(entry.getKey());
                    }
                });

        return result;
    }

    public static List<String> topKFrequentBest(String[] words, int k) {
        //less use of memory
        TreeMap<String, Integer> map = new TreeMap<>(String::compareTo);
        Arrays.stream(words).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
        return map.entrySet().stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] words4 = new String[]{"i","love","leetcode","i","love","coding"};
        List<String> res4 = topKFrequent(words4,3);
        res4.stream().forEach(System.out::println);
        System.out.println("-------------");

        String[] words3 = new String[]{"i","love","leetcode","i","love","coding"};
        List<String> res3 = topKFrequent(words3, 1);
        res3.stream().forEach(System.out::println);
        System.out.println("-------------");

        String[] words1 = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
        List<String> res1 = topKFrequentBest(words1, 4);
        res1.stream().forEach(System.out::println);
        System.out.println("-------------");

        String[] words2 = new String[]{"i","love","leetcode","i","love","coding"};
        List<String> res2 = topKFrequent(words2, 2);
        res2.stream().forEach(System.out::println);
        System.out.println("-------------");
    }
}
