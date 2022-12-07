package bst;
import java.util.*;

class BinarySearchTree{

    public static int getHeight(TreeNode root){
        //Write your code here
        if (root == null){
            return -1;
        }
        int leftDepth = getHeight(root.left);
        int rightDepth = getHeight(root.right);
        return (leftDepth > rightDepth ? leftDepth : rightDepth) +1;
    }

    /**
     * Given the root of a binary tree, return its maximum depth.
     * A binary tree's maximum depth is the number of nodes along the longest path
     * from the root node down to the farthest leaf node.
     * Example:
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 3
     * */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int maxLeft=maxDepth(root.left);
        int maxRight=maxDepth(root.right);
        return Math.max(maxLeft, maxRight)+1;
    }
    public static TreeNode insert(TreeNode root, int data){
        if(root==null){
            return new TreeNode(data);
        }
        else{
            TreeNode cur;
            if(data<=root.val){
                cur=insert(root.left,data);
                root.left=cur;
                System.out.print(root.left.val+"  ");
            }
            else{

                cur=insert(root.right,data);
                root.right=cur;
                System.out.print("  "+root.right.val);
            }
            return root;
        }
    }

    /**
     * https://leetcode.com/problems/search-in-a-binary-search-tree/
     * You are given the root of a binary search tree (BST) and an integer val.
     * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
     * If such a node does not exist, return null.
     * Example:
     * Input: root = [4,2,7,1,3], val = 2
     * Output: [2,1,3]
     * **/
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return root;
        if(root.val == val) {
            return root;
        }else{
            root = (root.val > val) ? searchBST(root.left, val):searchBST(root.right, val);
        }
        return root;
    }

    /**
     * https://leetcode.com/problems/symmetric-tree/
     * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
     * Example:
     * Input: root = [1,2,2,null,3,null,3]
     * Output: false
     * */
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    /**
     * https://leetcode.com/problems/invert-binary-tree/
     * Given the root of a binary tree, invert the tree, and return its root.
     * Example:
     * Input: root = [4,2,7,1,3,6,9]
     * Output: [4,7,2,9,6,3,1]
     * */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        final TreeNode left = root.left,
                right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    /**
     * https://leetcode.com/problems/path-sum/
     * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
     * A leaf is a node with no children.
     * Example:
     *  Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     *  Output: true
     *  Explanation: The root-to-leaf path with the target sum is shown.
     * */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null) return sum == root.val;

        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        TreeNode root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class NodeChildren {
    public int val;
    public List<NodeChildren> children;

    public NodeChildren(int _val) {
        val = _val;
    }

    public NodeChildren(int _val, List<NodeChildren> _children) {
        val = _val;
        children = _children;
    }
}
