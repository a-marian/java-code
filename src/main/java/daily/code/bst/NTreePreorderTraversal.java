package bst;


import java.util.*;

/**
 * 589. N-ary Tree Preorder Traversal
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal.
 * Each group of children is separated by the null value (See examples)
 * Example:
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * */
public class NTreePreorderTraversal {
    public List<Integer> list = new ArrayList<>();

    /* recursive way*/
    public List<Integer> preorderRecursive(NodeChildren root) {
        if (root == null)
            return list;
        list.add(root.val);
        for (NodeChildren n : root.children) {
            preorderRecursive(n);
        }
        return list;
    }
    // Time complexity: O(n)
    // Space complexity: O(n)

    /* iterative way */
    public List<Integer> preorderIterative(NodeChildren root) {
        if (root == null)
            return list;
        Deque<NodeChildren> stack = new ArrayDeque<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--) {
                stack.add(root.children.get(i));
            }
        }
        return list;
    }
    // Time complexity: O(n)
    // Space complexity: O(1)

}
/**
 *  https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 **/


