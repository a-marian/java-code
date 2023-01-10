package bst;
import java.util.*;

class HeightBinaryTree {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static int height(TreeNode root) {
        // Write your code here.
        if(root == null){
            return -1;
        } else {
            return Math.max(height(root.left),height(root.right)) + 1;
        }
    }

    public static TreeNode insert(TreeNode root, int data) {
        if(root == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur;
            if(data <= root.val) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static TreeNode lca(TreeNode root, int v1, int v2) {
        // Write your code here.
        if (v1 < root.val && v2 < root.val){
            return lca(root.left, v1, v2);
        }

        if (v1 > root.val && v2 > root.val){
            return lca(root.right, v1, v2);
        }
        return root;
    }

    public boolean validate(TreeNode root, Integer max, Integer min){
        if(root == null){
            return true;
        } else if(max != null && root.val >= max ||
                min != null && root.val <= min ){
            return false;
        } else {
            return validate(root.left, root.val, min) && validate(root.right, max, root.val);
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        TreeNode root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);

        //lowest common ancestor
        int v1 = 2;
        int v2 = 9;
        TreeNode ans = lca(root,v1,v2);
        System.out.println(ans.val);
    }
}
