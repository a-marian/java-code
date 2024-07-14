package bst;

import java.util.HashSet;

/**
 * 653. Two Sum IV - Input is a BST
 *  Given the root of a Binary Search Tree and a target number k,
 *  return true if there exist two elements in the BST such that their sum is equal to the given target.
 *  Example:
 *  Input: root = [5,3,6,2,4,null,7], k = 9
 *  Output: true
 * */
public class TwoSumTree {

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return findNumDFS(root, set, k);
    }

    private boolean findNumDFS(TreeNode root, HashSet set, int k){
        if (root == null) return false;
        if (set.contains(k-root.val)){
            return true;
        }else{
            set.add(root.val);
        }
        return findNumDFS(root.left, set, k) || findNumDFS(root.right, set, k);
    }
}

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * */
