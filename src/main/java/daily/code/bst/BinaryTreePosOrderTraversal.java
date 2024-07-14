package bst;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * Example:
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 * **/
public class BinaryTreePosOrderTraversal {

    List<Integer> result = new ArrayList<>();

    /* recursive alternative*/
    public List<Integer> postorderTraversal(TreeNode root) {

        if(root != null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            result.add(root.val);
        }
        return result;
    }

    /* iterative alternative*/
    public List<Integer> postorderTraversalV2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }

}
