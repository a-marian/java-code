package bst;
/**
 * 1026. Maximum Difference Between Node and Ancestor
 * Given the root of a binary tree, find the maximum value v for which there exist different
 * nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is
 * an ancestor of b.
 * Example:
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation: We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 * */
public class MaxAncestorDiff {
    int maxDiff = 0;
    public int maxAncestorDiff(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        return  getMaxAncestorDiffDFS(root, max, min);
    }

    private int getMaxAncestorDiffDFS(TreeNode root,  int max, int min){
        if(root == null) return 0;

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        maxDiff = Math.max(maxDiff, Math.abs(max - min));

        getMaxAncestorDiffDFS(root.left, max, min);
        getMaxAncestorDiffDFS(root.right, max, min);
        return maxDiff;
    }
}

/**
 * Time complexity: O(N), where N is the number of nodes in the tree.
 * This is because we visit each node in the tree exactly once and do a constant amount
 * of work for each node.
 * Space complexity: O(H), where H is the height of the tree.
 * This is because the maximum number of nodes on the call stack will be equal to the height of the tree,
 * as we need to store one function call for each level of the tree.
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 * */
