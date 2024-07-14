package bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * Example:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * */
public class BinaryTreeInOrderTraversal {

    /*iterative alternative */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;

        Stack<TreeNode> stacky = new Stack<>();

        TreeNode current = root;

        while(current != null || !stacky.isEmpty()){
            while(current != null){
                stacky.push(current);
                current = current.left;
            }

            current = stacky.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}
