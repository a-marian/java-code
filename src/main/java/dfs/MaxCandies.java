package dfs;

import java.util.*;

public class MaxCandies {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int candiesCount=0;
        boolean[] visited= new boolean[status.length];

        for(int box: initialBoxes){
            dfs(box, status, keys, containedBoxes, visited);
        }
        for(int i = 0; i < candies.length; i++){
            if(visited[i] && status[i] == 1){
                candiesCount += candies[i];
            }
        }
        return candiesCount;
    }

    private void dfs(int box, int[] status, int[][] keys, int[][] containedBoxes, boolean[] visited) {
        visited[box] = true;
        for(int key: keys[box]){
            if(key == box){
                continue;
            }
            status[key] = 1;
        }
        for (int bx:containedBoxes[box]) {
            if(!visited[bx]){
                dfs(bx, status, keys, containedBoxes, visited);
            }
        }
    }

    public int maxCandiesSlow(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] visited = new boolean[ n];
        LinkedList<Integer> processing = new LinkedList<>();
        Set<Integer> lockedBoxes = new HashSet<>();

        for(int box: initialBoxes){
            if(status[box] == 1){
                visited[box] = true;
                processing.add(box);
            } else {
                lockedBoxes.add(box);
            }
        }
        int res = 0;
        while(!processing.isEmpty()){
            int curr = processing.removeLast();
            res += candies[curr];
            for(int k: keys[curr]){
                status[k]=1;
                if(lockedBoxes.contains(k)){
                    visited[k] = true;
                    lockedBoxes.remove(k);
                    processing.add(k);
                }
            }
            for(int box: containedBoxes[curr]){
                if(visited[box]){
                    continue;
                }
                if(status[box] == 1){
                    processing.add(box);
                    visited[box] = true;
                } else {
                    lockedBoxes.add(box);
                }
            }
        }
        return res;
    }

    }
