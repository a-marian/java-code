package daily.now;

import java.util.*;

public class MaximumDistances {

    private int bfs(int startNode, Set<Integer> visitedNodes, List<List<Integer>> reversedGraph){
        //Queue to store nodes and their distances
        Queue<int[]> queue= new LinkedList<>();
        queue.offer(new int[]{startNode, 0});
        int maxDistance = 0;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentNode =  current[0];
            int currentDistance = current[1];
            for(int neighbor: reversedGraph.get(currentNode)){
                if(visitedNodes.contains(neighbor)) continue; //Skip already visited nodes
                visitedNodes.add(neighbor);
                queue.offer(new int[] {neighbor, currentDistance+1});
                maxDistance =Math.max(maxDistance, currentDistance +1);
            }
        }
        return maxDistance;
    }

    public int maximumInvitations(int[] favorite){
        int numPeople = favorite.length;
        List<List<Integer>>  reversedGraph = new ArrayList<>(numPeople);
        //Build the reversed graph where each node points to its admirers
        for(int i = 0; i < numPeople; i++){
            reversedGraph.add(new ArrayList<>());
        }
        for (int person = 0; person < numPeople; person++) {
            reversedGraph.get(favorite[person]).add(person);
        }

        int longestCycle = 0;
        int twoCycleInvitations = 0;
        boolean[] visited = new boolean[numPeople];

        //Find all cycles in the graph
        for (int person = 0; person < numPeople; person++) {
            if(!visited[person]){
                //Track visited persons and their distances
                Map<Integer, Integer> visitedPersons = new HashMap<>();
                int currentPerson = person;
                int distance = 0;
                while(true){
                    if(visited[currentPerson]) break;
                    visited[currentPerson] = true;
                    visitedPersons.put(currentPerson, distance++);
                    int nextPerson = favorite[currentPerson];

                    // Cycle detected
                    if(visitedPersons.containsKey(nextPerson)){
                        int cycleLength = distance -visitedPersons.get(nextPerson);
                        longestCycle = Math.max(longestCycle, cycleLength);

                        //Handle cyclesof length 2
                        if(cycleLength == 2){
                            Set<Integer> visitedNodes =  new HashSet<>();
                            visitedNodes.add(currentPerson);
                            visitedNodes.add(nextPerson);
                            twoCycleInvitations += 2 +
                                    bfs(nextPerson, visitedNodes, reversedGraph)
                                    + bfs(currentPerson, visitedNodes, reversedGraph);
                        }
                        break;
                    }
                    currentPerson = nextPerson;
                }
            }
        }
        return Math.max(longestCycle, twoCycleInvitations);
    }

    public int maximumInvitations2(int[] favorite){
        // topological sort
        int n = favorite.length;
        int[] inDegree = new int[n];

        //Calculate in-degree for each node
        for (int person = 0; person < n; ++person) {
            inDegree[favorite[person]]++;
        }

        //Topological sorting to remove non-cycle nodes
        Queue<Integer> q= new LinkedList<>();
        for (int person = 0; person < n; person++) {
            if(inDegree[person] == 0){
                q.offer(person);
            }
        }

        int[] depth = new int[n]; //Depth of each node
        Arrays.fill(depth, 1);

        while(!q.isEmpty()){
            int currentNode = q.poll();
            int nextNode = favorite[currentNode];
            depth[nextNode] = Math.max(depth[nextNode], depth[currentNode]+1);
            if(--inDegree[nextNode] == 0){
                q.offer(nextNode);
            }
        }

        int longestCycle =0;
        int twoCycleInvitations = 0;

        //Detect cycle
        for (int person = 0; person < n; ++person) {
            if(inDegree[person] == 0) continue; // Already processed
            int cycleLength =0;
            int current = person;
            while(inDegree[current] != 0){
                inDegree[current] = 0; //Mark as visited
                cycleLength++;
                current = favorite[current];
            }

            if(cycleLength == 2){
                //For  2-cycles, add the depth of both nodes
                twoCycleInvitations += depth[person]+ depth[favorite[person]];
            } else {
                longestCycle = Math.max(longestCycle, cycleLength);
            }
        }
        return Math.max(longestCycle, twoCycleInvitations);
    }

            public static int maximumInvitations3(int[]favorite){
                int n=favorite.length;
                int[]ins=new int[n];
                int[]queue=new int[n];
                int[]deep=new int[n];

                for (int i = 0; i < n; i++) {ins[favorite[i]]++;}

                int l=0,r=0;
                for (int i = 0; i < n; i++) {
                    if(ins[i]==0) queue[r++]=i;
                }

                while (l<r){
                    int cur=queue[l++];
                    int next=favorite[cur];
                    deep[next] = Math.max(deep[next], deep[cur] + 1);
                    if (--ins[next] == 0) {
                        queue[r++] = next;
                    }
                }

                int smallCircle=0;
                int bigCircle=0;

                for (int i = 0; i < n; i++) {
                    if(ins[i]!=0){
                        ins[i]=0;
                        int count=1;
                        for(int j=favorite[i];j!=i;j=favorite[j]){
                            count++;
                            ins[j]=0;
                        }

                        if(count==2){
                            smallCircle+=deep[i]+deep[favorite[i]]+2;
                        }else {
                            bigCircle=Math.max(bigCircle,count);
                        }
                    }
                }
                return Math.max(bigCircle,smallCircle);
            }


}
