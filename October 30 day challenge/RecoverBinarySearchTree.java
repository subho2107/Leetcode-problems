/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */


import java.util.*;

class RecoverBinarySearchTree {
    ArrayList<TreeNode[]> irregularities;
    TreeNode prev;

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            if (prev != null && root.val < prev.val)
                irregularities.add(new TreeNode[]{prev, root});
            prev = root;
            inorder(root.right);
        }
    }

    public void recoverTree(TreeNode root) {
        inorder(root);
        TreeNode node1, node2;
        if (irregularities.size() == 1) {
            node1 = irregularities.get(0)[0];
            node2 = irregularities.get(0)[1];

        } else {
            node1 = irregularities.get(0)[0];
            node2 = irregularities.get(1)[1];
        }
        node1.val = node1.val ^ node2.val ^ (node2.val = node1.val);
    }
}