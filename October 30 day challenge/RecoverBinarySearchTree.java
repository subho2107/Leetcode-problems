/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.io.*;
import java.util.*;
class RecoverBinarySearchTree {
    ArrayList<TreeNode> inorder;
    public void dfs(TreeNode root){
        if(root != null){
            if(root.left != null)
                dfs(root.left);
            inorder.add(root);
            if(root.right != null)
                dfs(root.right);
        }
    }
    public void recoverTree(TreeNode root) {
        inorder = new ArrayList<>();
        dfs(root);
        TreeNode one = null, two = null;
        for(int i = 0; i < inorder.size(); i++){
            TreeNode node = inorder.get(i);
            if(i == 0 && node.val > inorder.get(i+1).val)
                one = node;
            else if(i == inorder.size() - 1 && node.val < inorder.get(i-1).val)
                two = node;
            else if(i != 0 && i != inorder.size() - 1  && (node.val < inorder.get(i-1).val || node.val > inorder.get(i+1).val))
            {
                if(one == null)
                    one = node;
                else
                    two = node;
            }

        }
        one.val = one.val^two.val^(two.val = one.val);
    }
}