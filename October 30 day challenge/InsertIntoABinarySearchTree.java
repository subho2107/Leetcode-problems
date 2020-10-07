import java.io.*;
import java.util.*;

public class InsertIntoABinarySearchTree {
    public void insert(TreeNode root, int val){
        if(root == null)
            return;
        if(val < root.val){
            if(root.left == null){
                root.left = new TreeNode(val);
                return;
            }
            else
                insert(root.left, val);
        }
        else{
            if(root.right == null){
                root.right = new TreeNode(val);
                return;
            }
            else
                insert(root.right, val);
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
        }
        else
            insert(root, val);
        return root;
    }
}
