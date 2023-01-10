package bst;

/**
 * 872. Leaf-Similar Trees
 * Consider all the leaves of a binary tree, from left to right order,
 * the values of those leaves form a leaf value sequence.
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * */
import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<>();
        List<Integer> leafs2 = new ArrayList<>();
        getLeafs(root1, leafs1);
        getLeafs(root2, leafs2);
        return leafs1.equals(leafs2);
    }
    private void getLeafs(TreeNode root, List<Integer> leafs){
        if(root == null) return;
        if(root.left == null && root.right == null)
            leafs.add(root.val);
        getLeafs(root.left, leafs);
        getLeafs(root.right, leafs);
    }
}
/**
 * Time complexity: O(2T)
 * Space complexity: O(2T)
 * * T is the length of the given tree.
 * Solved by DFS
 * https://leetcode.com/problems/leaf-similar-trees/
 * */
