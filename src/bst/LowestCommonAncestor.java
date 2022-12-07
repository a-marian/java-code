package bst;



/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
 * the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Example 1:
 *       6
 *     /   \
 *   2      8
 *  / \    / \
 * 0  4   7   9
 *   / \
 *  3   5
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLowestComonAncestorDFS(root, p.val, q.val);
    }

    //recursive function to check each heap ( left and right) to find lowest ancestor
    private TreeNode findLowestComonAncestorDFS(TreeNode root, int p, int q){
        if(p < root.val && q < root.val){
            return findLowestComonAncestorDFS(root.left, p, q);
        }

        if(p > root.val && q > root.val){
            return  findLowestComonAncestorDFS(root.right, p, q);
        }
        return  root;
    }

    /**
     * Complexity Analysis
     * Time Complexity O(n) In case that we need to traverse entire tree for all nodes.
     * Space Complexity O(h), h represents tree height or how many levels will be.
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
     * */

}
