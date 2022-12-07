package bst;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthNTree {

    public int maxDepthBFS(NodeChildren root) {
        if(root == null) return 0;
        int depth = 0;

        Queue<NodeChildren> queue = new LinkedList();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i < size; i++){
                NodeChildren currentNode = queue.poll();
                for(NodeChildren child: currentNode.children){
                    queue.offer(child);
                }
            }
            depth++;
        }
        return depth++;
    }

    private int maxDepth;
    public int maxDepthDFS(NodeChildren root){
        if(root == null) return 0;
        getMathDepth(root, 1);
        return maxDepth;
    }

    public void getMathDepth(NodeChildren node, int depth){
        if(node == null) return;
        maxDepth = Math.max(depth, maxDepth);
        for(NodeChildren child: node.children){
            getMathDepth(child, depth+1);
        }
    }
}




