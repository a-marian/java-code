package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 * Example:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * */

public class BinaryTreeLevelOrderTraversal {


    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        leverOrderDFSHelper(list, root, 0);
        return list;
    }

    private void leverOrderDFSHelper(List<List<Integer>> list, TreeNode root, int level){
        if(root == null)
            return;

        List<Integer> curr;
        if(level >= list.size()){
            curr = new ArrayList<>();
            curr.add(root.val);
            list.add(curr);
        } else {
            curr = list.get(level);
            curr.add(root.val);
        }
        leverOrderDFSHelper(list, root.left, level+1);
        leverOrderDFSHelper(list, root.right, level+1);
    }

    public static List<List<Integer>> levelOrderBFS(TreeNode root){
        List<List<Integer>> list =  new ArrayList<>();
        if(root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);
                if(currNode.left != null)
                    queue.add(currNode.left);
                if (currNode.right != null)
                    queue.add(currNode.right);
            }
            list.add(currLevel);
        }
        return list;
    }

    static void levelOrder(TreeNode root){
        //Write your code here
        Queue<TreeNode> queuey = new LinkedList<>();
        //enqueque current root
        queuey.add(root);

        while(!queuey.isEmpty()){
            //dequeue next node
            TreeNode current = queuey.remove();
            System.out.print(current.val+" ");
            //enqueue child elements from next level in order
            if(current.left != null){
                queuey.add(current.left);
            }
            if(current.right != null){
                queuey.add(current.right);
            }
        }
    }
}

