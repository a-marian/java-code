package bst;

import java.io.*;

/**
 * 98. Validate Binary Search Tree
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * */

public class ValidateBinarySearchTree {

    public static Node buildTree(String[] arr, int from, int to) {
        int middle = from + (to - from) / 2;
        Node node = new Node();
        node.data = Integer.valueOf(arr[middle]);
        if (middle > from) {
            node.left = buildTree(arr, from, middle - 1);
            node.right = buildTree(arr, middle + 1, to);
        }
        return node;
    }

    public static boolean checkBST(Node root) {
        return validate(root, null, null);
    }

    public static boolean validate(Node root, Integer max, Integer min){
        if(root == null){
            return true;
        } else if(max != null && root.data >= max ||
                min != null && root.data <= min ){
            return false;
        } else {
            return validate(root.left, root.data, min) && validate(root.right, max, root.data);
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            String [] line = in.readLine().split(" ");
            Node root = buildTree(line, 0, line.length);
            if (checkBST(root)) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;
}
/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 * https://leetcode.com/problems/validate-binary-search-tree/
 * **/
//Input
//1 2 3 4 5 6 7
//Output
//Yes

//Input
//3 5 7 9 11 13 15
//Output
//Yes

//Input
//1 2 4 3 5 6 7
//Output
//No
