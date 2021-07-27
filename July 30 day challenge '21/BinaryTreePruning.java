import java.io.*;
import java.util.*;

public class BinaryTreePruning {
    public int dfs(TreeNode node){
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return node.val;
        int l = dfs(node.left), r = dfs(node.right);
        if(l == 0){
            node.left = null;
        }
        if(r == 0)
            node.right = null;
        return node.val+l+r;
    }
    public TreeNode pruneTree(TreeNode root) {
        int val = dfs(root);
        if(val == 0)
            return null;
        return root;
    }
}
